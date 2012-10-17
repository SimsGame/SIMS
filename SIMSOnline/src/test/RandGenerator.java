/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Random;

/**
 *
 * @author Stazzer
 */
public class RandGenerator {
    
    public int numberPlace = -1;
	public Random number = new Random();
	
	public int getRand(int mod) {
		while(numberPlace < 0) {
			numberPlace = number.nextInt()%mod;
		}
		return numberPlace;
	}
    
}
