/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;

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
    private int time_played = 0;

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
    public static boolean createUser(String accountname, char[] password, String email, String first_name, String last_name) {
        String str[] = new String[9];
        str[0] = accountname;
        str[1] = new String(password);      /*swing.password-fields return a 1-dim char-array, it's easier to work with a string here */
        str[2] = email;
        str[3] = first_name;
        str[4] = last_name;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd-MM-y");      //set format for the date (eg. 24.10.2012)
        str[5] = format.format(new java.util.Date());       //get the current date with the set format
        str[6] = "";    //last login: never happened yet
        str[7] = "0";   //time played
        str[8] = "0";   //UCoins
        
        //ready to create the user-files
        java.util.LinkedList users = new java.util.LinkedList<>();      //needed for updating the userlist
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
