/**
 * Exchanges Coins and Credits.
 */
package test;

import javax.swing.JTextField;

/**
 *
 * @author Jannik
 */
public class CoinExchange {
    Game game = new Game();
    
    public int ucoinsToCredits(int ucoins, int swap, JTextField credit){
        if(ucoins>game.ucoins){
            return 1;
        }
        else{
            credit.setText(""+ucoins*100);
            if(swap == 1){
                game.credits += ucoins*100;
                game.ucoins -= ucoins;
                return 0;
            }
            return 0;
        }  
    }
    
    /*public int creditsToUcoins(int credits, int current){
        return 0;
    }*/
}
