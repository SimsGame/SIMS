/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Tobias Mauritz
 * @author Yuliya
 */
public class PlanningPhase {

    // deklaration of the progress bars
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JProgressBar TirednessBar;
    //deklaration of the variables that are needed for the lector-change function
    protected static javax.swing.JLabel lectorCounter; //JLabel that shows how many times the user can change lector
    protected static boolean lectorChanged1 = false;  //flag is set if the lector was already changed in this month
    protected static boolean lectorChanged4 = false;
    protected static boolean lectorChanged7 = false;
    protected static boolean lectorChanged10 = false;
    protected static boolean lectorChanged13 = false;
    protected static boolean lectorChanged16 = false;
    protected static int actMonth = 1;  // variable for actual month (from game-file)
    protected static boolean validated;
    protected static int lectorValue; //  variable that changes lector value (also from game file)
    static StudInfo studInfo;

    public PlanningPhase() {
    }
    // constructor which expects the three progress bars.
    // Thes are needed for the StudInfo methods

    public PlanningPhase(javax.swing.JProgressBar jProgB_Knowledge,
            javax.swing.JProgressBar jProgB_Motivation,
            javax.swing.JProgressBar jProgB_Tiredness, javax.swing.JLabel jLab_DozCounter) {

        // initializes the progress bars
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;


        PlanningPhaseMain();

        validateLector(jLab_DozCounter);
    }

    public void PlanningPhaseMain() {

        // one instance of StudInfo which is used for all student buttons
        studInfo = new StudInfo(KnowledgeBar, MotivationBar, TirednessBar);

    }

    /*
     * function that gets the actual month and check if a user is allowed to
     * changed a lector. If yes, the label counter will be set to 1. In other
     * case - to 0)
     *
     */
    public static boolean validateLector(javax.swing.JLabel jLab_DozCounter) {
        //actMonth=User.getMonth();
        lectorCounter = jLab_DozCounter;
        if ((actMonth == 1 && !lectorChanged1) || (actMonth == 4 && !lectorChanged4)
                || (actMonth == 7 && !lectorChanged7) || (actMonth == 10 && !lectorChanged10)
                || (actMonth == 13 && !lectorChanged13) || (actMonth == 16 && !lectorChanged16)) {
            validated = true;
            lectorCounter.setText("1x");
            lectorCounter.repaint();
        } else {
            validated = false;
            lectorCounter.setText("0x");
            lectorCounter.repaint();
        }
        return validated;
    }
       
   /*
     function to change lector, if lector was changed the appropriate flag will be set to true
    */
    
    public static void changeLector(javax.swing.JLabel jLab_DozCounter) {
        //actMonth=User.getMonth(); - ABfrage des aktuellen Monats
        lectorCounter = jLab_DozCounter;
        if (actMonth == 1) {
            lectorChanged1 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        } else if (actMonth == 4) {
            lectorChanged4 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        } else if (actMonth == 7) {
            lectorChanged7 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        } else if (actMonth == 10) {
            lectorChanged10 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        } else if (actMonth == 13) {
            lectorChanged13 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        } else if (actMonth == 16) {
            lectorChanged16 = true;
            lectorValue = (int) Math.round(Math.random() * 100 + 1);
        }
        System.out.println("Dozent wurde gewechselt. Neuer Dozentenwert: " + lectorValue);
        lectorCounter.setText("0x");
        lectorCounter.repaint();
    }
}
