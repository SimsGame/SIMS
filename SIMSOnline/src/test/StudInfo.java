/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Tobi
 */
public class StudInfo{
        // position number of a student (0-29) which is needed for the StudenArray()
    private int stud_nr;
    
        // int, because the setValue() method of a ProgressBars expects int's and no double
    private int knowledge;
    private int motivation;
    private int tiredness;
    
    private double knowledge_H  = 0.0;
    private double motivation_H = 0.0;
    private double tiredness_H  = 0.0;
    
        // declaration of the progress bars
     private javax.swing.JProgressBar KnowledgeBar;
     private javax.swing.JProgressBar MotivationBar;
     private javax.swing.JProgressBar TirednessBar; 
        
        // current StudentArray 
    //private StudentArray StudArr = Game.studentArray;
    private  StudentArray StudArr = new StudentArray();   // muss StudArray laden!! sonst wird immer ein neuer erstellt
   
   
        // constructor which expects the three progress bars
   public StudInfo(javax.swing.JProgressBar jProgB_Knowledge, 
                    javax.swing.JProgressBar jProgB_Motivation, 
                    javax.swing.JProgressBar jProgB_Tiredness){
       
            // initializes the three progress bars to set values later
       this.KnowledgeBar = jProgB_Knowledge;
       this.MotivationBar = jProgB_Motivation;
       this.TirednessBar = jProgB_Tiredness;
       
      StudInfoAverage();
  
       
   }
   
//        // Constructor when Student-button is clicked
//        // student position and the 3 progress bars 
//    public StudInfo(int stud_nr,
//                    javax.swing.JProgressBar jProgB_Knowledge, 
//                    javax.swing.JProgressBar jProgB_Motivation, 
//                    javax.swing.JProgressBar jProgB_Tiredness){
//        
//        this.stud_nr = stud_nr;
//        
//        this.KnowledgeBar = jProgB_Knowledge;
//        this.MotivationBar = jProgB_Motivation;
//        this.TirednessBar = jProgB_Tiredness;
//        
//        this.knowledge =    (int) StudArr.getArray()[stud_nr].getKnowledge();
//        this.motivation =   (int) StudArr.getArray()[stud_nr].getMotivation();
//        this.tiredness =    (int) StudArr.getArray()[stud_nr].getTiredness();
//        
//        StudInfoSetBars();
//    }
        // initializes the attributes of the selected student
    public void StudInfoAttr(int stud_nr){
        
        this.knowledge =    (int) StudArr.getArray()[stud_nr].getKnowledge();
        this.motivation =   (int) StudArr.getArray()[stud_nr].getMotivation();
        this.tiredness =    (int) StudArr.getArray()[stud_nr].getTiredness();
        
        StudInfoSetBars();
    }
    
        // calculates the average attributs values of all students 
    public void StudInfoAverage(){
        this.knowledge_H=0;
        this.motivation_H=0;
        this.tiredness_H=0;
        
        // iterates the studentArray and sum up the attribute values
    for (int i=0; i<30; i++){
            this.knowledge_H  = this.knowledge_H  +   StudArr.getArray()[2].getKnowledge();
            this.motivation_H = this.motivation_H +   StudArr.getArray()[2].getMotivation();
            this.tiredness_H  = this.tiredness_H  +   StudArr.getArray()[2].getTiredness();
       }
       
       this.knowledge =  (int) (this.knowledge_H/30);
       this.motivation = (int) (this.motivation_H/30);
       this.tiredness =  (int) (this.tiredness_H/30);
       
       StudInfoSetBars();
    }
    
    
            // visualizes the attributs of a student via the progress bars
        private void StudInfoSetBars(){
        KnowledgeBar.setValue(knowledge); 
         KnowledgeBar.repaint();
         
        MotivationBar.setValue(motivation); 
         MotivationBar.repaint();
         
        TirednessBar.setValue(tiredness); 
         TirednessBar.repaint();

    }
    
}
