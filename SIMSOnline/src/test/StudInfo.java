/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Tobias Mauritz
 */
public class StudInfo {

    // int, because the setValue() method of a ProgressBars expects int's and no double
    private int knowledge;
    private int motivation;
    private int tiredness;
    private double knowledge_H = 0.0;
    private double motivation_H = 0.0;
    private double tiredness_H = 0.0;
    // declaration of the progress bars
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    // current StudentArray 
    private Student[] studArr;
    private int presentCounter;


    /**
     * - constructor which expects the three progress bars <br>
     * - called on loading the PlanningPhase
     * @param jProgB_Knowledge progress bar which shows the knowledge
     * @param jProgB_Motivation progress bar which shows the motivation
     * @param jProgB_Tiredness progress bar which shows the tiredness
     */
    public StudInfo(javax.swing.JProgressBar jProgB_Knowledge,
            javax.swing.JProgressBar jProgB_Motivation,
            javax.swing.JProgressBar jProgB_Tiredness) {

        
        // initializes the three progress bars to set values later
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;
        
        // studArr gets the StudentArray of current game
        this.studArr = Sims_1._maingame.getArray();
        // shows average values when PlanningPhase is loaded
        StudInfoAverage();


    }

    
    /**
     * - initializes the attributes of the selected student
     * @param stud_nr array index number of the student array
     */
    public void StudInfoAttr(int stud_nr) {
        if (studArr[stud_nr].present){
        this.knowledge = (int) studArr[stud_nr].getKnowledge();
        this.motivation = (int) studArr[stud_nr].getMotivation();
        this.tiredness = (int) studArr[stud_nr].getTiredness();

        StudInfoSetBars();
        } else{
            this.knowledge = 0;
            this.motivation = 0;
            this.tiredness = 0;
            System.out.println("Student not present!");
            StudInfoSetBars();
        }
    }

    
    /**
     * - calculates the average attributs values of all students
     */
    public void StudInfoAverage() {
        // initializing to 0
        this.knowledge_H = 0;
        this.motivation_H = 0;
        this.tiredness_H = 0;
        this.presentCounter = 0;

        // iterates the studentArray and sum up the attribute values
        for (int i = 0; i < 30; i++) {
            if (studArr[i].present){
            this.presentCounter = this.presentCounter + 1;
            this.knowledge_H = this.knowledge_H + studArr[i].getKnowledge();
            this.motivation_H = this.motivation_H + studArr[i].getMotivation();
            this.tiredness_H = this.tiredness_H + studArr[i].getTiredness();
            }
        }

        this.knowledge = (int) (this.knowledge_H / this.presentCounter);
        this.motivation = (int) (this.motivation_H / this.presentCounter);
        this.tiredness = (int) (this.tiredness_H / this.presentCounter);
        
        Sims_1._maingame.avarageMotivation = this.motivation;
        Sims_1._maingame.averageKnowledge = this.knowledge;
        Sims_1._maingame.averageTiredness = this.tiredness;
        StudInfoSetBars();
    }

    
        // sets the progress bars
    private void StudInfoSetBars() {
        KnowledgeBar.setValue(knowledge);
        KnowledgeBar.repaint();

        MotivationBar.setValue(motivation);
        MotivationBar.repaint();

        TirednessBar.setValue(tiredness);
        TirednessBar.repaint();

    }
}
