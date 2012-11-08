/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Joerg Woditschka
 * @author Nadir Yuldashev
 */
public class Student {
    private int id;
    private double knowledge=0; 
    private double knowledgeIncreasement;
    private final double intelligence = initIntelligence();
    private double tiredness;
    private double motivation;
    public boolean laptopClosed = true;
    private String studIconPath;
    private boolean cheatAvailable; //added by Julia    
    public final String[] iconPath = {
            "/pictures/studentface1transparent.png",
            "/pictures/studentface2transparent.png",
            "/pictures/studentface3transparent.png",
            "/pictures/studentface4transparent.png",
            "/pictures/studentface5transparent.png"};
    
    /**
     * 
     * @param id 
     */   
    public Student(int id){
        this.id=id;
        initTiredness();
        initMotivation();
        initIcon();
    }

    /**
     *
     * @return a double of value between 0 and 40 This functions initializes the
     * value of the tiredness attribute.
     */
    private void initTiredness() {
        this.tiredness=Math.round(Math.random()*40);
    }

     /**
     *
     * @return a double of value between 50 and 90 This functions initializes the
     * value of the motivation attribute.
     */
    private void initMotivation() {
        this.motivation=Math.round(50+Math.random()*40);
    }
    
    /**
     *
     * @return a IconPath for a student
     */
    private void initIcon(){
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
    void updateKnowledge(double add) {
        if (add!=-1){
        this.knowledgeIncreasement = ((this.motivation - this.tiredness) * this.intelligence * 0.000375)-add;
        if(this.knowledgeIncreasement<0) // this if belongs above the this.knowledge
            this.knowledgeIncreasement = 0;
        }
        else {
            this.knowledgeIncreasement = 0;
        }
        setKnowledge(this.knowledge + this.knowledgeIncreasement); //edited by Jörg: use setter to make sure that 0<value<100
        
    }
     
    void changeTiredness(double factor)
    {
       setTiredness(this.tiredness+1*factor); //edited by Jörg: use setter to make sure that 0<value<100
    }
     
    void changeMotivation(double factor)
    {
       setMotivation(this.motivation+1*factor); //edited by Jörg: use setter to make sure that 0<value<100
    }
    
    /**
     *
     * @return the id attribute of the student is returned
     */
    public double getId() {
        return this.id;
    }
    
       /**
     *
     * @return the knowledge attribute of the student is returned
     */
    public double getKnowledge() {
        return this.knowledge;
    }

    /**
     *
     * @param value
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
     *
     * @return the intelligence attribute of the student is returned
     */
    public double getIntelligence() {
        return this.intelligence;
    }

    /**
     *
     * @return the tiredness attribute of the student is returned
     */
    public double getTiredness() {
        return this.tiredness;
    }
    
    /**
     *
     * @return the 
     */
    public String getStudIcon() {
        return this.studIconPath;
    }

    /**
     *
     * @param value
     */
    public void setTiredness(double value) {
        if (!laptopClosed){
            value=value+0.7; // Making the tiredness grow faster than usual, but not as fast as motivation, so that it will have an effect; Changing constant to relative value? (value= value+ (value/100))
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
     *
     * @return the motivation attribute of the student is returned
     */
    public double getMotivation() {
        return this.motivation;
    }

    /**
     *
     * @param value the new value of motivation
     * 
     * Added the implementation of the increase when the laptop is opened. Also added the automatic opening of the laptop once the motivation goes below 30
     * Problem = Motivation will NEVER go below 30!
     * A number of times the student can open their laptop? Random?
     */
    public void setMotivation(double value) {
        if (!laptopClosed){
            value=value+3;
        }
        if(value<0){
            this.motivation= 0;
        }else if(value>100){
            this.motivation=100;
        }else{
            if (value<30 && laptopClosed) {
                laptopClosed=false;
            }
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
     * 
     * @return  true if a student has the CheatSheet.
     */
    
    public boolean getCheatAvailable(){
        return this.cheatAvailable;
    }
}