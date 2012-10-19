/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JLabel;

/**
 *
 * @author Stazzer
 */
public class OpenShop{
    
    public OpenShop(){
        
    }
    
    public void changeLabels(JLabel credits, JLabel punkte, JLabel ucoins){
        credits.setText("5");
        punkte.setText("7");
        ucoins.setText("50");
    }
}
