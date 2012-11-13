/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Objects of this class are timers, which are displayed in the timer label of the activity phase
 * @author Jörg Woditschka 
 * @authot Nadir Yudlashev
 * @author Kira Schomber
 */
public class Timer extends Thread {

    public static int timer; 
    private javax.swing.JLabel label_timer;
    private ActivityPhase activityPhase;
    public Game1 game;
    public static double averageMotivation;
    public static double averageTiredness;
    public static double averageKnowledge;
    private int windowCnt=30;
    private double add1;
    private double add2;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private javax.swing.JProgressBar NoiseBar;
    private javax.swing.JProgressBar AirBar;
    private javax.swing.JLabel[] studLaptops;

    /**
     * Constructor of a timer
     * @param jLabel_timer the timer label of the activity phase
     * @param game a gameobject
     * @param jKnowledgeBar the bar displaying the students average knowledge on the activity phase view
     * @param jAirBar the bar displaying the air quality on the activity phase view
     * @param jNoiseBar the bar displaying the noise on the activity phase view
     * @param jMotivationBar the bar displaying the students average motivation on the activity phase view
     * @param jTirednessBar the bar displaying the students average knowledge on the activity phase view
     * @param activityPhase an object of the activityPhase
     */
    public Timer(javax.swing.JLabel jLabel_timer, Game1 game, javax.swing.JProgressBar jKnowledgeBar, javax.swing.JProgressBar jAirBar, javax.swing.JProgressBar jNoiseBar, javax.swing.JProgressBar jMotivationBar, javax.swing.JProgressBar jTirednessBar, ActivityPhase activityPhase, javax.swing.JLabel[] jstudLaptops) {
        this.label_timer = jLabel_timer;
        initTimer();
        this.game = game;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        this.AirBar = jAirBar;
        this.NoiseBar = jNoiseBar;
        this.studLaptops = jstudLaptops;
        this.activityPhase = activityPhase;
    }
/**
 * This method updates the averages of the students attribute values in this class.
 */
    private void updateAvrg() {
        int cnt=0;
        averageKnowledge=0;
        averageMotivation=0;
        averageTiredness=0;
        for (int i = 0; i < 30; i++) {
            if(game.studentArray[i].present){
            averageKnowledge += game.studentArray[i].getKnowledge();
            averageMotivation += game.studentArray[i].getMotivation();
            averageTiredness += game.studentArray[i].getTiredness();
            cnt++;
            }
        }
        averageKnowledge /= cnt;
        averageMotivation /= cnt;
        averageTiredness /= cnt;

        //System.out.println("motivation" + averageMotivation + "   " + "Tiredness" + averageTiredness + "  Knowledge" + averageKnowledge);
    }
    
    @Override
    /**
     * This method is called when a timer thread is started.
     * It updates the value of the timer label and updates everything that needs to be calculated in each second.
     */
    public void run() {
        label_timer.setForeground(Color.black);
        while (timer > 0 && activityPhase.runTimer) {
            if(timer==30){
                label_timer.setForeground(Color.red);
            }
            long millis = System.currentTimeMillis();
            while ((System.currentTimeMillis() - millis) < 1000) {
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
            //This part updates the room depending of the quietingCounter
            if (game.quietingCounter > 0) {
                game.updateRoom(-1.65, -3.00);
                game.quietingCounter--;
                // this part will make the label dissappear once the effect of the quieting has worn off.
                if(game.quietingCounter==0){
                    activityPhase.sims.hideQuietingLabel();
                }
            // defaul calling of updateRoom method
            } else {
                game.updateRoom(-1.65, 1.00);
            }
            // determines the changing of the students attributes by calculating the values that are given to the update method. Taken into consideration are the teamwor and the break.
            if (game.teamwork) {
                add1 = (game.noise + 0.000001) / 200 * (2.5);
                add2 = (100.000001 - game.airQuality) / 200 * 2;
                game.updateArray(add1, add2, 0.02);
            } else if (game.shortBreak) {
                add1 = (game.noise + 0.000001) / 200 * (2);
                add2 = (100.000001 - game.airQuality) / 200 * (-6);
                game.updateArray(add1, add2, -1);
            // default calling of the updateArray method.
            } else {
                add1 = (game.noise + 0.000001) / 200 * (-2);
                add2 = (100.000001 - game.airQuality) / 200;
                game.updateArray(add1, add2, 0);
            }
            updateAvrg();
            checkLaptops();
            if (timer == 0) {
                int round = game.round;
                if (round % 3 == 0) { // the case makes sure the minimal value of knowledge needed to pass a semester will change accordingly to the present semester.
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
                    activityPhase.sims.displayExamResults(game.failedStudents, game.remainingStudents); // displays the results in a popup window
                    game.failedStudents=0; //resets the value, so that the there will only ever be displayed the number of students that didn't pass the current exam.
                }
            }
            if (!this.activityPhase.doNotPaintFlag) {
                paintBars();
            }
            paintRoomBars();
            if (game.barNum != 0) {
                game.barClicked(activityPhase.studButtons);
            }
            if (activityPhase.studentDisplayed != -1) {
                if (game.studentArray[activityPhase.studentDisplayed].present){
                    activityPhase.displayStudentBars();
                }
                else{
                    paintBars();
                }
            }
            if(!game.windowChangesNoise){ //makes sure it's impossible to misuse the feature of the decreasing noise value upon closing the window.
                if(windowCnt==0){
                    game.windowChangesNoise=true;
                    windowCnt=30;
                }else{
                    windowCnt--;
                }
            }
        }
        game.round += 1;
        game.gainBonusCredits();
        Game1.saveGame();
        activityPhase.sims.switchPhase();
    }
/**
 * the bars at the top of the activity phase are painted using the average student attributes.
 */
    private void paintBars() {
        KnowledgeBar.setValue((int) (averageKnowledge));
        MotivationBar.setValue((int) averageMotivation);
        TirednessBar.setValue((int) averageTiredness);
        KnowledgeBar.repaint();
        MotivationBar.repaint();
        TirednessBar.repaint();
    }
    
    private void paintRoomBars(){
        AirBar.setValue((int) game.airQuality);
        NoiseBar.setValue((int) game.noise);
        AirBar.repaint();
        NoiseBar.repaint();
    }

    /**
     * this method initializes the timer to a value of 180s (3:00)
     */
    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;

    }
    
/**
 * checks if laptopflag was changed and if student is still present, then creates transparent open laptops 
 */    
  private void checkLaptops(){
      for(int i=0;i<30;i++)
      {
          if((game.studentArray[i].laptopClosed== false) && (game.studentArray[i].present==true)){
           studLaptops[i].setIcon(new ImageIcon(getClass().getResource("/pictures/laptopauf.png")));
           studLaptops[i].setOpaque(false);
          } 
      }   
  }
}
