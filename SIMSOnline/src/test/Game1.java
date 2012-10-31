/*
 * This class holds all data during the game to have a samll amount of I/O 
 */
package test;

/**
 *
 * @author Jannik
 */
public class Game1 {
    /**
     * Test attributes. Will be changed by real items from file
     * later. 
     */
    
    public int ucoins;
    public int credits;
    public int points;
    public int semester = 4;
    public Student[] studentArray; //added by Jörg
    
    /**
     * Items are public to have an easy access from every class
     */
    
    public Item duplo;
    public Item redBull;
    public Item cheatSheet;
    public Item omniSenseAudio;
    
    
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
    public void putItem(String name, int amount, int available){
        this.points = 700;
        this.credits = 400;
        if(name.equals("Duplo")){
            this.duplo = new Item(name, amount, available);
            this.duplo.amount = 4;
        }
        if(name.equals("Red Bull")){
            this.redBull = new Item(name, amount, available);
            this.redBull.amount = 5;
        }
        if(name.equals("Spickzettel")){
            this.cheatSheet = new Item(name, amount, available);
            this.cheatSheet.amount = 1;
        }
        if(name.equals("OMNI Sense Audiobuch")){
            this.omniSenseAudio = new Item(name, amount, available);
        }
      }
        public Student[] getArray(){
        return studentArray;
    }
    
}
