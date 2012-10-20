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
public class OpenShop extends Game{
    
    Game game = new Game();
    
    public OpenShop(){
        
    }
    
    public void changeLabels(JLabel credits, JLabel points, JLabel ucoins){
        credits.setText(String.valueOf(game.credits));
        points.setText(String.valueOf(game.points));
        ucoins.setText(String.valueOf(game.ucoins));
    }
}
