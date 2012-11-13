/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;

/**
 *
 * @author Jörg Woditschka @authot Nadir Yudlashev
 * @author Kira Schomber
 */
public class Timer extends Thread {

    public static int timer; // changed to public by nadir to use in updatebars
    private javax.swing.JLabel label_timer;
    private ActivityPhase activityPhase;
    public Game1 game;
    public static double averageMotivation;
    public static double averageTiredness;
    public static double averageKnowledge;
    private double add1;
    private double add2;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private javax.swing.JProgressBar NoiseBar;
    private javax.swing.JProgressBar AirBar;

    public Timer(javax.swing.JLabel jLabel_timer, Game1 game, javax.swing.JProgressBar jKnowledgeBar, javax.swing.JProgressBar jAirBar, javax.swing.JProgressBar jNoiseBar, javax.swing.JProgressBar jMotivationBar, javax.swing.JProgressBar jTirednessBar, ActivityPhase activityPhase) {
        this.label_timer = jLabel_timer;
        initTimer();
        this.game = game;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        this.AirBar = jAirBar;
        this.NoiseBar = jNoiseBar;
        this.activityPhase = activityPhase;
    }

    private void updateAvrg() {
        for (int i = 0; i < 30; i++) {
            averageKnowledge += game.studentArray[i].getKnowledge();
            averageMotivation += game.studentArray[i].getMotivation();
            averageTiredness += game.studentArray[i].getTiredness();
        }
        averageKnowledge /= 30;
        averageMotivation /= 30;
        averageTiredness /= 30;

        System.out.println("motivation" + averageMotivation + "   " + "Tiredness" + averageTiredness + "Knowledge" + averageKnowledge);
    }

    @Override
    public void run() {
        label_timer.setForeground(Color.black);
        while (timer > 0 && activityPhase.runTimer) {
            if(timer==30){
                label_timer.setForeground(Color.red);
            }
            long millis = System.currentTimeMillis();
            while ((System.currentTimeMillis() - millis) < 100) {
                //do nothing
            }
            timer--;
            String timerText = (timer / 60) + ":";
            if ((timer % 60) < 10) {
                timerText += "0";
            }
            timerText += timer % 60;
            label_timer.setText(timerText);
            //You can only have teamwork OR break. One will override the other.
/*
             * public void updateRoom(double factor1, double factor2){
             * setAirQuality(this.airQuality + factor1); setNoise(this.noise +
             * factor2);
     }
             */
            if (game.quietingCounter > 0) {
                game.updateRoom(-1.65, -3.65);
                game.quietingCounter--;
            } else {
                game.updateRoom(-1.65, 1.65);
            }
            if (game.teamwork) {
                add1 = (game.noise + 0.000001) / 200 * (2.5);
                add2 = (100.000001 - game.airQuality) / 200 * 3.3;
                game.updateArray(add1, add2, 0.02);
            } else if (game.shortBreak) {
                add1 = (game.noise + 0.000001) / 200 * (3.3);
                add2 = (100.000001 - game.airQuality) / 200 * (-3.3);
                game.updateArray(add1, add2, -1);
            } else {
                add1 = (game.noise + 0.000001) / 200 * (-3.3);
                add2 = (100.000001 - game.airQuality) / 200 * 3.3;
                game.updateArray(add1, add2, 0);
            }
            updateAvrg();
            if (timer == 1) {
                int round = game.round;
                if (round % 3 == 0) {
                    switch (round) {
                        case 3:
                            game.examTime(10);
                            break;
                        case 6:
                            game.examTime(20);
                            break;
                        case 9:
                            game.examTime(35);
                            break;
                        case 12:
                            game.examTime(50);
                            break;
                        case 15:
                            game.examTime(70);
                            break;
                        case 18:
                            game.examTime(90);
                            break;
                        default:
                            break;
                    }
                }
            }
            if (!this.activityPhase.doNotPaintFlag) {
                paintBars();
            }
            if (game.barNum != 0) {
                game.barClicked(activityPhase.studButtons);
            }
            if (activityPhase.studentDisplayed != -1) {
                activityPhase.displayStudentBars();
            }
        }
        game.round += 1;
        activityPhase.sims.switchPhase();
    }

    private void paintBars() {
        KnowledgeBar.setValue((int) (averageKnowledge));
        MotivationBar.setValue((int) averageMotivation);
        TirednessBar.setValue((int) averageTiredness);
        AirBar.setValue((int) game.airQuality);
        NoiseBar.setValue((int) game.noise);
        KnowledgeBar.repaint();
        MotivationBar.repaint();
        TirednessBar.repaint();
        AirBar.repaint();
        NoiseBar.repaint();
    }

    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;

    }
}
