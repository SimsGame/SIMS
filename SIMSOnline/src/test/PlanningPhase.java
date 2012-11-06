/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;

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
    private static javax.swing.JLabel switchCounterLabel;
    private static javax.swing.JToggleButton switchStudToggleBut;
    // new Game-instance
    private Game1 game;
    // declaration of the StudentArray
    private static Student[] studArr;
    // declaration of an studInfo instance
    protected static StudInfo studInfo;
    
    //flags deklaration
    private static boolean switchFlag = false;
    private static int cheatFlag = 0;  //will be set to 1, if Spicker in Dropdown-Field is selected 
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
    private static javax.swing.JLabel lectorCounter; //JLabel that shows how many times the user can change lector
     
    private static boolean lectorChanged4 = false; //flag is set if the lector was already changed in this month
    private static boolean lectorChanged7 = false;
    private static boolean lectorChanged10 = false;
    private static boolean lectorChanged13 = false;
    private static boolean lectorChanged16 = false;
    private static boolean validated;
    protected static int actMonth = 4;  // variable for actual month (from game-file)    
    protected static int lectorValue; //  variable that changes lector value (also from game file)

        // PlanningPhase constructor
    public PlanningPhase() {
    }
    // constructor which expects the three progress bars.
    // These are needed for the StudInfo methods
    // called first

    public PlanningPhase(javax.swing.JProgressBar jProgB_Knowledge,
            javax.swing.JProgressBar jProgB_Motivation,
            javax.swing.JProgressBar jProgB_Tiredness, 
            javax.swing.JLabel jLab_DozCounter,javax.swing.JToggleButton jToggleBut_SwitchStud) {

        // initializes the progress bars
        this.KnowledgeBar = jProgB_Knowledge;
        this.MotivationBar = jProgB_Motivation;
        this.TirednessBar = jProgB_Tiredness;
        
        // initializes the ToggleButton for switching students
        this.switchStudToggleBut = jToggleBut_SwitchStud;

        // StudentArray will be initialized
        game = Sims_1._maingame;
            // muss globalen Studentenarray bekommen und keine neue Initialisierung
        game.initArray();
        // studArr gets the StudentArray
        this.studArr = game.studentArray;

        // one instance of StudInfo which is used for all student buttons
        // initialzing the PrograssBars on studInfo
        studInfo = new StudInfo(KnowledgeBar, MotivationBar, TirednessBar);
        
        //updates label "Dozenten tauschen
        validateLector(jLab_DozCounter);
    }


    // called from SwitchStud-Button on navi
    public  void startStudSwitch(javax.swing.JLabel jLab_SwitchCounter) {
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

    private void storeStud(int stud_nr) {

        if (studCounter == 1) {
            stud2 = studArr[stud_nr];
            stud2_nr = stud_nr;
            System.out.println("Stud2 auf Platz: " + (stud2_nr + 1));
            System.out.println("Stud2 ID = " + studArr[stud2_nr].getId());
            StudSwitch(stud1, stud2);

        }

        else if (studCounter == 0) {
            studCounter++;
            System.out.println("studCounter = " + studCounter);
            stud1 = studArr[stud_nr];
            stud1_nr = stud_nr;
            System.out.println("Stud1 auf Platz " + (stud1_nr + 1));
            System.out.println("Stud1 ID = " + studArr[stud1_nr].getId());
        }
    }

    private void StudSwitch(Student stud1, Student stud2) {

        System.out.println("VORHER: Platz" + (stud1_nr + 1) + " = Student " + studArr[stud1_nr].getId() + " <--> "
                + "Platz" + (stud2_nr + 1) + " = Stundent " + studArr[stud2_nr].getId());

        // swtiching the two selected students 
        studArr[stud1_nr] = stud2;
        studArr[stud2_nr] = stud1;

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

    public void StudButtonFunctions(int stud_nr) {
      // !!! ExmatrikulationsFlag abfragen
            // switchFlag == 0 --> SwitchButton not clickeds
        switchFlag = switchStudToggleBut.isSelected();
        if (!switchFlag) {
            System.out.println("clicked Student = " + studArr[stud_nr].getId() + " *** ");
            System.out.println("SwitchCounter = " + switchCounter);

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
            storeStud(stud_nr);
        }  
        
        //} else { // nichts passiert   --> z.B.
        //}
    }

    /*
     * function that gets the actual month and check if a user is allowed to
     * changed a lector. If yes, the label counter will be set to 1. In other
     * case - to 0)
     *
     */
    public  boolean validateLector(javax.swing.JLabel jLab_DozCounter) {
        //actMonth=User.getMonth();
        lectorCounter = jLab_DozCounter;
        if ( (actMonth == 4 && !lectorChanged4)  || (actMonth == 7 && !lectorChanged7) || 
             (actMonth == 10 && !lectorChanged10)|| (actMonth == 13 && !lectorChanged13)||
             (actMonth == 16 && !lectorChanged16)) {
            
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
     * function to change lector, if lector was changed the appropriate flag
     * will be set to true
     */
    public  void changeLector(javax.swing.JLabel jLab_DozCounter) {
        //actMonth=User.getMonth(); - ABfrage des aktuellen Monats
        lectorCounter = jLab_DozCounter;
        
         if (actMonth == 4) {
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
    
    //methode, die aktuelles Semester berechnet
    public  int getTerm(){
        switch (actMonth) {
            case 1: case 2: case3:
                return 1;
                
            case 4: case 5: case6:               
                return 2;
                
            case 7: case 8: case9:            
                return 3;
                
            case 10: case 11: case12:                
                return 4;
                
            case 13: case 14: case15:            
                return 5;
                
            case 16: case 17: case18:                
                return 6;
                
            default:
                return 0;
        }
                  
    }
    
    //Für Dialog-Fenster
    public  int getCheatFlag(){
        return cheatFlag;
    }
    
    public  void setCheatFlag(int Flag) {
          cheatFlag = Flag;
        
    }
    
    
    /**
     * this method will be applied if a cheatFlag is set to 1 and we have selected one of a student.
     * also updates Spicker-value in game-file
     * @param stud_nr 
     */
    public  void useCheat(int stud_nr){
        System.out.println("Student " +studArr[stud_nr].getId() + "kriegt den Spicker"); //-> wird später den Flag in game.txt setzen
        System.out.println("Anzahl der Spicker zuvor: " +Sims_1._maingame.cheatSheet.amount);
        Sims_1._maingame.cheatSheet.amount-=1;
        System.out.println("Spicker Anzahl im Inventar um 1 verringern, aktueller wert: " +Sims_1._maingame.cheatSheet.amount); // -> wird später  Spicker.amount um 1 verringern;
            cheatFlag=0;
            System.out.println("cheatFlag auf 0 setzen " +cheatFlag);
            //Spicker-Wert für das jeweilige Semester updaten:
            
            int currTerm= getTerm();
            switch (currTerm){
                case 2:
                // Spicker wurde im 2 Sem. eingesetzt - Spickerwert fürs 2 Sem. auf 1 setzen (quasi "eingesetz2" aus der lokalen methode bei spicker auswahl auf 1 setzen)
                    break;
                case 3:
                    // Spicker wurde im 3 Sem. eingesetzt - Spickerwert fürs 3 Sem. auf 1 setzen
                    break;
                case 4:
                    // Spicker wurde im 4 Sem. eingesetzt - Spickerwert fürs 4 Sem. auf 1 setzen
                    break;
                case 5:
                    // Spicker wurde im 5 Sem. eingesetzt - Spickerwert fürs 5 Sem. auf 1 setzen
                    break;
                case 6:
                    // Spicker wurde im 6 Sem. eingesetzt - Spickerwert fürs 6 Sem. auf 1 setzen
                    break;
                default:
                    break;
            }
    
}
}
