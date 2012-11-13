/*
 * This is the main form of the SIMS game. Each form element is created here.
 * From here different functions are called.
 */
package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Jannik, Yulia, Tobias, Nadir, Jörg, Dawid
 */
public class Sims_1 extends javax.swing.JFrame {

    //**************************************************************  //by Dawid
    //*******************Section of constants: start****************
    //**************************************************************
    public static final String _dataFolderName = "data";
    public static final String _profileFileName = "profile.txt";
    public static final String _gameFileName = "game.txt";
    public static final String _inventoryFileName = "inventory.txt";
    public static final String _usersFileName = "users.csv";
    public static final String _UCoinsName = "UCoins";
    public static final String _creditsName = "credits";
    public static final String _loginFileName = "login.txt";
    public static final String _adminName = "administr4t0r";
    public static final String _adminPass = "p4ssw0rd";
    //***************************************************************
    //***************Section of constants: end***********************
    //***************************************************************
    //###############################################################
    //***************************************************************  //by Dawid
    //**************Section of global vars: start********************
    //***************************************************************
    public static User _mainuser;
    public static Game1 _maingame;
    public static Admin _mainadmin;
    public ActivityPhase activityPhase;
    public static PlanningPhase planningPhase;
    protected static javax.swing.JButton[] activityPhaseButtons;
    protected static javax.swing.JButton[] planningPhaseButtons;
    protected static javax.swing.JLabel[] laptopLabels;
    //***************************************************************
    //***************Section of global vars: end*********************
    //***************************************************************
    public CardLayout cl;
    Item item = new Item();
    CoinExchange exchange = new CoinExchange();
    public JDialog miniGameFinished = new JDialog();
    public static long startTime = 0;
    public static long endTime = 0;

