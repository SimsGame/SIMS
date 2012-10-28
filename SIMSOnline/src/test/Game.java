/*
 * This class holds all data during the game to have a samll amount of I/O 
 */
package test;

/**
 *
 * @author Jannik
 */
public class Game {
    /**
     * Test attributes. Will be changed by real items from file
     * later. 
     */
    
    public static int ucoins;
    public static int credits;
    public static int points;
    public int semester = 4;
    public Student[] studentArray; //added by Jörg
    
    /**
     * Items are public to have an easy access from every class
     */
    
    public static Item duplo;
    public static Item redBull;
    public static Item cheatSheet;
    public static Item omniSenseAudio;
    
    
    /**
     * initializes the array of students.
     */
    public void initArray() {
        studentArray = new Student[30];
        for (int i = 0; i < 30; i++) {
            studentArray[i] = new Student(i);
        }
    }
    
     public void updateArray (double factor1, double factor2){
       for (int i = 0; i < 30; i++) {
       studentArray[i].changeMotivation(factor1);
       studentArray[i].changeTiredness(factor2);
       studentArray[i].updateKnowledge();
       }
    }    
    /**
     * Receives data (Item Objects) from Item.java and
     * stores them in the fitting Item Objects in this class.
     * That's how each item can becalled by name.
     */
    public void putItem(Item item){
        this.points = 700;
        this.ucoins = 50;
        this.credits = 400;
        if(item.name.equals("Duplo")){
            this.duplo = item;
            this.duplo.amount = 4;
        }
        if(item.name.equals("Red Bull")){
            this.redBull = item;
            this.redBull.amount = 5;
        }
        if(item.name.equals("Spickzettel")){
            this.cheatSheet = item;
            this.cheatSheet.amount = 1;
        }
        if(item.name.equals("OMNI Sense Audiobuch")){
            this.omniSenseAudio = item;
            this.omniSenseAudio.amount = 6;
        }
      }
    
}
