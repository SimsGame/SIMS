/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jörg Woditschka
 * @authot Nadir Yudlashev
 */
public class Timer extends Thread {

    public static int timer; // changed to public by nadir to use in updatebars
    private javax.swing.JLabel label_timer;
    public Game game;
    public static double averageMotivation;
    public static double averageTiredness;
    public static double averageKnowledge;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;

   public Timer(javax.swing.JLabel jLabel_timer, Game game,javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar) {
        this.label_timer = jLabel_timer;
        initTimer();
        this.game=game;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
    }
   
   
   private void updateAvrg(){
       for(int i=0;i<30;i++){
           averageKnowledge+=Game.studentArray[i].getKnowledge();
           averageMotivation+=Game.studentArray[i].getMotivation();
           averageTiredness+=Game.studentArray[i].getTiredness();
       }
       averageKnowledge/=30;
       averageMotivation/=30;
       averageTiredness/=30;
       
       System.out.println("motivation"+ averageMotivation + "   "+ "Tiredness" +averageTiredness +"Knowledge" +averageKnowledge);
   }
    @Override
    public void run() {
        while (timer > 0) {
            long millis = System.currentTimeMillis();
            while ((System.currentTimeMillis() - millis) < 1000) {
                //do nothing
            }
            timer--;
            String timerText=(timer / 60) + ":";
            if((timer % 60)<10){
                timerText+="0";
            }
            timerText+=timer % 60;
            label_timer.setText(timerText);
            
            game.updateArray(-1.5, 1.5);
         updateAvrg();
         KnowledgeBar.setValue((int)(averageKnowledge*250)); 
         MotivationBar.setValue((int)averageMotivation); 
         TirednessBar.setValue((int)averageTiredness); 
         KnowledgeBar.repaint();
         MotivationBar.repaint();
         TirednessBar.repaint();
            
            
            
            
            
            
        }
    }

    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;
        
    }
}