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

    public ActivityPhase(javax.swing.JLabel jLabel_timer) {
        this.label_timer = jLabel_timer;
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(label_timer));
        runTimer.start();
    }

}