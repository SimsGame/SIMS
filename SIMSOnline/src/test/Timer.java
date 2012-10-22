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

    private int timer;
    private javax.swing.JLabel jLabel_timer;

   public Timer(javax.swing.JLabel jLabel_timer) {
        this.jLabel_timer = jLabel_timer;
        initTimer();
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
            jLabel_timer.setText(timerText);
        }
    }

    private void initTimer() {
        jLabel_timer.setText("3:00");
        this.timer = 180;
    }
}
