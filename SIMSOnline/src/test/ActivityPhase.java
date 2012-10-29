/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jörg Woditschka
 * @author Nadir Yuldashev
 */
public class ActivityPhase {

    private javax.swing.JLabel label_timer;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private Game game;

    public ActivityPhase(javax.swing.JLabel jLabel_timer, javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar
) {
        this.label_timer = jLabel_timer;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        game = new Game();
        game.initArray();
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(label_timer, game));
        Thread updateBars = new Thread(new UpdateBars(KnowledgeBar, MotivationBar,TirednessBar, game));
        runTimer.start();
        updateBars.start();
    }

}