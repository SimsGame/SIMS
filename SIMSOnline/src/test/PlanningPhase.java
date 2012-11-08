/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import javax.swing.*;


/**
 * @author Tobias Mauritz
 * @author Yuliya Kuznetsova
 */
public class PlanningPhase {

    // deklaration of the progress bars
    private JProgressBar KnowledgeBar;
    private JProgressBar MotivationBar;
    private JProgressBar TirednessBar;
    private static JLabel switchCounterLabel;
    private static JToggleButton switchStudToggleBut;
    // declaration of the StudentArray
    private static Student[] studArr;
    // declaration of an studInfo instance
    protected static StudInfo studInfo;
    
    //flags deklaration
    private static boolean switchFlag = false;
    private int cheatFlag = 0;  //will be set to 1, if Spicker in Dropdown-Field is selected 
                                       //(before will be checked if the user can use this cheat)
    // counter
    private static int switchCounter = 5;
    private static int studCounter = 0;
   
    // students for the switching function
    private static Student stud1;
    private static Student stud2;
    private static int stud1_nr;
    private static int stud2_nr;
    
    
    //deklaration of the variables that are needed for the lector-change function
    private  JLabel lectorCounter; //JLabel that shows how many times the user can change lector
     
    private  boolean lectorChanged3 = false; //flag is set if the lector was already changed in this round
    private  boolean lectorChanged6 = false;
    private  boolean lectorChanged9 = false;
    private  boolean lectorChanged12 = false;
    private  boolean lectorChanged15 = false;
   
        
    protected static int lectorValue; //  variable that changes lector value (also from game file)
    
    private static JButton studBut1;
    private static JButton studBut2;
    public JButton[] studButtons;

        // PlanningPhase constructor
    public PlanningPhase() {
    }
    
     
//     constructor which expects the three progress bars.
//     These are needed for the StudInfo methods
//     called first
    /**
     * - constructor which initializes the progress bars, the dozent counter label 
     * and the switch student toggle button <br>
     * - tt sets the progress bars to the current average values of the students <br>
     * - tt validates if the dozent can be switched
     * @param jProgB_Knowledge progress bar which shows the knowledge
     * @param jProgB_Motivation progress bar which shows the motivation
     * @param jProgB_Tiredness progress bar which shows the tiredness
     * @param jLab_DozCounter 
     * @param jToggleBut_SwitchStud 
     */
    public PlanningPhase(JProgressBar jProgB_Knowledge,
            JProgressBar jProgB_Motivation,
            JProgressBar jProgB_Tiredness, 
            JLabel jLab_DozCounter,
            JToggleButton jToggleBut_SwitchStud) {

        // initializes the progress bars
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;
        
        // initializes the ToggleButton for switching students
        this.switchStudToggleBut = jToggleBut_SwitchStud;

        // StudentArray will be initialized
        this.studArr = Sims_1._maingame.getArray();

        // one instance of StudInfo which is used for all student buttons
        // initialzing the PrograssBars on studInfo
        studInfo = new StudInfo(KnowledgeBar, MotivationBar, TirednessBar);
        
        //updates label "Dozenten tauschen
        checkProffesorChangeability(jLab_DozCounter);
        
    }


