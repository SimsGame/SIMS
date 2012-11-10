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
    private boolean cheatFlag = false;  //will be set to true, if Spicker in Dropdown-Field is selected  and can be used
                                       
    // counter
    public  int switchCounter = 5;
    private  int studCounter = 0;
   
    // students for the switching function
    private static Student stud1;
    private static Student stud2;
    private static int stud1_nr;
    private static int stud2_nr;
    
    
    //deklaration of the variables that are needed for the lector-change function
    private  JLabel professorCounter; //JLabel that shows how many times the user can change lector
     
    private  boolean lectorChanged4 = false; //flag is set if the lector was already changed in this round
    private  boolean lectorChanged7 = false;
    private  boolean lectorChanged10 = false;
    private  boolean lectorChanged13 = false;
    private  boolean lectorChanged16 = false;  
    
    
    private static JButton studBut1;
    private static JButton studBut2;
    public JButton[] studButtons;
     

    /**
     * - constructor which initializes the progress bars, the professor counter label 
     * and the switch student toggle button <br>
     * - tt sets the progress bars to the current average values of the students <br>
     * - tt validates if the professor can be switched
     * @param jProgB_Knowledge progress bar which shows the knowledge
     * @param jProgB_Motivation progress bar which shows the motivation
     * @param jProgB_Tiredness progress bar which shows the tiredness
     * @param jLab_DozCounter label which shows how many times one can change professor
     * @param jToggleBut_SwitchStud toggle button for student switching
     * @param jLab_SwitchCounter label with counter value of available student switchs
     */
    public PlanningPhase(JProgressBar jProgB_Knowledge,
            JProgressBar jProgB_Motivation,
            JProgressBar jProgB_Tiredness, 
            JLabel jLab_DozCounter,
            JToggleButton jToggleBut_SwitchStud,
            JLabel jLab_SwitchCounter) {
        
        // initializes motivation and tiredness of students
        Sims_1._maingame.initAttr();
        // StudentArray will be initialized
        this.studArr = Sims_1._maingame.getArray();
        
        // initializes the progress bars
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;
        
        // initializes label of counter switchs
        this.switchCounterLabel = jLab_SwitchCounter;
        
        
        // initializes the ToggleButton for switching students
        this.switchStudToggleBut = jToggleBut_SwitchStud;

        // sets Label of StudentSwitch to default value --> switchCounter == 5
        switchCounterLabel.setText(switchCounter + "x");
        switchCounterLabel.repaint();

        // one instance of StudInfo which is used for all student buttons
        // initialzing the PrograssBars on studInfo
        studInfo = new StudInfo(KnowledgeBar, MotivationBar, TirednessBar);
        
        this.professorCounter = jLab_DozCounter;
        //updates label "Dozenten tauschen"
        checkProffesorChangeability(professorCounter);
        
        new StudIcons(Sims_1.planningPhaseButtons, Sims_1._maingame.getArray()); 
        
    }



    // called from SwitchStud-Button on navi
    /**
     * - is called when the stud switch toggle button was clicked
     * and initializes the switchFlag with the isSelected() method of
     * an toggle button
     * @param jLab_SwitchCounter 
     */
    public  void startStudSwitch() {
        
        
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
      
        
        // !!! ExmatrikulationsFlag abfragen!!!!
        
            // switchFlag == 0 --> SwitchButton not clickeds
        switchFlag = switchStudToggleBut.isSelected();
        if (!switchFlag) {
            System.out.println("clicked Student = " + studArr[stud_nr].getId() + " *** ");
            System.out.println("SwitchCounter = " + switchCounter);
            //System.out.println(studArr[stud_nr].getStudIcon());
            

            // start method StudInfo() which shows knowledge, motivation and tiredness 
            // of the student which was clicked
            studInfo.StudInfoAttr(stud_nr);      
            
            // if-condition should be here to avoid overlap with the StudSwitch-function
            // so use Cheat funktion will be invoked only if switchFlag==false and Cheat was selected
              if (cheatFlag){             
              
               useCheat(stud_nr);
               System.out.println("Cheat available? " +studArr[stud_nr].getCheatAvailable());
              }
               else 
                  System.out.println("Dieser Student bekommt keinen Spicker");  
                  System.out.println("Cheat available? " +studArr[stud_nr].getCheatAvailable());
             
         // switchFlag == true --> SwitchButton clicked
        } else {
            System.out.println("SwitchFlag = true");
            storeStud(stud_nr,studBut);
        }      
       
    }
     
    /**
     * function that gets the actual round and check if a user is allowed to 
     * change his/her professor right now. If so, the label professor counter
     * will be set to 1. In other case - to 0) 
     * user is allowed to change  his/her professor only at the beginning 
     * of the actual month and only once due semester time
     *
     * @param jLab_DozCounter Label in the navigation panel of a planning phase
     * that shows how many times the user can change professor
     * @return true if professor can be changed. In other case return false
     */
    public  boolean checkProffesorChangeability(JLabel jLab_DozCounter) {
        int actualRound=Sims_1._maingame.round;
        professorCounter = jLab_DozCounter;
        if ( (actualRound == 4 && !lectorChanged4)  || (actualRound == 7 && !lectorChanged7) || 
             (actualRound == 10 && !lectorChanged10)|| (actualRound == 13 && !lectorChanged13) ||
             (actualRound == 16 && !lectorChanged16)) {            
            professorCounter.setText("1x");
            professorCounter.repaint();
            return true;
        } else {            
            professorCounter.setText("0x");
            professorCounter.repaint();
            return false;
        }
        
    }

    /**
     * function to change lector: randomly sets the value of professor-field
     * between 0 and 100 - if professor was changed the appropriate
     * professor-change-flag for the current round will be set to true in order
     * to avoid new change
     *
     * @param jLab_DozCounter Label in the navigation panel of a planning phase that shows how many times
     *                        the user can change professor - will be updated
     * 
     */
    public void changeLector(JLabel jLab_DozCounter) {
        int actualRound = Sims_1._maingame.round; // - ABfrage des aktuellen Monats
        professorCounter = jLab_DozCounter;
        if (actualRound == 4) {
            lectorChanged4 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 7) {
            lectorChanged7 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 10) {
            lectorChanged10 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 13) {
            lectorChanged13 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        } else if (actualRound == 16) {
            lectorChanged16 = true;
            Sims_1._maingame.professor = (int) Math.round(Math.random() * 100 + 1);
        }
        System.out.println("Dozent wurde gewechselt. Neuer Dozentenwert: " + Sims_1._maingame.professor);
        professorCounter.setText("0x");
        professorCounter.repaint();
    }     
    
    /**
     *
     * @return true if CheatFlag is set.
     */
    public boolean getCheatFlag() {
        return cheatFlag;
    }

    /**
     *
     * @param flag true if the user really wants to use cheat sheet
     */
    public void setCheatFlag(boolean flag) {
        cheatFlag = flag;
    }
    
    
    /**
     * - this method will be applied if a cheatFlag is set to true and one of a students is selected
     * - updates amount of cheat sheets in the inventory and set cheatAvailable attribut of a clicked student to true
     * - also notes that cheat sheet in this semester was used in order to avoid new use in the same semester
     * 
     * @param stud_nr  student array index number of clicked student
     */
    public void useCheat(int stud_nr) {
        int currentSemester = Sims_1._maingame.getSemester();
        System.out.println("Student " + studArr[stud_nr].getId() + "kriegt den Spicker");
        studArr[stud_nr].setCheatAvailable(true);
        System.out.println("CheatAvailable?" + studArr[stud_nr].getCheatAvailable() + " Student " + studArr[stud_nr].getId());

        System.out.println("Anzahl der Spicker zuvor: " + Sims_1._maingame.cheatSheet.amount);
        Sims_1._maingame.cheatSheet.amount -= 1;
        System.out.println("Spicker Anzahl im Inventar um 1 verringern, aktueller wert: " + Sims_1._maingame.cheatSheet.amount);
        cheatFlag = false;
        System.out.println("cheatFlag auf false setzen " + cheatFlag);

        Sims_1._maingame.setCheated(currentSemester);
    }
}
