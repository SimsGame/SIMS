/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.ImageIcon;

/**
 *
 * @author Tobias Mauritz
 */
public class StudIcons {
    /**
     * - uses the iconPath attribute of a student to set the icon of a button
     * @param studButtons array of buttons of the students (buttons from planning or activity phase
     * @param studArray the current student array 
     */
    public StudIcons (javax.swing.JButton[] studButtons, Student[] studArray){
        int i;
        for (i=0;i<30;i++){
            studButtons[i].setIcon(new ImageIcon(getClass().getResource(studArray[i].getStudIcon())));
        }
    }
}