    /**
     * Sets up and initializes each component and some additional settings. The
     * auto login function is called from here as well.
     */
    public Sims_1() {
        button_afterGame = new JButton("Game");
        button_afterGame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                goToNextPage();
            }
        });
        miniGameFinished.add(button_afterGame);
        initComponents();
        setSize(1000, 700);
        buyCoins.setSize(400, 320);
        buyCoins.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        buyCoins.setLocationRelativeTo(null);
        dialog_error.setSize(400, 320);
        dialog_error.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog_error.setLocationRelativeTo(null);
        warningDialog.setSize(400, 320); //added  by Julia
        warningDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        warningDialog.setLocationRelativeTo(null);
        professorChangedDialog.setSize(400, 320); //added by Julia
        professorChangedDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        professorChangedDialog.setLocationRelativeTo(null);
        professorNotChangedDialog.setSize(400, 320);
        professorNotChangedDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        professorNotChangedDialog.setLocationRelativeTo(null);
        notAllowedUseCheatDialog.setSize(400, 320);  //added by Julia
        notAllowedUseCheatDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        notAllowedUseCheatDialog.setLocationRelativeTo(null);
        noCheatsAvailableDialog.setSize(400, 320); //added by Julia
        noCheatsAvailableDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        noCheatsAvailableDialog.setLocationRelativeTo(null);
       // warningExitPlanningPhase.setSize(500, 320);
        warningExitPlanningPhase.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        warningExitPlanningPhase.setLocationRelativeTo(null);
        dialog_statsError.setLocationRelativeTo(null);
        dialog_examResults.setLocationRelativeTo(null);
        panel_gamePhases.setVisible(false);                  //changes by Dawid
        panel_menue.setVisible(false);
        panel_Register.setVisible(false);
        panel_Login.setVisible(true);
        panel_adminUser.setVisible(false);
        panel_Profile.setVisible(false);
        label_lErr.setText("");
        panel_adminUser.setVisible(false);
        label_easteregg.setVisible(false);
        cl = (CardLayout) (panel_gamePhases.getLayout());
        setIconImage(new ImageIcon(getClass().getResource("/pictures/icon_test.png")).getImage()); // Icon added by Nadir
        setLocationRelativeTo(null); // Fenster zentrieren by Nadir
        autoLogin();
        panel_Admin.setVisible(false); // change by Nadir
        this.activityPhaseButtons=constructActivityPhaseButtons(); //added by Jörg
        this.laptopLabels=constructLaptopLabels();
        this.planningPhaseButtons=constructPlanningPhaseButtons(); //added by Tobias
        noSave_overlay.setVisible(false); //by Nadir , deactivates the overlay for development phase, remove later
        panel_Credits.setVisible(false);
        label_dozent_action.setVisible(false);
        SetActivityOpaque();
        SetPlanningOpaque();
        label_windowsclosed.setVisible(false);
        panel_stats.setVisible(false);
      
        
        
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buyCoins = new javax.swing.JDialog();
        label_swapper = new javax.swing.JLabel();
        label_swapperUcoins = new javax.swing.JLabel();
        label_swapperUcoinsAmount = new javax.swing.JLabel();
        label_swapperCredits = new javax.swing.JLabel();
        label_swapperCreditsAmount = new javax.swing.JLabel();
        label_currentExchange = new javax.swing.JLabel();
        textfield_swapperUcoins = new javax.swing.JTextField();
        button_swapperExchange = new javax.swing.JButton();
        button_swapperAbord = new javax.swing.JButton();
        textfield_swapperCredits = new javax.swing.JTextField();
        label_swapperArrow1 = new javax.swing.JLabel();
        label_swapperArrow3 = new javax.swing.JLabel();
        dialog_error = new javax.swing.JDialog();
        label_shopMessage = new javax.swing.JLabel();
        label_shopMessage1 = new javax.swing.JLabel();
        label_shopMessage2 = new javax.swing.JLabel();
        label_shopMessage3 = new javax.swing.JLabel();
        button_shopMessageOk = new javax.swing.JButton();
        warningDialog = new javax.swing.JDialog();
        jBut_JA = new javax.swing.JButton();
        jBut_NEIN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        professorChangedDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jBut_OKlector = new javax.swing.JButton();
        professorNotChangedDialog = new javax.swing.JDialog();
        jBut_OKnotchanged = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        noCheatsAvailableDialog = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jBut_OKnoCheatsAvailable = new javax.swing.JButton();
        notAllowedUseCheatDialog = new javax.swing.JDialog();
        jBut_OKnotAllowedUseCheat = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        warningExitPlanningPhase = new javax.swing.JDialog();
        label_warning1 = new javax.swing.JLabel();
        label_warning2 = new javax.swing.JLabel();
        label_warning3 = new javax.swing.JLabel();
        llabel_warning4 = new javax.swing.JLabel();
        label_warning5 = new javax.swing.JLabel();
        jBut_confirmExit = new javax.swing.JButton();
        jBut_cancelExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dialog_examResults = new javax.swing.JDialog();
        label_examHeading = new javax.swing.JLabel();
        label_examFailed = new javax.swing.JLabel();
        label_examFailedText = new javax.swing.JLabel();
        label_examRemainingText1 = new javax.swing.JLabel();
        label_examRemaining = new javax.swing.JLabel();
        label_examRemainingText2 = new javax.swing.JLabel();
        dialog_statsError = new javax.swing.JDialog();
        label_statsErrorHeadline = new javax.swing.JLabel();
        label_statsErrorText1 = new javax.swing.JLabel();
        label_statsErrorText2 = new javax.swing.JLabel();
        label_statsErrorText3 = new javax.swing.JLabel();
        button_statsErrorOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panel_menue = new javax.swing.JPanel();
        panel_stats = new javax.swing.JPanel();
        label_statsHeadline = new javax.swing.JLabel();
        label_statsEarnedCredits = new javax.swing.JLabel();
        label_statsCurrentCredits = new javax.swing.JLabel();
        label_statsPoints = new javax.swing.JLabel();
        label_statsOverallTime = new javax.swing.JLabel();
        label_statsSemester = new javax.swing.JLabel();
        label_statsRate = new javax.swing.JLabel();
        label_statsStudentArrtibutes = new javax.swing.JLabel();
        panel_Credits = new javax.swing.JPanel();
        label_creditsHeadline = new javax.swing.JLabel();
        label_creditsHeadline1 = new javax.swing.JLabel();
        label_creditsNames = new javax.swing.JLabel();
        label_creditsSIMS = new javax.swing.JLabel();
        label_creditsCopyright = new javax.swing.JLabel();
        panel_Profile = new javax.swing.JPanel();
        textfield_pKontoname = new javax.swing.JTextField();
        textfield_pEmail1 = new javax.swing.JTextField();
        textfield_pEmail2 = new javax.swing.JTextField();
        textfield_pName = new javax.swing.JTextField();
        textfield_pSurename = new javax.swing.JTextField();
        password_pPass1 = new javax.swing.JPasswordField();
        password_pPass2 = new javax.swing.JPasswordField();
        button_pSave = new javax.swing.JButton();
        label_pKontoname = new javax.swing.JLabel();
        label_pPass1 = new javax.swing.JLabel();
        label_pPass2 = new javax.swing.JLabel();
        label_pEmail1 = new javax.swing.JLabel();
        label_pEmail2 = new javax.swing.JLabel();
        label_pFirstName = new javax.swing.JLabel();
        label_pSecondName = new javax.swing.JLabel();
        button_pCancel = new javax.swing.JButton();
        label_pErrAccname = new javax.swing.JLabel();
        label_pErrPass1 = new javax.swing.JLabel();
        label_pErrPass2 = new javax.swing.JLabel();
        label_pErrEmail1 = new javax.swing.JLabel();
        label_pErrEmail2 = new javax.swing.JLabel();
        label_pErrFirstName = new javax.swing.JLabel();
        label_pErrLastName = new javax.swing.JLabel();
        Menu_overlay1 = new javax.swing.JLabel();
        loggedinas = new javax.swing.JLabel();
        label_handcursor = new javax.swing.JLabel();
        label_handcursor1 = new javax.swing.JLabel();
        label_handcursor2 = new javax.swing.JLabel();
        label_handcursor3 = new javax.swing.JLabel();
        label_handcursor4 = new javax.swing.JLabel();
        label_handcursor5 = new javax.swing.JLabel();
        label_handcursor6 = new javax.swing.JLabel();
        noSave_overlay = new javax.swing.JLabel();
        Menu_overlay = new javax.swing.JLabel();
        button_menuExit = new javax.swing.JButton();
        button_menuStartNewGame = new javax.swing.JButton();
        button_menuLoadGame = new javax.swing.JButton();
        button_menuCredits = new javax.swing.JButton();
        button_menuProfile = new javax.swing.JButton();
        button_menuLogOut = new javax.swing.JButton();
        button_menuStatistic = new javax.swing.JButton();
        panel_gamePhases = new javax.swing.JPanel();
        gamePlanning = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        label_logo_planning = new javax.swing.JLabel();
        text_backtomenue1 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLab_Planning_unused01 = new javax.swing.JLabel();
        jLab_Planning_unused02 = new javax.swing.JLabel();
        jLab_Planning_unused03 = new javax.swing.JLabel();
        jProgB_Müdigkeit = new javax.swing.JProgressBar();
        jProgB_Motivation = new javax.swing.JProgressBar();
        jProgB_Wissen = new javax.swing.JProgressBar();
        jLab_Planning_unused04 = new javax.swing.JLabel();
        Shop = new javax.swing.JPanel();
        jBut_startShop = new javax.swing.JButton();
        Navi = new javax.swing.JPanel();
        jPan_StudSwitch = new javax.swing.JPanel();
        jLab_StudSwitch = new javax.swing.JLabel();
        jLab_Planning_unused05 = new javax.swing.JLabel();
        jLab_Planning_unused06 = new javax.swing.JLabel();
        jLab_StudCounter = new javax.swing.JLabel();
        jToggleBut_SwitchStud = new javax.swing.JToggleButton();
        jLab_DozSwitch1 = new javax.swing.JLabel();
        jPan_DozSwitch = new javax.swing.JPanel();
        jLab_DozSwitch = new javax.swing.JLabel();
        jLab_Planning_unused07 = new javax.swing.JLabel();
        jLab_Planning_unused08 = new javax.swing.JLabel();
        jLab_DozCounter = new javax.swing.JLabel();
        jBut_ChangeProfessor = new javax.swing.JButton();
        jPan_ItemSelect = new javax.swing.JPanel();
        jComboB_Items = new javax.swing.JComboBox();
        jPan_ItemStorage = new javax.swing.JPanel();
        jLab_Planning_unused09 = new javax.swing.JLabel();
        jLab_Redbull = new javax.swing.JLabel();
        jLab_Duplo = new javax.swing.JLabel();
        jLab_OMNI = new javax.swing.JLabel();
        jPan_Planning_Play = new javax.swing.JPanel();
        jBut_Play = new javax.swing.JButton();
        StudField = new javax.swing.JPanel();
        jBut_Dozent = new javax.swing.JButton();
        jBut_1 = new javax.swing.JButton();
        jBut_2 = new javax.swing.JButton();
        jBut_3 = new javax.swing.JButton();
        jBut_4 = new javax.swing.JButton();
        jBut_5 = new javax.swing.JButton();
        jBut_6 = new javax.swing.JButton();
        jBut_7 = new javax.swing.JButton();
        jBut_8 = new javax.swing.JButton();
        jBut_9 = new javax.swing.JButton();
        jBut_10 = new javax.swing.JButton();
        jBut_11 = new javax.swing.JButton();
        jBut_12 = new javax.swing.JButton();
        jBut_13 = new javax.swing.JButton();
        jBut_14 = new javax.swing.JButton();
        jBut_15 = new javax.swing.JButton();
        jBut_16 = new javax.swing.JButton();
        jBut_17 = new javax.swing.JButton();
        jBut_18 = new javax.swing.JButton();
        jBut_19 = new javax.swing.JButton();
        jBut_20 = new javax.swing.JButton();
        jBut_21 = new javax.swing.JButton();
        jBut_22 = new javax.swing.JButton();
        jBut_23 = new javax.swing.JButton();
        jBut_24 = new javax.swing.JButton();
        jBut_25 = new javax.swing.JButton();
        jBut_26 = new javax.swing.JButton();
        jBut_27 = new javax.swing.JButton();
        jBut_28 = new javax.swing.JButton();
        jBut_29 = new javax.swing.JButton();
        jBut_30 = new javax.swing.JButton();
        label_PlanningPhaseoverlay = new javax.swing.JLabel();
        shop = new javax.swing.JPanel();
        panel_shopBackMainmenu = new javax.swing.JPanel();
        label_logo = new javax.swing.JLabel();
        text_backtomenue2 = new javax.swing.JLabel();
        panel_shopInventory = new javax.swing.JPanel();
        label_inventar = new javax.swing.JLabel();
        label_shopStudents = new javax.swing.JLabel();
        label_shopRemainingStudents = new javax.swing.JLabel();
        label_shopSemester = new javax.swing.JLabel();
        label_shopRemainingSemesters = new javax.swing.JLabel();
        label_item4 = new javax.swing.JLabel();
        label_item1 = new javax.swing.JLabel();
        label_item2 = new javax.swing.JLabel();
        label_item1Name = new javax.swing.JLabel();
        label_item1Amount = new javax.swing.JLabel();
        label_item2Name = new javax.swing.JLabel();
        label_item2Amount = new javax.swing.JLabel();
        label_item3Name = new javax.swing.JLabel();
        label_item3Amount = new javax.swing.JLabel();
        label_item3 = new javax.swing.JLabel();
        label_item4Name = new javax.swing.JLabel();
        label_item4Amount = new javax.swing.JLabel();
        panel_shopHeadline = new javax.swing.JPanel();
        ucoinsShop = new javax.swing.JLabel();
        creditsShop = new javax.swing.JLabel();
        punkteShop = new javax.swing.JLabel();
        button_startExchange = new javax.swing.JButton();
        label_shopUCoinsName = new javax.swing.JLabel();
        label_shopCreditsName = new javax.swing.JLabel();
        label_shopPointsName = new javax.swing.JLabel();
        label_shopName = new javax.swing.JLabel();
        panel_shopBackPlanningPhase = new javax.swing.JPanel();
        button_shopReturn = new javax.swing.JButton();
        panel_shopItems = new javax.swing.JPanel();
        label_cheatSheetOverlay = new javax.swing.JLabel();
        label_omniOverlay = new javax.swing.JLabel();
        label_duploOverlay = new javax.swing.JLabel();
        label_redBullOverlay = new javax.swing.JLabel();
        panel_redBull = new javax.swing.JPanel();
        label_redBullName = new javax.swing.JLabel();
        label_redBullAmount = new javax.swing.JLabel();
        label_redBullLocked = new javax.swing.JLabel();
        label_redBullImage = new javax.swing.JLabel();
        panel_omniSense = new javax.swing.JPanel();
        label_omniName = new javax.swing.JLabel();
        label_omniLocked = new javax.swing.JLabel();
        label_omniAmount = new javax.swing.JLabel();
        label_omniAudioImage = new javax.swing.JLabel();
        panel_duplo = new javax.swing.JPanel();
        label_duploName = new javax.swing.JLabel();
        label_duploAmount = new javax.swing.JLabel();
        label_duploLocked = new javax.swing.JLabel();
        label_duploImage = new javax.swing.JLabel();
        panel_cheatSheet = new javax.swing.JPanel();
        label_cheatSheetName = new javax.swing.JLabel();
        label_cheatSheetLocked = new javax.swing.JLabel();
        label_cheatSheetAmount = new javax.swing.JLabel();
        label_cheatSheetImage = new javax.swing.JLabel();
        gamePlaying = new javax.swing.JPanel();
        panel_logoarea = new javax.swing.JPanel();
        label_logo_playing = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        text_inventar = new javax.swing.JLabel();
        label_item3Inv = new javax.swing.JLabel();
        text_students = new javax.swing.JLabel();
        label_students = new javax.swing.JLabel();
        text_semester = new javax.swing.JLabel();
        label_semester = new javax.swing.JLabel();
        label_ucoinsInv = new javax.swing.JLabel();
        label_item2Inv = new javax.swing.JLabel();
        label_creditsInv = new javax.swing.JLabel();
        label_item3InvName = new javax.swing.JLabel();
        label_item3InvAmount = new javax.swing.JLabel();
        label_item1Inv = new javax.swing.JLabel();
        text_score = new javax.swing.JLabel();
        label_score = new javax.swing.JLabel();
        label_item1InvName = new javax.swing.JLabel();
        label_item2InvName = new javax.swing.JLabel();
        label_item2InvAmount = new javax.swing.JLabel();
        label_item1InvAmount = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        text_wissen = new javax.swing.JLabel();
        button_window = new javax.swing.JButton();
        label_knowledgeBar_overlay = new javax.swing.JLabel();
        text_motivation = new javax.swing.JLabel();
        text_tiredness = new javax.swing.JLabel();
        KnowledgeBar = new javax.swing.JProgressBar();
        MotivationBar = new javax.swing.JProgressBar();
        TirednessBar = new javax.swing.JProgressBar();
        text_noise = new javax.swing.JLabel();
        text_air = new javax.swing.JLabel();
        NoiseBar = new javax.swing.JProgressBar();
        AirBar = new javax.swing.JProgressBar();
        toggleButton_shortBreak = new javax.swing.JToggleButton();
        toggleButton_teamwork = new javax.swing.JToggleButton();
        panel_timerarea = new javax.swing.JPanel();
        label_timer = new javax.swing.JLabel();
        panel_activityPhaseStudField = new javax.swing.JPanel();
        button_dozent1 = new javax.swing.JButton();
        label_laptop6 = new javax.swing.JLabel();
        label_laptop5 = new javax.swing.JLabel();
        label_laptop4 = new javax.swing.JLabel();
        label_laptop3 = new javax.swing.JLabel();
        label_laptop2 = new javax.swing.JLabel();
        label_laptop1 = new javax.swing.JLabel();
        label_laptop7 = new javax.swing.JLabel();
        label_laptop8 = new javax.swing.JLabel();
        label_laptop9 = new javax.swing.JLabel();
        label_laptop10 = new javax.swing.JLabel();
        label_laptop11 = new javax.swing.JLabel();
        label_laptop12 = new javax.swing.JLabel();
        label_laptop13 = new javax.swing.JLabel();
        label_laptop14 = new javax.swing.JLabel();
        label_laptop15 = new javax.swing.JLabel();
        label_laptop16 = new javax.swing.JLabel();
        label_laptop17 = new javax.swing.JLabel();
        label_laptop18 = new javax.swing.JLabel();
        label_laptop19 = new javax.swing.JLabel();
        label_laptop20 = new javax.swing.JLabel();
        label_laptop21 = new javax.swing.JLabel();
        label_laptop22 = new javax.swing.JLabel();
        label_laptop23 = new javax.swing.JLabel();
        label_laptop24 = new javax.swing.JLabel();
        label_laptop25 = new javax.swing.JLabel();
        label_laptop26 = new javax.swing.JLabel();
        label_laptop27 = new javax.swing.JLabel();
        label_laptop28 = new javax.swing.JLabel();
        label_laptop29 = new javax.swing.JLabel();
        label_laptop30 = new javax.swing.JLabel();
        button_stud1 = new javax.swing.JButton();
        button_stud2 = new javax.swing.JButton();
        button_stud3 = new javax.swing.JButton();
        button_stud4 = new javax.swing.JButton();
        button_stud5 = new javax.swing.JButton();
        button_stud6 = new javax.swing.JButton();
        button_stud7 = new javax.swing.JButton();
        button_stud8 = new javax.swing.JButton();
        button_stud9 = new javax.swing.JButton();
        button_stud10 = new javax.swing.JButton();
        button_stud11 = new javax.swing.JButton();
        button_stud12 = new javax.swing.JButton();
        button_stud13 = new javax.swing.JButton();
        button_stud14 = new javax.swing.JButton();
        button_stud15 = new javax.swing.JButton();
        button_stud16 = new javax.swing.JButton();
        button_stud17 = new javax.swing.JButton();
        button_stud18 = new javax.swing.JButton();
        button_stud19 = new javax.swing.JButton();
        label_dozent_action = new javax.swing.JLabel();
        button_stud20 = new javax.swing.JButton();
        button_stud21 = new javax.swing.JButton();
        button_stud22 = new javax.swing.JButton();
        button_stud23 = new javax.swing.JButton();
        button_stud24 = new javax.swing.JButton();
        button_stud25 = new javax.swing.JButton();
        button_stud26 = new javax.swing.JButton();
        button_stud27 = new javax.swing.JButton();
        button_stud28 = new javax.swing.JButton();
        button_stud29 = new javax.swing.JButton();
        button_stud30 = new javax.swing.JButton();
        label_windowsclosed = new javax.swing.JLabel();
        label_GameFieldOverlay = new javax.swing.JLabel();
        jLab_DozSwitch2 = new javax.swing.JLabel();
        panel_gameOver = new javax.swing.JPanel();
        button_retry = new javax.swing.JButton();
        label_gameOverPoints = new javax.swing.JLabel();
        label_gameOverSemester = new javax.swing.JLabel();
        label_gameOver = new javax.swing.JLabel();
        panel_Login = new javax.swing.JPanel();
        panel_Register = new javax.swing.JPanel();
        textfield_rKontoname = new javax.swing.JTextField();
        textfield_rEmail1 = new javax.swing.JTextField();
        textfield_rEmail2 = new javax.swing.JTextField();
        textfield_rName = new javax.swing.JTextField();
        textfield_rSurename = new javax.swing.JTextField();
        password_rPass1 = new javax.swing.JPasswordField();
        password_rPass2 = new javax.swing.JPasswordField();
        button_rRegister = new javax.swing.JButton();
        label_rKontoname = new javax.swing.JLabel();
        label_rPass1 = new javax.swing.JLabel();
        label_rPass2 = new javax.swing.JLabel();
        label_rEmail1 = new javax.swing.JLabel();
        label_rEmail2 = new javax.swing.JLabel();
        label_rFirstName = new javax.swing.JLabel();
        label_rSecondName = new javax.swing.JLabel();
        button_cancel = new javax.swing.JButton();
        label_rErrAccname = new javax.swing.JLabel();
        label_rErrPass1 = new javax.swing.JLabel();
        label_rErrPass2 = new javax.swing.JLabel();
        label_rErrEmail1 = new javax.swing.JLabel();
        label_rErrEmail2 = new javax.swing.JLabel();
        label_rErrFirstName = new javax.swing.JLabel();
        label_rErrLastName = new javax.swing.JLabel();
        background_register = new javax.swing.JLabel();
        textfield_Kontoname = new javax.swing.JTextField();
        button_Login = new javax.swing.JButton();
        button_Register = new javax.swing.JToggleButton();
        password_Pass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        check_saveUser = new javax.swing.JCheckBox();
        check_autoLogin = new javax.swing.JCheckBox();
        label_lErr = new javax.swing.JLabel();
        label_eastereggtrigger = new javax.swing.JLabel();
        label_easteregg = new javax.swing.JLabel();
        buton_enterAdmin = new javax.swing.JButton();
        label_loginlogobig = new javax.swing.JLabel();
        login_background = new javax.swing.JLabel();
        panel_adminUser = new javax.swing.JPanel();
        button_aSave = new javax.swing.JButton();
        label_aAccname = new javax.swing.JLabel();
        label_aPass = new javax.swing.JLabel();
        textfield_aKontoname = new javax.swing.JTextField();
        textfield_aEmail = new javax.swing.JTextField();
        label_aEmail = new javax.swing.JLabel();
        button_auCancel1 = new javax.swing.JButton();
        label_aFirstName = new javax.swing.JLabel();
        textfield_aSurename = new javax.swing.JTextField();
        label_aLastName = new javax.swing.JLabel();
        textfield_aName = new javax.swing.JTextField();
        lable_aProfil = new javax.swing.JLabel();
        textfield_aUCoins = new javax.swing.JTextField();
        label_aUCions = new javax.swing.JLabel();
        textfield_aCredits = new javax.swing.JTextField();
        label_aCredits = new javax.swing.JLabel();
        textfield_aDuplo = new javax.swing.JTextField();
        label_aDuplo = new javax.swing.JLabel();
        textfield_aRedBull = new javax.swing.JTextField();
        textfield_aOMNI = new javax.swing.JTextField();
        label_aRedBull = new javax.swing.JLabel();
        label_aOMNI = new javax.swing.JLabel();
        label_aSpicker = new javax.swing.JLabel();
        slider_aMonth = new javax.swing.JSlider();
        label_aMonth = new javax.swing.JLabel();
        label_aGame = new javax.swing.JLabel();
        textfield_aPass = new javax.swing.JTextField();
        label_aMonthVal = new javax.swing.JLabel();
        button_aDelete = new javax.swing.JButton();
        label_aErrAccName = new javax.swing.JLabel();
        label_aErrPass = new javax.swing.JLabel();
        label_aErrEmail = new javax.swing.JLabel();
        label_aErrFirstName = new javax.swing.JLabel();
        label_aErrLastName = new javax.swing.JLabel();
        label_aErrUCoins = new javax.swing.JLabel();
        label_aErrCredits = new javax.swing.JLabel();
        label_aErrDuplo = new javax.swing.JLabel();
        label_aErrRedBull = new javax.swing.JLabel();
        label_aErrOmni = new javax.swing.JLabel();
        label_aErrSpicker = new javax.swing.JLabel();
        textfield_aSpicker = new javax.swing.JTextField();
        background_adminUser = new javax.swing.JLabel();
        panel_Admin = new javax.swing.JPanel();
        background_admin = new javax.swing.JLabel();
        button_aCancel = new javax.swing.JButton();

        buyCoins.setLocationByPlatform(true);
        buyCoins.setModal(true);
        buyCoins.setName("dialog_buyCoins"); // NOI18N
        buyCoins.getContentPane().setLayout(null);

        label_swapper.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_swapper.setText("UCoins => Credits Tausch");
        buyCoins.getContentPane().add(label_swapper);
        label_swapper.setBounds(30, 20, 370, 60);

        label_swapperUcoins.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_swapperUcoins.setText("UCoins:");
        buyCoins.getContentPane().add(label_swapperUcoins);
        label_swapperUcoins.setBounds(50, 90, 80, 30);

        label_swapperUcoinsAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_swapperUcoinsAmount.setText("5");
        buyCoins.getContentPane().add(label_swapperUcoinsAmount);
        label_swapperUcoinsAmount.setBounds(120, 80, 80, 50);

        label_swapperCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_swapperCredits.setText("Credits:");
        buyCoins.getContentPane().add(label_swapperCredits);
        label_swapperCredits.setBounds(50, 160, 70, 30);

        label_swapperCreditsAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_swapperCreditsAmount.setText("600");
        buyCoins.getContentPane().add(label_swapperCreditsAmount);
        label_swapperCreditsAmount.setBounds(120, 150, 80, 50);

        label_currentExchange.setText("1 UCoin = 100 Credits");
        buyCoins.getContentPane().add(label_currentExchange);
        label_currentExchange.setBounds(230, 120, 140, 40);

        textfield_swapperUcoins.setMinimumSize(new java.awt.Dimension(30, 20));
        textfield_swapperUcoins.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfield_swapperUcoinsKeyReleased(evt);
            }
        });
        buyCoins.getContentPane().add(textfield_swapperUcoins);
        textfield_swapperUcoins.setBounds(170, 90, 50, 30);

        button_swapperExchange.setText("Tauschen");
        button_swapperExchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_swapperExchangeActionPerformed(evt);
            }
        });
        buyCoins.getContentPane().add(button_swapperExchange);
        button_swapperExchange.setBounds(50, 220, 130, 23);

        button_swapperAbord.setText("Abbrechen");
        button_swapperAbord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_swapperAbordActionPerformed(evt);
            }
        });
        buyCoins.getContentPane().add(button_swapperAbord);
        button_swapperAbord.setBounds(210, 220, 130, 23);

        textfield_swapperCredits.setEditable(false);
        textfield_swapperCredits.setMinimumSize(new java.awt.Dimension(30, 20));
        buyCoins.getContentPane().add(textfield_swapperCredits);
        textfield_swapperCredits.setBounds(170, 160, 50, 30);

        label_swapperArrow1.setText("||");
        buyCoins.getContentPane().add(label_swapperArrow1);
        label_swapperArrow1.setBounds(190, 130, 8, 14);

        label_swapperArrow3.setText("\\/");
        buyCoins.getContentPane().add(label_swapperArrow3);
        label_swapperArrow3.setBounds(190, 140, 40, 14);

        dialog_error.setModal(true);
        dialog_error.getContentPane().setLayout(null);

        label_shopMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_shopMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_shopMessage.setText("Shop -  Mitteilung");
        dialog_error.getContentPane().add(label_shopMessage);
        label_shopMessage.setBounds(60, 10, 290, 70);

        label_shopMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_shopMessage1.setText("Erwerbe neue Credits im Spiel oder tausche UCoins!");
        dialog_error.getContentPane().add(label_shopMessage1);
        label_shopMessage1.setBounds(0, 130, 420, 70);

        label_shopMessage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_shopMessage2.setText("Du hast leider nicht mehr genug Credits/UCoins");
        dialog_error.getContentPane().add(label_shopMessage2);
        label_shopMessage2.setBounds(20, 90, 380, 30);

        label_shopMessage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_shopMessage3.setText("oder das Item ist gesperrt!");
        dialog_error.getContentPane().add(label_shopMessage3);
        label_shopMessage3.setBounds(0, 110, 400, 30);

        button_shopMessageOk.setText("OK");
        button_shopMessageOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_shopMessageOkActionPerformed(evt);
            }
        });
        dialog_error.getContentPane().add(button_shopMessageOk);
        button_shopMessageOk.setBounds(120, 210, 160, 30);

        warningDialog.setModal(true);
        warningDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                warningDialogWindowClosed(evt);
            }
        });

        jBut_JA.setText("ja");
        jBut_JA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_JAMouseClicked(evt);
            }
        });
        jBut_JA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_JAActionPerformed(evt);
            }
        });

        jBut_NEIN.setText("nein");
        jBut_NEIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_NEINMouseClicked(evt);
            }
        });
        jBut_NEIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_NEINActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("\t\tAchtung!  \n\nDu kannst den Spicker nur EIN MAL pro Semester\neinem beliebigen Studenten schenken.\nDann wird er die Klausuren auf jeden Fall\nbestehen. \n\nWillst du wirklich den Spicker einsetzen?\nWenn ja, klicke auf \"JA\" Button und wähle\ndanach deinen Lieblingsstudenten.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout warningDialogLayout = new javax.swing.GroupLayout(warningDialog.getContentPane());
        warningDialog.getContentPane().setLayout(warningDialogLayout);
        warningDialogLayout.setHorizontalGroup(
            warningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningDialogLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jBut_JA, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jBut_NEIN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(jScrollPane1)
        );
        warningDialogLayout.setVerticalGroup(
            warningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(warningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBut_JA, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jBut_NEIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        professorChangedDialog.setModal(true);

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setRows(5);
        jTextArea2.setText("\t\n\n\tDu hast jetzt deinen \n\tDozenten getauscht!");
        jScrollPane2.setViewportView(jTextArea2);

        jBut_OKlector.setText("OK");
        jBut_OKlector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_OKlectorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout professorChangedDialogLayout = new javax.swing.GroupLayout(professorChangedDialog.getContentPane());
        professorChangedDialog.getContentPane().setLayout(professorChangedDialogLayout);
        professorChangedDialogLayout.setHorizontalGroup(
            professorChangedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professorChangedDialogLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jBut_OKlector, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, professorChangedDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        professorChangedDialogLayout.setVerticalGroup(
            professorChangedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professorChangedDialogLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jBut_OKlector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        professorNotChangedDialog.setModal(true);

        jBut_OKnotchanged.setText("OK");
        jBut_OKnotchanged.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_OKnotchangedMouseClicked(evt);
            }
        });

        jTextArea5.setColumns(20);
        jTextArea5.setEditable(false);
        jTextArea5.setRows(5);
        jTextArea5.setText("\t\n      \n          Du darfst den Dozenten \n          momentan nicht wechseln!");
        jScrollPane5.setViewportView(jTextArea5);

        javax.swing.GroupLayout professorNotChangedDialogLayout = new javax.swing.GroupLayout(professorNotChangedDialog.getContentPane());
        professorNotChangedDialog.getContentPane().setLayout(professorNotChangedDialogLayout);
        professorNotChangedDialogLayout.setHorizontalGroup(
            professorNotChangedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professorNotChangedDialogLayout.createSequentialGroup()
                .addGroup(professorNotChangedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(professorNotChangedDialogLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jBut_OKnotchanged, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(professorNotChangedDialogLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        professorNotChangedDialogLayout.setVerticalGroup(
            professorNotChangedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professorNotChangedDialogLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jBut_OKnotchanged, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        noCheatsAvailableDialog.setModal(true);

        jTextArea6.setColumns(20);
        jTextArea6.setEditable(false);
        jTextArea6.setRows(5);
        jTextArea6.setText("\t\n\t\n\tKein Spicker\n\tverfügbar!\n");
        jScrollPane6.setViewportView(jTextArea6);

        jBut_OKnoCheatsAvailable.setText("OK");
        jBut_OKnoCheatsAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_OKnoCheatsAvailableMouseClicked(evt);
            }
        });
        jBut_OKnoCheatsAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_OKnoCheatsAvailableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noCheatsAvailableDialogLayout = new javax.swing.GroupLayout(noCheatsAvailableDialog.getContentPane());
        noCheatsAvailableDialog.getContentPane().setLayout(noCheatsAvailableDialogLayout);
        noCheatsAvailableDialogLayout.setHorizontalGroup(
            noCheatsAvailableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noCheatsAvailableDialogLayout.createSequentialGroup()
                .addGroup(noCheatsAvailableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(noCheatsAvailableDialogLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jBut_OKnoCheatsAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(noCheatsAvailableDialogLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        noCheatsAvailableDialogLayout.setVerticalGroup(
            noCheatsAvailableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noCheatsAvailableDialogLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jBut_OKnoCheatsAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        notAllowedUseCheatDialog.setModal(true);
        notAllowedUseCheatDialog.getContentPane().setLayout(null);

        jBut_OKnotAllowedUseCheat.setText("OK");
        jBut_OKnotAllowedUseCheat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_OKnotAllowedUseCheatMouseClicked(evt);
            }
        });
        jBut_OKnotAllowedUseCheat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_OKnotAllowedUseCheatActionPerformed(evt);
            }
        });
        notAllowedUseCheatDialog.getContentPane().add(jBut_OKnotAllowedUseCheat);
        jBut_OKnotAllowedUseCheat.setBounds(134, 259, 118, 50);

        jTextArea4.setColumns(20);
        jTextArea4.setEditable(false);
        jTextArea4.setRows(5);
        jTextArea4.setText("\n      Du darfst den Spicker \n      jetzt nicht einsetzen");
        jScrollPane4.setViewportView(jTextArea4);

        notAllowedUseCheatDialog.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(83, 137, 238, 113);

        warningExitPlanningPhase.setMinimumSize(new java.awt.Dimension(600, 320));
        warningExitPlanningPhase.setModal(true);
        warningExitPlanningPhase.getContentPane().setLayout(null);

        label_warning1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_warning1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_warning1.setText("Achtung!");
        warningExitPlanningPhase.getContentPane().add(label_warning1);
        label_warning1.setBounds(0, 11, 580, 50);

        label_warning2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_warning2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_warning2.setText("Du bist grade dabei das Spiel  zu verlassen.");
        warningExitPlanningPhase.getContentPane().add(label_warning2);
        label_warning2.setBounds(0, 80, 580, 24);

        label_warning3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_warning3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_warning3.setText("Dein Fortschritt wird an dieser Stelle nicht gespeichert");
        warningExitPlanningPhase.getContentPane().add(label_warning3);
        label_warning3.setBounds(-2, 114, 580, 15);

        llabel_warning4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        llabel_warning4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        llabel_warning4.setText("Wenn du trotzdem fortfahren willst, dann klicke auf \"Bestätigen\"");
        warningExitPlanningPhase.getContentPane().add(llabel_warning4);
        llabel_warning4.setBounds(0, 140, 580, 15);
        warningExitPlanningPhase.getContentPane().add(label_warning5);
        label_warning5.setBounds(358, 201, 110, 0);

        jBut_confirmExit.setText("Bestätigen");
        jBut_confirmExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_confirmExitMouseClicked(evt);
            }
        });
        warningExitPlanningPhase.getContentPane().add(jBut_confirmExit);
        jBut_confirmExit.setBounds(90, 220, 141, 43);

        jBut_cancelExit.setText("Abbrechen");
        jBut_cancelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_cancelExitMouseClicked(evt);
            }
        });
        warningExitPlanningPhase.getContentPane().add(jBut_cancelExit);
        jBut_cancelExit.setBounds(350, 220, 148, 43);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Das Spiel wird automatisch nach der Aktivitätsphase gespeichert");
        warningExitPlanningPhase.getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 170, 570, 15);

        dialog_examResults.setLocationByPlatform(true);
        dialog_examResults.setMinimumSize(new java.awt.Dimension(436, 295));
        dialog_examResults.setModal(true);

        label_examHeading.setText("Klausurergebnisse");

        label_examFailed.setText("jLabel4");

        label_examFailedText.setText("sind durchgefallen.");

        label_examRemainingText1.setText("Es bleiben");

        label_examRemaining.setText("jLabel7");

        label_examRemainingText2.setText("Studenten.");

        javax.swing.GroupLayout dialog_examResultsLayout = new javax.swing.GroupLayout(dialog_examResults.getContentPane());
        dialog_examResults.getContentPane().setLayout(dialog_examResultsLayout);
        dialog_examResultsLayout.setHorizontalGroup(
            dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_examResultsLayout.createSequentialGroup()
                .addGroup(dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialog_examResultsLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(label_examHeading))
                    .addGroup(dialog_examResultsLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialog_examResultsLayout.createSequentialGroup()
                                .addComponent(label_examFailed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_examFailedText))
                            .addGroup(dialog_examResultsLayout.createSequentialGroup()
                                .addComponent(label_examRemainingText1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_examRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_examRemainingText2)))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        dialog_examResultsLayout.setVerticalGroup(
            dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_examResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_examHeading)
                .addGap(89, 89, 89)
                .addGroup(dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_examFailed)
                    .addComponent(label_examFailedText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialog_examResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_examRemainingText1)
                    .addComponent(label_examRemaining)
                    .addComponent(label_examRemainingText2))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        dialog_statsError.setTitle("Statistik Fehler");
        dialog_statsError.setLocationByPlatform(true);
        dialog_statsError.setMinimumSize(new java.awt.Dimension(450, 320));
        dialog_statsError.setModal(true);
        dialog_statsError.getContentPane().setLayout(null);

        label_statsErrorHeadline.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_statsErrorHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statsErrorHeadline.setText("Fehler");
        dialog_statsError.getContentPane().add(label_statsErrorHeadline);
        label_statsErrorHeadline.setBounds(10, 0, 420, 80);

        label_statsErrorText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statsErrorText1.setText("Statistik kann aus technischen Gründen nicht angezeigt werden.");
        dialog_statsError.getContentPane().add(label_statsErrorText1);
        label_statsErrorText1.setBounds(10, 70, 420, 20);

        label_statsErrorText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statsErrorText2.setText("Bitte klick auf \"Neues Spiel\" oder \"Spiel Laden\" und versuch es erneut.");
        dialog_statsError.getContentPane().add(label_statsErrorText2);
        label_statsErrorText2.setBounds(10, 100, 420, 14);

        label_statsErrorText3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statsErrorText3.setText("Falls alles nicht hilft wende dich an den Administrator.");
        dialog_statsError.getContentPane().add(label_statsErrorText3);
        label_statsErrorText3.setBounds(10, 140, 420, 30);

        button_statsErrorOK.setText("Ich hasse euch!");
        button_statsErrorOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_statsErrorOKActionPerformed(evt);
            }
        });
        dialog_statsError.getContentPane().add(button_statsErrorOK);
        button_statsErrorOK.setBounds(150, 210, 130, 23);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("S.I.M.S.");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_menue.setMaximumSize(new java.awt.Dimension(1000, 700));
        panel_menue.setMinimumSize(new java.awt.Dimension(1000, 700));
        panel_menue.setName(""); // NOI18N
        panel_menue.setPreferredSize(new java.awt.Dimension(1000, 700));
        panel_menue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_stats.setOpaque(false);
        panel_stats.setLayout(null);

        label_statsHeadline.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_statsHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_statsHeadline.setText("Statistik");
        panel_stats.add(label_statsHeadline);
        label_statsHeadline.setBounds(150, 180, 170, 50);

        label_statsEarnedCredits.setText("Erhaltene Credits:");
        panel_stats.add(label_statsEarnedCredits);
        label_statsEarnedCredits.setBounds(50, 250, 290, 20);

        label_statsCurrentCredits.setText("Momentane Credits:");
        panel_stats.add(label_statsCurrentCredits);
        label_statsCurrentCredits.setBounds(50, 270, 280, 20);

        label_statsPoints.setText("Erreichte Punktzahl: ");
        panel_stats.add(label_statsPoints);
        label_statsPoints.setBounds(50, 370, 420, 20);

        label_statsOverallTime.setText("Gesamtspielzeit (in Stunden):");
        panel_stats.add(label_statsOverallTime);
        label_statsOverallTime.setBounds(50, 290, 290, 20);

        label_statsSemester.setText("Gespielte Semster: ");
        panel_stats.add(label_statsSemester);
        label_statsSemester.setBounds(50, 310, 320, 20);

        label_statsRate.setText("Erfolgs-/ Durchfallquote:");
        panel_stats.add(label_statsRate);
        label_statsRate.setBounds(50, 330, 380, 20);

        label_statsStudentArrtibutes.setText("Kursattribute (Durchschnitt): ");
        panel_stats.add(label_statsStudentArrtibutes);
        label_statsStudentArrtibutes.setBounds(50, 350, 440, 20);

        panel_menue.add(panel_stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 700));

        panel_Credits.setMinimumSize(new java.awt.Dimension(0, 1700));
        panel_Credits.setOpaque(false);
        panel_Credits.setLayout(null);

        label_creditsHeadline.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        label_creditsHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_creditsHeadline.setText("SIMS");
        panel_Credits.add(label_creditsHeadline);
        label_creditsHeadline.setBounds(150, 30, 240, 40);

        label_creditsHeadline1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_creditsHeadline1.setText("A game made by Macrosoft");
        panel_Credits.add(label_creditsHeadline1);
        label_creditsHeadline1.setBounds(160, 80, 230, 14);

        label_creditsNames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_creditsNames.setText("<HTML><BODY><DIV id=\"1\" style=\"text-align: center; color: blue; font-size: 16px; text-decoration: underline;\">Projektmanager</DIV><BR\\><DIV style=\"font-size: 11px; text-align: center;\">Kira Schomber</DIV><BR\\><BR\\><BR\\><BR\\><DIV style=\"text-align: center; color: blue; font-size: 16px; text-decoration: underline;\">Design / Writing</DIV><BR\\><DIV style=\"font-size: 11px; text-align: center;\">Kira Schomber<BR\\>Jörg Woditschka<BR\\>Dawid Rusin<BR\\>Tobias Mauritz<BR\\>Yuliya Kuznetsova<BR\\>Nadir Yuldashev<BR\\>Jannik Pachal</DIV><BR\\><BR\\><BR\\><BR\\><DIV style=\"text-align: center; color: blue; font-size: 16px; text-decoration: underline;\">Programmierung</DIV><BR\\><DIV style=\"font-size: 11px; text-align: center;\">Kira Schomber<BR\\>Jörg Woditschka<BR\\>Dawid Rusin<BR\\>Tobias Mauritz<BR\\>Yuliya Kuznetsova<BR\\>Nadir Yuldashev<BR\\>Jannik Pachal</DIV><BR\\><BR\\><BR\\><BR\\><DIV style=\"text-align: center; color: blue; font-size: 16px; text-decoration: underline;\">Grafiken</DIV><BR\\><DIV style=\"font-size: 11px; text-align: center;\">Jannik Pachal<BR\\>Nadir Yuldashev</DIV><BR\\><BR\\><BR\\><BR\\><DIV style=\"text-align: center; color: blue; font-size: 16px; text-decoration: underline;\">Danksagung</DIV><BR\\><DIV style=\"font-size: 11px; text-align: center;\">Vielen Dank an ALLE für eure tolle Mitarbeit!<BR\\>Hat echt viel Spaß gemacht mit euch dieses Projekt zu realisieren.<BR\\>Können wir gern wieder machen^^<BR\\><BR\\>P.S.: Sind es jetzt Credits oder Credits?!</DIV></BODY></HTML>");
        label_creditsNames.setMaximumSize(new java.awt.Dimension(2147483647, 1500));
        label_creditsNames.setMinimumSize(new java.awt.Dimension(158, 1500));
        label_creditsNames.setPreferredSize(new java.awt.Dimension(397, 990));
        panel_Credits.add(label_creditsNames);
        label_creditsNames.setBounds(0, -20, 530, 1500);

        label_creditsSIMS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_creditsSIMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/coollogo_forlogin_transparent.png"))); // NOI18N
        panel_Credits.add(label_creditsSIMS);
        label_creditsSIMS.setBounds(0, 1420, 530, 170);

        label_creditsCopyright.setText("Copyright by Macrosoft 2012");
        panel_Credits.add(label_creditsCopyright);
        label_creditsCopyright.setBounds(140, 1570, 210, 14);

        panel_menue.add(panel_Credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 1700));

        panel_Profile.setMaximumSize(new java.awt.Dimension(500, 700));
        panel_Profile.setMinimumSize(new java.awt.Dimension(500, 700));
        panel_Profile.setPreferredSize(new java.awt.Dimension(500, 700));
        panel_Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textfield_pKontoname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_pKontonameActionPerformed(evt);
            }
        });
        textfield_pKontoname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_pKontonameFocusGained(evt);
            }
        });
        panel_Profile.add(textfield_pKontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 149, -1));

        textfield_pEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_pEmail1ActionPerformed(evt);
            }
        });
        textfield_pEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_pEmail1FocusGained(evt);
            }
        });
        panel_Profile.add(textfield_pEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 149, -1));

        textfield_pEmail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_pEmail2FocusGained(evt);
            }
        });
        panel_Profile.add(textfield_pEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 149, -1));

        textfield_pName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_pNameActionPerformed(evt);
            }
        });
        textfield_pName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_pNameFocusGained(evt);
            }
        });
        panel_Profile.add(textfield_pName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 149, -1));

        textfield_pSurename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_pSurenameFocusGained(evt);
            }
        });
        panel_Profile.add(textfield_pSurename, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 149, -1));

        password_pPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_pPass1FocusGained(evt);
            }
        });
        panel_Profile.add(password_pPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 149, -1));

        password_pPass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_pPass2FocusGained(evt);
            }
        });
        panel_Profile.add(password_pPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 149, -1));

        button_pSave.setText("Übernehmen");
        button_pSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_pSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pSaveActionPerformed(evt);
            }
        });
        panel_Profile.add(button_pSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        label_pKontoname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pKontoname.setText("Kontoname:");
        panel_Profile.add(label_pKontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 20));

        label_pPass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pPass1.setText("Passwort:");
        panel_Profile.add(label_pPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        label_pPass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pPass2.setText("Passwort wiederholen:");
        panel_Profile.add(label_pPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        label_pEmail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pEmail1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_pEmail1.setText("Email:");
        panel_Profile.add(label_pEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        label_pEmail2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pEmail2.setText("Email wiederholen:");
        panel_Profile.add(label_pEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        label_pFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pFirstName.setText("Vorname:");
        panel_Profile.add(label_pFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        label_pSecondName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_pSecondName.setText("Nachname:");
        panel_Profile.add(label_pSecondName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        button_pCancel.setText("Abbrechen");
        button_pCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_pCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pCancelActionPerformed(evt);
            }
        });
        panel_Profile.add(button_pCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, -1, -1));

        label_pErrAccname.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrAccname.setText("Fehler?");
        label_pErrAccname.setName("label_rErrAccname"); // NOI18N
        panel_Profile.add(label_pErrAccname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        label_pErrPass1.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrPass1.setText("Fehler?");
        label_pErrPass1.setName("label_rErrPass1"); // NOI18N
        panel_Profile.add(label_pErrPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        label_pErrPass2.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrPass2.setText("Fehler?");
        panel_Profile.add(label_pErrPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        label_pErrEmail1.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrEmail1.setText("Fehler?");
        panel_Profile.add(label_pErrEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        label_pErrEmail2.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrEmail2.setText("Fehler?");
        panel_Profile.add(label_pErrEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        label_pErrFirstName.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrFirstName.setText("Fehler?");
        panel_Profile.add(label_pErrFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        label_pErrLastName.setForeground(new java.awt.Color(204, 0, 0));
        label_pErrLastName.setText("Fehler?");
        panel_Profile.add(label_pErrLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        Menu_overlay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/mainmenue_new.png"))); // NOI18N
        Menu_overlay1.setText("Overlay_hauptmenü");
        Menu_overlay1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_Profile.add(Menu_overlay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_menue.add(panel_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 870));

        loggedinas.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        loggedinas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panel_menue.add(loggedinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 580, 70));

        label_handcursor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 170, 40));

        label_handcursor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 160, 40));

        label_handcursor2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 120, 40));

        label_handcursor3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 210, 40));

        label_handcursor4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 140, 40));

        label_handcursor5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 150, 40));

        label_handcursor6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(label_handcursor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 110, 40));

        noSave_overlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noSave_overlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/keinspielstand_00000.png"))); // NOI18N
        panel_menue.add(noSave_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, 400));

        Menu_overlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/mainmenue_new.png"))); // NOI18N
        Menu_overlay.setText("Overlay_hauptmenü");
        Menu_overlay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_menue.add(Menu_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        button_menuExit.setText("Beenden");
        button_menuExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuExitActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 160, 40));

        button_menuStartNewGame.setText("Neues Spiel");
        button_menuStartNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuStartNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuStartNewGameActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuStartNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 160, 40));

        button_menuLoadGame.setText("Spiel Laden");
        button_menuLoadGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuLoadGameActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuLoadGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 210, 40));

        button_menuCredits.setText("Credits");
        button_menuCredits.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuCreditsActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 160, 40));

        button_menuProfile.setText("Profil");
        button_menuProfile.setContentAreaFilled(false);
        button_menuProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuProfileActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 160, 40));

        button_menuLogOut.setText("Abmelden");
        button_menuLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuLogOutActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 160, 40));

        button_menuStatistic.setText("Statistik");
        button_menuStatistic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_menuStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_menuStatisticActionPerformed(evt);
            }
        });
        panel_menue.add(button_menuStatistic, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 160, 40));

        jPanel1.add(panel_menue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        panel_gamePhases.setLayout(new java.awt.CardLayout());

        gamePlanning.setName("card3"); // NOI18N
        gamePlanning.setLayout(null);

        Logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Logo.setLayout(null);

        label_logo_planning.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_logo_planning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_logo_planning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/coollogo150x110_transparent.png"))); // NOI18N
        label_logo_planning.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_logo_planning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_logo_planningMouseClicked(evt);
            }
        });
        Logo.add(label_logo_planning);
        label_logo_planning.setBounds(0, 0, 150, 110);

        text_backtomenue1.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        text_backtomenue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_backtomenue1.setText("<- zurück zum Menü");
        Logo.add(text_backtomenue1);
        text_backtomenue1.setBounds(0, 90, 150, 14);

        gamePlanning.add(Logo);
        Logo.setBounds(0, 0, 150, 110);

        Header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Header.setLayout(null);

        jLab_Planning_unused01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLab_Planning_unused01.setText("Wissen:");
        Header.add(jLab_Planning_unused01);
        jLab_Planning_unused01.setBounds(10, 20, 70, 20);

        jLab_Planning_unused02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLab_Planning_unused02.setText("Motivation:");
        Header.add(jLab_Planning_unused02);
        jLab_Planning_unused02.setBounds(10, 40, 80, 30);

        jLab_Planning_unused03.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLab_Planning_unused03.setText("Müdigkeit:");
        Header.add(jLab_Planning_unused03);
        jLab_Planning_unused03.setBounds(10, 80, 90, 20);

        jProgB_Müdigkeit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgB_MüdigkeitMouseClicked(evt);
            }
        });
        Header.add(jProgB_Müdigkeit);
        jProgB_Müdigkeit.setBounds(90, 80, 260, 20);

        jProgB_Motivation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgB_MotivationMouseClicked(evt);
            }
        });
        Header.add(jProgB_Motivation);
        jProgB_Motivation.setBounds(90, 50, 260, 20);

        jProgB_Wissen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgB_WissenMouseClicked(evt);
            }
        });
        Header.add(jProgB_Wissen);
        jProgB_Wissen.setBounds(90, 20, 260, 20);

        jLab_Planning_unused04.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLab_Planning_unused04.setText("PLANUNGSPHASE");
        Header.add(jLab_Planning_unused04);
        jLab_Planning_unused04.setBounds(360, 10, 340, 90);

        gamePlanning.add(Header);
        Header.setBounds(150, 0, 700, 110);

        Shop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Shop.setLayout(null);

        jBut_startShop.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jBut_startShop.setText("SHOP");
        jBut_startShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_startShopMouseClicked(evt);
            }
        });
        jBut_startShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_startShopActionPerformed(evt);
            }
        });
        Shop.add(jBut_startShop);
        jBut_startShop.setBounds(5, 5, 120, 100);

        gamePlanning.add(Shop);
        Shop.setBounds(850, 0, 130, 110);

        Navi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Navi.setLayout(null);

        jPan_StudSwitch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan_StudSwitch.setLayout(null);
        jPan_StudSwitch.add(jLab_StudSwitch);
        jLab_StudSwitch.setBounds(0, 0, 150, 110);

        jLab_Planning_unused05.setText("umsetzen");
        jPan_StudSwitch.add(jLab_Planning_unused05);
        jLab_Planning_unused05.setBounds(40, 40, 70, 14);

        jLab_Planning_unused06.setText("Studenten");
        jPan_StudSwitch.add(jLab_Planning_unused06);
        jLab_Planning_unused06.setBounds(40, 20, 70, 20);

        jLab_StudCounter.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLab_StudCounter.setText("5x");
        jPan_StudSwitch.add(jLab_StudCounter);
        jLab_StudCounter.setBounds(60, 60, 30, 24);

        jToggleBut_SwitchStud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBut_SwitchStudMouseClicked(evt);
            }
        });
        jPan_StudSwitch.add(jToggleBut_SwitchStud);
        jToggleBut_SwitchStud.setBounds(10, 10, 130, 90);
        jPan_StudSwitch.add(jLab_DozSwitch1);
        jLab_DozSwitch1.setBounds(0, 0, 150, 110);

        Navi.add(jPan_StudSwitch);
        jPan_StudSwitch.setBounds(0, 0, 150, 110);
        jPan_StudSwitch.getAccessibleContext().setAccessibleDescription("");

        jPan_DozSwitch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan_DozSwitch.setLayout(null);
        jPan_DozSwitch.add(jLab_DozSwitch);
        jLab_DozSwitch.setBounds(0, 0, 150, 110);

        jLab_Planning_unused07.setText("Dozenten");
        jPan_DozSwitch.add(jLab_Planning_unused07);
        jLab_Planning_unused07.setBounds(40, 20, 70, 20);

        jLab_Planning_unused08.setText("tauschen");
        jPan_DozSwitch.add(jLab_Planning_unused08);
        jLab_Planning_unused08.setBounds(40, 40, 60, 20);

        jLab_DozCounter.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLab_DozCounter.setText("1x");
        jPan_DozSwitch.add(jLab_DozCounter);
        jLab_DozCounter.setBounds(60, 60, 30, 30);

        jBut_ChangeProfessor.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jBut_ChangeProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_ChangeProfessorMouseClicked(evt);
            }
        });
        jBut_ChangeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_ChangeProfessorActionPerformed(evt);
            }
        });
        jPan_DozSwitch.add(jBut_ChangeProfessor);
        jBut_ChangeProfessor.setBounds(10, 10, 130, 90);

        Navi.add(jPan_DozSwitch);
        jPan_DozSwitch.setBounds(0, 110, 150, 110);

        jPan_ItemSelect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan_ItemSelect.setLayout(null);

        jComboB_Items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "wähle Item", "Spicker" }));
        jComboB_Items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboB_ItemsMouseClicked(evt);
            }
        });
        jComboB_Items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboB_ItemsActionPerformed(evt);
            }
        });
        jPan_ItemSelect.add(jComboB_Items);
        jComboB_Items.setBounds(10, 40, 130, 30);

        Navi.add(jPan_ItemSelect);
        jPan_ItemSelect.setBounds(0, 220, 150, 110);

        jPan_ItemStorage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan_ItemStorage.setLayout(null);

        jLab_Planning_unused09.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLab_Planning_unused09.setText("Item-Vorräte");
        jPan_ItemStorage.add(jLab_Planning_unused09);
        jLab_Planning_unused09.setBounds(10, 10, 120, 20);

        jLab_Redbull.setText("");
        jPan_ItemStorage.add(jLab_Redbull);
        jLab_Redbull.setBounds(10, 40, 90, 14);

        jLab_Duplo.setText("mehr text");
        jPan_ItemStorage.add(jLab_Duplo);
        jLab_Duplo.setBounds(10, 60, 90, 14);

        jLab_OMNI.setText("noch mehr text" );
        jPan_ItemStorage.add(jLab_OMNI);
        jLab_OMNI.setBounds(10, 80, 140, 14);

        Navi.add(jPan_ItemStorage);
        jPan_ItemStorage.setBounds(0, 330, 150, 110);

        jPan_Planning_Play.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan_Planning_Play.setLayout(null);

        jBut_Play.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jBut_Play.setText("SPIELEN");
        jBut_Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_PlayMouseClicked(evt);
            }
        });
        jPan_Planning_Play.add(jBut_Play);
        jBut_Play.setBounds(10, 10, 130, 90);

        Navi.add(jPan_Planning_Play);
        jPan_Planning_Play.setBounds(0, 440, 150, 110);

        gamePlanning.add(Navi);
        Navi.setBounds(0, 110, 150, 550);

        StudField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        StudField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StudFieldMouseEntered(evt);
            }
        });
        StudField.setLayout(null);

        jBut_Dozent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_DozentMouseClicked(evt);
            }
        });
        jBut_Dozent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_DozentActionPerformed(evt);
            }
        });
        StudField.add(jBut_Dozent);
        jBut_Dozent.setBounds(370, 400, 90, 150);

        jBut_1.setBorderPainted(false);
        jBut_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBut_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBut_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBut_1MouseExited(evt);
            }
        });
        jBut_1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_1StateChanged(evt);
            }
        });
        jBut_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_1ActionPerformed(evt);
            }
        });
        StudField.add(jBut_1);
        jBut_1.setBounds(130, 10, 60, 60);

        jBut_2.setBorderPainted(false);
        jBut_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBut_2MouseEntered(evt);
            }
        });
        jBut_2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_2StateChanged(evt);
            }
        });
        StudField.add(jBut_2);
        jBut_2.setBounds(230, 10, 60, 60);

        jBut_3.setBorderPainted(false);
        jBut_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBut_3MouseEntered(evt);
            }
        });
        jBut_3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_3StateChanged(evt);
            }
        });
        StudField.add(jBut_3);
        jBut_3.setBounds(330, 10, 60, 60);

        jBut_4.setBorderPainted(false);
        jBut_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBut_4MouseEntered(evt);
            }
        });
        jBut_4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_4StateChanged(evt);
            }
        });
        StudField.add(jBut_4);
        jBut_4.setBounds(430, 10, 60, 60);

        jBut_5.setBorderPainted(false);
        jBut_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBut_5MouseEntered(evt);
            }
        });
        jBut_5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_5StateChanged(evt);
            }
        });
        StudField.add(jBut_5);
        jBut_5.setBounds(540, 10, 60, 60);

        jBut_6.setBorderPainted(false);
        jBut_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_6MouseClicked(evt);
            }
        });
        jBut_6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_6StateChanged(evt);
            }
        });
        StudField.add(jBut_6);
        jBut_6.setBounds(640, 10, 60, 60);

        jBut_7.setBorderPainted(false);
        jBut_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_7MouseClicked(evt);
            }
        });
        jBut_7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_7StateChanged(evt);
            }
        });
        StudField.add(jBut_7);
        jBut_7.setBounds(120, 90, 60, 60);

        jBut_8.setBorderPainted(false);
        jBut_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_8MouseClicked(evt);
            }
        });
        jBut_8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_8StateChanged(evt);
            }
        });
        StudField.add(jBut_8);
        jBut_8.setBounds(220, 90, 60, 60);

        jBut_9.setBorderPainted(false);
        jBut_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_9MouseClicked(evt);
            }
        });
        jBut_9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_9StateChanged(evt);
            }
        });
        StudField.add(jBut_9);
        jBut_9.setBounds(330, 90, 60, 60);

        jBut_10.setBorderPainted(false);
        jBut_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_10MouseClicked(evt);
            }
        });
        jBut_10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_10StateChanged(evt);
            }
        });
        StudField.add(jBut_10);
        jBut_10.setBounds(440, 90, 60, 60);

        jBut_11.setBorderPainted(false);
        jBut_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_11MouseClicked(evt);
            }
        });
        jBut_11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_11StateChanged(evt);
            }
        });
        StudField.add(jBut_11);
        jBut_11.setBounds(540, 90, 60, 60);

        jBut_12.setBorderPainted(false);
        jBut_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_12MouseClicked(evt);
            }
        });
        jBut_12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_12StateChanged(evt);
            }
        });
        StudField.add(jBut_12);
        jBut_12.setBounds(650, 90, 60, 60);

        jBut_13.setBorderPainted(false);
        jBut_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_13MouseClicked(evt);
            }
        });
        jBut_13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_13StateChanged(evt);
            }
        });
        StudField.add(jBut_13);
        jBut_13.setBounds(120, 180, 60, 60);

        jBut_14.setBorderPainted(false);
        jBut_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_14MouseClicked(evt);
            }
        });
        jBut_14.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_14StateChanged(evt);
            }
        });
        StudField.add(jBut_14);
        jBut_14.setBounds(230, 180, 60, 60);

        jBut_15.setBorderPainted(false);
        jBut_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_15MouseClicked(evt);
            }
        });
        jBut_15.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_15StateChanged(evt);
            }
        });
        StudField.add(jBut_15);
        jBut_15.setBounds(330, 180, 60, 60);

        jBut_16.setBorderPainted(false);
        jBut_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_16MouseClicked(evt);
            }
        });
        jBut_16.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_16StateChanged(evt);
            }
        });
        StudField.add(jBut_16);
        jBut_16.setBounds(430, 180, 60, 60);

        jBut_17.setBorderPainted(false);
        jBut_17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_17MouseClicked(evt);
            }
        });
        jBut_17.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_17StateChanged(evt);
            }
        });
        jBut_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_17ActionPerformed(evt);
            }
        });
        StudField.add(jBut_17);
        jBut_17.setBounds(540, 180, 60, 60);

        jBut_18.setBorderPainted(false);
        jBut_18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_18MouseClicked(evt);
            }
        });
        jBut_18.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_18StateChanged(evt);
            }
        });
        StudField.add(jBut_18);
        jBut_18.setBounds(640, 180, 60, 60);

        jBut_19.setToolTipText("");
        jBut_19.setBorderPainted(false);
        jBut_19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_19MouseClicked(evt);
            }
        });
        jBut_19.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_19StateChanged(evt);
            }
        });
        StudField.add(jBut_19);
        jBut_19.setBounds(120, 260, 60, 60);

        jBut_20.setBorderPainted(false);
        jBut_20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_20MouseClicked(evt);
            }
        });
        jBut_20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_20StateChanged(evt);
            }
        });
        StudField.add(jBut_20);
        jBut_20.setBounds(230, 260, 60, 60);

        jBut_21.setBorderPainted(false);
        jBut_21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_21MouseClicked(evt);
            }
        });
        jBut_21.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_21StateChanged(evt);
            }
        });
        StudField.add(jBut_21);
        jBut_21.setBounds(330, 260, 60, 60);

        jBut_22.setBorderPainted(false);
        jBut_22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_22MouseClicked(evt);
            }
        });
        jBut_22.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_22StateChanged(evt);
            }
        });
        StudField.add(jBut_22);
        jBut_22.setBounds(430, 260, 60, 60);

        jBut_23.setBorderPainted(false);
        jBut_23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_23MouseClicked(evt);
            }
        });
        jBut_23.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_23StateChanged(evt);
            }
        });
        StudField.add(jBut_23);
        jBut_23.setBounds(540, 260, 60, 60);

        jBut_24.setBorderPainted(false);
        jBut_24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_24MouseClicked(evt);
            }
        });
        jBut_24.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_24StateChanged(evt);
            }
        });
        StudField.add(jBut_24);
        jBut_24.setBounds(640, 260, 60, 60);

        jBut_25.setBorderPainted(false);
        jBut_25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_25MouseClicked(evt);
            }
        });
        jBut_25.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_25StateChanged(evt);
            }
        });
        StudField.add(jBut_25);
        jBut_25.setBounds(120, 340, 60, 60);

        jBut_26.setBorderPainted(false);
        jBut_26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_26MouseClicked(evt);
            }
        });
        jBut_26.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_26StateChanged(evt);
            }
        });
        StudField.add(jBut_26);
        jBut_26.setBounds(230, 340, 60, 60);

        jBut_27.setToolTipText("");
        jBut_27.setBorderPainted(false);
        jBut_27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_27MouseClicked(evt);
            }
        });
        jBut_27.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_27StateChanged(evt);
            }
        });
        StudField.add(jBut_27);
        jBut_27.setBounds(330, 340, 60, 60);

        jBut_28.setBorderPainted(false);
        jBut_28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_28MouseClicked(evt);
            }
        });
        jBut_28.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_28StateChanged(evt);
            }
        });
        StudField.add(jBut_28);
        jBut_28.setBounds(430, 340, 60, 60);

        jBut_29.setBorderPainted(false);
        jBut_29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_29MouseClicked(evt);
            }
        });
        jBut_29.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_29StateChanged(evt);
            }
        });
        StudField.add(jBut_29);
        jBut_29.setBounds(540, 340, 60, 60);

        jBut_30.setBorderPainted(false);
        jBut_30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBut_30MouseClicked(evt);
            }
        });
        jBut_30.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBut_30StateChanged(evt);
            }
        });
        StudField.add(jBut_30);
        jBut_30.setBounds(640, 340, 60, 60);

        label_PlanningPhaseoverlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fensterzu.png"))); // NOI18N
        StudField.add(label_PlanningPhaseoverlay);
        label_PlanningPhaseoverlay.setBounds(0, 0, 830, 550);

        gamePlanning.add(StudField);
        StudField.setBounds(150, 110, 830, 550);

        panel_gamePhases.add(gamePlanning, "card3");

        shop.setLayout(null);

        panel_shopBackMainmenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopBackMainmenu.setLayout(null);

        label_logo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/coollogo150x110_transparent.png"))); // NOI18N
        label_logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_logoMouseClicked(evt);
            }
        });
        panel_shopBackMainmenu.add(label_logo);
        label_logo.setBounds(0, 0, 150, 110);

        text_backtomenue2.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        text_backtomenue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_backtomenue2.setText("<- zurück zum Menü");
        panel_shopBackMainmenu.add(text_backtomenue2);
        text_backtomenue2.setBounds(0, 90, 150, 14);

        shop.add(panel_shopBackMainmenu);
        panel_shopBackMainmenu.setBounds(0, 0, 150, 110);

        panel_shopInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopInventory.setLayout(null);

        label_inventar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_inventar.setText("Inventar");
        panel_shopInventory.add(label_inventar);
        label_inventar.setBounds(30, 0, 120, 40);

        label_shopStudents.setText("Studenten:");
        panel_shopInventory.add(label_shopStudents);
        label_shopStudents.setBounds(10, 450, 80, 14);

        label_shopRemainingStudents.setText("4 / 30");
        panel_shopInventory.add(label_shopRemainingStudents);
        label_shopRemainingStudents.setBounds(80, 450, 50, 14);

        label_shopSemester.setText("Semester: ");
        panel_shopInventory.add(label_shopSemester);
        label_shopSemester.setBounds(10, 470, 80, 14);

        label_shopRemainingSemesters.setText("3 / 6");
        panel_shopInventory.add(label_shopRemainingSemesters);
        label_shopRemainingSemesters.setBounds(80, 470, 60, 14);

        label_item4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopInventory.add(label_item4);
        label_item4.setBounds(30, 350, 90, 80);

        label_item1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopInventory.add(label_item1);
        label_item1.setBounds(30, 50, 90, 80);

        label_item2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_item2.setPreferredSize(new java.awt.Dimension(20, 20));
        panel_shopInventory.add(label_item2);
        label_item2.setBounds(30, 150, 90, 80);

        label_item1Name.setText("jLabel4");
        panel_shopInventory.add(label_item1Name);
        label_item1Name.setBounds(60, 80, 34, 14);

        label_item1Amount.setText("jLabel4");
        panel_shopInventory.add(label_item1Amount);
        label_item1Amount.setBounds(60, 100, 34, 14);

        label_item2Name.setText("jLabel4");
        panel_shopInventory.add(label_item2Name);
        label_item2Name.setBounds(60, 190, 34, 14);

        label_item2Amount.setText("jLabel4");
        panel_shopInventory.add(label_item2Amount);
        label_item2Amount.setBounds(60, 210, 34, 14);

        label_item3Name.setText("jLabel4");
        panel_shopInventory.add(label_item3Name);
        label_item3Name.setBounds(60, 380, 34, 14);

        label_item3Amount.setText("jLabel26");
        panel_shopInventory.add(label_item3Amount);
        label_item3Amount.setBounds(60, 400, 40, 14);

        label_item3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopInventory.add(label_item3);
        label_item3.setBounds(30, 250, 90, 80);

        label_item4Name.setText("jLabel4");
        panel_shopInventory.add(label_item4Name);
        label_item4Name.setBounds(60, 280, 34, 14);

        label_item4Amount.setText("jLabel26");
        panel_shopInventory.add(label_item4Amount);
        label_item4Amount.setBounds(60, 300, 40, 14);

        shop.add(panel_shopInventory);
        panel_shopInventory.setBounds(0, 110, 150, 550);

        panel_shopHeadline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopHeadline.setLayout(null);

        ucoinsShop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ucoinsShop.setText("0");
        panel_shopHeadline.add(ucoinsShop);
        ucoinsShop.setBounds(80, 10, 80, 20);

        creditsShop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        creditsShop.setText("0");
        panel_shopHeadline.add(creditsShop);
        creditsShop.setBounds(80, 40, 70, 17);

        punkteShop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        punkteShop.setText("0");
        panel_shopHeadline.add(punkteShop);
        punkteShop.setBounds(80, 70, 70, 17);

        button_startExchange.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        button_startExchange.setText("UCoins Tauschen");
        button_startExchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_startExchangeActionPerformed(evt);
            }
        });
        panel_shopHeadline.add(button_startExchange);
        button_startExchange.setBounds(200, 10, 190, 90);

        label_shopUCoinsName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_shopUCoinsName.setText("UCoins:");
        panel_shopHeadline.add(label_shopUCoinsName);
        label_shopUCoinsName.setBounds(10, 10, 80, 20);

        label_shopCreditsName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_shopCreditsName.setText("Credits:");
        panel_shopHeadline.add(label_shopCreditsName);
        label_shopCreditsName.setBounds(10, 40, 70, 17);

        label_shopPointsName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_shopPointsName.setText("Punkte:");
        panel_shopHeadline.add(label_shopPointsName);
        label_shopPointsName.setBounds(10, 70, 70, 17);

        label_shopName.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_shopName.setText("SHOP");
        panel_shopHeadline.add(label_shopName);
        label_shopName.setBounds(470, 0, 210, 110);

        shop.add(panel_shopHeadline);
        panel_shopHeadline.setBounds(150, 0, 700, 110);

        panel_shopBackPlanningPhase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopBackPlanningPhase.setLayout(null);

        button_shopReturn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        button_shopReturn.setText("<HTML><BODY><DIV style=\"text-align: center;\">Zurück<BR\\>zur<BR\\>Planung</DIV></BODY></HTML>");
        button_shopReturn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_shopReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_shopReturnActionPerformed(evt);
            }
        });
        panel_shopBackPlanningPhase.add(button_shopReturn);
        button_shopReturn.setBounds(5, 5, 120, 100);

        shop.add(panel_shopBackPlanningPhase);
        panel_shopBackPlanningPhase.setBounds(850, 0, 130, 110);

        panel_shopItems.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_shopItems.setLayout(null);

        label_cheatSheetOverlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_cheatSheetOverlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_cheatSheetOverlayMouseClicked(evt);
            }
        });
        panel_shopItems.add(label_cheatSheetOverlay);
        label_cheatSheetOverlay.setBounds(100, 300, 230, 220);

        label_omniOverlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_omniOverlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_omniOverlayMouseClicked(evt);
            }
        });
        panel_shopItems.add(label_omniOverlay);
        label_omniOverlay.setBounds(510, 300, 230, 220);

        label_duploOverlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_duploOverlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_duploOverlayMouseClicked(evt);
            }
        });
        panel_shopItems.add(label_duploOverlay);
        label_duploOverlay.setBounds(510, 40, 230, 220);

        label_redBullOverlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_redBullOverlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_redBullOverlayMouseClicked(evt);
            }
        });
        panel_shopItems.add(label_redBullOverlay);
        label_redBullOverlay.setBounds(100, 40, 230, 220);

        panel_redBull.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_redBull.setName("panel_redBull"); // NOI18N
        panel_redBull.setLayout(null);

        label_redBullName.setBackground(new java.awt.Color(0, 0, 0));
        label_redBullName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_redBullName.setForeground(new java.awt.Color(255, 255, 255));
        label_redBullName.setText("Red Bull");
        label_redBullName.setOpaque(true);
        panel_redBull.add(label_redBullName);
        label_redBullName.setBounds(0, 130, 230, 30);

        label_redBullAmount.setBackground(new java.awt.Color(0, 0, 0));
        label_redBullAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_redBullAmount.setForeground(new java.awt.Color(255, 255, 255));
        label_redBullAmount.setText("100 Credits");
        label_redBullAmount.setOpaque(true);
        panel_redBull.add(label_redBullAmount);
        label_redBullAmount.setBounds(0, 160, 230, 30);

        label_redBullLocked.setBackground(new java.awt.Color(0, 0, 0));
        label_redBullLocked.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_redBullLocked.setForeground(new java.awt.Color(204, 51, 0));
        label_redBullLocked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_redBullLocked.setText("GESPERRT");
        label_redBullLocked.setOpaque(true);
        panel_redBull.add(label_redBullLocked);
        label_redBullLocked.setBounds(0, 50, 230, 50);

        label_redBullImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/RedBullShop230x220.png"))); // NOI18N
        label_redBullImage.setText("jLabel12");
        panel_redBull.add(label_redBullImage);
        label_redBullImage.setBounds(0, 0, 230, 220);

        panel_shopItems.add(panel_redBull);
        panel_redBull.setBounds(100, 40, 230, 220);

        panel_omniSense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_omniSense.setLayout(null);

        label_omniName.setBackground(new java.awt.Color(0, 0, 0));
        label_omniName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_omniName.setForeground(new java.awt.Color(255, 255, 255));
        label_omniName.setText("Verfügbar ab Semester 4");
        label_omniName.setOpaque(true);
        panel_omniSense.add(label_omniName);
        label_omniName.setBounds(0, 130, 230, 30);

        label_omniLocked.setBackground(new java.awt.Color(0, 0, 0));
        label_omniLocked.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_omniLocked.setForeground(new java.awt.Color(204, 51, 0));
        label_omniLocked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_omniLocked.setText("GESPERRT");
        label_omniLocked.setOpaque(true);
        panel_omniSense.add(label_omniLocked);
        label_omniLocked.setBounds(0, 50, 230, 50);

        label_omniAmount.setBackground(new java.awt.Color(0, 0, 0));
        label_omniAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_omniAmount.setForeground(new java.awt.Color(255, 255, 255));
        label_omniAmount.setText("5 UCoins");
        label_omniAmount.setOpaque(true);
        panel_omniSense.add(label_omniAmount);
        label_omniAmount.setBounds(0, 160, 230, 30);

        label_omniAudioImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/OMNISenseAudioShop230x220.png"))); // NOI18N
        panel_omniSense.add(label_omniAudioImage);
        label_omniAudioImage.setBounds(0, 0, 230, 220);

        panel_shopItems.add(panel_omniSense);
        panel_omniSense.setBounds(510, 300, 230, 220);

        panel_duplo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_duplo.setLayout(null);

        label_duploName.setBackground(new java.awt.Color(0, 0, 0));
        label_duploName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_duploName.setForeground(new java.awt.Color(255, 255, 255));
        label_duploName.setText("Duplo");
        label_duploName.setOpaque(true);
        panel_duplo.add(label_duploName);
        label_duploName.setBounds(0, 130, 230, 30);

        label_duploAmount.setBackground(new java.awt.Color(0, 0, 0));
        label_duploAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_duploAmount.setForeground(new java.awt.Color(255, 255, 255));
        label_duploAmount.setText("100 Credits");
        label_duploAmount.setOpaque(true);
        panel_duplo.add(label_duploAmount);
        label_duploAmount.setBounds(0, 160, 230, 30);

        label_duploLocked.setBackground(new java.awt.Color(0, 0, 0));
        label_duploLocked.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_duploLocked.setForeground(new java.awt.Color(204, 51, 0));
        label_duploLocked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_duploLocked.setText("GESPERRT");
        label_duploLocked.setOpaque(true);
        panel_duplo.add(label_duploLocked);
        label_duploLocked.setBounds(0, 50, 230, 50);

        label_duploImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/FerreroDuploShop230x220.png"))); // NOI18N
        panel_duplo.add(label_duploImage);
        label_duploImage.setBounds(0, 0, 230, 220);

        panel_shopItems.add(panel_duplo);
        panel_duplo.setBounds(510, 40, 230, 220);

        panel_cheatSheet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_cheatSheet.setLayout(null);

        label_cheatSheetName.setBackground(new java.awt.Color(0, 0, 0));
        label_cheatSheetName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_cheatSheetName.setForeground(new java.awt.Color(255, 255, 255));
        label_cheatSheetName.setText("Spicker");
        label_cheatSheetName.setOpaque(true);
        panel_cheatSheet.add(label_cheatSheetName);
        label_cheatSheetName.setBounds(0, 130, 230, 30);

        label_cheatSheetLocked.setBackground(new java.awt.Color(0, 0, 0));
        label_cheatSheetLocked.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_cheatSheetLocked.setForeground(new java.awt.Color(204, 51, 0));
        label_cheatSheetLocked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_cheatSheetLocked.setText("GESPERRT");
        label_cheatSheetLocked.setOpaque(true);
        panel_cheatSheet.add(label_cheatSheetLocked);
        label_cheatSheetLocked.setBounds(0, 50, 230, 50);

        label_cheatSheetAmount.setBackground(new java.awt.Color(0, 0, 0));
        label_cheatSheetAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_cheatSheetAmount.setForeground(new java.awt.Color(255, 255, 255));
        label_cheatSheetAmount.setText("5 UCoins");
        label_cheatSheetAmount.setOpaque(true);
        panel_cheatSheet.add(label_cheatSheetAmount);
        label_cheatSheetAmount.setBounds(0, 160, 230, 30);

        label_cheatSheetImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/SpickzettelShop230x220.png"))); // NOI18N
        panel_cheatSheet.add(label_cheatSheetImage);
        label_cheatSheetImage.setBounds(0, 0, 230, 220);

        panel_shopItems.add(panel_cheatSheet);
        panel_cheatSheet.setBounds(100, 300, 230, 220);

        shop.add(panel_shopItems);
        panel_shopItems.setBounds(150, 110, 830, 550);

        panel_gamePhases.add(shop, "card4");

        gamePlaying.setMinimumSize(new java.awt.Dimension(1024, 768));
        gamePlaying.setPreferredSize(new java.awt.Dimension(1024, 768));
        gamePlaying.setLayout(null);

        panel_logoarea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_logoarea.setLayout(null);

        label_logo_playing.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_logo_playing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_logo_playing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/coollogo150x110_transparent.png"))); // NOI18N
        label_logo_playing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_logo_playing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_logo_playingMouseClicked(evt);
            }
        });
        panel_logoarea.add(label_logo_playing);
        label_logo_playing.setBounds(0, 0, 150, 110);

        gamePlaying.add(panel_logoarea);
        panel_logoarea.setBounds(0, 0, 150, 110);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        text_inventar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_inventar.setText("Inventar");
        jPanel4.add(text_inventar);
        text_inventar.setBounds(30, 0, 120, 40);

        label_item3Inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_item3Inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_item3InvMouseClicked(evt);
            }
        });
        jPanel4.add(label_item3Inv);
        label_item3Inv.setBounds(30, 250, 80, 80);

        text_students.setText("Studenten:");
        jPanel4.add(text_students);
        text_students.setBounds(10, 450, 80, 14);

        label_students.setText("4 / 30");
        jPanel4.add(label_students);
        label_students.setBounds(80, 450, 50, 14);

        text_semester.setText("Semester: ");
        jPanel4.add(text_semester);
        text_semester.setBounds(10, 470, 80, 14);

        label_semester.setText("3 / 6");
        jPanel4.add(label_semester);
        label_semester.setBounds(80, 470, 60, 14);

        label_ucoinsInv.setText("UCoins: 300");
        jPanel4.add(label_ucoinsInv);
        label_ucoinsInv.setBounds(10, 380, 130, 14);

        label_item2Inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_item2Inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_item2InvMouseClicked(evt);
            }
        });
        jPanel4.add(label_item2Inv);
        label_item2Inv.setBounds(30, 150, 80, 80);

        label_creditsInv.setText("Credits: 700");
        jPanel4.add(label_creditsInv);
        label_creditsInv.setBounds(10, 360, 140, 14);

        label_item3InvName.setText("Red Bull");
        jPanel4.add(label_item3InvName);
        label_item3InvName.setBounds(30, 260, 80, 30);

        label_item3InvAmount.setText("3 x");
        jPanel4.add(label_item3InvAmount);
        label_item3InvAmount.setBounds(30, 300, 80, 14);

        label_item1Inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_item1Inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_item1InvMouseClicked(evt);
            }
        });
        jPanel4.add(label_item1Inv);
        label_item1Inv.setBounds(30, 50, 80, 80);

        text_score.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        text_score.setText("Punkte:");
        jPanel4.add(text_score);
        text_score.setBounds(10, 510, 70, 20);

        label_score.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_score.setText("----");
        jPanel4.add(label_score);
        label_score.setBounds(90, 500, 40, 40);

        label_item1InvName.setText("Red Bull");
        jPanel4.add(label_item1InvName);
        label_item1InvName.setBounds(30, 80, 80, 30);

        label_item2InvName.setText("Red Bull");
        jPanel4.add(label_item2InvName);
        label_item2InvName.setBounds(30, 160, 80, 30);

        label_item2InvAmount.setText("3 x");
        jPanel4.add(label_item2InvAmount);
        label_item2InvAmount.setBounds(30, 190, 80, 14);

        label_item1InvAmount.setText("3 x");
        jPanel4.add(label_item1InvAmount);
        label_item1InvAmount.setBounds(30, 110, 80, 14);

        gamePlaying.add(jPanel4);
        jPanel4.setBounds(0, 110, 150, 550);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        text_wissen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_wissen.setText("Wissen:");
        jPanel5.add(text_wissen);
        text_wissen.setBounds(10, 10, 70, 30);

        button_window.setText("Fenster : ZU");
        button_window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_windowActionPerformed(evt);
            }
        });
        jPanel5.add(button_window);
        button_window.setBounds(350, 10, 120, 23);

        label_knowledgeBar_overlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/barlayout.png"))); // NOI18N
        jPanel5.add(label_knowledgeBar_overlay);
        label_knowledgeBar_overlay.setBounds(80, 0, 300, 80);

        text_motivation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_motivation.setText("Motivation:");
        jPanel5.add(text_motivation);
        text_motivation.setBounds(10, 40, 80, 40);

        text_tiredness.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_tiredness.setText("Müdigkeit:");
        jPanel5.add(text_tiredness);
        text_tiredness.setBounds(10, 80, 80, 20);

        KnowledgeBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KnowledgeBarMouseClicked(evt);
            }
        });
        jPanel5.add(KnowledgeBar);
        KnowledgeBar.setBounds(80, 20, 260, 20);
        KnowledgeBar.getAccessibleContext().setAccessibleDescription("");

        MotivationBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MotivationBarMouseClicked(evt);
            }
        });
        jPanel5.add(MotivationBar);
        MotivationBar.setBounds(80, 50, 260, 20);

        TirednessBar.setRequestFocusEnabled(false);
        TirednessBar.setString("100%");
        TirednessBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TirednessBarMouseClicked(evt);
            }
        });
        jPanel5.add(TirednessBar);
        TirednessBar.setBounds(80, 80, 260, 20);

        text_noise.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_noise.setText("Lärmpegel:");
        jPanel5.add(text_noise);
        text_noise.setBounds(480, 10, 80, 20);

        text_air.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_air.setText("Luftqualität:");
        jPanel5.add(text_air);
        text_air.setBounds(480, 34, 80, 30);
        jPanel5.add(NoiseBar);
        NoiseBar.setBounds(560, 10, 130, 20);
        jPanel5.add(AirBar);
        AirBar.setBounds(560, 40, 130, 20);

        toggleButton_shortBreak.setText("Pause");
        toggleButton_shortBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButton_shortBreakActionPerformed(evt);
            }
        });
        jPanel5.add(toggleButton_shortBreak);
        toggleButton_shortBreak.setBounds(350, 73, 120, 30);

        toggleButton_teamwork.setText("Gruppenarbeit");
        toggleButton_teamwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButton_teamworkActionPerformed(evt);
            }
        });
        jPanel5.add(toggleButton_teamwork);
        toggleButton_teamwork.setBounds(350, 40, 120, 23);

        gamePlaying.add(jPanel5);
        jPanel5.setBounds(150, 0, 700, 110);

        panel_timerarea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_timerarea.setLayout(null);

        label_timer.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_timer.setText("--:--");
        panel_timerarea.add(label_timer);
        label_timer.setBounds(10, 10, 140, 90);

        gamePlaying.add(panel_timerarea);
        panel_timerarea.setBounds(850, 0, 130, 110);

        panel_activityPhaseStudField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_activityPhaseStudField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_activityPhaseStudFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_activityPhaseStudFieldMouseEntered(evt);
            }
        });
        panel_activityPhaseStudField.setLayout(null);

        button_dozent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dozent1ActionPerformed(evt);
            }
        });
        panel_activityPhaseStudField.add(button_dozent1);
        button_dozent1.setBounds(370, 400, 90, 150);

        label_laptop6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop6MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop6);
        label_laptop6.setBounds(650, 65, 50, 30);

        label_laptop5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop5MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop5);
        label_laptop5.setBounds(550, 65, 50, 30);

        label_laptop4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop4MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop4);
        label_laptop4.setBounds(450, 65, 50, 30);

        label_laptop3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop3MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop3);
        label_laptop3.setBounds(340, 65, 50, 30);

        label_laptop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop2MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop2);
        label_laptop2.setBounds(230, 65, 50, 30);

        label_laptop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop1MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop1);
        label_laptop1.setBounds(130, 65, 50, 30);

        label_laptop7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop7MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop7);
        label_laptop7.setBounds(130, 150, 50, 30);

        label_laptop8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop8MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop8);
        label_laptop8.setBounds(230, 150, 50, 30);

        label_laptop9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop9MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop9);
        label_laptop9.setBounds(340, 150, 50, 30);

        label_laptop10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop10MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop10);
        label_laptop10.setBounds(430, 150, 50, 30);

        label_laptop11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop11MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop11);
        label_laptop11.setBounds(540, 150, 50, 30);

        label_laptop12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop12MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop12);
        label_laptop12.setBounds(640, 150, 50, 30);

        label_laptop13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop13MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop13);
        label_laptop13.setBounds(120, 230, 50, 30);

        label_laptop14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop14MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop14);
        label_laptop14.setBounds(230, 230, 50, 30);

        label_laptop15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop15MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop15);
        label_laptop15.setBounds(340, 230, 50, 30);

        label_laptop16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop16MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop16);
        label_laptop16.setBounds(440, 230, 50, 30);

        label_laptop17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop17MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop17);
        label_laptop17.setBounds(550, 230, 50, 30);

        label_laptop18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop18MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop18);
        label_laptop18.setBounds(650, 230, 50, 30);

        label_laptop19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop19MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop19);
        label_laptop19.setBounds(120, 310, 50, 30);

        label_laptop20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop20MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop20);
        label_laptop20.setBounds(230, 310, 50, 30);

        label_laptop21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop21MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop21);
        label_laptop21.setBounds(340, 310, 50, 30);

        label_laptop22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop22MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop22);
        label_laptop22.setBounds(440, 310, 50, 30);

        label_laptop23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop23MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop23);
        label_laptop23.setBounds(550, 310, 50, 30);

        label_laptop24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop24MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop24);
        label_laptop24.setBounds(650, 320, 50, 30);

        label_laptop25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop25MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop25);
        label_laptop25.setBounds(130, 400, 50, 30);

        label_laptop26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop26MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop26);
        label_laptop26.setBounds(230, 400, 50, 30);

        label_laptop27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop27MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop27);
        label_laptop27.setBounds(330, 400, 50, 30);

        label_laptop28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop28MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop28);
        label_laptop28.setBounds(440, 400, 50, 30);

        label_laptop29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop29MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop29);
        label_laptop29.setBounds(550, 400, 50, 30);

        label_laptop30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/laptopzu.png"))); // NOI18N
        label_laptop30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laptop30MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(label_laptop30);
        label_laptop30.setBounds(650, 400, 50, 30);

        button_stud1.setBackground(new java.awt.Color(255, 255, 255));
        button_stud1.setBorder(null);
        button_stud1.setBorderPainted(false);
        button_stud1.setFocusPainted(false);
        button_stud1.setFocusable(false);
        button_stud1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_stud1.setInheritsPopupMenu(true);
        button_stud1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud1MouseClicked(evt);
            }
        });
        button_stud1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud1StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud1);
        button_stud1.setBounds(120, 10, 60, 60);

        button_stud2.setBorder(null);
        button_stud2.setBorderPainted(false);
        button_stud2.setFocusPainted(false);
        button_stud2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud2MouseClicked(evt);
            }
        });
        button_stud2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud2StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud2);
        button_stud2.setBounds(230, 10, 60, 60);

        button_stud3.setBorderPainted(false);
        button_stud3.setFocusPainted(false);
        button_stud3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud3MouseClicked(evt);
            }
        });
        button_stud3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud3StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud3);
        button_stud3.setBounds(340, 10, 60, 60);

        button_stud4.setBorderPainted(false);
        button_stud4.setFocusPainted(false);
        button_stud4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud4MouseClicked(evt);
            }
        });
        button_stud4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud4StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud4);
        button_stud4.setBounds(440, 10, 60, 60);

        button_stud5.setBorderPainted(false);
        button_stud5.setFocusPainted(false);
        button_stud5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud5MouseClicked(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud5);
        button_stud5.setBounds(540, 10, 60, 60);

        button_stud6.setBorderPainted(false);
        button_stud6.setFocusPainted(false);
        button_stud6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud6MouseClicked(evt);
            }
        });
        button_stud6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud6StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud6);
        button_stud6.setBounds(640, 10, 60, 60);

        button_stud7.setBorderPainted(false);
        button_stud7.setFocusPainted(false);
        button_stud7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud7MouseClicked(evt);
            }
        });
        button_stud7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud7StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud7);
        button_stud7.setBounds(120, 90, 60, 60);

        button_stud8.setBorderPainted(false);
        button_stud8.setFocusPainted(false);
        button_stud8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud8MouseClicked(evt);
            }
        });
        button_stud8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud8StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud8);
        button_stud8.setBounds(220, 90, 60, 60);

        button_stud9.setBorderPainted(false);
        button_stud9.setFocusPainted(false);
        button_stud9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud9MouseClicked(evt);
            }
        });
        button_stud9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud9StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud9);
        button_stud9.setBounds(330, 90, 60, 60);

        button_stud10.setBorderPainted(false);
        button_stud10.setFocusPainted(false);
        button_stud10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud10MouseClicked(evt);
            }
        });
        button_stud10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud10StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud10);
        button_stud10.setBounds(430, 90, 60, 60);

        button_stud11.setBorderPainted(false);
        button_stud11.setFocusPainted(false);
        button_stud11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud11MouseClicked(evt);
            }
        });
        button_stud11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud11StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud11);
        button_stud11.setBounds(540, 90, 60, 60);

        button_stud12.setBorderPainted(false);
        button_stud12.setFocusPainted(false);
        button_stud12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud12MouseClicked(evt);
            }
        });
        button_stud12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud12StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud12);
        button_stud12.setBounds(640, 90, 60, 60);

        button_stud13.setBorderPainted(false);
        button_stud13.setFocusPainted(false);
        button_stud13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud13MouseClicked(evt);
            }
        });
        button_stud13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud13StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud13);
        button_stud13.setBounds(120, 180, 60, 60);

        button_stud14.setBorderPainted(false);
        button_stud14.setFocusPainted(false);
        button_stud14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud14MouseClicked(evt);
            }
        });
        button_stud14.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud14StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud14);
        button_stud14.setBounds(220, 180, 60, 60);

        button_stud15.setBorderPainted(false);
        button_stud15.setFocusPainted(false);
        button_stud15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud15MouseClicked(evt);
            }
        });
        button_stud15.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud15StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud15);
        button_stud15.setBounds(330, 180, 60, 60);

        button_stud16.setBorderPainted(false);
        button_stud16.setFocusPainted(false);
        button_stud16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud16MouseClicked(evt);
            }
        });
        button_stud16.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud16StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud16);
        button_stud16.setBounds(430, 180, 60, 60);

        button_stud17.setBorderPainted(false);
        button_stud17.setFocusPainted(false);
        button_stud17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud17MouseClicked(evt);
            }
        });
        button_stud17.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud17StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud17);
        button_stud17.setBounds(540, 180, 60, 60);

        button_stud18.setBorderPainted(false);
        button_stud18.setFocusPainted(false);
        button_stud18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud18MouseClicked(evt);
            }
        });
        button_stud18.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud18StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud18);
        button_stud18.setBounds(640, 180, 60, 60);

        button_stud19.setBorderPainted(false);
        button_stud19.setFocusPainted(false);
        button_stud19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud19MouseClicked(evt);
            }
        });
        button_stud19.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud19StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud19);
        button_stud19.setBounds(120, 260, 60, 60);

        label_dozent_action.setBackground(new java.awt.Color(255, 0, 0));
        label_dozent_action.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        label_dozent_action.setText("RUHE!");
        panel_activityPhaseStudField.add(label_dozent_action);
        label_dozent_action.setBounds(240, 440, 130, 60);

        button_stud20.setBorderPainted(false);
        button_stud20.setFocusPainted(false);
        button_stud20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud20MouseClicked(evt);
            }
        });
        button_stud20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud20StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud20);
        button_stud20.setBounds(220, 260, 60, 60);

        button_stud21.setBorderPainted(false);
        button_stud21.setFocusPainted(false);
        button_stud21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud21MouseClicked(evt);
            }
        });
        button_stud21.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud21StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud21);
        button_stud21.setBounds(330, 260, 60, 60);

        button_stud22.setBorderPainted(false);
        button_stud22.setFocusPainted(false);
        button_stud22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud22MouseClicked(evt);
            }
        });
        button_stud22.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud22StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud22);
        button_stud22.setBounds(430, 260, 60, 60);

        button_stud23.setBorderPainted(false);
        button_stud23.setFocusPainted(false);
        button_stud23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud23MouseClicked(evt);
            }
        });
        button_stud23.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud23StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud23);
        button_stud23.setBounds(540, 260, 60, 60);

        button_stud24.setBorderPainted(false);
        button_stud24.setFocusPainted(false);
        button_stud24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud24MouseClicked(evt);
            }
        });
        button_stud24.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud24StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud24);
        button_stud24.setBounds(650, 260, 60, 60);

        button_stud25.setBorderPainted(false);
        button_stud25.setFocusPainted(false);
        button_stud25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud25MouseClicked(evt);
            }
        });
        button_stud25.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud25StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud25);
        button_stud25.setBounds(120, 340, 60, 60);

        button_stud26.setBorderPainted(false);
        button_stud26.setFocusPainted(false);
        button_stud26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud26MouseClicked(evt);
            }
        });
        button_stud26.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud26StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud26);
        button_stud26.setBounds(220, 340, 60, 60);

        button_stud27.setToolTipText("");
        button_stud27.setBorderPainted(false);
        button_stud27.setFocusPainted(false);
        button_stud27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud27MouseClicked(evt);
            }
        });
        button_stud27.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud27StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud27);
        button_stud27.setBounds(330, 340, 60, 60);

        button_stud28.setBorderPainted(false);
        button_stud28.setFocusPainted(false);
        button_stud28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud28MouseClicked(evt);
            }
        });
        button_stud28.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud28StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud28);
        button_stud28.setBounds(430, 340, 60, 60);

        button_stud29.setBorderPainted(false);
        button_stud29.setFocusPainted(false);
        button_stud29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud29MouseClicked(evt);
            }
        });
        button_stud29.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud29StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud29);
        button_stud29.setBounds(540, 340, 60, 60);

        button_stud30.setBorderPainted(false);
        button_stud30.setFocusPainted(false);
        button_stud30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_stud30MouseClicked(evt);
            }
        });
        button_stud30.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                button_stud30StateChanged(evt);
            }
        });
        panel_activityPhaseStudField.add(button_stud30);
        button_stud30.setBounds(650, 340, 60, 60);

        label_windowsclosed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fensteroffen.png"))); // NOI18N
        label_windowsclosed.setText("jLabel4");
        label_windowsclosed.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_activityPhaseStudField.add(label_windowsclosed);
        label_windowsclosed.setBounds(0, 0, 830, 550);

        label_GameFieldOverlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fensterzu.png"))); // NOI18N
        label_GameFieldOverlay.setText("jLabel4");
        panel_activityPhaseStudField.add(label_GameFieldOverlay);
        label_GameFieldOverlay.setBounds(0, 0, 830, 550);
        panel_activityPhaseStudField.add(jLab_DozSwitch2);
        jLab_DozSwitch2.setBounds(0, 0, 150, 110);

        gamePlaying.add(panel_activityPhaseStudField);
        panel_activityPhaseStudField.setBounds(150, 110, 830, 550);

        panel_gamePhases.add(gamePlaying, "card2");

        panel_gameOver.setLayout(null);

        button_retry.setText("Nochmal!");
        button_retry.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_retry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_retryActionPerformed(evt);
            }
        });
        panel_gameOver.add(button_retry);
        button_retry.setBounds(390, 570, 190, 50);

        label_gameOverPoints.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        label_gameOverPoints.setForeground(new java.awt.Color(255, 255, 255));
        label_gameOverPoints.setText("Erreichte Punktzahl:");
        panel_gameOver.add(label_gameOverPoints);
        label_gameOverPoints.setBounds(310, 500, 380, 50);

        label_gameOverSemester.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        label_gameOverSemester.setForeground(new java.awt.Color(255, 255, 255));
        label_gameOverSemester.setText("Erreichtes Semester: ");
        panel_gameOver.add(label_gameOverSemester);
        label_gameOverSemester.setBounds(310, 470, 380, 30);

        label_gameOver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_gameOver.setOpaque(true);
        panel_gameOver.add(label_gameOver);
        label_gameOver.setBounds(0, -40, 1020, 770);

        panel_gamePhases.add(panel_gameOver, "card8");

        jPanel1.add(panel_gamePhases, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));

        panel_Login.setMaximumSize(new java.awt.Dimension(1000, 700));
        panel_Login.setMinimumSize(new java.awt.Dimension(1000, 700));
        panel_Login.setPreferredSize(new java.awt.Dimension(1000, 700));
        panel_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Register.setMaximumSize(new java.awt.Dimension(500, 700));
        panel_Register.setMinimumSize(new java.awt.Dimension(500, 700));
        panel_Register.setPreferredSize(new java.awt.Dimension(500, 700));
        panel_Register.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textfield_rKontoname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_rKontonameActionPerformed(evt);
            }
        });
        textfield_rKontoname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rKontonameFocusGained(evt);
            }
        });
        panel_Register.add(textfield_rKontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 149, -1));

        textfield_rEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_rEmail1ActionPerformed(evt);
            }
        });
        textfield_rEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rEmail1FocusGained(evt);
            }
        });
        panel_Register.add(textfield_rEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 149, -1));

        textfield_rEmail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rEmail2FocusGained(evt);
            }
        });
        panel_Register.add(textfield_rEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 149, -1));

        textfield_rName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_rNameActionPerformed(evt);
            }
        });
        textfield_rName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rNameFocusGained(evt);
            }
        });
        panel_Register.add(textfield_rName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 149, -1));

        textfield_rSurename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rSurenameFocusGained(evt);
            }
        });
        panel_Register.add(textfield_rSurename, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 149, -1));

        password_rPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_rPass1FocusGained(evt);
            }
        });
        panel_Register.add(password_rPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 149, -1));

        password_rPass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_rPass2FocusGained(evt);
            }
        });
        panel_Register.add(password_rPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 149, -1));

        button_rRegister.setText("Registrieren");
        button_rRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_rRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rRegisterActionPerformed(evt);
            }
        });
        panel_Register.add(button_rRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        label_rKontoname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rKontoname.setText("Kontoname:");
        panel_Register.add(label_rKontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));
        label_rKontoname.getAccessibleContext().setAccessibleName("label_rKontoname");

        label_rPass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rPass1.setText("Passwort:");
        panel_Register.add(label_rPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        label_rPass1.getAccessibleContext().setAccessibleName("label_rPass1");

        label_rPass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rPass2.setText("Passwort wiederholen:");
        panel_Register.add(label_rPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        label_rPass2.getAccessibleContext().setAccessibleName("label_rPass2");

        label_rEmail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rEmail1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_rEmail1.setText("Email:");
        panel_Register.add(label_rEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        label_rEmail1.getAccessibleContext().setAccessibleName("label_rEmail1");

        label_rEmail2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rEmail2.setText("Email wiederholen:");
        panel_Register.add(label_rEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        label_rEmail2.getAccessibleContext().setAccessibleName("label_rEmail2");

        label_rFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rFirstName.setText("Vorname:");
        panel_Register.add(label_rFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));
        label_rFirstName.getAccessibleContext().setAccessibleName("label_rFirstName");

        label_rSecondName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_rSecondName.setText("Nachname:");
        panel_Register.add(label_rSecondName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));
        label_rSecondName.getAccessibleContext().setAccessibleName("label_rSecondName");

        button_cancel.setText("Abbrechen");
        button_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        panel_Register.add(button_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));
        button_cancel.getAccessibleContext().setAccessibleName("button_rCancel");

        label_rErrAccname.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrAccname.setText("Fehler?");
        label_rErrAccname.setName("label_rErrAccname"); // NOI18N
        panel_Register.add(label_rErrAccname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));
        label_rErrAccname.getAccessibleContext().setAccessibleName("label_rErrAccname");

        label_rErrPass1.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrPass1.setText("Fehler?");
        label_rErrPass1.setName("label_rErrPass1"); // NOI18N
        panel_Register.add(label_rErrPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));
        label_rErrPass1.getAccessibleContext().setAccessibleName("label_rErrPass1");

        label_rErrPass2.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrPass2.setText("Fehler?");
        panel_Register.add(label_rErrPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));
        label_rErrPass2.getAccessibleContext().setAccessibleName("label_rErrPass2");

        label_rErrEmail1.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrEmail1.setText("Fehler?");
        panel_Register.add(label_rErrEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));
        label_rErrEmail1.getAccessibleContext().setAccessibleName("label_rErrEmail1");

        label_rErrEmail2.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrEmail2.setText("Fehler?");
        panel_Register.add(label_rErrEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));
        label_rErrEmail2.getAccessibleContext().setAccessibleName("label_rErrEmail2");

        label_rErrFirstName.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrFirstName.setText("Fehler?");
        panel_Register.add(label_rErrFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));
        label_rErrFirstName.getAccessibleContext().setAccessibleName("label_rErrFirstName");

        label_rErrLastName.setForeground(new java.awt.Color(204, 0, 0));
        label_rErrLastName.setText("Fehler?");
        panel_Register.add(label_rErrLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));
        label_rErrLastName.getAccessibleContext().setAccessibleName("label_rErrSecondName");
        label_rErrLastName.getAccessibleContext().setAccessibleDescription("");

        background_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/loginscreen2_00000.png"))); // NOI18N
        background_register.setText("jLabel17");
        panel_Register.add(background_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_Login.add(panel_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 870));

        textfield_Kontoname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textfield_Kontoname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_KontonameActionPerformed(evt);
            }
        });
        textfield_Kontoname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_KontonameFocusGained(evt);
            }
        });
        panel_Login.add(textfield_Kontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 145, 30));

        button_Login.setText("Login");
        button_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_LoginActionPerformed(evt);
            }
        });
        panel_Login.add(button_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 80, 46));

        button_Register.setText("Registrieren");
        button_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RegisterActionPerformed(evt);
            }
        });
        panel_Login.add(button_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, 110, 30));

        password_Pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_PassFocusGained(evt);
            }
        });
        panel_Login.add(password_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 145, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Kontoname:");
        panel_Login.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));
        jLabel12.getAccessibleContext().setAccessibleName("label_lUsername");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Passwort:");
        panel_Login.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, 20));
        jLabel15.getAccessibleContext().setAccessibleName("label_lPassword");

        check_saveUser.setText("Kontoname und Passwort speichern");
        check_saveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_saveUserActionPerformed(evt);
            }
        });
        panel_Login.add(check_saveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, -1));
        check_saveUser.getAccessibleContext().setAccessibleName("checkBox_lSaveData");

        check_autoLogin.setText("Automatisch einloggen");
        panel_Login.add(check_autoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));
        check_autoLogin.getAccessibleContext().setAccessibleName("checkBox_lAutoLogin");

        label_lErr.setForeground(new java.awt.Color(204, 0, 0));
        label_lErr.setText("Fehler?");
        panel_Login.add(label_lErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, -1));

        label_eastereggtrigger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                onmouseover_easteregg(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                onmouseleave_easteregg(evt);
            }
        });
        panel_Login.add(label_eastereggtrigger, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 40, 30));

        label_easteregg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/easteregg_transparent.png"))); // NOI18N
        panel_Login.add(label_easteregg, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 300, 130));

        buton_enterAdmin.setText("enter Admin-Data");
        buton_enterAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_enterAdminActionPerformed(evt);
            }
        });
        panel_Login.add(buton_enterAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 120, 40));

        label_loginlogobig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/coollogo_forlogin_transparent.png"))); // NOI18N
        panel_Login.add(label_loginlogobig, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 420, 140));

        login_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/loginscreen2_00000.png"))); // NOI18N
        login_background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_backgroundMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_backgroundMouseExited(evt);
            }
        });
        panel_Login.add(login_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(panel_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 821));

        panel_adminUser.setMaximumSize(new java.awt.Dimension(1000, 700));
        panel_adminUser.setMinimumSize(new java.awt.Dimension(1000, 700));
        panel_adminUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_aSave.setText("Übernehmen");
        button_aSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_aSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aSaveActionPerformed(evt);
            }
        });
        panel_adminUser.add(button_aSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 149, 53));

        label_aAccname.setText("Kontoname:");
        panel_adminUser.add(label_aAccname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        label_aPass.setText("Passwort:");
        panel_adminUser.add(label_aPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        textfield_aKontoname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_aKontonameActionPerformed(evt);
            }
        });
        textfield_aKontoname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_aKontonameFocusGained(evt);
            }
        });
        panel_adminUser.add(textfield_aKontoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 149, -1));

        textfield_aEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_aEmailActionPerformed(evt);
            }
        });
        textfield_aEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_aEmailFocusGained(evt);
            }
        });
        panel_adminUser.add(textfield_aEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 149, -1));

        label_aEmail.setText("Email:");
        panel_adminUser.add(label_aEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        button_auCancel1.setText("Abbrechen");
        button_auCancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_auCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_auCancel1ActionPerformed(evt);
            }
        });
        panel_adminUser.add(button_auCancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 144, 53));

        label_aFirstName.setText("Vorname:");
        panel_adminUser.add(label_aFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        textfield_aSurename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_aSurenameFocusGained(evt);
            }
        });
        panel_adminUser.add(textfield_aSurename, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 149, -1));

        label_aLastName.setText("Nachname:");
        panel_adminUser.add(label_aLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        textfield_aName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_aNameFocusGained(evt);
            }
        });
        panel_adminUser.add(textfield_aName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 149, -1));

        lable_aProfil.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lable_aProfil.setText("Profil:");
        panel_adminUser.add(lable_aProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));
        panel_adminUser.add(textfield_aUCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 149, -1));

        label_aUCions.setText("UCoins:");
        panel_adminUser.add(label_aUCions, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        panel_adminUser.add(textfield_aCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 149, -1));

        label_aCredits.setText("Credits:");
        panel_adminUser.add(label_aCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        panel_adminUser.add(textfield_aDuplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 149, -1));

        label_aDuplo.setText("Duplo:");
        panel_adminUser.add(label_aDuplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));
        panel_adminUser.add(textfield_aRedBull, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 149, -1));
        panel_adminUser.add(textfield_aOMNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 149, -1));

        label_aRedBull.setText("RedBull:");
        panel_adminUser.add(label_aRedBull, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        label_aOMNI.setText("OMNI-Sense:");
        panel_adminUser.add(label_aOMNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        label_aSpicker.setText("Spicker:");
        panel_adminUser.add(label_aSpicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        slider_aMonth.setMaximum(18);
        slider_aMonth.setMinimum(1);
        slider_aMonth.setSnapToTicks(true);
        slider_aMonth.setValue(9);
        slider_aMonth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_aMonthStateChanged(evt);
            }
        });
        panel_adminUser.add(slider_aMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 150, -1));

        label_aMonth.setText("Monat: ");
        panel_adminUser.add(label_aMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        label_aGame.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        label_aGame.setText("Spielstand:");
        panel_adminUser.add(label_aGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));
        panel_adminUser.add(textfield_aPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 149, -1));

        label_aMonthVal.setText("2");
        panel_adminUser.add(label_aMonthVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 20, -1));

        button_aDelete.setText("Profil löschen");
        button_aDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_aDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aDeleteActionPerformed(evt);
            }
        });
        panel_adminUser.add(button_aDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 149, 34));

        label_aErrAccName.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrAccName.setText("Fehler?");
        panel_adminUser.add(label_aErrAccName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        label_aErrPass.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrPass.setText("Fehler?");
        panel_adminUser.add(label_aErrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        label_aErrEmail.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrEmail.setText("Fehler?");
        panel_adminUser.add(label_aErrEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        label_aErrFirstName.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrFirstName.setText("Fehler?");
        panel_adminUser.add(label_aErrFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        label_aErrLastName.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrLastName.setText("Fehler?");
        panel_adminUser.add(label_aErrLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        label_aErrUCoins.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrUCoins.setText("Fehler?");
        panel_adminUser.add(label_aErrUCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        label_aErrCredits.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrCredits.setText("Fehler?");
        panel_adminUser.add(label_aErrCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        label_aErrDuplo.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrDuplo.setText("Fehler?");
        panel_adminUser.add(label_aErrDuplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        label_aErrRedBull.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrRedBull.setText("Fehler?");
        panel_adminUser.add(label_aErrRedBull, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        label_aErrOmni.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrOmni.setText("Fehler?");
        panel_adminUser.add(label_aErrOmni, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, -1));

        label_aErrSpicker.setForeground(new java.awt.Color(255, 0, 0));
        label_aErrSpicker.setText("Fehler?");
        panel_adminUser.add(label_aErrSpicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, -1, -1));
        panel_adminUser.add(textfield_aSpicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 150, -1));

        background_adminUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/adminpanel_00000.png"))); // NOI18N
        panel_adminUser.add(background_adminUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(panel_adminUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_Admin.setMaximumSize(new java.awt.Dimension(1000, 700));
        panel_Admin.setMinimumSize(new java.awt.Dimension(1000, 700));
        panel_Admin.setPreferredSize(new java.awt.Dimension(1000, 700));

        background_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/adminpanel_00000.png"))); // NOI18N
        background_admin.setText("jLabel4");
        background_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        button_aCancel.setText("Abbrechen");
        button_aCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button_aCancel.setMaximumSize(new java.awt.Dimension(300, 50));
        button_aCancel.setMinimumSize(new java.awt.Dimension(300, 50));
        button_aCancel.setPreferredSize(new java.awt.Dimension(300, 50));
        button_aCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_AdminLayout = new javax.swing.GroupLayout(panel_Admin);
        panel_Admin.setLayout(panel_AdminLayout);
        panel_AdminLayout.setHorizontalGroup(
            panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_AdminLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(button_aCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_AdminLayout.setVerticalGroup(
            panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_admin)
            .addGroup(panel_AdminLayout.createSequentialGroup()
                .addGap(619, 619, 619)
                .addComponent(button_aCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panel_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToNextPage() {
        // Flipes to the planning phase after a minigame.
        //Game1.saveGame();
        if(_maingame.getSemester() == 7){
            label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/game_success.png")));
            cl.show(panel_gamePhases, "card8");
        }
        else{
           planningPhase = new PlanningPhase(jProgB_Wissen, jProgB_Motivation, jProgB_Müdigkeit, jLab_DozCounter, jToggleBut_SwitchStud,jLab_StudCounter, jBut_Dozent);
            if (panel_gamePhases.isVisible() == false) {
                panel_gamePhases.setVisible(true);
            }
        
            cl.show(panel_gamePhases, "card3");
            gamePlanning.requestFocus();
            jLab_Duplo.setText("Duplo: " + _maingame.duplo.amount + "x");
            jLab_Redbull.setText("Red Bull: " + _maingame.redBull.amount + "x");
            jLab_OMNI.setText("OMNISense Audio: " + _maingame.omniSenseAudio.amount + "x");
            panel_menue.setVisible(false);
        }
    }

    private void jToggleBut_SwitchStudMouseClicked(java.awt.event.MouseEvent evt) {
        planningPhase.startStudSwitch();

    }

    private void buton_enterAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_enterAdminActionPerformed
        textfield_Kontoname.setText(_adminName);
        password_Pass.setText(_adminPass);
    }//GEN-LAST:event_buton_enterAdminActionPerformed

    private void button_menuStartNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuStartNewGameActionPerformed
        // Starts a new game with initial values from the game_1.java.
        panel_stats.setVisible(false);
        Game1.initNewSavefile();
        Game1.loadGame();
        startTime = System.currentTimeMillis();
        
        switchPhase();
    }//GEN-LAST:event_button_menuStartNewGameActionPerformed

    private void button_menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuExitActionPerformed
        // Closes the entire game.
        System.exit(0);
    }//GEN-LAST:event_button_menuExitActionPerformed

    private void button_menuLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuLoadGameActionPerformed
        // Loads and existing game which always starts with a planning phase.
        panel_stats.setVisible(false);
        if (!noSave_overlay.isVisible()) {
            Game1.loadGame();
            switchPhase();
            startTime = System.currentTimeMillis();
            System.out.println("Current round " + Sims_1._maingame.round + " Current Semester " + Sims_1._maingame.getSemester());
        }
    }//GEN-LAST:event_button_menuLoadGameActionPerformed

    private void button_menuCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuCreditsActionPerformed
        panel_stats.setVisible(false);
        panel_Profile.setVisible(false);
        panel_Credits.setVisible(true);
        panel_Credits.requestFocus();
        javax.swing.Timer timer;
        int delay = 100; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            int down = 0;
            public void actionPerformed(ActionEvent evt) {
                if(down == 1){
                    panel_Credits.setLocation(panel_Credits.getX(), panel_Credits.getY()-2);
                    System.out.print(panel_Credits.getY()+"\n");
                    if(panel_Credits.getY() == -1200 || panel_Credits.hasFocus() == false){
                        down = 0;
                        panel_Credits.setVisible(false);
                        ((javax.swing.Timer)evt.getSource()).stop();
                    }
                }
                else{
                    //down = 0;
                    panel_Credits.setLocation(panel_Credits.getX(), panel_Credits.getY()+490);
                    if(panel_Credits.getY() >= +490)
                        down = 1;
                }
            }
        };
        timer = new javax.swing.Timer(delay, taskPerformer);
        timer.start();
    }//GEN-LAST:event_button_menuCreditsActionPerformed

    private void button_menuProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuProfileActionPerformed
        panel_stats.setVisible(false);
        initProfile();
        panel_Profile.setVisible(true);
    }//GEN-LAST:event_button_menuProfileActionPerformed

    private void button_menuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuLogOutActionPerformed
        panel_stats.setVisible(false);
        logOut();
    }//GEN-LAST:event_button_menuLogOutActionPerformed

    private void button_swapperExchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_swapperExchangeActionPerformed
        // This function is called from the shop, after the coin exchanger was opened and
        // the amount that shall be swapped was entered.
        // To finish the exchange the exchange button has to be pressed. After that the ucoins are reduced and
        // the credits increased.
        int parseResult = 0;
        int result = 1;
        try {
            parseResult = Integer.parseInt(textfield_swapperUcoins.getText());
        } catch (Exception e) {
            textfield_swapperUcoins.setText("");
        }
        if (parseResult >= 0) {
            result = exchange.ucoinsToCredits(parseResult, 1, textfield_swapperCredits);
        }
        if (result == 0) {
            label_swapperCreditsAmount.setText("" + _maingame.credits);
            label_swapperUcoinsAmount.setText("" + _mainuser.getUcoins());
            OpenShop labels = new OpenShop();
            labels.changeLabels(creditsShop, punkteShop, ucoinsShop);
            textfield_swapperUcoins.setText("");
            textfield_swapperCredits.setText("");
        }
    }//GEN-LAST:event_button_swapperExchangeActionPerformed

    private void button_swapperAbordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_swapperAbordActionPerformed
        // This function closes the exchange window if the user does not want to exchange more.
        buyCoins.setVisible(false);
    }//GEN-LAST:event_button_swapperAbordActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void label_logo_planningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logo_planningMouseClicked
       warningExitPlanningPhase.setVisible(true);        
       
    }//GEN-LAST:event_label_logo_planningMouseClicked

    private void label_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logoMouseClicked
        warningExitPlanningPhase.setVisible(true);
    }//GEN-LAST:event_label_logoMouseClicked

    private void button_startExchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startExchangeActionPerformed
        // Starts the exchange dialog in the shop
        label_swapperCreditsAmount.setText("" + _maingame.credits);
        label_swapperUcoinsAmount.setText("" + _mainuser.getUcoins());
        buyCoins.setVisible(true);
    }//GEN-LAST:event_button_startExchangeActionPerformed

    private void label_logo_playingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logo_playingMouseClicked
        //panel_gamePhases.setVisible(false);
        //panel_menue.setVisible(true);
        //activityPhase.runTimer=false;
    }//GEN-LAST:event_label_logo_playingMouseClicked

    private void button_menuStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_menuStatisticActionPerformed
        try{
            label_statsCurrentCredits.setText("Aktueller Creditstand: "+_maingame.credits);
            label_statsEarnedCredits.setText("Verdiente Credits: "+(_maingame.overallCredits+100));
            double time = (double) _mainuser.getTime_played();
            DecimalFormat df = new DecimalFormat("#.##");
            label_statsOverallTime.setText("Gesamtspielzeit(Minuten): "+df.format((time/1000/60)));
            label_statsPoints.setText("Gesamtpunktzahl: "+_maingame.points);
            label_statsSemester.setText("Gespielte Semster: "+_maingame.getSemester());
            int present = 0;
            for(int i=0; i<_maingame.studentArray.length; i++){
                if(_maingame.studentArray[i].present == true){
                    present++;
                }
            }
            label_statsRate.setText("Studenten: "+String.valueOf(present)+" / 30");
            label_statsStudentArrtibutes.setText("Durchschnittswerte: "+"Wissen: "+_maingame.averageKnowledge+" Motivation: "+_maingame.avarageMotivation+" Müdigkeit: "+_maingame.averageTiredness);
            panel_stats.setVisible(true);
        }
        catch(NullPointerException e){
            dialog_statsError.setVisible(true);
        }
    }//GEN-LAST:event_button_menuStatisticActionPerformed

    private void jBut_OKnoCheatsAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_OKnoCheatsAvailableActionPerformed

    }//GEN-LAST:event_jBut_OKnoCheatsAvailableActionPerformed

    private void jBut_ChangeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_ChangeProfessorActionPerformed

    }//GEN-LAST:event_jBut_ChangeProfessorActionPerformed

    private void jBut_startShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_startShopActionPerformed

    }//GEN-LAST:event_jBut_startShopActionPerformed

    private void jBut_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_17ActionPerformed

    }//GEN-LAST:event_jBut_17ActionPerformed
 private void label_laptop1MouseClicked(java.awt.event.MouseEvent evt) {                                           
if(_maingame.studentArray[0].laptopClosed== false)
{
    label_laptop1.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[0].laptopClosed = true;
}// TODO add your handling code here:
    }                                          

    private void label_laptop2MouseClicked(java.awt.event.MouseEvent evt) {                                           
 if(_maingame.studentArray[1].laptopClosed== false)
{
    label_laptop2.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[1].laptopClosed = true;
    
}       // TODO add your handling code here:
    }                                          

    private void label_laptop3MouseClicked(java.awt.event.MouseEvent evt) {                                           
if(_maingame.studentArray[2].laptopClosed== false)
{
    label_laptop3.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[2].laptopClosed = true;
    
}        // TODO add your handling code here:
    }                                          

    private void label_laptop4MouseClicked(java.awt.event.MouseEvent evt) {                                           
 if(_maingame.studentArray[3].laptopClosed== false)
{
    label_laptop4.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[3].laptopClosed = true;
    
}       // TODO add your handling code here:
    }                                          

    private void label_laptop5MouseClicked(java.awt.event.MouseEvent evt) {                                           
   if(_maingame.studentArray[4].laptopClosed== false)
{
    label_laptop5.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[4].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                          

    private void label_laptop6MouseClicked(java.awt.event.MouseEvent evt) {                                           
   if(_maingame.studentArray[5].laptopClosed== false)
{
    label_laptop6.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[5].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                          

    private void label_laptop12MouseClicked(java.awt.event.MouseEvent evt) {                                            
  if(_maingame.studentArray[11].laptopClosed== false)
{
    label_laptop12.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[11].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                           

    private void label_laptop11MouseClicked(java.awt.event.MouseEvent evt) {                                            
 if(_maingame.studentArray[10].laptopClosed== false)
{
    label_laptop11.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[10].laptopClosed = true;
    
}       // TODO add your handling code here:
    }                                           

    private void label_laptop10MouseClicked(java.awt.event.MouseEvent evt) {                                            
   if(_maingame.studentArray[9].laptopClosed== false)
{
    label_laptop10.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[9].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                           

    private void label_laptop9MouseClicked(java.awt.event.MouseEvent evt) {                                           
  if(_maingame.studentArray[8].laptopClosed== false)
{
    label_laptop9.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[8].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                          

    private void label_laptop8MouseClicked(java.awt.event.MouseEvent evt) {                                           
    if(_maingame.studentArray[7].laptopClosed== false)
{
    label_laptop8.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[7].laptopClosed = true;
    
}    // TODO add your handling code here:
    }                                          

    private void label_laptop7MouseClicked(java.awt.event.MouseEvent evt) {                                           
   if(_maingame.studentArray[6].laptopClosed== false)
{
    label_laptop7.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[6].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                          

    private void label_laptop18MouseClicked(java.awt.event.MouseEvent evt) {                                            
   if(_maingame.studentArray[17].laptopClosed== false)
{
    label_laptop18.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[17].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                           

    private void label_laptop17MouseClicked(java.awt.event.MouseEvent evt) {                                            
  if(_maingame.studentArray[16].laptopClosed== false)
{
    label_laptop17.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[16].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                           

    private void label_laptop16MouseClicked(java.awt.event.MouseEvent evt) {                                            
   if(_maingame.studentArray[15].laptopClosed== false)
{
    label_laptop16.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[15].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                           

    private void label_laptop15MouseClicked(java.awt.event.MouseEvent evt) {                                            
     if(_maingame.studentArray[14].laptopClosed== false)
{
    label_laptop15.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[14].laptopClosed = true;
    
}   // TODO add your handling code here:
    }                                           

    private void label_laptop14MouseClicked(java.awt.event.MouseEvent evt) {                                            
  if(_maingame.studentArray[13].laptopClosed== false)
{
    label_laptop14.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[13].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                           

    private void label_laptop13MouseClicked(java.awt.event.MouseEvent evt) {                                            
  if(_maingame.studentArray[12].laptopClosed== false)
{
    label_laptop13.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[12].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                           

    private void label_laptop24MouseClicked(java.awt.event.MouseEvent evt) {                                            
   if(_maingame.studentArray[23].laptopClosed== false)
{
    label_laptop24.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[23].laptopClosed = true;
    
}     // TODO add your handling code here:
    }                                           

    private void label_laptop23MouseClicked(java.awt.event.MouseEvent evt) {                                            
    if(_maingame.studentArray[22].laptopClosed== false)
{
    label_laptop23.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[22].laptopClosed = true;
    
}    // TODO add your handling code here:
    }                                           

    private void label_laptop22MouseClicked(java.awt.event.MouseEvent evt) {                                            
     if(_maingame.studentArray[21].laptopClosed== false)
{
    label_laptop22.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[21].laptopClosed = true;
    
}   // TODO add your handling code here:
    }                                           

    private void label_laptop21MouseClicked(java.awt.event.MouseEvent evt) {                                            
   if(_maingame.studentArray[20].laptopClosed== false)
{
    label_laptop21.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[20].laptopClosed = true;
}     // TODO add your handling code here:
    }                                           

    private void label_laptop20MouseClicked(java.awt.event.MouseEvent evt) {                                            
     if(_maingame.studentArray[19].laptopClosed== false)
{
    label_laptop20.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[19].laptopClosed = true;
    
}   // TODO add your handling code here:
    }                                           

    private void label_laptop19MouseClicked(java.awt.event.MouseEvent evt) {                                            
  if(_maingame.studentArray[18].laptopClosed== false)
{
    label_laptop19.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[18].laptopClosed = true;
    
}      // TODO add your handling code here:
    }                                           

    private void label_laptop30MouseClicked(java.awt.event.MouseEvent evt) {                                            
    if(_maingame.studentArray[29].laptopClosed== false)
{
    label_laptop30.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[29].laptopClosed = true;
    
}    // TODO add your handling code here:
    }                                           

    private void label_laptop29MouseClicked(java.awt.event.MouseEvent evt) {                                            
     if(_maingame.studentArray[28].laptopClosed== false)
{
    label_laptop29.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[28].laptopClosed = true;
    
}   // TODO add your handling code here:
    }                                           

    private void label_laptop28MouseClicked(java.awt.event.MouseEvent evt) {                                            
    if(_maingame.studentArray[27].laptopClosed== false)
{
    label_laptop28.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[27].laptopClosed = true;
    
}    // TODO add your handling code here:
    }                                           

    private void label_laptop27MouseClicked(java.awt.event.MouseEvent evt) {                                            
      if(_maingame.studentArray[26].laptopClosed== false)
{
    label_laptop27.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[26].laptopClosed = true;
    
}  // TODO add your handling code here:
    }                                           

    private void label_laptop26MouseClicked(java.awt.event.MouseEvent evt) {                                            
    if(_maingame.studentArray[25].laptopClosed== false)
{
    label_laptop26.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[25].laptopClosed = true;
    
}    // TODO add your handling code here:
    }                                           

    private void label_laptop25MouseClicked(java.awt.event.MouseEvent evt) {                                            
      if(_maingame.studentArray[24].laptopClosed== false)
{
    label_laptop25.setIcon(new ImageIcon(getClass().getResource("/pictures/laptopzu.png")));
    _maingame.studentArray[24].laptopClosed = true;
    
}  // TODO add your handling code here:
    }
    private void jBut_startShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_startShopMouseClicked
        // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
        
        // This function is called after the shop button from the planning phase was pressed.
        // It opens the shop, creates the inventory and the objects that can be bought.
        cl.show(panel_gamePhases, "card4");
        panel_menue.setVisible(false);
        
        OpenShop labels = new OpenShop();
        labels.changeLabels(creditsShop, punkteShop, ucoinsShop);
        //Checks the Students that are still present
        int present = 0;
        for(int i=0; i<_maingame.studentArray.length; i++){
            if(_maingame.studentArray[i].present == true){
                present++;
            }
        }
        label_shopRemainingStudents.setText(String.valueOf(present)+" / 30");
        label_shopRemainingSemesters.setText(String.valueOf(_maingame.getSemester())+" / 6");
        
        item.createItemInventory(label_item1, label_item1Name, label_item1Amount, _maingame.redBull);
        item.createItemInventory(label_item2, label_item2Name, label_item2Amount, _maingame.duplo);
        item.createItemInventory(label_item3, label_item3Name, label_item3Amount, _maingame.omniSenseAudio);
        item.createItemInventory(label_item4, label_item4Name, label_item4Amount, _maingame.cheatSheet);
        item.createItemShop(label_redBullName, label_redBullAmount, label_redBullLocked, _maingame.redBull);
        item.createItemShop(label_duploName, label_duploAmount, label_duploLocked, _maingame.duplo);
        item.createItemShop(label_cheatSheetName, label_cheatSheetAmount, label_cheatSheetLocked, _maingame.cheatSheet);
        item.createItemShop(label_omniName, label_omniAmount, label_omniLocked, _maingame.omniSenseAudio);
    }//GEN-LAST:event_jBut_startShopMouseClicked

    private void label_redBullOverlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_redBullOverlayMouseClicked
        // On click Red Bull can be bought if the user has enough credits 
        int result = item.managePurchase(_maingame.redBull, label_redBullLocked);
        if (result != 0) {
            dialog_error.setVisible(true);
            dialog_error.setBounds(300, 200, 400, 320);
        } else {
            jBut_startShopMouseClicked(evt);
            item.updateInventoryPlanningPhase(jLab_Redbull, _maingame.redBull);
        }
    }//GEN-LAST:event_label_redBullOverlayMouseClicked

    private void label_duploOverlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_duploOverlayMouseClicked
        // On click Duplo can be bought if the user has enough credits 
        int result = item.managePurchase(_maingame.duplo, label_duploLocked);
        if (result != 0) {
            dialog_error.setVisible(true);
            dialog_error.setBounds(300, 200, 400, 320);
        } else {
            jBut_startShopMouseClicked(evt);
            item.updateInventoryPlanningPhase(jLab_Duplo, _maingame.duplo);
        }
    }//GEN-LAST:event_label_duploOverlayMouseClicked

    private void label_cheatSheetOverlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cheatSheetOverlayMouseClicked
        // On click the cheat sheet can be bought if the user has enough ucoins 
        int result = item.managePurchase(_maingame.cheatSheet, label_cheatSheetLocked);
        if (result != 0) {
            dialog_error.setVisible(true);
            dialog_error.setBounds(300, 200, 400, 320);
        } else {
            jBut_startShopMouseClicked(evt);
        }
    }//GEN-LAST:event_label_cheatSheetOverlayMouseClicked

    private void label_omniOverlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_omniOverlayMouseClicked
        // On click the OMNI Sense audiobook can be bought if the user has enough ucoins 
        int result = item.managePurchase(_maingame.omniSenseAudio, label_omniLocked);
        if (result != 0) {
            dialog_error.setVisible(true);
            dialog_error.setBounds(300, 200, 400, 320);
        } else {
            jBut_startShopMouseClicked(evt);
            item.updateInventoryPlanningPhase(jLab_OMNI, _maingame.omniSenseAudio);
        }
    }//GEN-LAST:event_label_omniOverlayMouseClicked

    private void button_shopMessageOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_shopMessageOkActionPerformed
        dialog_error.setVisible(false);
    }//GEN-LAST:event_button_shopMessageOkActionPerformed

    private void jBut_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_1ActionPerformed

    }//GEN-LAST:event_jBut_1ActionPerformed

    private void textfield_swapperUcoinsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_swapperUcoinsKeyReleased
        // If the user types something in the exchange dialog the changed
        // amount is displayed directly.
        int parseResult = 0;
        try {
            parseResult = Integer.parseInt(textfield_swapperUcoins.getText());
        } catch (Exception e) {
            textfield_swapperUcoins.setText("");
        }
        if (parseResult >= 0) {
            exchange.ucoinsToCredits(parseResult, 0, textfield_swapperCredits);
        }
    }//GEN-LAST:event_textfield_swapperUcoinsKeyReleased

    private void jBut_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_1MouseClicked
        /**
         * @author Tobias Mauritz
         */
        planningPhase.StudButtonFunctions(0,jBut_1);
        // !!! kann nicht funzen!! wir brauchen akutelles Objekt von PLanningPhase, hier ist nur das generelle!
        // --> alles auslagern in Planungsphasen-Mehtode
//        if (PlanningPhase.getSwitchFlag() == 0){
//            
//            // start method StudInfo() which shows knowledge, motivation and tiredness 
//            // of the student which was clicked
//        PlanningPhase.studInfo.StudInfoAttr(0);
//            //StudInfo curStud = new StudInfo(0,jProgB_Wissen,jProgB_Motivation, jProgB_Müdigkeit);
//        //System.out.println("Student 1 = "+PlanningPhase.StudArr[0].getId());
//        
//        } else {
//            System.out.println("TauschFlag = 1");
//            PlanningPhase.storeStud(1);
//        }
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_1MouseClicked

    private void jBut_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_2MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(1,jBut_2);

//        if (PlanningPhase.getSwitchFlag() == 0){
//            
//            PlanningPhase.studInfo.StudInfoAttr(1);
//            //System.out.println("Student 2 = "+PlanningPhase.StudArr[1].getId());
//      
//        } else {
//            System.out.println("TauschFlag = 1");
//            PlanningPhase.storeStud(2);
//            
//        }
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_2MouseClicked

    private void jBut_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_3MouseClicked

        planningPhase.StudButtonFunctions(2,jBut_3);
          SetPlanningPhaseOpacity(); 

    }//GEN-LAST:event_jBut_3MouseClicked

    private void jBut_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_4MouseClicked
        planningPhase.StudButtonFunctions(3,jBut_4);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_4MouseClicked

    private void jBut_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_5MouseClicked
        planningPhase.StudButtonFunctions(4,jBut_5);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_5MouseClicked

    private void jBut_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_1MouseEntered

    }//GEN-LAST:event_jBut_1MouseEntered

    private void jBut_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_1MouseExited

    }//GEN-LAST:event_jBut_1MouseExited

    private void StudFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudFieldMouseEntered

    }//GEN-LAST:event_StudFieldMouseEntered

    private void StudFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudFieldMouseClicked

        System.out.println("StudField");
        // 
        planningPhase.studInfo.StudInfoAverage();
        //StudInfo z = new StudInfo(jProgB_Wissen,jProgB_Motivation, jProgB_Müdigkeit);

    }//GEN-LAST:event_StudFieldMouseClicked

    private void jBut_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_2MouseEntered

    }//GEN-LAST:event_jBut_2MouseEntered

    private void jBut_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_3MouseEntered

    }//GEN-LAST:event_jBut_3MouseEntered

    private void jBut_4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_4MouseEntered
  
    }//GEN-LAST:event_jBut_4MouseEntered

    private void jBut_5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_5MouseEntered
      
    }//GEN-LAST:event_jBut_5MouseEntered

    private void jBut_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_6MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(5,jBut_6);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_6MouseClicked

    private void jBut_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_7MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(6,jBut_7);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_7MouseClicked

    private void jBut_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_8MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(7,jBut_8);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_8MouseClicked

    private void jBut_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_9MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(8,jBut_9);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_9MouseClicked

    private void jBut_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_10MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(9,jBut_10);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_10MouseClicked

    private void jBut_11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_11MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(10,jBut_11);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_11MouseClicked

    private void jBut_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_12MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(11,jBut_12);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_12MouseClicked

    private void jBut_13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_13MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(12,jBut_13);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_13MouseClicked

    private void jBut_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_14MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(13,jBut_14);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_14MouseClicked

    private void jBut_15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_15MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(14,jBut_15);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_15MouseClicked

    private void jBut_16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_16MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(15,jBut_16);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_16MouseClicked

    private void jBut_17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_17MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(16,jBut_17);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_17MouseClicked

    private void jBut_18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_18MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(17,jBut_18);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_18MouseClicked

    private void jBut_19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_19MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(18,jBut_19);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_19MouseClicked

    private void jBut_20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_20MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(19,jBut_20);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_20MouseClicked

    private void jBut_21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_21MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(20,jBut_21);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_21MouseClicked

    private void jBut_22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_22MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(21,jBut_22);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_22MouseClicked

    private void jBut_23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_23MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(22,jBut_23);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_23MouseClicked

    private void jBut_24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_24MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(23,jBut_24);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_24MouseClicked

    private void jBut_25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_25MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(24,jBut_25);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_25MouseClicked

    private void jBut_26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_26MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(25,jBut_26);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_26MouseClicked

    private void jBut_27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_27MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(26,jBut_27);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_27MouseClicked

    private void jBut_28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_28MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(27,jBut_28);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_28MouseClicked

    private void jBut_29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_29MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(28,jBut_29);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_29MouseClicked

    private void jBut_30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_30MouseClicked
        // functionality: see comment at jBut_1MouseClicked
        planningPhase.StudButtonFunctions(29,jBut_30);
          SetPlanningPhaseOpacity(); 
    }//GEN-LAST:event_jBut_30MouseClicked

    private void jBut_ChangeProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_ChangeProfessorMouseClicked
        // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
        
        //check if can change lector. If so - do this, else -  show error 
        boolean allowed = planningPhase.checkProffesorChangeability();
        if (allowed) {
            planningPhase.changeProfessor();
            professorChangedDialog.setVisible(true);
        } else {
            professorNotChangedDialog.setVisible(true);
        }
    }//GEN-LAST:event_jBut_ChangeProfessorMouseClicked

    private void jBut_PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_PlayMouseClicked
        // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
        // Starts the action phase and the inventory. 
        if (panel_gamePhases.isVisible() == false) {
            panel_gamePhases.setVisible(true);
        }
        cl.show(panel_gamePhases, "card2");
        startActivityPhase();
        panel_menue.setVisible(false);
        item.createItemInventory(label_item1Inv, label_item1InvName, label_item1InvAmount, _maingame.redBull);
        item.createItemInventory(label_item2Inv, label_item2InvName, label_item2InvAmount, _maingame.duplo);
        item.createItemInventory(label_item3Inv, label_item3InvName, label_item3InvAmount, _maingame.omniSenseAudio);
        label_ucoinsInv.setText("UCoins:  " + _mainuser.getUcoins());
        label_creditsInv.setText("Credits:   " + _maingame.credits);
        SetActivityPhaseOpacity();
     //   activityPhase = new ActivityPhase(label_timer, KnowledgeBar,AirBar,NoiseBar, MotivationBar, TirednessBar, label_item1InvAmount, label_item2InvAmount, label_item3InvAmount, activityPhaseButtons, label_score); // added by Jörg, Nadir
    }//GEN-LAST:event_jBut_PlayMouseClicked

    private void textfield_rKontonameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rKontonameFocusGained
        textfield_rKontoname.requestFocus();  //by Dawid
        textfield_rKontoname.selectAll();
    }//GEN-LAST:event_textfield_rKontonameFocusGained

    private void textfield_rEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_rEmail1ActionPerformed

    }//GEN-LAST:event_textfield_rEmail1ActionPerformed

    private void textfield_rEmail1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rEmail1FocusGained
        textfield_rEmail1.requestFocus();  //by Dawid
        textfield_rEmail1.selectAll();
    }//GEN-LAST:event_textfield_rEmail1FocusGained

    private void textfield_rEmail2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rEmail2FocusGained
        textfield_rEmail2.requestFocus();  //by Dawid
        textfield_rEmail2.selectAll();
    }//GEN-LAST:event_textfield_rEmail2FocusGained

    private void textfield_rNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rNameFocusGained
        textfield_rName.requestFocus();  //by Dawid
        textfield_rName.selectAll();
    }//GEN-LAST:event_textfield_rNameFocusGained

    private void textfield_rSurenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rSurenameFocusGained
        textfield_rSurename.requestFocus();  //by Dawid
        textfield_rSurename.selectAll();
    }//GEN-LAST:event_textfield_rSurenameFocusGained

    private void password_rPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_rPass1FocusGained
        password_rPass1.requestFocus();  //by Dawid
        password_rPass1.selectAll();
    }//GEN-LAST:event_password_rPass1FocusGained

    private void password_rPass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_rPass2FocusGained
        password_rPass2.requestFocus();  //by Dawid
        password_rPass2.selectAll();
    }//GEN-LAST:event_password_rPass2FocusGained

    private void button_rRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rRegisterActionPerformed
        JComponent[] toCheck = {textfield_rKontoname, password_rPass1, password_rPass2, textfield_rEmail1, textfield_rEmail2, textfield_rName, textfield_rSurename};
        JLabel[] errMess = {label_rErrAccname, label_rErrPass1, label_rErrPass2, label_rErrEmail1, label_rErrEmail2, label_rErrFirstName, label_rErrLastName};
        JTextField[] accName_eMail = {textfield_rKontoname, textfield_rEmail1};
        JLabel[] errMess2 = {label_rErrAccname, label_rErrEmail1};
        if (checkRegister_(toCheck, errMess) & !checkGlobUser(accName_eMail, errMess2)) {  //by Dawid
            User.createUser(textfield_rKontoname.getText(), password_rPass1.getPassword(), textfield_rEmail1.getText(), textfield_rName.getText(), textfield_rSurename.getText());
            panel_Login.setVisible(true);
            panel_Register.setVisible(false);
            button_Register.setSelected(false);
        }
    }//GEN-LAST:event_button_rRegisterActionPerformed

    private void button_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_LoginActionPerformed
        if (checkLogIn(textfield_Kontoname.getText(), password_Pass.getPassword())) {  //by Dawid
            logIn(textfield_Kontoname.getText());
        }
    }//GEN-LAST:event_button_LoginActionPerformed

    private void button_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RegisterActionPerformed
        initRegister();  //by Dawid
        button_Register.setSelected(true);
        panel_Register.setVisible(true);
    }//GEN-LAST:event_button_RegisterActionPerformed

    private void textfield_KontonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_KontonameActionPerformed

    }//GEN-LAST:event_textfield_KontonameActionPerformed

    private void check_saveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_saveUserActionPerformed
     
    }//GEN-LAST:event_check_saveUserActionPerformed

    private void textfield_rKontonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_rKontonameActionPerformed
   
    }//GEN-LAST:event_textfield_rKontonameActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        panel_Register.setVisible(false);  //by Dawid
        button_Register.setSelected(false);
    }//GEN-LAST:event_button_cancelActionPerformed

    private void jComboB_ItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboB_ItemsActionPerformed
        /*
         * lokale Variablen für diese Methode, momentan zu Testzwecken
         */
        int currentSemester=Sims_1._maingame.getSemester(); // current Semester
        boolean usedCheat=Sims_1._maingame.getCheated(currentSemester); //checks if Cheat was already used in this semester
        
        javax.swing.JComboBox box = (javax.swing.JComboBox) evt.getSource();
        String selected = (String) box.getSelectedItem();
        System.out.println("Right now selected " + selected);
        if (selected.equals("Spicker")) {
            if (Sims_1._maingame.cheatSheet.amount == 0) {
                System.out.println("Kein Spicker verfügbar");
                noCheatsAvailableDialog.setVisible(true);
            } else if ((currentSemester>=2)&&(currentSemester<=6)&&!usedCheat){
                warningDialog.setVisible(true);
                System.out.println("show warning");
            } else {
                System.out.println("Du kannst in dem " + currentSemester + " Semester den Spicker nicht mehr einsetzen");
                notAllowedUseCheatDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_jComboB_ItemsActionPerformed

    private void jBut_JAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_JAMouseClicked
        planningPhase.setCheatFlag(true);
        warningDialog.setVisible(false);

    }//GEN-LAST:event_jBut_JAMouseClicked

    private void jBut_NEINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_NEINMouseClicked
        planningPhase.setCheatFlag(false);
        warningDialog.setVisible(false);
    }//GEN-LAST:event_jBut_NEINMouseClicked

    private void warningDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_warningDialogWindowClosed
