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
//     double id;
//     double intelligence;
      int knowledge_PlP;
      int motivation_PlP = 3;
      int tiredness_PlP;
//     static StudentArray StudArr;
     
     // initializing of the progress bars
     private javax.swing.JProgressBar KnowledgeBar;
     private javax.swing.JProgressBar MotivationBar;
     private javax.swing.JProgressBar TirednessBar;
    
     public PlanningPhase (){
     
     }
     
    public PlanningPhase(javax.swing.JProgressBar jProgB_Knowledge, 
                    javax.swing.JProgressBar jProgB_Motivation, 
                    javax.swing.JProgressBar jProgB_Tiredness){
        
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;

       
//        StudArr = new StudentArray();
//        
//        this.id = StudArr.getArray()[2].getId();
//        this.intelligence = StudArr.getArray()[2].getIntelligence();
//        this.knowledge = StudArr.getArray()[2].getKnowledge();
//        this.motivation = StudArr.getArray()[2].getMotivation();
//        this.tiredness = StudArr.getArray()[2].getTiredness();
        PlanningPhaseMain();
    
    }
    
//    public PlanningPhase(javax.swing.JProgressBar jProgB_Knowledge, 
//                    javax.swing.JProgressBar jProgB_Motivation, 
//                    javax.swing.JProgressBar jProgB_Tiredness){
//        
//        StudInfo x = new StudInfo(jProgB_Knowledge,jProgB_Motivation, jProgB_Tiredness);
//    }
    
    private void PlanningPhaseMain(){
//        System.out.println("id = "+id);
//        System.out.println("id = "+intelligence);
//        System.out.println("id = "+knowledge);
//        System.out.println("id = "+motivation);
//        System.out.println("id = "+tiredness);
        
        StudInfo xx = new StudInfo(KnowledgeBar,MotivationBar,TirednessBar);

    }
    
    
}