    // called from SwitchStud-Button on navi
    /**
     * - is called when the stud switch toggle button was clicked
     * and initializes the switchFlag with the isSelected() method of
     * an toggle button
     * @param jLab_SwitchCounter 
     */
    public  void startStudSwitch(JLabel jLab_SwitchCounter) {
        switchCounterLabel = jLab_SwitchCounter;
        
        // declares switchFlag to true/false when ToggleButton is pressed
        switchFlag = switchStudToggleBut.isSelected();

        if (switchFlag) {
            if (switchCounter > 0) {
                // is not needed
                //switchStudToggleBut.setSelected(true);
                studCounter = 0;
                //switchFlag = 1;
            } else {
                switchStudToggleBut.setSelected(false);
                System.out.println("SwitchCounter (>0?)= " + switchCounter);
                System.out.println("Du kannst nicht mehr tauschen!");
            }

        } else {
            // not needed
            //switchStudToggleBut.setSelected(false);
            System.out.println("StudTausch abgebrochen!");
            System.out.println("Aktuelle Werte: ");
            System.out.println("SwitchFlag (true?) = " + switchFlag);
            System.out.println("SwitchCounter (übrige Anzahl Switchs?) = " + switchCounter);
            System.out.println("StudCounter (0?) = " + studCounter);
            System.out.println("SwitchFlag (false?) = " + switchFlag);
        }
    }
    /**
     * - stores the clicked student into stud2 or stud1 which depends on the studCounter <br>
     * - when both are stored the StudSwitch() method is called
     * @param stud_nr student array index number of clicked student
     * @param studBut student button which was clicked which will be stored
     */
    private void storeStud(int stud_nr,JButton studBut) {

        if (studCounter == 1) {
            stud2 = studArr[stud_nr];
            stud2_nr = stud_nr;
            this.studBut2 = studBut;
            System.out.println("Stud2 auf Platz: " + (stud2_nr + 1));
            System.out.println("Stud2 ID = " + studArr[stud2_nr].getId());
            StudSwitch(stud1, stud2);

        }

        else if (studCounter == 0) {
            studCounter++;
            System.out.println("studCounter = " + studCounter);
            stud1 = studArr[stud_nr];
            stud1_nr = stud_nr;
            this.studBut1 = studBut;
            System.out.println("Stud1 auf Platz " + (stud1_nr + 1));
            System.out.println("Stud1 ID = " + studArr[stud1_nr].getId());
        }
    }

    /**
     * - switchs the two selected students in the array and resets the button icons on it <br>
     * - it also resets the help variables to default
     * @param stud1 first clicked student to switch
     * @param stud2 second clicked student to switch
     */
    private void StudSwitch(Student stud1, Student stud2) {

        System.out.println("VORHER: Platz" + (stud1_nr + 1) + " = Student " + studArr[stud1_nr].getId() + " <--> "
                + "Platz" + (stud2_nr + 1) + " = Stundent " + studArr[stud2_nr].getId());

        // swtiching the two selected students 
        studArr[stud1_nr] = stud2;
        studArr[stud2_nr] = stud1;
        studBut1.setIcon(new ImageIcon(getClass().getResource(studArr[stud1_nr].getStudIcon())));
        studBut2.setIcon(new ImageIcon(getClass().getResource(studArr[stud2_nr].getStudIcon())));

        System.out.println("NACHHER: Platz" + (stud1_nr + 1) + " = Student " + studArr[stud1_nr].getId()
                + " ---- Platz" + (stud2_nr + 1) + " = Stundent " + studArr[stud2_nr].getId());

        // initializing the default values switchFlag, studCounter and decrements the switchCounter
        //switchFlag = 0;
        switchCounter--;
        studCounter = 0;
        
        switchStudToggleBut.setSelected(false);

        switchCounterLabel.setText(switchCounter + "x");
        switchCounterLabel.repaint();

    }
    /**
     * - it reacts when a student button was clicked
     * - if switch student button was clicked before it start the storeStud() method <br>
     * - if not it shows the attributes of the clicked student and checks  the cheatFlag
     * @param stud_nr student array index number of clicked student
     * @param studBut button which was clicked
     */
    public void StudButtonFunctions(int stud_nr, JButton studBut) {
      // !!! ExmatrikulationsFlag abfragen
            // switchFlag == 0 --> SwitchButton not clickeds
        switchFlag = switchStudToggleBut.isSelected();
        if (!switchFlag) {
            System.out.println("clicked Student = " + studArr[stud_nr].getId() + " *** ");
            System.out.println("SwitchCounter = " + switchCounter);
            //System.out.println(studArr[stud_nr].getStudIcon());
            

            // start method StudInfo() which shows knowledge, motivation and tiredness 
            // of the student which was clicked
            studInfo.StudInfoAttr(stud_nr);
           
            //die if-Abrage muss hier stehen,um Überlappungen mit dem Studententausch zu vermeiden
            //d.h. der Spicker kann nur dann eingesetzt werden, wenn der UmtauschButton nicht angeklickt ist(switchFlag=0)
            
              
              if (cheatFlag == 1){
                  
              //Abfrage willst du den Spicker einsetzen? Wenn ja gecklickt useCheat methode ausführen, beim Abbrechen cheatFlag auf 0 setzen 
               useCheat(stud_nr);
              }
               else 
                  System.out.println("Dieser Student bekommt keinen Spicker");
            
             
         // switchFlag == 1 --> SwitchButton clicked
        } else {
            System.out.println("SwitchFlag = true");
            storeStud(stud_nr,studBut);
        }  
        
        //} else { // nichts passiert   --> z.B.
        //}
    }
     
