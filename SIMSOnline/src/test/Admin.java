/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.*;
import java.util.LinkedList;

/**
 *
 * @author Dawid Rusin
 */
public class Admin {

    LinkedList<User> users = new LinkedList();  //list of all user on the local system
    JButton[] userButtons;      //buttons to open the user-data
    JPanel adminpanel;          //panel where the admin-view is displayed in
    JPanel userpanel;           //panel where the user-data is displayed in
    JTextField[] userdata;      //textfields with the userdata and the gamestate-data
    JSlider months;             //slider for the months/rounds ingame
    User currentuser;           //the current user beeing edited
    JLabel[] errMess;           //labels to display the errormessages

    /**
     * Constructor, creates the admin-view
     * @param adminpanel panel to display the admin view
     * @param userpanel panel to display the user-data
     * @param userdata textfields containing the user- and game state-data
     * @param months Slider to display the in-game rounds/months
     * @param errMess labels to display error messages
     */
    public Admin(JPanel adminpanel, JPanel userpanel, JTextField[] userdata, JSlider months, JLabel[] errMess) {

        this.errMess = errMess;
        for (int i = 0; i < this.errMess.length; i++) {
            this.errMess[i].setText("");
        }
        this.adminpanel = adminpanel;
        this.adminpanel.removeAll();
        this.userpanel = userpanel;
        this.months = months;
        this.userdata = userdata;
        String[][] userList = null;
        try {
            //read the list of all users
            userList = CSVHandling.readCSVStringArr2(Sims_1._usersFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(userList == null)) {
            for (int i = 0; i < userList.length; i++) {
                try {
                    //add the users to Admin.users
                    users.add(new User(userList[i][0]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //init the array of buttons to open user-data
        userButtons = new JButton[users.size()];
        LinkedList<User> usersHelp = (LinkedList<User>) users.clone();
        for (int i = 0; i < userButtons.length; i++) {
            //display the username as button-label
            userButtons[i] = new JButton(usersHelp.pop().getAccountname());
            //set size of the buttons and the position in the panel
            userButtons[i].setSize(150, 50);
            userButtons[i].setLocation(10 + 160 * (i / 9), 80 + (i % 9) * 60);
            userButtons[i].addActionListener(new AdminActionListener(i));
            this.adminpanel.add(userButtons[i]);
            userButtons[i].setVisible(true);
        }

    }

    /**
     * Sets Admin.currentuser as the current user being edited, also initializes the text fields with the needed data
     * @param index the number of the user-button
     */
    private void getUser(int index) {

        currentuser = users.get(index);
        Sims_1._mainuser = currentuser;
        userdata[0].setText(currentuser.getAccountname());
        userdata[1].setText(currentuser.getPassword());
        userdata[2].setText(currentuser.getEmail());
        userdata[3].setText(currentuser.getFirst_name());
        userdata[4].setText(currentuser.getLast_name());
        userdata[5].setText(Integer.toString(currentuser.getUcoins()));
        
        if (new File(Sims_1._dataFolderName + "/" + currentuser.getAccountname() + "/" + Sims_1._gameFileName).exists()) {
        Game1.loadGame();
        userdata[6].setText(Integer.toString(Sims_1._maingame.credits));
        userdata[7].setText(Integer.toString(Sims_1._maingame.duplo.amount));
        userdata[8].setText(Integer.toString(Sims_1._maingame.redBull.amount));
        userdata[9].setText(Integer.toString(Sims_1._maingame.omniSenseAudio.amount));
        userdata[10].setText((Integer.toString(Sims_1._maingame.cheatSheet.amount)));
        months.setValue(Sims_1._maingame.round);             //aus Spielstand
        } else {
            months.setValue(1);
        }
        adminpanel.setVisible(false);
        userpanel.setVisible(true);
    }

    /**
     * Checks if the input done by the admin is valid
     * @return true if the input is valid, false otherwise
     */
    public boolean checkChanges() {
        JComponent[] toCheck = {userdata[0], new JPasswordField(userdata[1].getText()), new JPasswordField(userdata[1].getText()), userdata[2], userdata[2], userdata[3], userdata[4]};
        JLabel[] errMessLoc = {errMess[0], errMess[1], errMess[1], errMess[2], errMess[2], errMess[3], errMess[4]};
        boolean checked = true;
        int check = -1;
        for (int i = 0; i < 5; i++) {
            check = -1;
            try {
                check = new Integer(userdata[6 + i].getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (check < 0) {
                errMess[6 + i].setText("Ungültige eingabe");
                checked = false;
            }

        }
        return (Sims_1.checkRegister_(toCheck, errMessLoc)) & checked;
    }

    /**
     * Deletes the user currentuser from the local machine
     */
    public void delSpecUser() {
        User.deleteUser(currentuser.getAccountname(), currentuser.getEmail());
        User.deleteAllUserFiles(currentuser.getAccountname());
    }

    /**
     * Saves the changes done by the admin
     */
    public void saveChages() {
        User.deleteUser(currentuser.getAccountname(), currentuser.getEmail());

        currentuser.setAccountname(userdata[0].getText());
        currentuser.setPassword(userdata[1].getText());
        currentuser.setEmail(userdata[2].getText());
        currentuser.setFirst_name(userdata[3].getText());
        currentuser.setLast_name(userdata[4].getText());
        currentuser.setUcoins(new Integer(userdata[5].getText()));

        Sims_1._maingame.credits = new Integer(userdata[6].getText());
        Sims_1._maingame.duplo.amount = new Integer(userdata[7].getText());
        Sims_1._maingame.redBull.amount = new Integer(userdata[8].getText());
        Sims_1._maingame.omniSenseAudio.amount = new Integer(userdata[9].getText());
        Sims_1._maingame.cheatSheet.amount = 0;
        Sims_1._maingame.round = new Integer(months.getValue());

        User.createUser(currentuser);
        Game1.saveGame();

        JOptionPane.showMessageDialog(null, "Daten erfolgreich geändert!");
    }

    /**
     * Custom ActionListener for the user buttons to determine the index of the user clicked
     */
    private class AdminActionListener implements ActionListener {

        int index;

        public AdminActionListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getUser(index);
        }
    }
}
