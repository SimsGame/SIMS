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
    public double airQuality;
    public double noise;
    
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
    /**
     * @param add1  used to determine the changing of the students motivation in relation to the outward conditions (laptop open, teamwork, etc.). Regularly a negative value.
     * @param add2  used to determine the changing of the students motivation in relation to the outward conditions (laptop open, teamwork, etc.). Regularly a positive value.
     */
     public void updateArray (double add1, double add2){
       for (int i = 0; i < 30; i++) {
       studentArray[i].changeMotivation(add1);
       studentArray[i].changeTiredness(add2);
       studentArray[i].updateKnowledge();
       }
    }    

     /**
      * initializes the attributes of the room in general
      */
     public void initRoom(){
         this.airQuality=100;
         this.noise=Math.round(Math.random()*30);
     }
     
     /**
      * @param factor1  describes how much value AirQuality changes. Regularly a negative value.
      * @param factor2  describes how much value Noise changes. Regularly a positive value.
      * 
      * This function updates the attributes of the room.
      */
     public void updateRoom(double factor1, double factor2){
         this.airQuality = this.airQuality + factor1;
         this.noise = this.noise + factor2;
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
