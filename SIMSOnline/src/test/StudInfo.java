/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Tobi
 */
public class StudInfo {
        // position number of a student (0-29) which is needed for the StudenArray()
    private int stud_nr;
    
        // int, because the setValue() method of a ProgressBars expects int's and no double
    private int knowledge;
    private int motivation;
    private int tiredness;
    
        // initializing of the progress bars
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
        
        // current StudentArray 
    private  StudentArray StudArr = new StudentArray();   // muss StudArray laden!! sonst wird immer ein neuer erstellt
    
   
        // Constructor when Student-button is clicked
        // student position and the 3 progress bars 
    public StudInfo(int stud_nr,
                    javax.swing.JProgressBar jProgB_Knowledge, 
                    javax.swing.JProgressBar jProgB_Motivation, 
                    javax.swing.JProgressBar jProgB_Tiredness){
        
        this.stud_nr = stud_nr;
        
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;
        

        this.knowledge =    (int) StudArr.getArray()[stud_nr].getKnowledge();
        this.motivation =   (int) StudArr.getArray()[stud_nr].getMotivation();
        this.tiredness =    (int) StudArr.getArray()[stud_nr].getTiredness();
        
        StudInfoMain();
    }
    
    private void StudInfoMain(){
//        System.out.println(stud_nr);
//        System.out.println("id = "+knowledge);
//        System.out.println("id = "+motivation);
//        System.out.println("id = "+tiredness);
        
            // visualizes the attributs of a student via the progress bars
        KnowledgeBar.setValue(knowledge); 
         KnowledgeBar.repaint();
         
        MotivationBar.setValue(motivation); 
         MotivationBar.repaint();
         
        TirednessBar.setValue(tiredness); 
         TirednessBar.repaint();
        
        
    }
    
}
