/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jörg Woditschka
 */
public class Timer extends Thread {

    public static int timer; // changed to public by nadir to use in updatebars
    private javax.swing.JLabel label_timer;
    public Game game = new Game();
    private double averageMotivation;
    private double averageTiredness;

   public Timer(javax.swing.JLabel jLabel_timer) {
        this.label_timer = jLabel_timer;
        initTimer();
        game.initArray();
    }

   private void changeAttributes(){
       game.updateArray(0.1, -0.1);
       for(int i=0;i<30;i++){
           averageMotivation+=game.studentArray[i].getMotivation();
           averageTiredness+=game.studentArray[i].getTiredness();
       }
       averageMotivation/=30;
       averageTiredness/=30;
       System.out.println("Motivation: "+averageMotivation+"\tTiredness: "+averageTiredness);
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
            
            changeAttributes();
            
        }
    }

    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;
        
    }
}