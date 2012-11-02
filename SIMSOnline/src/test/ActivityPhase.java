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

    public boolean redBullPressed = false;
    public boolean duploPressed = false;
    public boolean OmniSensePressed = false;
    private javax.swing.JLabel label_timer;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private Game1 game;

    public ActivityPhase(javax.swing.JLabel jLabel_timer, javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar) {
        this.label_timer = jLabel_timer;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        game = Sims_1._maingame;
        game.initArray();
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(label_timer, game, KnowledgeBar, MotivationBar,TirednessBar));
        runTimer.start();  
    }
    
    void StudentClicked(int studNum) {
        if (redBullPressed) {
            if (game.redBull.amount > 0) {
                Game.redBull.amount -= 1;
                //label_redBull.setText(Game.redBull.amount+"x");
                Game.studentArray[studNum].setKnowledge(Game.studentArray[studNum].getKnowledge() + Game.redBull.knowledge);
                Game.studentArray[studNum].setMotivation(Game.studentArray[studNum].getMotivation() + Game.redBull.motivation);
                Game.studentArray[studNum].setTiredness(Game.studentArray[studNum].getTiredness() + Game.redBull.tiredness);
                System.out.println(Game.studentArray[studNum].getTiredness());
            }
        } else if (duploPressed) {
            if (Game.duplo.amount > 0) {
                Game.duplo.amount -= 1;
                Game.studentArray[studNum].setKnowledge(Game.studentArray[studNum].getKnowledge() + Game.duplo.knowledge);
                Game.studentArray[studNum].setMotivation(Game.studentArray[studNum].getMotivation() + Game.duplo.motivation);
                Game.studentArray[studNum].setTiredness(Game.studentArray[studNum].getTiredness() + Game.duplo.tiredness);
            }
        } else if (OmniSensePressed) {
            if (Game.omniSenseAudio.amount > 0) {
                Game.omniSenseAudio.amount -= 1;
                Game.studentArray[studNum].setKnowledge(Game.studentArray[studNum].getKnowledge() + Game.omniSenseAudio.knowledge);
                Game.studentArray[studNum].setMotivation(Game.studentArray[studNum].getMotivation() + Game.omniSenseAudio.motivation);
                Game.studentArray[studNum].setTiredness(Game.studentArray[studNum].getTiredness() + Game.omniSenseAudio.tiredness);
            }
        }
    }

}