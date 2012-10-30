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
        // new Game-instance
    public Game game = new Game();
    public static Student[] studArr;
    
    protected static StudInfo studInfo;
    
    private static int switchFlag = 0;
    private static int switchCounter = 5;
    private static int studCounter = 0;
    private static Student stud1;
    private static Student stud2;
    private static int stud1_nr;
    private static int stud2_nr;
    
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
        
            // StudentArray will be initialized
        game.initArray();
            // studArr gets the StudentArray
        studArr = game.getArray();
        
        PlanningPhaseMain();

        validateLector(jLab_DozCounter);
    }

    public void PlanningPhaseMain() {

        // one instance of StudInfo which is used for all student buttons
        studInfo = new StudInfo(KnowledgeBar, MotivationBar, TirednessBar);

    }
        // called from SwitchStud-Button on navi
    public static void startStudSwitch(){
        if (switchFlag == 0){
            System.out.println("SwitchFlag = "+switchFlag);
            System.out.println("SwitchCounter = "+switchCounter);
            System.out.println("StudCounter = "+studCounter);
            if (switchCounter > 0){
                studCounter = 0;
                switchFlag = 1;
            } else {
                System.out.println("SwitchFlag = "+switchFlag);
                System.out.println("SwitchCounter = "+switchCounter);
                System.out.println("StudCounter = "+studCounter);
                System.out.println("Du kannst nicht merh tauschen!");
            }
         
        } else {
            System.out.println("SwitchFlag = "+switchFlag);
            System.out.println("SwitchCounter = "+switchCounter);
            System.out.println("StudCounter = "+studCounter);
            System.out.println("StudTausch abgebrochen!");
            switchFlag = 0;
        }
   }
    
    public static void storeStud(int stud_nr){
        
//        switch (StudCounter){
//            case 0:{
//                StudCounter++;
//                stud1 = StudArr.getArray()[stud_nr];
//                stud1_nr = stud_nr;
//            }
//                
//            case 1:{
//                stud2 = StudArr.getArray()[stud_nr];
//                stud2_nr = stud_nr;
//                StudSwitch(stud1, stud2);
//            }
//            default:{
//                System.out.println("Falscher StudCounter-Wert!");
//            }
//        }
        if (studCounter == 1){
                stud2 = studArr[stud_nr];
                stud2_nr = stud_nr;
                System.out.println("Stud2 = "+stud2_nr);
                StudSwitch(stud1, stud2);
        
        }
        
        if (studCounter == 0){
                studCounter++;
                System.out.println("studCounter = "+studCounter);
                stud1 = studArr[stud_nr];
                stud1_nr = stud_nr;
                System.out.println("Stud1 = "+stud1_nr);
        }
        


    }
    
    private static void StudSwitch(Student stud1, Student stud2){
       // Student stud_H;
        
        studArr[stud1_nr] = stud2;
        studArr[stud2_nr] = stud1;
        
        switchFlag = 0;
        switchCounter--;
        studCounter = 0;
       
    }
    
    public static int getSwitchFlag(){
        return switchFlag;
    }
    
    public static void StudButtonFunctions(int stud_nr){
        
        if (switchFlag == 0){
            System.out.println("SwitchFlag = "+switchFlag);
            System.out.println("SwitchCounter = "+switchCounter);
            System.out.println("StudCounter = "+studCounter);
            
            // start method StudInfo() which shows knowledge, motivation and tiredness 
            // of the student which was clicked
        studInfo.StudInfoAttr(stud_nr);
        
            //StudInfo curStud = new StudInfo(0,jProgB_Wissen,jProgB_Motivation, jProgB_Müdigkeit);
        System.out.println("clicked Student = "+studArr[stud_nr].getId());
        
        } else {
            System.out.println("TauschFlag = 1");
            storeStud(stud_nr);
        }
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
