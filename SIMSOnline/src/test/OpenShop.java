/*
 * Class that is called whenever a player presses the "shop" button during the planning screen.
 * Fills all boxes/ fields in the shop with content
 */
package test;

import javax.swing.JLabel;

/**
 *
 * @author Jannik
 */
public class OpenShop{
    
    public OpenShop(){
        
    }
    
    /**
     * Sets UCoins, Credits and points of the player.
     * At the same moment only in the shop.
     */   
    public void changeLabels(JLabel credits, JLabel points, JLabel ucoins){
        credits.setText(""+Sims_1._maingame.credits);
        points.setText(""+Sims_1._maingame.points);
        ucoins.setText(""+Sims_1._mainuser.getUcoins());
    }
}
