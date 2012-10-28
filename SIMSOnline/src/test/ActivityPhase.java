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

    public ActivityPhase(javax.swing.JLabel jLabel_timer, javax.swing.JProgressBar jKnowledgeBar) {
        this.label_timer = jLabel_timer;
        this.KnowledgeBar = jKnowledgeBar;
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(label_timer));
         Thread updateBars = new Thread(new UpdateBars(KnowledgeBar));
        runTimer.start();
        updateBars.start();
    }

}