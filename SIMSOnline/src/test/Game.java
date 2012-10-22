/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Stazzer
 */
public class Game {
    public int ucoins = 5;
    public int credits = 60;
    public int points = 700; 
    
    public Item duplo;
    public Item redBull;
    public Item cheatSheet;
    public Item omniSenseAudio;
    
    public void putItem(Item item){
        if(item.name.equals("Duplo")){
            this.duplo = item;
        }
        if(item.name.equals("Red Bull")){
            this.redBull = item;
        }
        if(item.name.equals("Spickzettel")){
            this.cheatSheet = item;
        }
        if(item.name.equals("OMNI Sense Audiobuch")){
            this.omniSenseAudio = item;
        }
    }
}
