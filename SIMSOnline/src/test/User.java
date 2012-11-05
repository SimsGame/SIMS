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

/**
 *
 * @author rusinda
 */
public class User {

    private String accountname = "";
    private String password = "";
    private String email = "";
    private String first_name = "";
    private String last_name = "";
    private Date reg_date = new Date();
    private Date last_login = new Date();
    private int ucoins = 0;

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

    public int getTime_played() {
        return time_played;
    }

    public void setUcoins(int ucoins) {
        this.ucoins = ucoins;
    }

    public int getUcoins() {
        return ucoins;
    }
    private int time_played = 0;

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

    public User() {
        accountname = "blubb";
        password = "blubb";
        email = "blubb@blubb.com";
        first_name = "Blubb";
        last_name = "Blubber";
        ucoins = 500;
    }

    public User(String accname) {
        String[] userData = null;
        try {
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
            ucoins = Integer.parseInt(userData[7]);
            time_played = Integer.parseInt(userData[8]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * creates a new user on the local system, needed for registration
     *
     * @param accountname string
     * @param password char[]
     * @param email string
     * @param first_name string
     * @param last_name string
     * @return true if the user could be created, false otherwise
     */
    public static boolean deleteUser(String accountname, String email) {

        LinkedList<LinkedList> userlist = null;
        LinkedList<LinkedList> uhelp = null;

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
            File fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._inventoryFileName);
            fileToDelete.delete();
            fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._gameFileName);
            fileToDelete.delete();
            fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._profileFileName);
            fileToDelete.delete();
            fileToDelete = new File(Sims_1._dataFolderName + "/" + accountname);
            fileToDelete.delete();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean createUser(User user) {
        return createUser(user.getAccountname(), user.getPassword().toCharArray(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getReg_date(), user.getLast_login(), user.getTime_played(), user.getUcoins());
    }

    public static boolean createUser(String accountname, char[] password, String email, String first_name, String last_name) {
        return createUser(accountname, password, email, first_name, last_name, new Date(), new Date(), 0, 0);
    }

    public static boolean createUser(String accountname, char[] password, String email, String first_name, String last_name, Date registerDate, Date lastLogin, int timePlayed, int UCoins) {

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
        str[7] = Integer.toString(timePlayed);   //time played
        str[8] = Integer.toString(UCoins);   //UCoins

        //ready to create the user-files
        java.util.LinkedList users = new java.util.LinkedList<>();      //needed for updating the userlist-file
        try {
            //create the userfolder (automatically through through writeCSV()) and create the needed userfiles
            CSVHandling.writeCSV(str, Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._profileFileName);
            CSVHandling.writeFile("", Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._inventoryFileName);
            CSVHandling.writeFile("", Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._gameFileName);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;      //exception has been thrown before the userlist-file could be written
    }
}
