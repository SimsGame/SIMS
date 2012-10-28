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

   public Timer(javax.swing.JLabel jLabel_timer) {
        this.label_timer = jLabel_timer;
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
            label_timer.setText(timerText);
        }
    }

    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;
    }
}