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

    private javax.swing.JLabel jLabel_timer;

    public ActivityPhase(javax.swing.JLabel jLabel_timer) {
        this.jLabel_timer = jLabel_timer;
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(jLabel_timer));
        runTimer.start();
    }

}