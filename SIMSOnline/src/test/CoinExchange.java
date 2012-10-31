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
    
    public int ucoinsToCredits(int ucoins, int swap, JTextField credit){
        if(ucoins>Sims_1._mainuser.getUcoins()){
            return 1;
        }
        else{
            credit.setText(""+ucoins*100);
            if(swap == 1){
                Sims_1._maingame.credits += ucoins*100;
                Sims_1._mainuser.setUcoins(Sims_1._mainuser.getUcoins()-ucoins);
                return 0;
            }
            return 0;
        }  
    }
}
