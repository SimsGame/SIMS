/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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

    public Admin(JPanel adminpanel) {
        this.adminpanel = adminpanel;
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
            userButtons[i].setLocation(10 + 160 * (i / 10), 10 + (i % 10) * 60);
            userButtons[i].addActionListener(new AdminActionListener(i));
            this.adminpanel.add(userButtons[i]);
            userButtons[i].setVisible(true);
        }

    }

    public void getUser(int index) {
        System.out.println(users.get(index));
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
