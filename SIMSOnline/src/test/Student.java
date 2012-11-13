/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Objects of this class are one student of the game
 * @author Joerg Woditschka
 * @author Nadir Yuldashev
 */
public class Student {
    @Deprecated private int id = 0;
    private double knowledge=0;                 //in savefile
    private double knowledgeIncreasement;
    private double intelligence; //= initIntelligence(); //in savefile
    private double tiredness;
    private double motivation;
    public boolean laptopClosed = true;
    public boolean present;// = true;
    private String studIconPath;    // added by Tobias
    private boolean cheatAvailable; //added by Julia   
    public final String[] iconPath = {  // added by Tobias
            "/pictures/studentface1_60x60.png",
            "/pictures/studentface2_60x60.png",
            "/pictures/studentface3_60x60.png",
            "/pictures/studentface4_60x60.png",
            "/pictures/studentface5_60x60.png"};
    public int iconNum;
    
    /**
     * 
     * @param id 
     */   
    @Deprecated public Student(int id){
        this.id=id;
        initTiredness();
        initMotivation();
        initIcon();
    }
    
    public Student(LinkedList<String> student){
        this.knowledge = new Double(student.pop());
        this.intelligence = new Double(student.pop());
        //System.out.println(this.intelligence);
        this.iconNum = new Integer(student.pop());
        this.studIconPath = iconPath[this.iconNum];
        this.cheatAvailable = Boolean.getBoolean(student.pop());
        if(student.pop().equals("0")){
            this.present = false;
        } else {
            this.present = true;
        }
    }

    /**
     *
     * @return a double of value between 0 and 40 This functions initializes the
     * value of the tiredness attribute.
     */
    public void initTiredness() {
        this.tiredness=Math.round(Math.random()*40);
    }

     /**
     *
     * @return a double of value between 50 and 90 This functions initializes the
     * value of the motivation attribute.
     */
    public void initMotivation() {
        this.motivation=Math.round(50+Math.random()*40);
    }
    
    /**
     * initializes the icon to a student
     * @return a IconPath for a student
     */
    public void initIcon(){
        this.studIconPath = iconPath[(int)(Math.random()*5)]; 
    }

     /**
     *
     * @return a double of value between 1,30 and 2,00 This functions initializes the
     * value of the intelligence attribute. This is only done once for each
     * student.
     */
    private double initIntelligence() {
        double result = Math.round((1.3 + Math.random() % 0.7) * 100);
        result = result / 100;
        return result;
    }

    /**
     * This functions updates the knowledge and the knowledgeincreasement values
     * of the student. It should be run once every second.
     * Updated by Kira: Added 'add', to realize the decreasing knowledgeIncreasement during teamwork and the nonexistent knowledgeIncreasement during shortBreak.
     */
    
    /**
    * This function updates the knowledge through calculating the knowledgeIncreasement and summing it and the knowledge up.
    * The knowledgeIncreasement is influenced by the intelligence of the row a certain student is seated in and the surroundings, such as break and teamwork.
    * 
    * @param add    If add=-1, the knowledgeIncreasement will be 0. In case of a break, it will be 0.02, and per default it's 0, so that it won't influence the knowledgeIncreasement.
    * @param rowIntelligence    The average of the intelligence of the students in one row.
    */
    void updateKnowledge(double add, double rowIntelligence) {
        double influence=0;
        if (add!=-1){
            if (rowIntelligence<1.65){
                influence=-0.005*rowIntelligence;
            }
            else if (rowIntelligence>1.65){
                influence=0.005*rowIntelligence;
            }
            this.knowledgeIncreasement = ((this.motivation - this.tiredness) * this.intelligence * 0.00075)+influence-add;
            if(this.knowledgeIncreasement<0){ 
                this.knowledgeIncreasement = 0;
            }
        }
        else {
            this.knowledgeIncreasement = 0;
        }
        setKnowledge(this.knowledge + this.knowledgeIncreasement); //edited by Jörg: use setter to make sure that 0<value<100        
    }
   
    /**
     * Changes the tiredness value by calling the setTiredness function.
     * 
     * @param factor    The value by which the tiredness is increased.
     */
    public void changeTiredness(double factor)
    {
       setTiredness(this.tiredness+factor);
    }
     
    /**
     * Changes the motivation value by calling the setMotivation function.
     * 
     * @param factor    The value by which the motivation is decreased.
     */
    public void changeMotivation(double factor)
    {
       setMotivation(this.motivation+factor);
    }
    
    /**
     *
     * @return the id attribute of the student is returned
     */
    public double getId() {
        return this.id;
    }
    
       /**
     *getMethod for the knowledge-value.
     * 
     * @return the knowledge attribute of the student is returned
     */
    public double getKnowledge() {
        return this.knowledge;
    }

    /**
     *setter for the Knowledge. Main functionality is that it won't allow a value x<1 or x>100.
     * 
     * @param value sets the knowledge of the students
     */
    public void setKnowledge(double value) {
        if(value<0){
            this.knowledge= 0;
        }else if(value>100){
            this.knowledge=100;
        }else{
            this.knowledge = value;
        }
    }

    /**
     * getMethod for the intelligence-value.
     * 
     * @return the intelligence attribute of the student is returned
     */
    public double getIntelligence() {
        return this.intelligence;
    }

    /**
     *getMethod for the tiredness-value.
     * 
     * @return the tiredness attribute of the student is returned
     */
    public double getTiredness() {
        return this.tiredness;
    }
    
    /**
     *getMethod for the Student icon path.
     * 
     * @return the 
     */
    public String getStudIcon() {
        return this.studIconPath;
    }

    /**
     *Setter for the tiredness value. Takes the state of a students laptop into consideration. It makes the value grow faster if the laptop is open. Is also influenced by the values of the professor.
     * Prevents a value x<0 and x>100.
     * 
     * @param value sets the tiredness of the student
     */
    public void setTiredness(double value) {
        value=value+Sims_1._maingame.professor/100;
        if (!laptopClosed){
            value=value+2; // Making the tiredness grow faster than usual, but not as fast as motivation, so that it will have an effect;
        }
        if(value<0){
            this.tiredness= 0;
        }else if(value>100){
            this.tiredness=100;
        }else{
            this.tiredness = value;
        }
    }

    /**
     * getMethod for the motivation-value.
     *
     * @return the motivation attribute of the student is returned
     */
    public double getMotivation() {
        return this.motivation;
    }

    /**
     * Setter for the motivation value. Takes the state of a students laptop into consideration. It makes the value grow faster if the laptop is open. Is also influenced by the values of the professor.
     * Prevents a value x<0 and x>100.
     * Also responsible for the random opening of the students laptops if their motivation drops below a value of 30. The lower the value the higher the possibility of the student opening their laptop.
     * 
     * @param value the new value of motivation
     */
    public void setMotivation(double value) {
        value=value+(Sims_1._maingame.professor/100);
        if (!laptopClosed){
            value=value+2.5;
        }
        else if (value<30 && laptopClosed) {
                double helper = 31-this.motivation;
                double i = Math.round(Math.random());
                if (helper*i>17){
                    laptopClosed=false;
                }
            }
        if(value<0){
            this.motivation= 0;
        }else if(value>100){
            this.motivation=100;
        }else{
            this.motivation = value;
        }
    }
    
    /**
     * CheatSheet will be set 
     * @param flag 
     */
    public void setCheatAvailable(boolean flag){
        this.cheatAvailable=flag;
    }
    
    /**
     * getMethod for the motivation-value.
     * 
     * @return  true if a student has the CheatSheet.
     */
    
    public boolean getCheatAvailable(){
        return this.cheatAvailable;
    }
}
