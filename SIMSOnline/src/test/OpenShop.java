/*
 * Class that is called whenever a player presses the "shop" button during the planning screen.
 * Fills all boxes/ fields in the shop with content
 */
package test;

import javax.swing.JLabel;

/**
 *
 * @author Stazzer
 */
public class OpenShop{
    
    Game game = new Game();
    
    public OpenShop(){
        
    }
    
    /*
     * Sets UCoins, Credits and points of the player
     */
    
    public void changeLabels(JLabel credits, JLabel points, JLabel ucoins){
        credits.setText(""+game.credits);
        points.setText(""+game.points);
        ucoins.setText(""+game.ucoins);
    }
}
