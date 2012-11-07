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
    private ActivityPhase activityPhase;
    public Game1 game;
    public static double averageMotivation;
    public static double averageTiredness;
    public static double averageKnowledge;
    public boolean windowOpen = false;
    public boolean laptopClosed = false;
    public boolean teamwork = false;
    public boolean shortBreak = false;
    private double add1;
    private double add2;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;

   public Timer(javax.swing.JLabel jLabel_timer, Game1 game,javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar, ActivityPhase activityPhase) {
        this.label_timer = jLabel_timer;
        initTimer();
        this.game=game;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        this.activityPhase=activityPhase;
    }
   
   
   private void updateAvrg(){
       for(int i=0;i<30;i++){
           averageKnowledge+=game.studentArray[i].getKnowledge();
           averageMotivation+=game.studentArray[i].getMotivation();
           averageTiredness+=game.studentArray[i].getTiredness();
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

           // problem: no default state. Thus implementing the planned changing of the attributes is impossible without disrupting the usual game flow, since the laptop is always either opened or closed.
            if (laptopClosed){
                add1=(game.noise+0.000001)/200*(-3.3);
                add2=(100.000001-game.airQuality)/200*-3.3;
                game.updateArray(add1, add2);
            }
            else if(teamwork){
                add1=(game.noise+0.000001)/200*(-3.3);
                add2=(100.000001-game.airQuality)/200*3.3;
                game.updateArray(add1, add2);
            }
            else {
                add1=(game.noise+0.000001)/200*(-3.3);
                add2=(100.000001-game.airQuality)/200*3.3;
                game.updateArray(add1, add2);
            }
         updateAvrg();
         
            game.updateArray(-1.5, 1.5);
            updateAvrg();
            if(!this.activityPhase.doNotPaintFlag){
            paintBars();
            }
            if(activityPhase.barNum!=0){
                activityPhase.barClicked();
            }
            if(activityPhase.studentDisplayed!=-1){
                activityPhase.displayStudentBars();
            }
        }
    }
    
    private void paintBars(){
         KnowledgeBar.setValue((int)(averageKnowledge*250)); 
         MotivationBar.setValue((int)averageMotivation); 
         TirednessBar.setValue((int)averageTiredness); 
         KnowledgeBar.repaint();
         MotivationBar.repaint();
         TirednessBar.repaint();     
    }

    private void initTimer() {
        label_timer.setText("3:00");
        this.timer = 180;
        
    }
}
