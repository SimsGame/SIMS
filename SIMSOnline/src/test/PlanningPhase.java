/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * 
 * @author Tobias Mauritz
 * @author Yuliya
 */
public class PlanningPhase {

     
     // deklaration of the progress bars
     private javax.swing.JProgressBar KnowledgeBar;
     private javax.swing.JProgressBar MotivationBar;
     private javax.swing.JProgressBar TirednessBar;
     
     static StudInfo studInfo;
    
     public PlanningPhase (){
     
     }
        // constructor which expects the three progress bars.
        // Thes are needed for the StudInfo methods
    public PlanningPhase(javax.swing.JProgressBar jProgB_Knowledge, 
                    javax.swing.JProgressBar jProgB_Motivation, 
                    javax.swing.JProgressBar jProgB_Tiredness){
        
             // initializes the progress bars
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;

        PlanningPhaseMain();
    
    }
    
    
    public void PlanningPhaseMain(){
        
            // one instance of StudInfo which is used for all student buttons
         studInfo = new StudInfo(KnowledgeBar,MotivationBar,TirednessBar);

    }
    
    
}
