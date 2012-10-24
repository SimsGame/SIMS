/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Nadir Yuldashev
 */
public class UpdateBars extends Thread {

    private int knowledge=0;
    private javax.swing.JProgressBar KnowledgeBar;
    private int timer = Timer.timer;

   public UpdateBars(javax.swing.JProgressBar jKnowledgeBar) {
        this.KnowledgeBar = jKnowledgeBar;
        
   
    }

    @Override
    public void run() {
        while(timer>0){
            knowledge=knowledge+1;
         KnowledgeBar.setValue(knowledge); 
         KnowledgeBar.repaint();
        try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
}

         
            
        }
    }

   

