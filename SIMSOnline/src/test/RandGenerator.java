/*
 * Creates real random numbers using a salt
 */
package test;

import java.util.Random;

/**
 *
 * @author Jannik
 */
public class RandGenerator {
    
    public int numberPlace = -1;
	public Random number = new Random();
	
        /**
         * Creates the random number with a given modulo.
         * @param mod the modulo to not get too large numbers
         * @return returns the generated random number
         */
	public int getRand(int mod) {
		while(numberPlace < 0) {
			numberPlace = number.nextInt()%mod;
		}
		return numberPlace;
	}
    
}
