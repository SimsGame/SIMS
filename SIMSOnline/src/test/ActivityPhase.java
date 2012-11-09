/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;

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
    public boolean runTimer = true;
    public int studentDisplayed = -1;
    private javax.swing.JLabel label_score;
    private javax.swing.JLabel label_timer;
    private javax.swing.JLabel label_redBull;
    private javax.swing.JLabel label_duplo;
    private javax.swing.JLabel label_omniSense;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    private javax.swing.JProgressBar AirBar;
    private javax.swing.JProgressBar NoiseBar;
    public javax.swing.JButton[] studButtons;
    private Game1 game;
    
    public ActivityPhase(javax.swing.JLabel label_timer, javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jAirBar,javax.swing.JProgressBar jNoiseBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar, javax.swing.JLabel label_redBull, javax.swing.JLabel label_duplo, javax.swing.JLabel label_omniSense, javax.swing.JButton[] studButtons, javax.swing.JLabel score) {        
        this.label_timer = label_timer;
        this.label_redBull = label_redBull;
        this.label_duplo = label_duplo;
        this.label_omniSense = label_omniSense;
        this.KnowledgeBar = jKnowledgeBar;
        this.MotivationBar = jMotivationBar;
        this.TirednessBar = jTirednessBar;
        this.AirBar = jAirBar;
        this.NoiseBar = jNoiseBar;
        this.studButtons = studButtons;
        game = Sims_1._maingame;
        game.initAttr();
        game.initRoom();
        this.label_score=score;
        this.label_score.setText(Integer.toString(this.game.points));
        activityPhaseMain();
    }
    
    private void activityPhaseMain(){
        game.calculateRowIntelligence();
        Thread runTimer = new Thread(new Timer(label_timer, game, KnowledgeBar,AirBar,NoiseBar, MotivationBar,TirednessBar, this));
        runTimer.start();  
    }
    
    public void StudentClicked(int studNum) {
                this.studentDisplayed=studNum;
        if (redBullPressed) {
            if (game.redBull.amount > 0) {
                game.redBull.amount -= 1;
                label_redBull.setText(game.redBull.amount+" x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.redBull.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.redBull.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.redBull.tiredness);
                game.points += 200;
                label_score.setText(Integer.toString(game.points));
                
            }
        } else if (duploPressed) {
            if (game.duplo.amount > 0) {
                game.duplo.amount -= 1;
                label_duplo.setText(game.duplo.amount+" x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.duplo.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.duplo.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.duplo.tiredness);
                game.points += 200;
                label_score.setText(Integer.toString(game.points));
            }
        } else if (OmniSensePressed) {
            if (game.omniSenseAudio.amount > 0) {
                game.omniSenseAudio.amount -= 1;
                label_omniSense.setText(game.omniSenseAudio.amount+" x");
                game.studentArray[studNum].setKnowledge(game.studentArray[studNum].getKnowledge() + game.omniSenseAudio.knowledge);
                game.studentArray[studNum].setMotivation(game.studentArray[studNum].getMotivation() + game.omniSenseAudio.motivation);
                game.studentArray[studNum].setTiredness(game.studentArray[studNum].getTiredness() + game.omniSenseAudio.tiredness);
                game.points += 500;
                label_score.setText(Integer.toString(game.points));
            }
        }
        displayStudentBars();
    }
    
    public void displayStudentBars(){
        
        MotivationBar.setValue((int)game.studentArray[this.studentDisplayed].getMotivation());
        TirednessBar.setValue((int)game.studentArray[this.studentDisplayed].getTiredness());
        KnowledgeBar.setValue((int)((game.studentArray[this.studentDisplayed].getKnowledge()))); // 250 is the facot we set so we see growth faster, change later by Nadir
        KnowledgeBar.repaint();
        MotivationBar.repaint();
        TirednessBar.repaint();
        this.doNotPaintFlag = true;
        game.barClicked(studButtons);
    }

}