    /**
     *  -   function that gets the actual round and check if a user is allowed to
     *  -   change his/her professor right now. If so, the label professor counter will be set to 1. In other case - to 0)
     *  -   user is allowed to change his/her professor only at the beginning of the actual month and only once due semester time
     * @param jLab_DozCounter  Label in the navigation panel of a planning phase that shows how many times the user can change professor
     * @return true if professor can be changed. In other case return false
     */
    public  boolean checkProffesorChangeability(JLabel jLab_DozCounter) {
        int actualRound=Sims_1._maingame.round;
        lectorCounter = jLab_DozCounter;
        if ( (actualRound == 3 && !lectorChanged3)  || (actualRound == 6 && !lectorChanged6) || 
             (actualRound == 9 && !lectorChanged9)|| (actualRound == 12 && !lectorChanged12) ||
             (actualRound == 15 && !lectorChanged15)) {            
            lectorCounter.setText("1x");
            lectorCounter.repaint();
            return true;
        } else {            
            lectorCounter.setText("0x");
            lectorCounter.repaint();
            return false;
        }
        
    }

    /**
     * - function to change lector: randomly sets the value of professor-field between 0 and 100
     * - if professor was changed the appropriate professor-change-flag for the current round will be set to true i.e. 
     *
     * @param jLab_DozCounter  Label in the navigation panel of a planning phase that shows how many times the user can change 
     *                         professor - will be updated
     */ 
    public  void changeLector(JLabel jLab_DozCounter) {
        int actualRound=Sims_1._maingame.round; // - ABfrage des aktuellen Monats
        lectorCounter = jLab_DozCounter;        
         if (actualRound == 3) {
            lectorChanged3 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 6) {
            lectorChanged6 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 9) {
            lectorChanged9 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 12) {
            lectorChanged12 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 15) {
            lectorChanged15 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        }
        System.out.println("Dozent wurde gewechselt. Neuer Dozentenwert: " + Sims_1._maingame.professor);
        lectorCounter.setText("0x");
        lectorCounter.repaint();
    }
    
    
    
    /**
     * - Für Dialog-Fenster 
     * @return 
     */
    public  int getCheatFlag(){
        return cheatFlag;
    }
    
    public  void setCheatFlag(int Flag) {
          cheatFlag = Flag;
        
    }
    
    
    /**
     * - this method will be applied if a cheatFlag is set to 1 and we have selected one of a student
     *      also updates Spicker-value in game-file
     *   @param stud_nr 
     */
    public  void useCheat(int stud_nr){
        int currentSemester=Sims_1._maingame.getSemester();
        System.out.println("Student " +studArr[stud_nr].getId() + "kriegt den Spicker");
        
        //-> FLAG BEIM STUDENT SETZEN 
        studArr[stud_nr].setCheatAvailable(true);
        System.out.println("CheatAvailable?" +studArr[stud_nr].getCheatAvailable() + " Student " +studArr[stud_nr].getId());
        
        System.out.println("Anzahl der Spicker zuvor: " +Sims_1._maingame.cheatSheet.amount);
        Sims_1._maingame.cheatSheet.amount-=1;
        System.out.println("Spicker Anzahl im Inventar um 1 verringern, aktueller wert: " +Sims_1._maingame.cheatSheet.amount); // -> wird später  Spicker.amount um 1 verringern;
            cheatFlag=0;
            System.out.println("cheatFlag auf 0 setzen " +cheatFlag);
            //Spicker-Wert für das jeweilige Semester updaten:            
           Sims_1._maingame.setCheated(currentSemester);       
          
            
    
}
}
