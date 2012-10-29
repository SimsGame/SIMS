/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Nadir Yuldashev, Jörg Woditschka
 */
public class UpdateBars extends Thread {

   
    private Game game;
    private double avrgmotivation;
    private double avrgtiredness;
    private double avrgknowledge;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private int timer = 10;

   public UpdateBars(javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar, Game game) {
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        this.game = game;
    }

   private void updateAvrg(){
       for(int i=0;i<30;i++){
           avrgknowledge+=game.studentArray[i].getKnowledge();
           avrgmotivation+=game.studentArray[i].getMotivation();
           avrgtiredness+=game.studentArray[i].getTiredness();
       }
       avrgknowledge/=30;
       avrgmotivation/=30;
       avrgtiredness/=30;
       
       System.out.println("motivation"+ avrgmotivation + "   "+ "Tiredness" +avrgtiredness +"Knowledge" +avrgknowledge);
   }
   
    @Override
    public void run() {
        while(timer>0){
             updateAvrg();
         KnowledgeBar.setValue((int)(avrgknowledge*250)); 
         MotivationBar.setValue((int)avrgmotivation); 
         TirednessBar.setValue((int)avrgtiredness); 
         KnowledgeBar.repaint();
         MotivationBar.repaint();
         TirednessBar.repaint();
        try{Thread.sleep(0);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
}

         
            
        }
    }

   

