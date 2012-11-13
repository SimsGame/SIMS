/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Dawid Rusin
 */
public class User {

    private String accountname;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private Date reg_date;
    private Date last_login;
    private long time_played;
    private int ucoins;
    
    public void setTime_played(long time_played) {
        this.time_played = time_played;
    }
    
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountname() {
        return accountname;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Date getLast_login() {
        return last_login;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public long getTime_played() {
        return time_played;
    }

    public void setUcoins(int ucoins) {
        this.ucoins = ucoins;
    }

    public int getUcoins() {
        return ucoins;
    }

    /**
     * A more useful toString()-method, overrides the standard one
     * @return String with the user-data
     */
    @Override
    public String toString() {
        String output = "accountname = " + accountname + "\n"
                + "password = " + password + "\n"
                + "email = " + email + "\n"
                + "first_name = " + first_name + "\n"
                + "last_name = " + last_name + "\n"
                + "reg_date = " + reg_date + "\n"
                + "last_login = " + last_login + "\n"
                + "ucoins = " + ucoins + "\n"
                + "time_plyed = " + time_played;

        return output;
    }

    /**
     * Creates _mainuser in Sims_1, reads out the user-profile-file and sets the data
     * @param accname account name of the logged in user
     */
    public User(String accname) {
        String[] userData = null;
        try {
            //reads the data from the file and sets it into _mainuser
            userData = CSVHandling.readCSVStringArr(Sims_1._dataFolderName + "/" + accname + "/" + Sims_1._profileFileName);
            accountname = userData[0];
            password = userData[1];
            email = userData[2];
            first_name = userData[3];
            last_name = userData[4];
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-y");
            reg_date = (Date) formatter.parse(userData[5]);
            if (userData[6].equals("")) {
                last_login = null;
            } else {
                last_login = (Date) formatter.parse(userData[6]);
            }
            time_played = Integer.parseInt(userData[7]);
            ucoins = Integer.parseInt(userData[8]);
            System.out.println(this.ucoins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the user specified
     * @param user the user to delete
     * @return true if the deletion was successful, false otherwise
     */
    public static boolean deleteUser(User user) {
        return deleteUser(user.getAccountname(), user.getEmail());
    }

    /**
     * Deletes the user specified
     * @param accountname account name of the user to delete
     * @param email email of the user to delete
     * @return true if the deletion was successful, false otherwise
     */
    public static boolean deleteUser(String accountname, String email) {

        LinkedList<LinkedList> userlist = null;

        try {
            userlist = CSVHandling.readCSV(Sims_1._usersFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).contains(accountname) | userlist.get(i).contains(email)) {
                userlist.remove(i);
            }
        }

        try {
            CSVHandling.writeCSV(userlist, Sims_1._usersFileName);
            File fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._profileFileName);
            fileToDelete.delete();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes the game save file, the inventory file and the user folder
     * @param accountname name of the user to delete
     * @return true if the deletion was successful, false otherwise
     */
    public static boolean deleteAllUserFiles(String accountname) {

        try {
            File fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._inventoryFileName);
            fileToDelete.delete();
            fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._gameFileName);
            fileToDelete.delete();
            fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname);
            fileToDelete.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Saves the current Sims_1._mainuser to the profile-file
     * @return true if successful, false otherwise
     */
    public static boolean saveUser() {
        return createUser(Sims_1._mainuser);
    }
    
    /**
     * Saves the date on closing the program
     * @return true if successful, false otherwise
     */
    public static boolean saveLastLogin(){
        return createUser(Sims_1._mainuser.accountname, Sims_1._mainuser.password.toCharArray(), Sims_1._mainuser.email, Sims_1._mainuser.first_name, Sims_1._mainuser.last_name, Sims_1._mainuser.reg_date, new Date(), Sims_1._mainuser.time_played, Sims_1._mainuser.ucoins);
    }

    /**
     * Creates a new user (new profile-file)
     * @param user the user to create
     * @return true if successful, false otherwise
     */
    public static boolean createUser(User user) {
        return createUser(user.getAccountname(), user.getPassword().toCharArray(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getReg_date(), user.getLast_login(), user.getTime_played(), user.getUcoins());
    }

    /**
     * creates a new user (new profile-file)
     * @param accountname the name of the account
     * @param password user's password
     * @param email user's email
     * @param first_name user's first name
     * @param last_name user's last name
     * @return true if successful, false otherwise
     */
    public static boolean createUser(String accountname, char[] password, String email, String first_name, String last_name) {
        return createUser(accountname, password, email, first_name, last_name, new Date(), new Date(), 0, 0);
    }

    /**
     * @param accountname the name of the account
     * @param password user's password
     * @param email user's email
     * @param first_name user's first name
     * @param last_name user's last name
     * @param registerDate date of the registration
     * @param lastLogin date of the last login
     * @param timePlayed time played by the user
     * @param UCoins ucoin-amount
     * @return true if successful, false otherwise
     */
    public static boolean createUser(String accountname, char[] password, String email, String first_name, String last_name, Date registerDate, Date lastLogin, long timePlayed, int UCoins) {

        //set up an array with the user-data to write:
        String str[] = new String[9];
        str[0] = accountname;
        str[1] = new String(password);
        /*
         * swing.password-fields return a 1-dim char-array, it's easier to work
         * with a string here
         */
        str[2] = email;
        str[3] = first_name;
        str[4] = last_name;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-y");      //set format for the date (eg. 24.10.2012)
        str[5] = format.format(registerDate);       //get the current date with the set format
        str[6] = format.format(lastLogin);    //last login
        str[7] = Long.toString(timePlayed);   //time played
        str[8] = Integer.toString(UCoins);   //UCoins

        //ready to create the user-files
        java.util.LinkedList users = new java.util.LinkedList<>();      //needed for updating the userlist-file
        try {
            //create the userfolder (automatically through through writeCSV()) and create the needed userfiles
            CSVHandling.writeCSV(str, Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._profileFileName);
            //CSVHandling.writeFile("", Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._inventoryFileName);
            //CSVHandling.writeFile("0", Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._gameFileName);
            JTextField[] toCheck = {new JTextField(accountname), new JTextField(email)};
            JLabel[] placebo = {new JLabel(), new JLabel()};
            if (!Sims_1.checkGlobUser(toCheck, placebo)) {
                try {
                    users = CSVHandling.readCSV(Sims_1._usersFileName);     //try reading the userlist
                } catch (Exception e) {
                    e.printStackTrace();
                }
                java.util.LinkedList newUser;
                users.add(newUser = new java.util.LinkedList<String>());
                newUser.add(accountname);       //add the new username and email to the userlist
                newUser.add(email);
                CSVHandling.writeCSV(users, Sims_1._usersFileName);     //rewrite the userlist-file
                return true;            //end if everything went well
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;      //exception has been thrown before the userlist-file could be written
    }
}
