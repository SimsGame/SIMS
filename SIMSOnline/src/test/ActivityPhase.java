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
    public boolean doNotPaintFlag = false;
    public boolean paintStudents = false;
    private javax.swing.JLabel label_timer;
    private javax.swing.JLabel label_redBull;
    private javax.swing.JLabel label_duplo;
    private javax.swing.JLabel label_omniSense;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private Game1 game;
    
    public ActivityPhase(javax.swing.JLabel label_timer, javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar, javax.swing.JLabel label_redBull, javax.swing.JLabel label_duplo, javax.swing.JLabel label_omniSense) {
        this.label_timer = label_timer;
        this.label_redBull = label_redBull;
        this.label_duplo = label_duplo;
        this.label_omniSense = label_omniSense;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        game = Sims_1._maingame;
        game.initArray();
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        Thread runTimer = new Thread(new Timer(label_timer, game, KnowledgeBar, MotivationBar,TirednessBar, this));
        runTimer.start();  
    }
    
    public void BarClicked(int barNum){
        paintStudents=true;
        for(int i=0; i<30; i++){
        }
    }
    
    public void StudentClicked(int studNum) {
        if (redBullPressed) {
            if (game.redBull.amount > 0) {
                game.redBull.amount -= 1;
                label_redBull.setText(game.redBull.amount+"x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.redBull.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.redBull.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.redBull.tiredness);
                System.out.println(game.studentArray[studNum].getTiredness());
            }
        } else if (duploPressed) {
            if (game.duplo.amount > 0) {
                game.duplo.amount -= 1;
                label_duplo.setText(game.duplo.amount+"x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.duplo.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.duplo.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.duplo.tiredness);
            }
        } else if (OmniSensePressed) {
            if (game.omniSenseAudio.amount > 0) {
                game.omniSenseAudio.amount -= 1;
                label_omniSense.setText(game.omniSenseAudio.amount+"x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.omniSenseAudio.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.omniSenseAudio.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.omniSenseAudio.tiredness);
            }
        }
        KnowledgeBar.setValue((int)game.studentArray[studNum].getKnowledge());
        MotivationBar.setValue((int)game.studentArray[studNum].getMotivation());
        TirednessBar.setValue((int)game.studentArray[studNum].getTiredness());
        KnowledgeBar.repaint();
        MotivationBar.repaint();
        TirednessBar.repaint();
        this.doNotPaintFlag = true;
    }

}