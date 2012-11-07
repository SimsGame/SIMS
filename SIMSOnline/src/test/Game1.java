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
     * Test attributes. Will be changed by real items from file later.
     */
    public int credits;
    public int points;
    public int round;
    public Student[] studentArray; //added by Jörg
    public double airQuality;
    public double noise;
    public boolean windowClosed = true;
    
    /**
     * Items are public to have an easy access from every class
     */
    public Item duplo;
    public Item redBull;
    public Item cheatSheet;
    public Item omniSenseAudio;
    private Boolean[] cheated = new Boolean[5];

    public int getSemester() {
        return (round / 3 + 1);
    }

    public boolean getCheated(int semester) {
        int i = semester - 2;
        if (i < 0 | i > 5) {
            return false;
        }
        return cheated[i];
    }

    public boolean setCheated(int semester, boolean flag) {
        int i = semester - 2;
        if (i < 0 | i > 5) {
            return false;
        }
        cheated[i] = flag;
        return true;
    }

    public boolean setCheated(int semester) {
        return setCheated(semester, true);
    }

    /**
     * initializes the array of students.
     */
    public final void initArray() {
        studentArray = new Student[30];
        for (int i = 0; i < 30; i++) {
            studentArray[i] = new Student(i);
        }
    }
    /**
     * @param add1  used to determine the changing of the students motivation in relation to the outward conditions (laptop open, teamwork, etc.). Regularly a negative value.
     * @param add2  used to determine the changing of the students motivation in relation to the outward conditions (laptop open, teamwork, etc.). Regularly a positive value.
     */
     public void updateArray (double add1, double add2, double add3){
       for (int i = 0; i < 30; i++) {
       studentArray[i].changeMotivation(add1);
       studentArray[i].changeTiredness(add2);
       studentArray[i].updateKnowledge(add3);   //changed by Kira: Added another variable and changed updateKnowledge in Student.java
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
      * @param value    The value of the airQuality
      * 
      * Setter used to avoid values x<0 or x>100
      */
     
     public void setAirQuality(double value) {
        if (!windowClosed){
            value=value+3;
        }
        if(value<0){
            this.airQuality= 0;
        }else if(value>100){
            this.airQuality=100;
        }else{
            this.airQuality = value;
        }
    }
     
      /**
      * @param value    The value of the noise
      * 
      * Setter used to avoid values x<0 or x>100
      */
    public void setNoise(double value) {
        if (!windowClosed){
            value=value+0.7;
        }
        if(value<0){
            this.noise= 0;
        }else if(value>100){
            this.noise=100;
        }else{
            this.noise = value;
        }
    }
     /**
      * @param factor1  describes how much value AirQuality changes. Regularly a negative value.
      * @param factor2  describes how much value Noise changes. Regularly a positive value.
      * 
      * This function updates the attributes of the room.
      */
     public void updateRoom(double factor1, double factor2){
         setAirQuality(this.airQuality + factor1);
         setNoise(this.noise + factor2);
     }
     /**
     * Receives data (Item Objects) from Item.java and
     * stores them in the fitting Item Objects in this class.
     * That's how each item can becalled by name.
     */
    
    public final void putItem(String name, int amount, int available) {

        if (name.equals(Item._duploName)) {
            this.duplo = new Item(name, amount, available);
        }
        if (name.equals(Item._redBullName)) {
            this.redBull = new Item(name, amount, available);
        }
        if (name.equals(Item._spickerName)) {
            this.cheatSheet = new Item(name, amount, available);
        }
        if (name.equals(Item._omniSenseName)) {
            this.omniSenseAudio = new Item(name, amount, available);
        }
    }

    public Student[] getArray() {
        return studentArray;
    }

    public Game1() {
        this.putItem(Item._duploName, 1, 0);
        this.putItem(Item._redBullName, 1, 0);
        this.putItem(Item._spickerName, 0, 2);
        this.putItem(Item._omniSenseName, 0, 4);
        this.round = 1;
        this.credits = 100;
        this.points = 0;
        initArray();
        for (int i = 0; i < cheated.length; i++) {
            cheated[i] = false;
        }

    }
}
