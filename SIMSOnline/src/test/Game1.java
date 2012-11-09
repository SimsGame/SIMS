/*
 * This class holds all data during the game to have a samll amount of I/O 
 */
package test;

import java.awt.Color;

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
    public int professor; //added by Julia
    public int barNum = 0; //value defines attribute statusbar which is actually clicked: 0: none, 1: knowledge, 2: motivation, 3: tiredness
    public Student[] studentArray; //added by Jörg
    public double[] rowIntelligence;
    public double airQuality;
    public double noise;
    public int quietingCounter=0;
    public int lecturer_counter=3;
    public boolean teamwork = false;
    public boolean shortBreak = false;
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
      int counter = 0;
      int endCounter=5;
      for (int j=0; j<6; j++){
            for (int i=counter; i<endCounter; i++){
                if (quietingCounter>0&&add1>=0){
                    add1=-1;
                }
                else if(quietingCounter>0){
                    add1=add1-1;
                }
                studentArray[i].changeMotivation(add1);
                studentArray[i].changeTiredness(add2);
                studentArray[i].updateKnowledge(add3, rowIntelligence[j]);   //changed by Kira: Added another variable and changed updateKnowledge in Student.java
            }
            counter=counter+5;
            endCounter=endCounter+5;
       }
     }

     public void calculateRowIntelligence(){
        rowIntelligence = new double[6];
        int rowStart=0;
        int rowEnd=5;
        double row=0;
        for (int i=0; i<6; i++){
            for (int j=rowStart; j<rowEnd;j++){
                row = row+studentArray[j].getIntelligence();
            }
            row=row/5;
            rowIntelligence[i]=row;
            row=0;
            rowStart=rowStart+5;
            rowEnd=rowEnd+5;
        }
     }
     
     public void examTime(double examvalue){
         for (int i = 0; i < 30; i++) {
             if (studentArray[i].present){
                 double knowledge=studentArray[i].getKnowledge();
                 if(knowledge<examvalue){
                   studentArray[i].present=false;
                 } 
             }
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
            value=value+5;
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
            value=value+0.5;
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
     * That's how each item can be called by name.
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
    
/**
 * this function takes an array of 30 buttons and paints them to visualize the students attributes.
 * It takes the number of the actually clicked bar of this class to paint the students by taking the right attribute.
 * @param studButtons array of 30 buttons which should be painted
 */
    public void barClicked(javax.swing.JButton[] studButtons){        
        if(this.barNum==0){
            for(int i=0; i<30; i++){
            Color color = new Color(220, 220, 220);
            studButtons[i].setBackground(color);
            studButtons[i].setOpaque(true);
            }
        }else if(this.barNum==1){
            for(int i=0; i<30; i++){
            Color color = new Color((int)(this.studentArray[i].getKnowledge()*2.55), 0, 0);
            studButtons[i].setBackground(color);
            studButtons[i].setOpaque(true);
            }
        } else if(this.barNum==2){
            for(int i=0; i<30; i++){
            Color color = new Color(0, (int)(this.studentArray[i].getMotivation()*2.55), 0);
            studButtons[i].setBackground(color);
            studButtons[i].setOpaque(true);
            }
        } else if(this.barNum==3){
            for(int i=0; i<30; i++){
            Color color = new Color(0, 0, (int)(this.studentArray[i].getTiredness()*2.55));
            studButtons[i].setBackground(color);
            studButtons[i].setOpaque(true);
            }
        }
    }
}