//        planningPhase.setCheatFlag(0);
//        warning.setVisible(false);
    }//GEN-LAST:event_warningDialogWindowClosed

    private void jBut_NEINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_NEINActionPerformed
   
    }//GEN-LAST:event_jBut_NEINActionPerformed

    private void jBut_JAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_JAActionPerformed

    }//GEN-LAST:event_jBut_JAActionPerformed

    private void jBut_OKlectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_OKlectorMouseClicked
        professorChangedDialog.setVisible(false);
    }//GEN-LAST:event_jBut_OKlectorMouseClicked

    private void jBut_OKnotchangedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_OKnotchangedMouseClicked
        professorNotChangedDialog.setVisible(false);
    }//GEN-LAST:event_jBut_OKnotchangedMouseClicked

    private void textfield_KontonameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_KontonameFocusGained
        textfield_Kontoname.requestFocus();
        textfield_Kontoname.selectAll();
    }//GEN-LAST:event_textfield_KontonameFocusGained

    private void password_PassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_PassFocusGained
        password_Pass.requestFocus();
        password_Pass.selectAll();
    }//GEN-LAST:event_password_PassFocusGained

    private void button_stud1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud1MouseClicked

        activityPhase.StudentClicked(0);
     SetActivityPhaseOpacity();
  
    }//GEN-LAST:event_button_stud1MouseClicked

    private void button_stud2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud2MouseClicked
   
   activityPhase.StudentClicked(1);
    SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud2MouseClicked

    private void button_stud3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud3MouseClicked
  
   activityPhase.StudentClicked(2);
  SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud3MouseClicked

    private void button_stud4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud4MouseClicked
     
        activityPhase.StudentClicked(3);
     SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud4MouseClicked

    private void button_stud5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud5MouseClicked
       
        activityPhase.StudentClicked(4);
      SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud5MouseClicked

    private void button_stud6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud6MouseClicked
   
        activityPhase.StudentClicked(5);
              SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud6MouseClicked

    private void button_stud7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud7MouseClicked
      
        activityPhase.StudentClicked(6);
    SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud7MouseClicked

    private void button_stud8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud8MouseClicked
       
        activityPhase.StudentClicked(7);
          SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud8MouseClicked

    private void button_stud9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud9MouseClicked
        activityPhase.StudentClicked(8);
             SetActivityPhaseOpacity();

    }//GEN-LAST:event_button_stud9MouseClicked

    private void button_stud10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud10MouseClicked
        
        activityPhase.StudentClicked(9);
      SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud10MouseClicked

    private void button_stud11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud11MouseClicked
        
        activityPhase.StudentClicked(10);
      SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud11MouseClicked

    private void button_stud12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud12MouseClicked
         
        activityPhase.StudentClicked(11);
       SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud12MouseClicked

    private void button_stud13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud13MouseClicked
       
        activityPhase.StudentClicked(12);
       SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud13MouseClicked

    private void button_stud14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud14MouseClicked
        
        activityPhase.StudentClicked(13);
        SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud14MouseClicked

    private void button_stud15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud15MouseClicked
        
        activityPhase.StudentClicked(14);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud15MouseClicked

    private void button_stud16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud16MouseClicked
       
        activityPhase.StudentClicked(15);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud16MouseClicked

    private void button_stud17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud17MouseClicked
  
        activityPhase.StudentClicked(16);
   SetActivityPhaseOpacity();  
    }//GEN-LAST:event_button_stud17MouseClicked

    private void button_stud18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud18MouseClicked
        activityPhase.StudentClicked(17);
           SetActivityPhaseOpacity();

    }//GEN-LAST:event_button_stud18MouseClicked

    private void button_stud19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud19MouseClicked
        
        activityPhase.StudentClicked(18);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud19MouseClicked

    private void button_stud20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud20MouseClicked
       
        activityPhase.StudentClicked(19);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud20MouseClicked

    private void button_stud21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud21MouseClicked
        
        activityPhase.StudentClicked(20);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud21MouseClicked

    private void button_stud22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud22MouseClicked
   
        activityPhase.StudentClicked(21);
           SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud22MouseClicked

    private void button_stud23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud23MouseClicked
      
        activityPhase.StudentClicked(22);
      SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud23MouseClicked

    private void button_stud24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud24MouseClicked
         
        activityPhase.StudentClicked(23);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud24MouseClicked

    private void button_stud25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud25MouseClicked
       
        activityPhase.StudentClicked(24);
        SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud25MouseClicked

    private void button_stud26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud26MouseClicked
   
        activityPhase.StudentClicked(25);
        SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud26MouseClicked

    private void button_stud27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud27MouseClicked
        
        activityPhase.StudentClicked(26);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud27MouseClicked

    private void button_stud28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud28MouseClicked
          
        activityPhase.StudentClicked(27);
      SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud28MouseClicked

    private void button_stud29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud29MouseClicked
         
        activityPhase.StudentClicked(28);
         SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud29MouseClicked

    private void button_stud30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_stud30MouseClicked
        
        activityPhase.StudentClicked(29);
          SetActivityPhaseOpacity();
    }//GEN-LAST:event_button_stud30MouseClicked

    private void panel_activityPhaseStudFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_activityPhaseStudFieldMouseClicked
    activityPhase.doNotPaintFlag= false;
    activityPhase.studentDisplayed = -1;
    }//GEN-LAST:event_panel_activityPhaseStudFieldMouseClicked

    private void panel_activityPhaseStudFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_activityPhaseStudFieldMouseEntered
 
    }//GEN-LAST:event_panel_activityPhaseStudFieldMouseEntered

    private void label_item1InvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_item1InvMouseClicked
        if (activityPhase.redBullPressed == false) {
            activityPhase.redBullPressed = true;
            activityPhase.duploPressed = false;
            activityPhase.OmniSensePressed = false;
            System.out.println("redBull on!");
        } else {
            activityPhase.redBullPressed = false;
            System.out.println("redBull off!");
        }
    }//GEN-LAST:event_label_item1InvMouseClicked

    private void label_item2InvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_item2InvMouseClicked
        if (activityPhase.duploPressed == false) {
            activityPhase.redBullPressed = false;
            activityPhase.duploPressed = true;
            activityPhase.OmniSensePressed = false;
            System.out.println("duplo on!");
        } else {
            activityPhase.duploPressed = false;
            System.out.println("duplo off!");
        }
    }//GEN-LAST:event_label_item2InvMouseClicked

    private void label_item3InvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_item3InvMouseClicked
        if (activityPhase.redBullPressed == false) {
            activityPhase.redBullPressed = false;
            activityPhase.duploPressed = false;
            activityPhase.OmniSensePressed = true;
            System.out.println("OmniSense on!");
        } else {
            activityPhase.redBullPressed = false;
            System.out.println("OmniSense off!");
        }
    }//GEN-LAST:event_label_item3InvMouseClicked

    private void button_aSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aSaveActionPerformed
        if (_mainadmin.checkChanges()) {
            _mainadmin.saveChages();
            adminLogin();
        }
    }//GEN-LAST:event_button_aSaveActionPerformed

    private void textfield_aKontonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_aKontonameActionPerformed
       
    }//GEN-LAST:event_textfield_aKontonameActionPerformed

    private void textfield_aKontonameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_aKontonameFocusGained
        
    }//GEN-LAST:event_textfield_aKontonameFocusGained

    private void textfield_aEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_aEmailActionPerformed
  
    }//GEN-LAST:event_textfield_aEmailActionPerformed

    private void textfield_aEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_aEmailFocusGained
        
    }//GEN-LAST:event_textfield_aEmailFocusGained

    private void button_auCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_auCancel1ActionPerformed
        panel_Admin.setVisible(true);
        panel_adminUser.setVisible(false);
    }//GEN-LAST:event_button_auCancel1ActionPerformed

    private void textfield_aSurenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_aSurenameFocusGained
        
    }//GEN-LAST:event_textfield_aSurenameFocusGained

    private void textfield_aNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_aNameFocusGained
        
    }//GEN-LAST:event_textfield_aNameFocusGained

    private void slider_aMonthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_aMonthStateChanged
        label_aMonthVal.setText(Integer.toString(slider_aMonth.getValue()));
    }//GEN-LAST:event_slider_aMonthStateChanged

    private void textfield_rNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_rNameActionPerformed
        
    }//GEN-LAST:event_textfield_rNameActionPerformed

    private void button_aDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Profil wirklich löschen? Achtung: kann nciht rückgängig gemacht werden") == JOptionPane.OK_OPTION) {
            _mainadmin.delSpecUser();
            adminLogin();
        }
    }//GEN-LAST:event_button_aDeleteActionPerformed

    private void button_aCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aCancelActionPerformed
        panel_Admin.setVisible(false);
        panel_Login.setVisible(true);
    }//GEN-LAST:event_button_aCancelActionPerformed

    private void textfield_pKontonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_pKontonameActionPerformed
      
    }//GEN-LAST:event_textfield_pKontonameActionPerformed

    private void textfield_pKontonameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_pKontonameFocusGained
      
    }//GEN-LAST:event_textfield_pKontonameFocusGained

    private void textfield_pEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_pEmail1ActionPerformed
        
    }//GEN-LAST:event_textfield_pEmail1ActionPerformed

    private void textfield_pEmail1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_pEmail1FocusGained
        
    }//GEN-LAST:event_textfield_pEmail1FocusGained

    private void textfield_pEmail2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_pEmail2FocusGained
       
    }//GEN-LAST:event_textfield_pEmail2FocusGained

    private void textfield_pNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_pNameActionPerformed
       
    }//GEN-LAST:event_textfield_pNameActionPerformed

    private void textfield_pNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_pNameFocusGained
        
    }//GEN-LAST:event_textfield_pNameFocusGained

    private void textfield_pSurenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_pSurenameFocusGained
        
    }//GEN-LAST:event_textfield_pSurenameFocusGained

    private void password_pPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_pPass1FocusGained
        
    }//GEN-LAST:event_password_pPass1FocusGained

    private void password_pPass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_pPass2FocusGained
       
    }//GEN-LAST:event_password_pPass2FocusGained

    private void button_pSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pSaveActionPerformed
        JComponent[] toCheck = {textfield_pKontoname, password_pPass1, password_pPass2, textfield_pEmail1, textfield_pEmail2, textfield_pName, textfield_pSurename};
        JLabel[] errMess = {label_pErrAccname, label_pErrPass1, label_pErrPass2, label_pErrEmail1, label_pErrEmail2, label_pErrFirstName, label_pErrLastName};
        JTextField[] toCheck2 = {textfield_pKontoname, textfield_pEmail1};
        JLabel[] errMess2 = {label_pErrAccname, label_pErrEmail1};
        JLabel inputLabel = new JLabel("Bitte aktuelles Passwort eingeben!");
        JPasswordField inputPw = new JPasswordField();
        Object[] ob = {inputLabel, inputPw};
        Boolean okPressed = false;
        Boolean changePass = false;

        if (((_mainuser.getAccountname().equals(textfield_pKontoname.getText()) & _mainuser.getEmail().equals(textfield_pEmail1.getText())) | !checkGlobUserVar(toCheck2, errMess2)) & checkRegister_(toCheck, errMess)) {
            if (JOptionPane.showConfirmDialog(null, ob, "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                if (new String(inputPw.getPassword()).equals(_mainuser.getPassword())) {
                    changePass = true;
                } else {
                    inputLabel.setText("Falsches Passwort! Bitte aktuelles Passwort eingeben!");
                    inputPw.setText("");
                    while ((okPressed = (JOptionPane.showConfirmDialog(null, ob, "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)) & !new String(inputPw.getPassword()).equals(_mainuser.getPassword())) {
                        inputPw.setText("");
                    }
                    System.out.println(okPressed);
                    if (okPressed & new String(inputPw.getPassword()).equals(_mainuser.getPassword())) {
                        changePass = true;
                    }
                }
            }
            System.out.println(changePass);
            if (changePass) {
                if (!_mainuser.getAccountname().equals(textfield_pKontoname.getText()) | !_mainuser.getEmail().equals(textfield_pEmail1.getText())) {
                    User.deleteUser(_mainuser);
                }
                User.createUser(textfield_pKontoname.getText(), password_pPass1.getPassword(), textfield_pEmail1.getText(), textfield_pName.getText(), textfield_pSurename.getText(), _mainuser.getReg_date(), _mainuser.getLast_login(), _mainuser.getTime_played(), _mainuser.getUcoins());
                _mainuser = new User(textfield_pKontoname.getText());
            }
            panel_Profile.setVisible(false);
            JOptionPane.showMessageDialog(null, "Daten erfolgreich geändert!");
        }
    }//GEN-LAST:event_button_pSaveActionPerformed

    private void button_pCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pCancelActionPerformed
        panel_Profile.setVisible(false);
    }//GEN-LAST:event_button_pCancelActionPerformed

    private void KnowledgeBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KnowledgeBarMouseClicked
        if(_maingame.barNum==1){
            _maingame.barNum=0;    
        }else{          
            _maingame.barNum=1;         
        }
        _maingame.barClicked(activityPhase.studButtons); 
        if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetActivityPhaseOpacity();
                
            }           
        }
    }//GEN-LAST:event_KnowledgeBarMouseClicked

    private void MotivationBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MotivationBarMouseClicked
        if(_maingame.barNum==2){
            _maingame.barNum=0;
        }else{
            _maingame.barNum=2;
        }
        _maingame.barClicked(activityPhase.studButtons);
         if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetActivityPhaseOpacity();
            
            }           
        }
    }//GEN-LAST:event_MotivationBarMouseClicked

    private void TirednessBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TirednessBarMouseClicked
        if(_maingame.barNum==3){
            _maingame.barNum=0;
        }else{
            _maingame.barNum=3;
        }
        _maingame.barClicked(activityPhase.studButtons);
         if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetActivityPhaseOpacity();
            
            }           
        }
    }//GEN-LAST:event_TirednessBarMouseClicked

    private void jBut_DozentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_DozentMouseClicked
        // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
    }//GEN-LAST:event_jBut_DozentMouseClicked

    private void jComboB_ItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboB_ItemsMouseClicked
        // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
    }//GEN-LAST:event_jComboB_ItemsMouseClicked

    private void toggleButton_teamworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButton_teamworkActionPerformed
        if (!_maingame.teamwork){
            toggleButton_teamwork.setSelected(true);
            _maingame.shortBreak=false;
            toggleButton_shortBreak.setSelected(false);
            _maingame.teamwork=true;
            {button_stud1.setLocation(230, 10);
            button_stud2.setLocation(290, 10);
            button_stud3.setLocation(350, 10);
            button_stud4.setLocation(410, 10);
            button_stud5.setLocation(470, 10);
            button_stud6.setLocation(530, 10);
            button_stud7.setLocation(230, 90);
            button_stud8.setLocation(290, 90);
            button_stud9.setLocation(350, 90);
            button_stud10.setLocation(410, 90);
            button_stud11.setLocation(470, 90);
            button_stud12.setLocation(530, 90);
            button_stud13.setLocation(230, 180);
            button_stud14.setLocation(290, 180);
            button_stud15.setLocation(350, 180);
            button_stud16.setLocation(410,180);
            button_stud17.setLocation(470, 180);
            button_stud18.setLocation(530, 180);
            button_stud19.setLocation(230, 260);
            button_stud20.setLocation(290, 260);
            button_stud21.setLocation(350, 260);
            button_stud22.setLocation(410, 260);
            button_stud23.setLocation(470, 260);
            button_stud24.setLocation(530, 260);
            button_stud25.setLocation(230, 340);
            button_stud26.setLocation(290, 340);
            button_stud27.setLocation(350, 340);
            button_stud28.setLocation(410, 340);
            button_stud29.setLocation(470, 340);
            button_stud30.setLocation(530, 340);
            
            
            }
        }
        else {
            toggleButton_teamwork.setSelected(false);
            _maingame.teamwork=false;
            button_stud1.setLocation(120, 10);
            button_stud2.setLocation(220, 10);
            button_stud3.setLocation(330, 10);
            button_stud4.setLocation(430, 10);
            button_stud5.setLocation(540, 10);
            button_stud6.setLocation(640, 10);
            button_stud7.setLocation(120, 90);
            button_stud8.setLocation(220, 90);
            button_stud9.setLocation(330, 90);
            button_stud10.setLocation(430, 90);
            button_stud11.setLocation(540, 90);
            button_stud12.setLocation(640, 90);
            button_stud13.setLocation(120, 180);
            button_stud14.setLocation(220, 180);
            button_stud15.setLocation(330, 180);
            button_stud16.setLocation(430,180);
            button_stud17.setLocation(540, 180);
            button_stud18.setLocation(640, 180);
            button_stud19.setLocation(120, 260);
            button_stud20.setLocation(220, 260);
            button_stud21.setLocation(330, 260);
            button_stud22.setLocation(430, 260);
            button_stud23.setLocation(540, 260);
            button_stud24.setLocation(640, 260);
            button_stud25.setLocation(120, 340);
            button_stud26.setLocation(220, 340);
            button_stud27.setLocation(330, 340);
            button_stud28.setLocation(430, 340);
            button_stud29.setLocation(540, 340);
            button_stud30.setLocation(640, 340);
        }
    }//GEN-LAST:event_toggleButton_teamworkActionPerformed

    private void button_windowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_windowActionPerformed
        String test = button_window.getText();
        if (test.equals("Fenster : OFFEN")) {
            _maingame.windowClosed=true;
            button_window.setText("Fenster : ZU");
            if(_maingame.windowChangesNoise){
            _maingame.updateRoom(0, -10);
            _maingame.windowChangesNoise=false;
            }
            label_windowsclosed.setVisible(false);
        }
        if (test.equals("Fenster : ZU")) {
            _maingame.windowClosed=false;
            button_window.setText("Fenster : OFFEN");
            label_windowsclosed.setVisible(true);
        }
    }//GEN-LAST:event_button_windowActionPerformed

    private void toggleButton_shortBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButton_shortBreakActionPerformed
        if (!_maingame.shortBreak){
            toggleButton_shortBreak.setSelected(true);
            _maingame.teamwork=false;
            toggleButton_teamwork.setSelected(false);
            _maingame.shortBreak=true;
            System.out.println("You just started a break: " +_maingame.shortBreak);
        }
        else {
            toggleButton_shortBreak.setSelected(false);
            _maingame.shortBreak=false; 
            System.out.println("You just ended the break: " +_maingame.shortBreak);
        }
    }//GEN-LAST:event_toggleButton_shortBreakActionPerformed

    private void onmouseover_easteregg(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onmouseover_easteregg
        label_easteregg.setVisible(true);
    }//GEN-LAST:event_onmouseover_easteregg

    private void onmouseleave_easteregg(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onmouseleave_easteregg
        label_easteregg.setVisible(false);
    }//GEN-LAST:event_onmouseleave_easteregg

    private void login_backgroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_backgroundMouseEntered
       
    }//GEN-LAST:event_login_backgroundMouseEntered


    private void login_backgroundMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_backgroundMouseExited
  
    }//GEN-LAST:event_login_backgroundMouseExited

    private void jProgB_WissenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgB_WissenMouseClicked
        if(_maingame.barNum==1){
            _maingame.barNum=0;
        }else{
            _maingame.barNum=1;
        }
        _maingame.barClicked(planningPhaseButtons);
          if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetPlanningPhaseOpacity();
                
            }           
        }
    }//GEN-LAST:event_jProgB_WissenMouseClicked

    private void jProgB_MotivationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgB_MotivationMouseClicked
        if(_maingame.barNum==2){
            _maingame.barNum=0;
        }else{
            _maingame.barNum=2;
        }
        _maingame.barClicked(planningPhaseButtons);
              if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetPlanningPhaseOpacity();
                
            }           
        }
    }//GEN-LAST:event_jProgB_MotivationMouseClicked

    private void jProgB_MüdigkeitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgB_MüdigkeitMouseClicked
        if(_maingame.barNum==3){
            _maingame.barNum=0;
        }else{
            _maingame.barNum=3;
        }
        _maingame.barClicked(planningPhaseButtons);
              if(_maingame.barNum==0){
            {// set opacity on all buttons back
                SetPlanningPhaseOpacity();
                
            }           
        }
    }//GEN-LAST:event_jProgB_MüdigkeitMouseClicked

    private void jBut_OKnoCheatsAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_OKnoCheatsAvailableMouseClicked
        noCheatsAvailableDialog.setVisible(false);
    }//GEN-LAST:event_jBut_OKnoCheatsAvailableMouseClicked

    private void jBut_OKnotAllowedUseCheatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_OKnotAllowedUseCheatActionPerformed
      
    }//GEN-LAST:event_jBut_OKnotAllowedUseCheatActionPerformed

    private void jBut_OKnotAllowedUseCheatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_OKnotAllowedUseCheatMouseClicked
        notAllowedUseCheatDialog.setVisible(false);
    }//GEN-LAST:event_jBut_OKnotAllowedUseCheatMouseClicked

    private void button_dozent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dozent1ActionPerformed
      if (_maingame.lecturer_counter>0){
            label_dozent_action.setVisible(true);
            _maingame.quietingCounter=10;
            _maingame.lecturer_counter--;
        }
    }//GEN-LAST:event_button_dozent1ActionPerformed

    private void button_retryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_retryActionPerformed
        panel_gamePhases.setVisible(false);
        panel_menue.setVisible(true);
    }//GEN-LAST:event_button_retryActionPerformed

    private void button_stud1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud1StateChanged
     SetActivityPhaseOpacity();   
    }//GEN-LAST:event_button_stud1StateChanged

    private void button_stud2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud2StateChanged
     SetActivityPhaseOpacity();     
    }//GEN-LAST:event_button_stud2StateChanged

    private void button_stud3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud3StateChanged
      SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud3StateChanged

    private void button_stud4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud4StateChanged
   SetActivityPhaseOpacity();     // TODO add your handling code here:
    }//GEN-LAST:event_button_stud4StateChanged

    private void button_stud5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud5StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud5StateChanged

    private void button_stud6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud6StateChanged
     SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud6StateChanged

    private void button_stud7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud7StateChanged
   SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud7StateChanged

    private void button_stud8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud8StateChanged
     SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud8StateChanged

    private void button_stud9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud9StateChanged
    SetActivityPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_button_stud9StateChanged

    private void button_stud10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud10StateChanged
    SetActivityPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_button_stud10StateChanged

    private void button_stud11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud11StateChanged
    SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud11StateChanged

    private void button_stud12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud12StateChanged
   SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud12StateChanged

    private void button_stud13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud13StateChanged
    SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud13StateChanged

    private void button_stud14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud14StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud14StateChanged

    private void button_stud15StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud15StateChanged
    SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud15StateChanged

    private void button_stud16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud16StateChanged
    SetActivityPhaseOpacity();// TODO add your handling code here:
    }//GEN-LAST:event_button_stud16StateChanged

    private void button_stud17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud17StateChanged
   SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud17StateChanged

    private void button_stud18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud18StateChanged
      SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud18StateChanged

    private void button_stud19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud19StateChanged
     SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud19StateChanged

    private void button_stud20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud20StateChanged
      SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud20StateChanged

    private void button_stud21StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud21StateChanged
     SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud21StateChanged

    private void button_stud22StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud22StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud22StateChanged

    private void button_stud23StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud23StateChanged
   SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud23StateChanged

    private void button_stud24StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud24StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud24StateChanged

    private void button_stud25StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud25StateChanged
     SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud25StateChanged

    private void button_stud26StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud26StateChanged
      SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud26StateChanged

    private void button_stud27StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud27StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud27StateChanged

    private void button_stud28StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud28StateChanged
      SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud28StateChanged

    private void button_stud29StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud29StateChanged
     SetActivityPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_button_stud29StateChanged

    private void button_stud30StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_button_stud30StateChanged
   SetActivityPhaseOpacity(); // TODO add your handling code here:
    }//GEN-LAST:event_button_stud30StateChanged

    private void jBut_DozentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_DozentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBut_DozentActionPerformed

    private void jBut_15StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_15StateChanged
      SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_15StateChanged

    private void jBut_2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_2StateChanged
      SetPlanningPhaseOpacity();     // TODO add your handling code here:
    }//GEN-LAST:event_jBut_2StateChanged

    private void jBut_3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_3StateChanged
       SetPlanningPhaseOpacity();    // TODO add your handling code here:
    }//GEN-LAST:event_jBut_3StateChanged

    private void jBut_4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_4StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_4StateChanged

    private void jBut_5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_5StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_5StateChanged

    private void jBut_6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_6StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_6StateChanged

    private void jBut_7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_7StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_7StateChanged

    private void jBut_8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_8StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_8StateChanged

    private void jBut_9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_9StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_9StateChanged

    private void jBut_12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_12StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_12StateChanged

    private void jBut_11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_11StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_11StateChanged

    private void jBut_10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_10StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_10StateChanged

    private void jBut_14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_14StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_14StateChanged

    private void jBut_13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_13StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_13StateChanged

    private void jBut_16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_16StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_16StateChanged

    private void jBut_17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_17StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_17StateChanged

    private void jBut_18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_18StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_18StateChanged

    private void jBut_19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_19StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_19StateChanged

    private void jBut_20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_20StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_20StateChanged

    private void jBut_21StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_21StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_21StateChanged

    private void jBut_22StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_22StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_22StateChanged

    private void jBut_23StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_23StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_23StateChanged

    private void jBut_24StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_24StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_24StateChanged

    private void jBut_25StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_25StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_25StateChanged

    private void jBut_26StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_26StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_26StateChanged

    private void jBut_27StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_27StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_27StateChanged

    private void jBut_28StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_28StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_28StateChanged

    private void jBut_29StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_29StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_29StateChanged

    private void jBut_30StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_30StateChanged
        SetPlanningPhaseOpacity();   // TODO add your handling code here:
    }//GEN-LAST:event_jBut_30StateChanged

    private void jBut_1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBut_1StateChanged
         SetPlanningPhaseOpacity();  // TODO add your handling code here:
    }//GEN-LAST:event_jBut_1StateChanged

    private void jBut_confirmExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_confirmExitMouseClicked
         // if the toggleButton is clicked for switching student and not a student the button will be deselected
        jToggleBut_SwitchStud.setSelected(false);
        
        endTime = System.currentTimeMillis();
        _mainuser.setTime_played(_mainuser.getTime_played()+(endTime - startTime));
        
        panel_gamePhases.setVisible(false);
        User.saveUser();
        Game1.saveGame();
        panel_menue.setVisible(true);
        warningExitPlanningPhase.setVisible(false);
    }//GEN-LAST:event_jBut_confirmExitMouseClicked

    private void jBut_cancelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBut_cancelExitMouseClicked
        // TODO add your handling code here:
        warningExitPlanningPhase.setVisible(false);
    }//GEN-LAST:event_jBut_cancelExitMouseClicked

    private void button_shopReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_shopReturnActionPerformed
        // Returns from the shop back to the planning phase
        User.saveUser();
        Game1.saveGame();
        cl.show(panel_gamePhases, "card3");
        //planningPhase.startPlanningPhase();
        panel_menue.setVisible(false);  
    }//GEN-LAST:event_button_shopReturnActionPerformed

    private void button_statsErrorOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_statsErrorOKActionPerformed
        dialog_statsError.setVisible(false);
    }//GEN-LAST:event_button_statsErrorOKActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        User.saveLastLogin();
    }//GEN-LAST:event_formWindowClosed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sims_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sims_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sims_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sims_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Sims_1().setVisible(true);
            }
        });
    }
    public static JButton button_afterGame; // Button used after a minigame added by Jannik
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar AirBar;
    private javax.swing.JPanel Header;
    private javax.swing.JProgressBar KnowledgeBar;
    private javax.swing.JPanel Logo;
    private javax.swing.JLabel Menu_overlay;
    private javax.swing.JLabel Menu_overlay1;
    private javax.swing.JProgressBar MotivationBar;
    private javax.swing.JPanel Navi;
    private javax.swing.JProgressBar NoiseBar;
    private javax.swing.JPanel Shop;
    private javax.swing.JPanel StudField;
    private javax.swing.JProgressBar TirednessBar;
    private javax.swing.JLabel background_admin;
    private javax.swing.JLabel background_adminUser;
    private javax.swing.JLabel background_register;
    private javax.swing.JButton buton_enterAdmin;
    private javax.swing.JButton button_Login;
    private javax.swing.JToggleButton button_Register;
    private javax.swing.JButton button_aCancel;
    private javax.swing.JButton button_aDelete;
    private javax.swing.JButton button_aSave;
    private javax.swing.JButton button_auCancel1;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_dozent1;
    private javax.swing.JButton button_menuCredits;
    private javax.swing.JButton button_menuExit;
    private javax.swing.JButton button_menuLoadGame;
    private javax.swing.JButton button_menuLogOut;
    private javax.swing.JButton button_menuProfile;
    private javax.swing.JButton button_menuStartNewGame;
    private javax.swing.JButton button_menuStatistic;
    private javax.swing.JButton button_pCancel;
    private javax.swing.JButton button_pSave;
    private javax.swing.JButton button_rRegister;
    private javax.swing.JButton button_retry;
    private javax.swing.JButton button_shopMessageOk;
    private javax.swing.JButton button_shopReturn;
    private javax.swing.JButton button_startExchange;
    private javax.swing.JButton button_statsErrorOK;
    private javax.swing.JButton button_stud1;
    private javax.swing.JButton button_stud10;
    private javax.swing.JButton button_stud11;
    private javax.swing.JButton button_stud12;
    private javax.swing.JButton button_stud13;
    private javax.swing.JButton button_stud14;
    private javax.swing.JButton button_stud15;
    private javax.swing.JButton button_stud16;
    private javax.swing.JButton button_stud17;
    private javax.swing.JButton button_stud18;
    private javax.swing.JButton button_stud19;
    private javax.swing.JButton button_stud2;
    private javax.swing.JButton button_stud20;
    private javax.swing.JButton button_stud21;
    private javax.swing.JButton button_stud22;
    private javax.swing.JButton button_stud23;
    private javax.swing.JButton button_stud24;
    private javax.swing.JButton button_stud25;
    private javax.swing.JButton button_stud26;
    private javax.swing.JButton button_stud27;
    private javax.swing.JButton button_stud28;
    private javax.swing.JButton button_stud29;
    private javax.swing.JButton button_stud3;
    private javax.swing.JButton button_stud30;
    private javax.swing.JButton button_stud4;
    private javax.swing.JButton button_stud5;
    private javax.swing.JButton button_stud6;
    private javax.swing.JButton button_stud7;
    private javax.swing.JButton button_stud8;
    private javax.swing.JButton button_stud9;
    private javax.swing.JButton button_swapperAbord;
    private javax.swing.JButton button_swapperExchange;
    private javax.swing.JButton button_window;
    private javax.swing.JDialog buyCoins;
    private javax.swing.JCheckBox check_autoLogin;
    private javax.swing.JCheckBox check_saveUser;
    private javax.swing.JLabel creditsShop;
    private javax.swing.JDialog dialog_error;
    private javax.swing.JDialog dialog_examResults;
    private javax.swing.JDialog dialog_statsError;
    private javax.swing.JPanel gamePlanning;
    private javax.swing.JPanel gamePlaying;
    private javax.swing.JButton jBut_1;
    private javax.swing.JButton jBut_10;
    private javax.swing.JButton jBut_11;
    private javax.swing.JButton jBut_12;
    private javax.swing.JButton jBut_13;
    private javax.swing.JButton jBut_14;
    private javax.swing.JButton jBut_15;
    private javax.swing.JButton jBut_16;
    private javax.swing.JButton jBut_17;
    private javax.swing.JButton jBut_18;
    private javax.swing.JButton jBut_19;
    private javax.swing.JButton jBut_2;
    private javax.swing.JButton jBut_20;
    private javax.swing.JButton jBut_21;
    private javax.swing.JButton jBut_22;
    private javax.swing.JButton jBut_23;
    private javax.swing.JButton jBut_24;
    private javax.swing.JButton jBut_25;
    private javax.swing.JButton jBut_26;
    private javax.swing.JButton jBut_27;
    private javax.swing.JButton jBut_28;
    private javax.swing.JButton jBut_29;
    private javax.swing.JButton jBut_3;
    private javax.swing.JButton jBut_30;
    private javax.swing.JButton jBut_4;
    private javax.swing.JButton jBut_5;
    private javax.swing.JButton jBut_6;
    private javax.swing.JButton jBut_7;
    private javax.swing.JButton jBut_8;
    private javax.swing.JButton jBut_9;
    private javax.swing.JButton jBut_ChangeProfessor;
    private javax.swing.JButton jBut_Dozent;
    private javax.swing.JButton jBut_JA;
    private javax.swing.JButton jBut_NEIN;
    private javax.swing.JButton jBut_OKlector;
    private javax.swing.JButton jBut_OKnoCheatsAvailable;
    private javax.swing.JButton jBut_OKnotAllowedUseCheat;
    private javax.swing.JButton jBut_OKnotchanged;
    private javax.swing.JButton jBut_Play;
    private javax.swing.JButton jBut_cancelExit;
    private javax.swing.JButton jBut_confirmExit;
    private javax.swing.JButton jBut_startShop;
    private javax.swing.JComboBox jComboB_Items;
    private javax.swing.JLabel jLab_DozCounter;
    private javax.swing.JLabel jLab_DozSwitch;
    private javax.swing.JLabel jLab_DozSwitch1;
    private javax.swing.JLabel jLab_DozSwitch2;
    private javax.swing.JLabel jLab_Duplo;
    private javax.swing.JLabel jLab_OMNI;
    private javax.swing.JLabel jLab_Planning_unused01;
    private javax.swing.JLabel jLab_Planning_unused02;
    private javax.swing.JLabel jLab_Planning_unused03;
    private javax.swing.JLabel jLab_Planning_unused04;
    private javax.swing.JLabel jLab_Planning_unused05;
    private javax.swing.JLabel jLab_Planning_unused06;
    private javax.swing.JLabel jLab_Planning_unused07;
    private javax.swing.JLabel jLab_Planning_unused08;
    private javax.swing.JLabel jLab_Planning_unused09;
    private static javax.swing.JLabel jLab_Redbull;
    private javax.swing.JLabel jLab_StudCounter;
    private javax.swing.JLabel jLab_StudSwitch;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPan_DozSwitch;
    private javax.swing.JPanel jPan_ItemSelect;
    private javax.swing.JPanel jPan_ItemStorage;
    private javax.swing.JPanel jPan_Planning_Play;
    private javax.swing.JPanel jPan_StudSwitch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgB_Motivation;
    private javax.swing.JProgressBar jProgB_Müdigkeit;
    private javax.swing.JProgressBar jProgB_Wissen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JToggleButton jToggleBut_SwitchStud;
    private javax.swing.JLabel label_GameFieldOverlay;
    private javax.swing.JLabel label_PlanningPhaseoverlay;
    private javax.swing.JLabel label_aAccname;
    private javax.swing.JLabel label_aCredits;
    private javax.swing.JLabel label_aDuplo;
    private javax.swing.JLabel label_aEmail;
    private javax.swing.JLabel label_aErrAccName;
    private javax.swing.JLabel label_aErrCredits;
    private javax.swing.JLabel label_aErrDuplo;
    private javax.swing.JLabel label_aErrEmail;
    private javax.swing.JLabel label_aErrFirstName;
    private javax.swing.JLabel label_aErrLastName;
    private javax.swing.JLabel label_aErrOmni;
    private javax.swing.JLabel label_aErrPass;
    private javax.swing.JLabel label_aErrRedBull;
    private javax.swing.JLabel label_aErrSpicker;
    private javax.swing.JLabel label_aErrUCoins;
    private javax.swing.JLabel label_aFirstName;
    private javax.swing.JLabel label_aGame;
    private javax.swing.JLabel label_aLastName;
    private javax.swing.JLabel label_aMonth;
    private javax.swing.JLabel label_aMonthVal;
    private javax.swing.JLabel label_aOMNI;
    private javax.swing.JLabel label_aPass;
    private javax.swing.JLabel label_aRedBull;
    private javax.swing.JLabel label_aSpicker;
    private javax.swing.JLabel label_aUCions;
    private javax.swing.JLabel label_cheatSheetAmount;
    private javax.swing.JLabel label_cheatSheetImage;
    private javax.swing.JLabel label_cheatSheetLocked;
    private javax.swing.JLabel label_cheatSheetName;
    private javax.swing.JLabel label_cheatSheetOverlay;
    private javax.swing.JLabel label_creditsCopyright;
    private javax.swing.JLabel label_creditsHeadline;
    private javax.swing.JLabel label_creditsHeadline1;
    private javax.swing.JLabel label_creditsInv;
    private javax.swing.JLabel label_creditsNames;
    private javax.swing.JLabel label_creditsSIMS;
    private javax.swing.JLabel label_currentExchange;
    private javax.swing.JLabel label_dozent_action;
    private javax.swing.JLabel label_duploAmount;
    private javax.swing.JLabel label_duploImage;
    private javax.swing.JLabel label_duploLocked;
    private javax.swing.JLabel label_duploName;
    private javax.swing.JLabel label_duploOverlay;
    private javax.swing.JLabel label_easteregg;
    private javax.swing.JLabel label_eastereggtrigger;
    private javax.swing.JLabel label_examFailed;
    private javax.swing.JLabel label_examFailedText;
    private javax.swing.JLabel label_examHeading;
    private javax.swing.JLabel label_examRemaining;
    private javax.swing.JLabel label_examRemainingText1;
    private javax.swing.JLabel label_examRemainingText2;
    private javax.swing.JLabel label_gameOver;
    private javax.swing.JLabel label_gameOverPoints;
    private javax.swing.JLabel label_gameOverSemester;
    private javax.swing.JLabel label_handcursor;
    private javax.swing.JLabel label_handcursor1;
    private javax.swing.JLabel label_handcursor2;
    private javax.swing.JLabel label_handcursor3;
    private javax.swing.JLabel label_handcursor4;
    private javax.swing.JLabel label_handcursor5;
    private javax.swing.JLabel label_handcursor6;
    private javax.swing.JLabel label_inventar;
    private javax.swing.JLabel label_item1;
    private javax.swing.JLabel label_item1Amount;
    private javax.swing.JLabel label_item1Inv;
    private javax.swing.JLabel label_item1InvAmount;
    private javax.swing.JLabel label_item1InvName;
    private javax.swing.JLabel label_item1Name;
    private javax.swing.JLabel label_item2;
    private javax.swing.JLabel label_item2Amount;
    private javax.swing.JLabel label_item2Inv;
    private javax.swing.JLabel label_item2InvAmount;
    private javax.swing.JLabel label_item2InvName;
    private javax.swing.JLabel label_item2Name;
    private javax.swing.JLabel label_item3;
    private javax.swing.JLabel label_item3Amount;
    private javax.swing.JLabel label_item3Inv;
    private javax.swing.JLabel label_item3InvAmount;
    private javax.swing.JLabel label_item3InvName;
    private javax.swing.JLabel label_item3Name;
    private javax.swing.JLabel label_item4;
    private javax.swing.JLabel label_item4Amount;
    private javax.swing.JLabel label_item4Name;
    private javax.swing.JLabel label_knowledgeBar_overlay;
    private javax.swing.JLabel label_lErr;
    private javax.swing.JLabel label_laptop1;
    private javax.swing.JLabel label_laptop10;
    private javax.swing.JLabel label_laptop11;
    private javax.swing.JLabel label_laptop12;
    private javax.swing.JLabel label_laptop13;
    private javax.swing.JLabel label_laptop14;
    private javax.swing.JLabel label_laptop15;
    private javax.swing.JLabel label_laptop16;
    private javax.swing.JLabel label_laptop17;
    private javax.swing.JLabel label_laptop18;
    private javax.swing.JLabel label_laptop19;
    private javax.swing.JLabel label_laptop2;
    private javax.swing.JLabel label_laptop20;
    private javax.swing.JLabel label_laptop21;
    private javax.swing.JLabel label_laptop22;
    private javax.swing.JLabel label_laptop23;
    private javax.swing.JLabel label_laptop24;
    private javax.swing.JLabel label_laptop25;
    private javax.swing.JLabel label_laptop26;
    private javax.swing.JLabel label_laptop27;
    private javax.swing.JLabel label_laptop28;
    private javax.swing.JLabel label_laptop29;
    private javax.swing.JLabel label_laptop3;
    private javax.swing.JLabel label_laptop30;
    private javax.swing.JLabel label_laptop4;
    private javax.swing.JLabel label_laptop5;
    private javax.swing.JLabel label_laptop6;
    private javax.swing.JLabel label_laptop7;
    private javax.swing.JLabel label_laptop8;
    private javax.swing.JLabel label_laptop9;
    private javax.swing.JLabel label_loginlogobig;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_logo_planning;
    private javax.swing.JLabel label_logo_playing;
    private javax.swing.JLabel label_omniAmount;
    private javax.swing.JLabel label_omniAudioImage;
    private javax.swing.JLabel label_omniLocked;
    private javax.swing.JLabel label_omniName;
    private javax.swing.JLabel label_omniOverlay;
    private javax.swing.JLabel label_pEmail1;
    private javax.swing.JLabel label_pEmail2;
    private javax.swing.JLabel label_pErrAccname;
    private javax.swing.JLabel label_pErrEmail1;
    private javax.swing.JLabel label_pErrEmail2;
    private javax.swing.JLabel label_pErrFirstName;
    private javax.swing.JLabel label_pErrLastName;
    private javax.swing.JLabel label_pErrPass1;
    private javax.swing.JLabel label_pErrPass2;
    private javax.swing.JLabel label_pFirstName;
    private javax.swing.JLabel label_pKontoname;
    private javax.swing.JLabel label_pPass1;
    private javax.swing.JLabel label_pPass2;
    private javax.swing.JLabel label_pSecondName;
    private javax.swing.JLabel label_rEmail1;
    private javax.swing.JLabel label_rEmail2;
    private javax.swing.JLabel label_rErrAccname;
    private javax.swing.JLabel label_rErrEmail1;
    private javax.swing.JLabel label_rErrEmail2;
    private javax.swing.JLabel label_rErrFirstName;
    private javax.swing.JLabel label_rErrLastName;
    private javax.swing.JLabel label_rErrPass1;
    private javax.swing.JLabel label_rErrPass2;
    private javax.swing.JLabel label_rFirstName;
    private javax.swing.JLabel label_rKontoname;
    private javax.swing.JLabel label_rPass1;
    private javax.swing.JLabel label_rPass2;
    private javax.swing.JLabel label_rSecondName;
    private javax.swing.JLabel label_redBullAmount;
    private javax.swing.JLabel label_redBullImage;
    private javax.swing.JLabel label_redBullLocked;
    private javax.swing.JLabel label_redBullName;
    private javax.swing.JLabel label_redBullOverlay;
    private javax.swing.JLabel label_score;
    private javax.swing.JLabel label_semester;
    private javax.swing.JLabel label_shopCreditsName;
    private javax.swing.JLabel label_shopMessage;
    private javax.swing.JLabel label_shopMessage1;
    private javax.swing.JLabel label_shopMessage2;
    private javax.swing.JLabel label_shopMessage3;
    private javax.swing.JLabel label_shopName;
    private javax.swing.JLabel label_shopPointsName;
    private javax.swing.JLabel label_shopRemainingSemesters;
    private javax.swing.JLabel label_shopRemainingStudents;
    private javax.swing.JLabel label_shopSemester;
    private javax.swing.JLabel label_shopStudents;
    private javax.swing.JLabel label_shopUCoinsName;
    private javax.swing.JLabel label_statsCurrentCredits;
    private javax.swing.JLabel label_statsEarnedCredits;
    private javax.swing.JLabel label_statsErrorHeadline;
    private javax.swing.JLabel label_statsErrorText1;
    private javax.swing.JLabel label_statsErrorText2;
    private javax.swing.JLabel label_statsErrorText3;
    private javax.swing.JLabel label_statsHeadline;
    private javax.swing.JLabel label_statsOverallTime;
    private javax.swing.JLabel label_statsPoints;
    private javax.swing.JLabel label_statsRate;
    private javax.swing.JLabel label_statsSemester;
    private javax.swing.JLabel label_statsStudentArrtibutes;
    private javax.swing.JLabel label_students;
    private javax.swing.JLabel label_swapper;
    private javax.swing.JLabel label_swapperArrow1;
    private javax.swing.JLabel label_swapperArrow3;
    private javax.swing.JLabel label_swapperCredits;
    private javax.swing.JLabel label_swapperCreditsAmount;
    private javax.swing.JLabel label_swapperUcoins;
    private javax.swing.JLabel label_swapperUcoinsAmount;
    private javax.swing.JLabel label_timer;
    private javax.swing.JLabel label_ucoinsInv;
    private javax.swing.JLabel label_warning1;
    private javax.swing.JLabel label_warning2;
    private javax.swing.JLabel label_warning3;
    private javax.swing.JLabel label_warning5;
    private javax.swing.JLabel label_windowsclosed;
    private javax.swing.JLabel lable_aProfil;
    private javax.swing.JLabel llabel_warning4;
    private javax.swing.JLabel loggedinas;
    private javax.swing.JLabel login_background;
    private javax.swing.JDialog noCheatsAvailableDialog;
    private javax.swing.JLabel noSave_overlay;
    private javax.swing.JDialog notAllowedUseCheatDialog;
    private javax.swing.JPanel panel_Admin;
    private javax.swing.JPanel panel_Credits;
    private javax.swing.JPanel panel_Login;
    private javax.swing.JPanel panel_Profile;
    private javax.swing.JPanel panel_Register;
    private javax.swing.JPanel panel_activityPhaseStudField;
    private javax.swing.JPanel panel_adminUser;
    private javax.swing.JPanel panel_cheatSheet;
    private javax.swing.JPanel panel_duplo;
    private javax.swing.JPanel panel_gameOver;
    private javax.swing.JPanel panel_gamePhases;
    private javax.swing.JPanel panel_logoarea;
    private javax.swing.JPanel panel_menue;
    private javax.swing.JPanel panel_omniSense;
    private javax.swing.JPanel panel_redBull;
    private javax.swing.JPanel panel_shopBackMainmenu;
    private javax.swing.JPanel panel_shopBackPlanningPhase;
    private javax.swing.JPanel panel_shopHeadline;
    private javax.swing.JPanel panel_shopInventory;
    private javax.swing.JPanel panel_shopItems;
    private javax.swing.JPanel panel_stats;
    private javax.swing.JPanel panel_timerarea;
    private javax.swing.JPasswordField password_Pass;
    private javax.swing.JPasswordField password_pPass1;
    private javax.swing.JPasswordField password_pPass2;
    private javax.swing.JPasswordField password_rPass1;
    private javax.swing.JPasswordField password_rPass2;
    private javax.swing.JDialog professorChangedDialog;
    private javax.swing.JDialog professorNotChangedDialog;
    private javax.swing.JLabel punkteShop;
    private javax.swing.JPanel shop;
    private javax.swing.JSlider slider_aMonth;
    private javax.swing.JLabel text_air;
    private javax.swing.JLabel text_backtomenue1;
    private javax.swing.JLabel text_backtomenue2;
    private javax.swing.JLabel text_inventar;
    private javax.swing.JLabel text_motivation;
    private javax.swing.JLabel text_noise;
    private javax.swing.JLabel text_score;
    private javax.swing.JLabel text_semester;
    private javax.swing.JLabel text_students;
    private javax.swing.JLabel text_tiredness;
    private javax.swing.JLabel text_wissen;
    private javax.swing.JTextField textfield_Kontoname;
    private javax.swing.JTextField textfield_aCredits;
    private javax.swing.JTextField textfield_aDuplo;
    private javax.swing.JTextField textfield_aEmail;
    private javax.swing.JTextField textfield_aKontoname;
    private javax.swing.JTextField textfield_aName;
    private javax.swing.JTextField textfield_aOMNI;
    private javax.swing.JTextField textfield_aPass;
    private javax.swing.JTextField textfield_aRedBull;
    private javax.swing.JTextField textfield_aSpicker;
    private javax.swing.JTextField textfield_aSurename;
    private javax.swing.JTextField textfield_aUCoins;
    private javax.swing.JTextField textfield_pEmail1;
    private javax.swing.JTextField textfield_pEmail2;
    private javax.swing.JTextField textfield_pKontoname;
    private javax.swing.JTextField textfield_pName;
    private javax.swing.JTextField textfield_pSurename;
    private javax.swing.JTextField textfield_rEmail1;
    private javax.swing.JTextField textfield_rEmail2;
    private javax.swing.JTextField textfield_rKontoname;
    private javax.swing.JTextField textfield_rName;
    private javax.swing.JTextField textfield_rSurename;
    private javax.swing.JTextField textfield_swapperCredits;
    private javax.swing.JTextField textfield_swapperUcoins;
    private javax.swing.JToggleButton toggleButton_shortBreak;
    private javax.swing.JToggleButton toggleButton_teamwork;
    private javax.swing.JLabel ucoinsShop;
    private javax.swing.JDialog warningDialog;
    private javax.swing.JDialog warningExitPlanningPhase;
    // End of variables declaration//GEN-END:variables

    //***********************************************************************  /by Dawid
    //*****************LogIn/Register: start*********************************
    //***********************************************************************
    /**
     * Initializes the fields and labels for the register-form
     */
    private void initRegister() {
        label_rErrAccname.setText("");
        label_rErrEmail1.setText("");
        label_rErrEmail2.setText("");
        label_rErrFirstName.setText("");
        label_rErrPass1.setText("");
        label_rErrPass2.setText("");
        label_rErrLastName.setText("");

        textfield_rEmail1.setText("");
        textfield_rEmail2.setText("");
        textfield_rKontoname.setText("");
        textfield_rName.setText("");
        textfield_rSurename.setText("");
        password_rPass1.setText("");
        password_rPass2.setText("");

        textfield_rEmail1.setBackground(Color.white);
        textfield_rEmail2.setBackground(Color.white);
        textfield_rKontoname.setBackground(Color.white);
        textfield_rName.setBackground(Color.white);
        textfield_rSurename.setBackground(Color.white);
        password_rPass1.setBackground(Color.white);
        password_rPass2.setBackground(Color.white);
    }

    /**
     * Checks if the value consists of letters and/or numbers
     *
     * @param str character-array to get checked
     * @return true if there are only letters and/or numbers, false otherwise
     */
    public static boolean checkAlphaNumm(char[] str) {     //checks if a string contains only of numbers and letters
        int i;
        for (i = 0; i < str.length; i++) {
            if (!(Character.isDigit(str[i]) | Character.isLetter(str[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the passed value is a valid email-address (syntax-wise)
     *
     * @param str String with the email-address to check
     * @return true if the email-address is correct, false otherwise
     */
    public static boolean checkEmail(String str) {
        int i;
        boolean atChar = false;
        if (!str.contains(".")) {
            return false;
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                if (atChar) {
                    return false;
                } else {
                    atChar = true;
                }
            }
        }
        if (atChar) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the passed value is a valid name: -not empty -only letters and
     * "-" allowed
     *
     * @param str String containing the name to check
     * @return true if it is a valid name, false otherwise
     */
    public static boolean checkName(String str) {
        if (str.equals("")) {
            return false;
        }
        int i;
        for (i = 0; i < str.length(); i++) {
            if (!(Character.isLetter(str.charAt(i)) | str.charAt(i) == '-')) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkGlobUserVar(JTextField[] input, JLabel[] errMess) {
        JTextField[] test1 = {new JTextField("t"), input[1]};
        JTextField[] test2 = {input[0], new JTextField("t")};
        return checkGlobUser(test1, errMess) & checkGlobUser(test2, errMess);
    }

    /**
     * Checks in the global user-file if the user already exists
     *
     * @param str String with the name of the user to check
     * @return true if user already exists, false otherwise
     */
    public static boolean checkGlobUser(JTextField[] input, JLabel[] errMess) {

        try {
            java.util.LinkedList<java.util.LinkedList> list = CSVHandling.readCSV(Sims_1._usersFileName);
            for (java.util.LinkedList sublist : list) {
                if (sublist.contains(input[0].getText())) {
                    errMess[0].setText("Kontoname schon vergeben!");
                    input[0].setBackground(Color.red);
                    return true;
                } else {
                    errMess[0].setText("");
                    input[0].setBackground(Color.white);
                }
                if (sublist.contains(input[1].getText())) {
                    errMess[1].setText("Email schon in Benutzung!");
                    input[1].setBackground(Color.red);
                    return true;
                } else {
                    errMess[1].setText("");
                    input[1].setBackground(Color.white);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean checkRegister_(JComponent[] toCheck, JLabel[] errMess) {
        JTextField account = (JTextField) toCheck[0];
        JPasswordField pass1 = (JPasswordField) toCheck[1];
        JPasswordField pass2 = (JPasswordField) toCheck[2];
        JTextField email1 = (JTextField) toCheck[3];
        JTextField email2 = (JTextField) toCheck[4];
        JTextField name = (JTextField) toCheck[5];
        JTextField lastName = (JTextField) toCheck[6];

        boolean check = true;
        if (account.getText().length() < 5) {
            account.setBackground(Color.red);
            errMess[0].setText("Kontoname zu kurz! (5-15 Zeichen)");
            check = false;
        } else if (account.getText().length() > 15) {
            account.setBackground(Color.red);
            errMess[0].setText("Kontoname zu lang! (5-15 Zeichen)");
            check = false;
        } else if (!checkAlphaNumm(account.getText().toCharArray())) {
            account.setBackground(Color.red);
            errMess[0].setText("Kontoname verwendet Sonderzeichen!");
        } else {
            account.setBackground(Color.white);
            errMess[0].setText("");
        }

        if (pass1.getPassword().length < 5) {
            pass1.setBackground(Color.red);
            pass2.setText("");
            errMess[1].setText("Passwort zu kurz! (5-15 Zeichen)");
            check = false;
        } else if (pass1.getPassword().length > 15) {
            pass1.setBackground(Color.red);
            pass2.setText("");
            errMess[1].setText("Passwort zu lang! (5-15 Zeichen)");
            check = false;
        } else if (!checkAlphaNumm(pass1.getPassword())) {
            pass1.setBackground(Color.red);
            pass2.setText("");
            errMess[1].setText("Passwort verwendet Sonderzeichen!");
            check = false;
        } else {
            pass1.setBackground(Color.white);
            errMess[1].setText("");


            if (!new String(pass1.getPassword()).equals(new String(pass2.getPassword()))) {
                pass1.setBackground(Color.red);
                pass2.setBackground(Color.red);
                errMess[2].setText("Passwörter stimmen nicht überein!");
                check = false;
            } else {
                pass1.setBackground(Color.white);
                pass2.setBackground(Color.white);
                errMess[2].setText("");
            }
        }

        if (email1.getText().length() < 5 | !checkEmail(email1.getText())) {
            email1.setBackground(Color.red);
            check = false;
            errMess[3].setText("Ungültige Adresse!");
            if (!email1.equals(email2)) {
                email2.setText("");
            };
        } else {
            email1.setBackground(Color.white);
            errMess[3].setText("");


            if (!email1.getText().equals(email2.getText())) {
                email1.setBackground(Color.red);
                email2.setBackground(Color.red);
                errMess[4].setText("Emails stimmen nicht überein!");
                check = false;
            } else {
                email1.setBackground(Color.white);
                email2.setBackground(Color.white);
                errMess[4].setText("");
            }
        }

        if (!checkName(name.getText())) {
            name.setBackground(Color.red);
            errMess[5].setText("Kein gültiger Name!");
            check = false;
        } else {
            name.setBackground(Color.white);
            errMess[5].setText("");
        }

        if (!checkName(lastName.getText())) {
            lastName.setBackground(Color.red);
            errMess[6].setText("Kein gültiger Nachname!");
            check = false;
        } else {
            errMess[6].setText("");
            lastName.setBackground(Color.white);
        }

        if (check) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the entered login-data is correct; user gets feedback to the
     * invalid input after this function is called
     *
     * @param accountname String containing the username
     * @param password Character-array containing the password
     * @return true if the login-data is correct, false otherwise
     */
    private boolean checkLogIn(String accountname, char[] password) {

        if (accountname.equals(_adminName) & new String(password).equals(_adminPass)) {
            adminLogin();
            return false;
        }

        if (accountname.equals("")) {
            label_lErr.setText("Falscher Benutzername oder falsches Passwort!");
            return false;
        }
        String userlist = "";
        try {
            userlist = CSVHandling.readCSVString(Sims_1._usersFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlist.contains(accountname)) {
            String userPw = "";
            try {
                userPw = CSVHandling.readCSVStringArr(Sims_1._dataFolderName + "/" + accountname + "/" + Sims_1._profileFileName)[1];
                //loggedinas.setText("Eingeloggt als: " + accountname); // by nadir , currentuser
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (userPw.contentEquals(new String(password))) {
                return true;
            }
        }
        label_lErr.setText("Falscher Benutzername oder falsches Passwort!");
        return false;
    }

    /**
     * Logs the user into the program; writes the login-file used to save the
     * user or enable auto-login
     *
     * @param accountname String with the username
     */
    private void logIn(String accountname) {
        String[] strArr = new String[3];
        if (check_saveUser.isSelected()) {
            strArr[0] = textfield_Kontoname.getText();
            strArr[1] = new String(password_Pass.getPassword());
            if (check_autoLogin.isSelected()) {
                strArr[2] = "1";
            } else {
                strArr[2] = "0";
            }
        } else {
            strArr[0] = "";
            strArr[1] = "";
            strArr[2] = "0";
        }
        try {
            CSVHandling.writeCSV(strArr, _loginFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        _mainuser = new User(accountname);
        //_maingame = new Game1();
//        CSVRead read = new CSVRead();
//        try {
//            read.readCSV();
//        } catch (Exception ex) {
//            Logger.getLogger(Sims_1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        panel_Login.setVisible(false);
        panel_menue.setVisible(true);
        if (!new File(_dataFolderName + "/" + _mainuser.getAccountname() + "/" + _gameFileName).exists()) {
            noSave_overlay.setVisible(true);
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-y");
        loggedinas.setText("<html><body>Eingeloggt als: " + _mainuser.getAccountname() + "<br>Letzter Login: " + format.format(_mainuser.getLast_login()) + "</body></html>");
        System.out.println(noSave_overlay.isVisible());
        System.out.println(_mainuser);
    }

    /**
     * Standardized login with a fictional user, just for dev-purposes
     */
    @Deprecated private void logIn() {
        _mainuser = new User();  //by Dawid
        _maingame = new Game1();
        CSVRead read = new CSVRead();
        try {
            read.readCSV();
        } catch (Exception ex) {
            Logger.getLogger(Sims_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel_Login.setVisible(false);
        panel_Admin.setVisible(false);
        panel_adminUser.setVisible(false);
        panel_menue.setVisible(true);
        System.out.println(_mainuser);
    }

    private void logOut() {
        _mainuser = null;
        _maingame = null;
        panel_Profile.setVisible(false);
        check_autoLogin.setSelected(false);
        panel_menue.setVisible(false);
        panel_Login.setVisible(true);

    }

    /**
     * Reads the login file and writes the saved values into the login-fields;
     * if the auto-login-flag is set logIn(username) is called
     */
    private void autoLogin() {
        try {
            String[] loginArr = CSVHandling.readCSVStringArr(_loginFileName);
            if (!loginArr[0].equals("")) {
                check_saveUser.setSelected(true);
            }
            textfield_Kontoname.setText(loginArr[0]);
            password_Pass.setText(loginArr[1]);
            if (loginArr[2].matches("1")) {
                check_autoLogin.setSelected(true);
                if (checkLogIn(loginArr[0], loginArr[1].toCharArray())) {
                    logIn(loginArr[0]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adminLogin() {
        panel_Login.setVisible(false);
        panel_Admin.setVisible(true);
        panel_adminUser.setVisible(false);
        JTextField[] textFieldHelp = {textfield_aKontoname, textfield_aPass, textfield_aEmail, textfield_aName, textfield_aSurename, textfield_aUCoins, textfield_aCredits, textfield_aDuplo, textfield_aRedBull, textfield_aOMNI, textfield_aSpicker};
        JLabel[] errMess = {label_aErrAccName, label_aErrPass, label_aErrEmail, label_aErrFirstName, label_aErrLastName, label_aErrUCoins, label_aErrCredits, label_aErrDuplo, label_aErrRedBull, label_aErrOmni, label_aErrSpicker};
        _mainadmin = new Admin(panel_Admin, panel_adminUser, textFieldHelp, slider_aMonth, errMess);
        panel_Admin.add(button_aCancel);
        panel_Admin.add(background_admin);

    }

    private void initProfile() {
        label_pErrEmail1.setText("");
        label_pErrAccname.setText("");
        label_pErrEmail2.setText("");
        label_pErrFirstName.setText("");
        label_pErrLastName.setText("");
        label_pErrPass1.setText("");
        label_pErrPass2.setText("");

        textfield_pKontoname.setBackground(Color.white);
        password_pPass1.setBackground(Color.white);
        password_pPass1.setBackground(Color.white);
        textfield_pEmail1.setBackground(Color.white);
        textfield_pEmail2.setBackground(Color.white);
        textfield_pName.setBackground(Color.white);
        textfield_pSurename.setBackground(Color.white);

        textfield_pKontoname.setText(_mainuser.getAccountname());
        password_pPass1.setText(_mainuser.getPassword());
        password_pPass2.setText(_mainuser.getPassword());
        textfield_pEmail1.setText(_mainuser.getEmail());
        textfield_pEmail2.setText(_mainuser.getEmail());
        textfield_pName.setText(_mainuser.getFirst_name());
        textfield_pSurename.setText(_mainuser.getLast_name());
    }
    
    private javax.swing.JButton[] constructActivityPhaseButtons(){
        javax.swing.JButton[] result = new javax.swing.JButton[30];
                result[0]=button_stud1;
                result[1]=button_stud2;
                result[2]=button_stud3;
                result[3]=button_stud4;
                result[4]=button_stud5;
                result[5]=button_stud6;
                result[6]=button_stud7;
                result[7]=button_stud8;
                result[8]=button_stud9;
                result[9]=button_stud10;
                result[10]=button_stud11;
                result[11]=button_stud12;
                result[12]=button_stud13;
                result[13]=button_stud14;
                result[14]=button_stud15;
                result[15]=button_stud16;
                result[16]=button_stud17;
                result[17]=button_stud18;
                result[18]=button_stud19;
                result[19]=button_stud20;
                result[20]=button_stud21;
                result[21]=button_stud22;
                result[22]=button_stud23;
                result[23]=button_stud24;
                result[24]=button_stud25;
                result[25]=button_stud26;
                result[26]=button_stud27;
                result[27]=button_stud28;
                result[28]=button_stud29;
                result[29]=button_stud30;              
        return result;
    }
    
    private javax.swing.JButton[] constructPlanningPhaseButtons(){
        javax.swing.JButton[] result = new javax.swing.JButton[30];
                result[0]=jBut_1;
                result[1]=jBut_2;
                result[2]=jBut_3;
                result[3]=jBut_4;
                result[4]=jBut_5;
                result[5]=jBut_6;
                result[6]=jBut_7;
                result[7]=jBut_8;
                result[8]=jBut_9;
                result[9]=jBut_10;
                result[10]=jBut_11;
                result[11]=jBut_12;
                result[12]=jBut_13;
                result[13]=jBut_14;
                result[14]=jBut_15;
                result[15]=jBut_16;
                result[16]=jBut_17;
                result[17]=jBut_18;
                result[18]=jBut_19;
                result[19]=jBut_20;
                result[20]=jBut_21;
                result[21]=jBut_22;
                result[22]=jBut_23;
                result[23]=jBut_24;
                result[24]=jBut_25;
                result[25]=jBut_26;
                result[26]=jBut_27;
                result[27]=jBut_28;
                result[28]=jBut_29;
                result[29]=jBut_30;              
        return result;
    }
    
    private javax.swing.JLabel[] constructLaptopLabels(){
        javax.swing.JLabel[] result = new javax.swing.JLabel[30];
                result[0]=label_laptop1;
                result[1]=label_laptop2;
                result[2]=label_laptop3;
                result[3]=label_laptop4;
                result[4]=label_laptop5;
                result[5]=label_laptop6;
                result[6]=label_laptop7;
                result[7]=label_laptop8;
                result[8]=label_laptop9;
                result[9]=label_laptop10;
                result[10]=label_laptop11;
                result[11]=label_laptop12;
                result[12]=label_laptop13;
                result[13]=label_laptop14;
                result[14]=label_laptop15;
                result[15]=label_laptop16;
                result[16]=label_laptop17;
                result[17]=label_laptop18;
                result[18]=label_laptop19;
                result[19]=label_laptop20;
                result[20]=label_laptop21;
                result[21]=label_laptop22;
                result[22]=label_laptop23;
                result[23]=label_laptop24;
                result[24]=label_laptop25;
                result[25]=label_laptop26;
                result[26]=label_laptop27;
                result[27]=label_laptop28;
                result[28]=label_laptop29;
                result[29]=label_laptop30;              
        return result;
    }
    //***********************************************************************  /by Dawid
    //*****************LogIn/Register: end***********************************
    //***********************************************************************
    
public void startActivityPhase(){
        
    if (panel_gamePhases.isVisible() == false) {
            panel_gamePhases.setVisible(true);
        }
        cl.show(panel_gamePhases, "card2");
        panel_menue.setVisible(false);
        item.createItemInventory(label_item1Inv, label_item1InvName, label_item1InvAmount, _maingame.redBull);
        item.createItemInventory(label_item2Inv, label_item2InvName, label_item2InvAmount, _maingame.duplo);
        item.createItemInventory(label_item3Inv, label_item3InvName, label_item3InvAmount, _maingame.omniSenseAudio);
        label_ucoinsInv.setText("UCoins:  " + _mainuser.getUcoins());
        label_creditsInv.setText("Credits:   " + _maingame.credits);
            // sets StudIcons on StudButtons
        new StudIcons(activityPhaseButtons, _maingame.getArray()); // added by Tobi
        activityPhase = new ActivityPhase(label_timer, KnowledgeBar,AirBar,NoiseBar, MotivationBar, TirednessBar, label_item1InvAmount, label_item2InvAmount, label_item3InvAmount, activityPhaseButtons, label_score, this, button_dozent1,laptopLabels); // added by Jörg, Nadir
}

public void startPlanningPhase(){
 if (panel_gamePhases.isVisible() == false) {
            panel_gamePhases.setVisible(true);
        }
        cl.show(panel_gamePhases, "card3");
        panel_menue.setVisible(false);

        // sets StudIcons on StudButtons
        //new StudIcons(planningPhaseButtons, _maingame.getArray());  
        planningPhase = new PlanningPhase(jProgB_Wissen, jProgB_Motivation, jProgB_Müdigkeit, jLab_DozCounter, jToggleBut_SwitchStud, jLab_StudCounter, jBut_Dozent);  // added by Tobias, Yulyia
        jLab_Duplo.setText("Duplo: " + _maingame.duplo.amount + "x");
        jLab_Redbull.setText("Red Bull: " + _maingame.redBull.amount + "x");
        jLab_OMNI.setText("OMNISense Audio: " + _maingame.omniSenseAudio.amount + "x");
}
public void switchPhase(){
    //Checks the Students that are still present
    int present = 0;
    for(int i=0; i<_maingame.studentArray.length; i++){
        if(_maingame.studentArray[i].present == true){
            present++;
        }
    }
    label_students.setText(String.valueOf(present)+" / 30");
    label_semester.setText(String.valueOf(_maingame.getSemester())+" / 6"); // show curent semester in the activityphase
    if (panel_gamePhases.isVisible() == false) {
            panel_gamePhases.setVisible(true);
        }
    if(_maingame.round%3 == 1 && present != 0){
        // Create a random minigame
        RandGenerator randGen = new RandGenerator();
        switch(randGen.getRand(3)+1){
            case 1: {JPanel panel_snakeMinigame = new Board(); panel_gamePhases.add(panel_snakeMinigame, "card5"); cl.show(panel_gamePhases, "card5"); panel_snakeMinigame.requestFocus(); panel_menue.setVisible(false); break;} 
            case 2: {JPanel panel_numberMinigame = new MinigameNumbergame(); panel_gamePhases.add(panel_numberMinigame, "card6"); cl.show(panel_gamePhases, "card6"); panel_numberMinigame.requestFocus(); panel_menue.setVisible(false); break;} 
            case 3: {JPanel panel_mazeMinigame = new MinigameMazegame(); panel_gamePhases.add(panel_mazeMinigame, "card7"); cl.show(panel_gamePhases, "card7"); panel_mazeMinigame.requestFocus(); panel_menue.setVisible(false); break;}
            default: {goToNextPage(); break;}
        }
    }
    // Calls the planninghpase without having a minigame
    else if(_maingame.round%3 != 1 && present != 0){
        cl.show(panel_gamePhases, "card3");
        startPlanningPhase();
    }
    // Calls the page after the last Semester if there are still students available
    else if(_maingame.round%3 == 1 && present != 0 && _maingame.getSemester() == 7){
     //   panel_gamePhases.setVisible(false);
       // panel_menue.setVisible(true);
     //unnecesary   label_gameOverSemester.setText("Erreichtes Semester:   "+String.valueOf(_maingame.getSemester()));
        label_gameOverPoints.setText("Erreichte Punktzahl:   "+String.valueOf(_maingame.points));
        label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/game_success.png"))); 
        cl.show(panel_gamePhases, "card8");
    }
    // Calls the gameOver screen if there are no students any more
   else{   
        label_gameOverSemester.setText("Erreichtes Semester:   "+String.valueOf(_maingame.getSemester()));
        label_gameOverPoints.setText("Erreichte Punktzahl:   "+String.valueOf(_maingame.points));
        switch(_maingame.getSemester()){
            case 1:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_1.png")));}
            case 2:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_1.png")));}
            case 3:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_1.png")));}
            case 4:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_5.png")));}
            case 5:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_5.png")));}
            case 6:{label_gameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gameover_5.png")));}
        }
        cl.show(panel_gamePhases, "card8");
    }
}
public void SetActivityOpaque(){ //button properties for transparency
        button_dozent1.setFocusPainted(false);
        button_dozent1.setBorder(null);
        button_dozent1.setOpaque(false);
        button_dozent1.setFocusPainted(false);
        button_dozent1.setBorderPainted(false);
        button_dozent1.setContentAreaFilled(false);
        button_dozent1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));    
        button_stud1.setFocusPainted(false);
        button_stud1.setBorder(null);
        button_stud1.setOpaque(false);
        button_stud1.setFocusPainted(false);
        button_stud1.setBorderPainted(false);
        button_stud1.setContentAreaFilled(false);
        button_stud1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud2.setFocusPainted(false);
        button_stud2.setBorder(null);
        button_stud2.setOpaque(false);
        button_stud2.setFocusPainted(false);
        button_stud2.setBorderPainted(false);
        button_stud2.setContentAreaFilled(false);
        button_stud2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud3.setFocusPainted(false);
        button_stud3.setBorder(null);
        button_stud3.setOpaque(false);
        button_stud3.setFocusPainted(false);
        button_stud3.setBorderPainted(false);
        button_stud3.setContentAreaFilled(false);
        button_stud3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud4.setFocusPainted(false);
        button_stud4.setBorder(null);
        button_stud4.setOpaque(false);
        button_stud4.setFocusPainted(false);
        button_stud4.setBorderPainted(false);
        button_stud4.setContentAreaFilled(false);
        button_stud4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud5.setFocusPainted(false);
        button_stud5.setBorder(null);
        button_stud5.setOpaque(false);
        button_stud5.setFocusPainted(false);
        button_stud5.setBorderPainted(false);
        button_stud5.setContentAreaFilled(false);
        button_stud5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud6.setFocusPainted(false);
        button_stud6.setBorder(null);
        button_stud6.setOpaque(false);
        button_stud6.setFocusPainted(false);
        button_stud6.setBorderPainted(false);
        button_stud6.setContentAreaFilled(false);
        button_stud6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud7.setFocusPainted(false);
        button_stud7.setBorder(null);
        button_stud7.setOpaque(false);
        button_stud7.setFocusPainted(false);
        button_stud7.setBorderPainted(false);
        button_stud7.setContentAreaFilled(false);
        button_stud7.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud8.setFocusPainted(false);
        button_stud8.setBorder(null);
        button_stud8.setOpaque(false);
        button_stud8.setFocusPainted(false);
        button_stud8.setBorderPainted(false);
        button_stud8.setContentAreaFilled(false);
        button_stud8.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud9.setFocusPainted(false);
        button_stud9.setBorder(null);
        button_stud9.setOpaque(false);
        button_stud9.setFocusPainted(false);
        button_stud9.setBorderPainted(false);
        button_stud9.setContentAreaFilled(false);
        button_stud9.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud10.setFocusPainted(false);
        button_stud10.setBorder(null);
        button_stud10.setOpaque(false);
        button_stud10.setFocusPainted(false);
        button_stud10.setBorderPainted(false);
        button_stud10.setContentAreaFilled(false);
        button_stud10.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud11.setFocusPainted(false);
        button_stud11.setBorder(null);
        button_stud11.setOpaque(false);
        button_stud11.setFocusPainted(false);
        button_stud11.setBorderPainted(false);
        button_stud11.setContentAreaFilled(false);
        button_stud11.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud12.setFocusPainted(false);
        button_stud12.setBorder(null);
        button_stud12.setOpaque(false);
        button_stud12.setFocusPainted(false);
        button_stud12.setBorderPainted(false);
        button_stud12.setContentAreaFilled(false);
        button_stud12.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud13.setFocusPainted(false);
        button_stud13.setBorder(null);
        button_stud13.setOpaque(false);
        button_stud13.setFocusPainted(false);
        button_stud13.setBorderPainted(false);
        button_stud13.setContentAreaFilled(false);
        button_stud13.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud14.setFocusPainted(false);
        button_stud14.setBorder(null);
        button_stud14.setOpaque(false);
        button_stud14.setFocusPainted(false);
        button_stud14.setBorderPainted(false);
        button_stud14.setContentAreaFilled(false);
        button_stud14.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud15.setFocusPainted(false);
        button_stud15.setBorder(null);
        button_stud15.setOpaque(false);
        button_stud15.setFocusPainted(false);
        button_stud15.setBorderPainted(false);
        button_stud15.setContentAreaFilled(false);
        button_stud15.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud16.setFocusPainted(false);
        button_stud16.setBorder(null);
        button_stud16.setOpaque(false);
        button_stud16.setFocusPainted(false);
        button_stud16.setBorderPainted(false);
        button_stud16.setContentAreaFilled(false);
        button_stud16.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud17.setFocusPainted(false);
        button_stud17.setBorder(null);
        button_stud17.setOpaque(false);
        button_stud17.setFocusPainted(false);
        button_stud17.setBorderPainted(false);
        button_stud17.setContentAreaFilled(false);
        button_stud17.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud18.setFocusPainted(false);
        button_stud18.setBorder(null);
        button_stud18.setOpaque(false);
        button_stud18.setFocusPainted(false);
        button_stud18.setBorderPainted(false);
        button_stud18.setContentAreaFilled(false);
        button_stud18.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud19.setFocusPainted(false);
        button_stud19.setBorder(null);
        button_stud19.setOpaque(false);
        button_stud19.setFocusPainted(false);
        button_stud19.setBorderPainted(false);
        button_stud19.setContentAreaFilled(false);
        button_stud19.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud20.setFocusPainted(false);
        button_stud20.setBorder(null);
        button_stud20.setOpaque(false);
        button_stud20.setFocusPainted(false);
        button_stud20.setBorderPainted(false);
        button_stud20.setContentAreaFilled(false);
        button_stud20.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud21.setFocusPainted(false);
        button_stud21.setBorder(null);
        button_stud21.setOpaque(false);
        button_stud21.setFocusPainted(false);
        button_stud21.setBorderPainted(false);
        button_stud21.setContentAreaFilled(false);
        button_stud21.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud22.setFocusPainted(false);
        button_stud22.setBorder(null);
        button_stud22.setOpaque(false);
        button_stud22.setFocusPainted(false);
        button_stud22.setBorderPainted(false);
        button_stud22.setContentAreaFilled(false);
        button_stud22.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud23.setFocusPainted(false);
        button_stud23.setBorder(null);
        button_stud23.setOpaque(false);
        button_stud23.setFocusPainted(false);
        button_stud23.setBorderPainted(false);
        button_stud23.setContentAreaFilled(false);
        button_stud23.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud24.setFocusPainted(false);
        button_stud24.setBorder(null);
        button_stud24.setOpaque(false);
        button_stud24.setFocusPainted(false);
        button_stud24.setBorderPainted(false);
        button_stud24.setContentAreaFilled(false);
        button_stud24.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud25.setFocusPainted(false);
        button_stud25.setBorder(null);
        button_stud25.setOpaque(false);
        button_stud25.setFocusPainted(false);
        button_stud25.setBorderPainted(false);
        button_stud25.setContentAreaFilled(false);
        button_stud25.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud26.setFocusPainted(false);
        button_stud26.setBorder(null);
        button_stud26.setOpaque(false);
        button_stud26.setFocusPainted(false);
        button_stud26.setBorderPainted(false);
        button_stud26.setContentAreaFilled(false);
        button_stud26.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud27.setFocusPainted(false);
        button_stud27.setBorder(null);
        button_stud27.setOpaque(false);
        button_stud27.setFocusPainted(false);
        button_stud27.setBorderPainted(false);
        button_stud27.setContentAreaFilled(false);
        button_stud27.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud28.setFocusPainted(false);
        button_stud28.setBorder(null);
        button_stud28.setOpaque(false);
        button_stud28.setFocusPainted(false);
        button_stud28.setBorderPainted(false);
        button_stud28.setContentAreaFilled(false);
        button_stud28.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud29.setFocusPainted(false);
        button_stud29.setBorder(null);
        button_stud29.setOpaque(false);
        button_stud29.setFocusPainted(false);
        button_stud29.setBorderPainted(false);
        button_stud29.setContentAreaFilled(false);
        button_stud29.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button_stud30.setFocusPainted(false);
        button_stud30.setBorder(null);
        button_stud30.setOpaque(false);
        button_stud30.setFocusPainted(false);
        button_stud30.setBorderPainted(false);
        button_stud30.setContentAreaFilled(false);
        button_stud30.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        }
public void SetPlanningOpaque(){ //button properties for transparency
        jBut_Dozent.setFocusPainted(false);
        jBut_Dozent.setBorder(null);
        jBut_Dozent.setOpaque(false);
        jBut_Dozent.setFocusPainted(false);
        jBut_Dozent.setBorderPainted(false);
        jBut_Dozent.setContentAreaFilled(false);
        jBut_Dozent.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));    
        jBut_1.setFocusPainted(false);
        jBut_1.setBorder(null);
        jBut_1.setOpaque(false);
        jBut_1.setFocusPainted(false);
        jBut_1.setBorderPainted(false);
        jBut_1.setContentAreaFilled(false);
        jBut_1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_2.setFocusPainted(false);
        jBut_2.setBorder(null);
        jBut_2.setOpaque(false);
        jBut_2.setFocusPainted(false);
        jBut_2.setBorderPainted(false);
        jBut_2.setContentAreaFilled(false);
        jBut_2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_3.setFocusPainted(false);
        jBut_3.setBorder(null);
        jBut_3.setOpaque(false);
        jBut_3.setFocusPainted(false);
        jBut_3.setBorderPainted(false);
        jBut_3.setContentAreaFilled(false);
        jBut_3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_4.setFocusPainted(false);
        jBut_4.setBorder(null);
        jBut_4.setOpaque(false);
        jBut_4.setFocusPainted(false);
        jBut_4.setBorderPainted(false);
        jBut_4.setContentAreaFilled(false);
        jBut_4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_5.setFocusPainted(false);
        jBut_5.setBorder(null);
        jBut_5.setOpaque(false);
        jBut_5.setFocusPainted(false);
        jBut_5.setBorderPainted(false);
        jBut_5.setContentAreaFilled(false);
        jBut_5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_6.setFocusPainted(false);
        jBut_6.setBorder(null);
        jBut_6.setOpaque(false);
        jBut_6.setFocusPainted(false);
        jBut_6.setBorderPainted(false);
        jBut_6.setContentAreaFilled(false);
        jBut_6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_7.setFocusPainted(false);
        jBut_7.setBorder(null);
        jBut_7.setOpaque(false);
        jBut_7.setFocusPainted(false);
        jBut_7.setBorderPainted(false);
        jBut_7.setContentAreaFilled(false);
        jBut_7.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_8.setFocusPainted(false);
        jBut_8.setBorder(null);
        jBut_8.setOpaque(false);
        jBut_8.setFocusPainted(false);
        jBut_8.setBorderPainted(false);
        jBut_8.setContentAreaFilled(false);
        jBut_8.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_9.setFocusPainted(false);
        jBut_9.setBorder(null);
        jBut_9.setOpaque(false);
        jBut_9.setFocusPainted(false);
        jBut_9.setBorderPainted(false);
        jBut_9.setContentAreaFilled(false);
        jBut_9.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_10.setFocusPainted(false);
        jBut_10.setBorder(null);
        jBut_10.setOpaque(false);
        jBut_10.setFocusPainted(false);
        jBut_10.setBorderPainted(false);
        jBut_10.setContentAreaFilled(false);
        jBut_10.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_11.setFocusPainted(false);
        jBut_11.setBorder(null);
        jBut_11.setOpaque(false);
        jBut_11.setFocusPainted(false);
        jBut_11.setBorderPainted(false);
        jBut_11.setContentAreaFilled(false);
        jBut_11.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_12.setFocusPainted(false);
        jBut_12.setBorder(null);
        jBut_12.setOpaque(false);
        jBut_12.setFocusPainted(false);
        jBut_12.setBorderPainted(false);
        jBut_12.setContentAreaFilled(false);
        jBut_12.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_13.setFocusPainted(false);
        jBut_13.setBorder(null);
        jBut_13.setOpaque(false);
        jBut_13.setFocusPainted(false);
        jBut_13.setBorderPainted(false);
        jBut_13.setContentAreaFilled(false);
        jBut_13.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_14.setFocusPainted(false);
        jBut_14.setBorder(null);
        jBut_14.setOpaque(false);
        jBut_14.setFocusPainted(false);
        jBut_14.setBorderPainted(false);
        jBut_14.setContentAreaFilled(false);
        jBut_14.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_15.setFocusPainted(false);
        jBut_15.setBorder(null);
        jBut_15.setOpaque(false);
        jBut_15.setFocusPainted(false);
        jBut_15.setBorderPainted(false);
        jBut_15.setContentAreaFilled(false);
        jBut_15.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_16.setFocusPainted(false);
        jBut_16.setBorder(null);
        jBut_16.setOpaque(false);
        jBut_16.setFocusPainted(false);
        jBut_16.setBorderPainted(false);
        jBut_16.setContentAreaFilled(false);
        jBut_16.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_17.setFocusPainted(false);
        jBut_17.setBorder(null);
        jBut_17.setOpaque(false);
        jBut_17.setFocusPainted(false);
        jBut_17.setBorderPainted(false);
        jBut_17.setContentAreaFilled(false);
        jBut_17.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_18.setFocusPainted(false);
        jBut_18.setBorder(null);
        jBut_18.setOpaque(false);
        jBut_18.setFocusPainted(false);
        jBut_18.setBorderPainted(false);
        jBut_18.setContentAreaFilled(false);
        jBut_18.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_19.setFocusPainted(false);
        jBut_19.setBorder(null);
        jBut_19.setOpaque(false);
        jBut_19.setFocusPainted(false);
        jBut_19.setBorderPainted(false);
        jBut_19.setContentAreaFilled(false);
        jBut_19.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_20.setFocusPainted(false);
        jBut_20.setBorder(null);
        jBut_20.setOpaque(false);
        jBut_20.setFocusPainted(false);
        jBut_20.setBorderPainted(false);
        jBut_20.setContentAreaFilled(false);
        jBut_20.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_21.setFocusPainted(false);
        jBut_21.setBorder(null);
        jBut_21.setOpaque(false);
        jBut_21.setFocusPainted(false);
        jBut_21.setBorderPainted(false);
        jBut_21.setContentAreaFilled(false);
        jBut_21.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_22.setFocusPainted(false);
        jBut_22.setBorder(null);
        jBut_22.setOpaque(false);
        jBut_22.setFocusPainted(false);
        jBut_22.setBorderPainted(false);
        jBut_22.setContentAreaFilled(false);
        jBut_22.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_23.setFocusPainted(false);
        jBut_23.setBorder(null);
        jBut_23.setOpaque(false);
        jBut_23.setFocusPainted(false);
        jBut_23.setBorderPainted(false);
        jBut_23.setContentAreaFilled(false);
        jBut_23.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_24.setFocusPainted(false);
        jBut_24.setBorder(null);
        jBut_24.setOpaque(false);
        jBut_24.setFocusPainted(false);
        jBut_24.setBorderPainted(false);
        jBut_24.setContentAreaFilled(false);
        jBut_24.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_25.setFocusPainted(false);
        jBut_25.setBorder(null);
        jBut_25.setOpaque(false);
        jBut_25.setFocusPainted(false);
        jBut_25.setBorderPainted(false);
        jBut_25.setContentAreaFilled(false);
        jBut_25.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_26.setFocusPainted(false);
        jBut_26.setBorder(null);
        jBut_26.setOpaque(false);
        jBut_26.setFocusPainted(false);
        jBut_26.setBorderPainted(false);
        jBut_26.setContentAreaFilled(false);
        jBut_26.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_27.setFocusPainted(false);
        jBut_27.setBorder(null);
        jBut_27.setOpaque(false);
        jBut_27.setFocusPainted(false);
        jBut_27.setBorderPainted(false);
        jBut_27.setContentAreaFilled(false);
        jBut_27.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_28.setFocusPainted(false);
        jBut_28.setBorder(null);
        jBut_28.setOpaque(false);
        jBut_28.setFocusPainted(false);
        jBut_28.setBorderPainted(false);
        jBut_28.setContentAreaFilled(false);
        jBut_28.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_29.setFocusPainted(false);
        jBut_29.setBorder(null);
        jBut_29.setOpaque(false);
        jBut_29.setFocusPainted(false);
        jBut_29.setBorderPainted(false);
        jBut_29.setContentAreaFilled(false);
        jBut_29.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jBut_30.setFocusPainted(false);
        jBut_30.setBorder(null);
        jBut_30.setOpaque(false);
        jBut_30.setFocusPainted(false);
        jBut_30.setBorderPainted(false);
        jBut_30.setContentAreaFilled(false);
        jBut_30.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        }
public  void SetActivityPhaseOpacity(){
                button_stud1.setOpaque(false);
                button_stud2.setOpaque(false);
                button_stud3.setOpaque(false);
                button_stud4.setOpaque(false);
                button_stud5.setOpaque(false);
                button_stud6.setOpaque(false);
                button_stud7.setOpaque(false);
                button_stud8.setOpaque(false);
                button_stud9.setOpaque(false);
                button_stud10.setOpaque(false);
                button_stud11.setOpaque(false);
                button_stud12.setOpaque(false);
                button_stud13.setOpaque(false);
                button_stud14.setOpaque(false);
                button_stud15.setOpaque(false);
                button_stud16.setOpaque(false);
                button_stud17.setOpaque(false);
                button_stud18.setOpaque(false);
                button_stud19.setOpaque(false);
                button_stud20.setOpaque(false);
                button_stud21.setOpaque(false);
                button_stud22.setOpaque(false);
                button_stud23.setOpaque(false);
                button_stud24.setOpaque(false);
                button_stud25.setOpaque(false);
                button_stud26.setOpaque(false);
                button_stud27.setOpaque(false);
                button_stud28.setOpaque(false);
                button_stud29.setOpaque(false);
                button_stud30.setOpaque(false);
}
public  void SetPlanningPhaseOpacity(){
                jBut_1.setOpaque(false);
                jBut_2.setOpaque(false);
                jBut_3.setOpaque(false);
                jBut_4.setOpaque(false);
                jBut_5.setOpaque(false);
                jBut_6.setOpaque(false);
                jBut_7.setOpaque(false);
                jBut_8.setOpaque(false);
                jBut_9.setOpaque(false);
                jBut_10.setOpaque(false);
                jBut_11.setOpaque(false);
                jBut_12.setOpaque(false);
                jBut_13.setOpaque(false);
                jBut_14.setOpaque(false);
                jBut_15.setOpaque(false);
                jBut_16.setOpaque(false);
                jBut_17.setOpaque(false);
                jBut_18.setOpaque(false);
                jBut_19.setOpaque(false);
                jBut_20.setOpaque(false);
                jBut_21.setOpaque(false);
                jBut_22.setOpaque(false);
                jBut_23.setOpaque(false);
                jBut_24.setOpaque(false);
                jBut_25.setOpaque(false);
                jBut_26.setOpaque(false);
                jBut_27.setOpaque(false);
                jBut_28.setOpaque(false);
                jBut_29.setOpaque(false);
                jBut_30.setOpaque(false);
}
public void displayExamResults(int failed, int remaining){
    System.out.println(failed+"failed : remaining"+remaining);
    label_examFailed.setText(""+failed);
    label_examRemaining.setText(""+remaining);
    dialog_examResults.setVisible(true);
}
public void hideQuietingLabel(){
    label_dozent_action.setVisible(false);
}
}
