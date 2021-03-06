/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Objects of this class are activity phases ("Aktionsphasen"). 
 * @author Jörg Woditschka
 * @author Nadir Yuldashev
 * @author Kira Schomber
 */
public class ActivityPhase {
    public Thread timer;
    public boolean redBullPressed = false;
    public boolean duploPressed = false;
    public boolean OmniSensePressed = false;
    public boolean doNotPaintFlag = false;
    public boolean runTimer = true;
    public int studentDisplayed = -1;
    public Sims_1 sims;
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
    public javax.swing.JLabel[] studLaptops;
    private javax.swing.JButton professorButton; //added by Julia
    private Game1 game;
    
    /**
     * Constructor of an activityPhase
     * @param label_timer the label of the timer on the activity phase view
     * @param jKnowledgeBar the bar displaying the students average knowledge on the activity phase view
     * @param jAirBar the bar displaying the air quality on the activity phase view
     * @param jNoiseBar the bar displaying the noise on the activity phase view
     * @param jMotivationBar the bar displaying the students average motivation on the activity phase view
     * @param jTirednessBar the bar displaying the students average knowledge on the activity phase view
     * @param label_redBull the label displaying the amount of "redBull"s on the activity phase view
     * @param label_duplo the label displaying the amount of "duplo"s on the activity phase view
     * @param label_omniSense the label displaying the amount of "Omni Sense audio books"s on the activity phase view
     * @param studButtons the Array of buttons of the Students on the activity phase view
     * @param score the actual score
     * @param sims the SIMS object
     * @param jBut_Dozent the button of the lecturer
     * @param studLaptops an arrray of the labels of the students laptops
     */
    public ActivityPhase(javax.swing.JLabel label_timer, javax.swing.JProgressBar jKnowledgeBar,javax.swing.JProgressBar jAirBar,javax.swing.JProgressBar jNoiseBar,javax.swing.JProgressBar jMotivationBar,javax.swing.JProgressBar jTirednessBar, javax.swing.JLabel label_redBull, javax.swing.JLabel label_duplo, javax.swing.JLabel label_omniSense, javax.swing.JButton[] studButtons, javax.swing.JLabel score, Sims_1 sims, javax.swing.JButton jBut_Dozent,javax.swing.JLabel[] studLaptops) {        
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
        game.initRoom();
        this.label_score=score;
        this.label_score.setText(Integer.toString(this.game.points));
        this.sims=sims;
        this.studLaptops = studLaptops;
        this.professorButton  = jBut_Dozent; //added by Julia
        this.professorButton.setIcon(new ImageIcon(getClass().getResource(Sims_1._maingame.professorIcon))); //added byJulia
        activityPhaseMain();
     
    }
    /**
     * a method which is called from the cunstructor to make it more readable
     */
    private void activityPhaseMain(){
        game.calculateRowIntelligence();
        timer = new Thread(new Timer(label_timer, game, KnowledgeBar,AirBar,NoiseBar, MotivationBar,TirednessBar, this,studLaptops));
        timer.start(); 
    }
    
    /**
     * This method checks whether an item was selected and uses it on a clicked student
     * @param studNum the number of the Student clicked
     */
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
    
    /**
     * This method makes the bars at the top of the activity phases view display one students attributes
     */
    public void displayStudentBars(){
        MotivationBar.setValue((int)game.studentArray[this.studentDisplayed].getMotivation());
        TirednessBar.setValue((int)game.studentArray[this.studentDisplayed].getTiredness());
        KnowledgeBar.setValue((int)((game.studentArray[this.studentDisplayed].getKnowledge()))); 
        KnowledgeBar.repaint();
        MotivationBar.repaint();
        TirednessBar.repaint();
        this.doNotPaintFlag = true;
        game.barClicked(studButtons);     
    }

}
