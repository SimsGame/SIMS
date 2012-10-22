/*
 * This class holds all data during the game to have a samll amount of I/O 
 */
package test;

/**
 *
 * @author Jannik
 */
public class Game {
    public int ucoins = 5;
    public int credits = 60;
    public int points = 700; 
    
    /**
     * Items are public to have an easy access from every class
     */
    
    public Item duplo;
    public Item redBull;
    public Item cheatSheet;
    public Item omniSenseAudio;
    
    
    /**
     * Receives data (Item Objects) from Item.java and
     * stores them in the fitting Item Objects in this class.
     * That's how each item can becalled by name.
     */
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
