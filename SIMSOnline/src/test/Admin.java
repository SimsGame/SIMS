/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import java.util.LinkedList;

/**
 *
 * @author rusinda
 */
public class Admin {
    
    LinkedList<User> users = new LinkedList();
    JButton[] userButtons;
    JPanel adminpanel;
    JPanel userpanel;
    JTextField[] userdata;
    JCheckBox spicker;
    JSlider months;
    User currentuser;
    JLabel[] errMess;
    
    public Admin(JPanel adminpanel, JPanel userpanel, JTextField[] userdata, JCheckBox spicker, JSlider months, JLabel[] errMess) {
        
        this.errMess = errMess;
        for(int i = 0; i< this.errMess.length; i++){
            this.errMess[i].setText("");
        }
        this.adminpanel = adminpanel;
        this.adminpanel.removeAll();
        this.userpanel = userpanel;
        this.months = months;
        this.userdata = userdata;
        this.spicker = spicker;
        String[][] userList = null;
        try {
            userList = CSVHandling.readCSVStringArr2(Sims_1._usersFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(userList == null)) {
            for (int i = 0; i < userList.length; i++) {
                try {
                    users.add(new User(userList[i][0]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        userButtons = new JButton[users.size()];
        LinkedList<User> usersHelp = (LinkedList<User>) users.clone();
        for (int i = 0; i < userButtons.length; i++) {
            userButtons[i] = new JButton(usersHelp.pop().getAccountname());
            userButtons[i].setSize(150, 50);
            userButtons[i].setLocation(10 + 160 * (i /9), 80 + (i % 9) * 60);
            userButtons[i].addActionListener(new AdminActionListener(i));
            this.adminpanel.add(userButtons[i]);
            userButtons[i].setVisible(true);
        }
        
    }
    
    private void getUser(int index) {
        
        currentuser = users.get(index);
        userdata[0].setText(currentuser.getAccountname());
        userdata[1].setText(currentuser.getPassword());
        userdata[2].setText(currentuser.getEmail());
        userdata[3].setText(currentuser.getFirst_name());
        userdata[4].setText(currentuser.getLast_name());
        userdata[5].setText(Integer.toString(currentuser.getUcoins()));
        userdata[6].setText("aus Spielstand");
        userdata[7].setText("aus Spielstand");
        userdata[8].setText("aus Spielstand");
        userdata[9].setText("aus Spielstand");
        spicker.setSelected(false);     //aus Spielstand
        months.setValue(4);             //aus Spielstand
        
        adminpanel.setVisible(false);
        userpanel.setVisible(true);        
    }
    
    public boolean checkChanges(){
        JComponent[] toCheck = {userdata[0], new JPasswordField(userdata[1].getText()), new JPasswordField(userdata[1].getText()), userdata[2], userdata[2], userdata[3], userdata[4]};
        JLabel[] errMessLoc = {errMess[0], errMess[1], errMess[1], errMess[2], errMess[2], errMess[3], errMess[4]};
        
        return (Sims_1.checkRegister_(toCheck, errMessLoc));
    }
    
    public boolean checkChanges_() {
        
        if (!Sims_1.checkAlphaNumm(userdata[0].getText().toCharArray()) | userdata[0].getText().length() < 5 | userdata[0].getText().length() > 15) {
            userdata[0].setBackground(Color.red);
            return false;
        } else {
            userdata[0].setBackground(Color.white);
        }
        if (!Sims_1.checkAlphaNumm(userdata[1].getText().toCharArray()) | userdata[1].getText().length() < 5 | userdata[1].getText().length() > 15) {
            userdata[1].setBackground(Color.red);
            return false;
        } else {
            userdata[1].setBackground(Color.white);
        }
        if (!Sims_1.checkEmail(userdata[2].getText())) {
            userdata[2].setBackground(Color.red);
            return false;
        } else {
            userdata[2].setBackground(Color.white);
        }
        if (!Sims_1.checkName(userdata[3].getText())) {
            userdata[3].setBackground(Color.red);
            return false;
        } else {
            userdata[3].setBackground(Color.white);
        }
        if (!Sims_1.checkName(userdata[4].getText())) {
            userdata[4].setBackground(Color.red);
            return false;
        } else {
            userdata[4].setBackground(Color.white);
        }
        if (new Integer(userdata[5].getText()) < 0) {
            userdata[5].setBackground(Color.red);
            return false;
        } else {
            userdata[5].setBackground(Color.white);
        }
        return true;
    }
    
    public void delSpecUser() {
        User.deleteUser(currentuser.getAccountname(), currentuser.getEmail());
    }
    
    public void saveChages() {
        delSpecUser();
        
        currentuser.setAccountname(userdata[0].getText());
        currentuser.setPassword(userdata[1].getText());
        currentuser.setEmail(userdata[2].getText());
        currentuser.setFirst_name(userdata[3].getText());
        currentuser.setLast_name(userdata[4].getText());
        currentuser.setUcoins(new Integer(userdata[5].getText()));
        
        User.createUser(currentuser);
    }
    
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
