/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.ImageIcon;

/**
 *
 * @author Tobi
 */
public class StudIcons {
    
    public StudIcons (javax.swing.JButton[] studButtons, Student[] studArray){
        int i;
        for (i=0;i<30;i++){
            studButtons[i].setIcon(new ImageIcon(getClass().getResource(studArray[i].getStudIcon())));
        }
    }
}
