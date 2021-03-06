/*
 * This game is the second minigame. The goal is to reach the center of the maze as fast as possible. 
 */
package test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jannik
 */
public class MinigameMazegame extends javax.swing.JPanel {

   /**
     * Creates new form MazeGame and sets the car to one of the four starting positions.
     */
    public JDialog endDialog = new JDialog();
    static long startTime = 0;
    static long endTime = 0;
    private int timerflag = 0;
    
    
    private javax.swing.JLabel label_auto;
    private javax.swing.JLabel label_goal;
    private javax.swing.JLabel label_spawn1;
    private javax.swing.JLabel label_spawn2;
    private javax.swing.JLabel label_spawn3;
    private javax.swing.JLabel label_spawn4;
    private javax.swing.JLabel label_wall;
    private javax.swing.JLabel label_wall1;
    private javax.swing.JLabel label_wall10;
    private javax.swing.JLabel label_wall100;
    private javax.swing.JLabel label_wall101;
    private javax.swing.JLabel label_wall102;
    private javax.swing.JLabel label_wall103;
    private javax.swing.JLabel label_wall104;
    private javax.swing.JLabel label_wall105;
    private javax.swing.JLabel label_wall106;
    private javax.swing.JLabel label_wall107;
    private javax.swing.JLabel label_wall108;
    private javax.swing.JLabel label_wall109;
    private javax.swing.JLabel label_wall11;
    private javax.swing.JLabel label_wall110;
    private javax.swing.JLabel label_wall111;
    private javax.swing.JLabel label_wall112;
    private javax.swing.JLabel label_wall113;
    private javax.swing.JLabel label_wall114;
    private javax.swing.JLabel label_wall115;
    private javax.swing.JLabel label_wall116;
    private javax.swing.JLabel label_wall117;
    private javax.swing.JLabel label_wall118;
    private javax.swing.JLabel label_wall119;
    private javax.swing.JLabel label_wall12;
    private javax.swing.JLabel label_wall120;
    private javax.swing.JLabel label_wall121;
    private javax.swing.JLabel label_wall122;
    private javax.swing.JLabel label_wall123;
    private javax.swing.JLabel label_wall124;
    private javax.swing.JLabel label_wall125;
    private javax.swing.JLabel label_wall126;
    private javax.swing.JLabel label_wall127;
    private javax.swing.JLabel label_wall128;
    private javax.swing.JLabel label_wall129;
    private javax.swing.JLabel label_wall13;
    private javax.swing.JLabel label_wall130;
    private javax.swing.JLabel label_wall131;
    private javax.swing.JLabel label_wall132;
    private javax.swing.JLabel label_wall133;
    private javax.swing.JLabel label_wall134;
    private javax.swing.JLabel label_wall135;
    private javax.swing.JLabel label_wall136;
    private javax.swing.JLabel label_wall137;
    private javax.swing.JLabel label_wall138;
    private javax.swing.JLabel label_wall139;
    private javax.swing.JLabel label_wall14;
    private javax.swing.JLabel label_wall140;
    private javax.swing.JLabel label_wall141;
    private javax.swing.JLabel label_wall142;
    private javax.swing.JLabel label_wall143;
    private javax.swing.JLabel label_wall144;
    private javax.swing.JLabel label_wall145;
    private javax.swing.JLabel label_wall146;
    private javax.swing.JLabel label_wall147;
    private javax.swing.JLabel label_wall148;
    private javax.swing.JLabel label_wall149;
    private javax.swing.JLabel label_wall15;
    private javax.swing.JLabel label_wall150;
    private javax.swing.JLabel label_wall151;
    private javax.swing.JLabel label_wall152;
    private javax.swing.JLabel label_wall153;
    private javax.swing.JLabel label_wall154;
    private javax.swing.JLabel label_wall155;
    private javax.swing.JLabel label_wall156;
    private javax.swing.JLabel label_wall157;
    private javax.swing.JLabel label_wall158;
    private javax.swing.JLabel label_wall159;
    private javax.swing.JLabel label_wall16;
    private javax.swing.JLabel label_wall160;
    private javax.swing.JLabel label_wall161;
    private javax.swing.JLabel label_wall162;
    private javax.swing.JLabel label_wall163;
    private javax.swing.JLabel label_wall164;
    private javax.swing.JLabel label_wall165;
    private javax.swing.JLabel label_wall166;
    private javax.swing.JLabel label_wall167;
    private javax.swing.JLabel label_wall168;
    private javax.swing.JLabel label_wall169;
    private javax.swing.JLabel label_wall17;
    private javax.swing.JLabel label_wall170;
    private javax.swing.JLabel label_wall171;
    private javax.swing.JLabel label_wall172;
    private javax.swing.JLabel label_wall173;
    private javax.swing.JLabel label_wall174;
    private javax.swing.JLabel label_wall175;
    private javax.swing.JLabel label_wall176;
    private javax.swing.JLabel label_wall177;
    private javax.swing.JLabel label_wall178;
    private javax.swing.JLabel label_wall179;
    private javax.swing.JLabel label_wall18;
    private javax.swing.JLabel label_wall180;
    private javax.swing.JLabel label_wall181;
    private javax.swing.JLabel label_wall182;
    private javax.swing.JLabel label_wall183;
    private javax.swing.JLabel label_wall184;
    private javax.swing.JLabel label_wall185;
    private javax.swing.JLabel label_wall186;
    private javax.swing.JLabel label_wall187;
    private javax.swing.JLabel label_wall188;
    private javax.swing.JLabel label_wall189;
    private javax.swing.JLabel label_wall19;
    private javax.swing.JLabel label_wall190;
    private javax.swing.JLabel label_wall191;
    private javax.swing.JLabel label_wall192;
    private javax.swing.JLabel label_wall193;
    private javax.swing.JLabel label_wall194;
    private javax.swing.JLabel label_wall195;
    private javax.swing.JLabel label_wall196;
    private javax.swing.JLabel label_wall197;
    private javax.swing.JLabel label_wall198;
    private javax.swing.JLabel label_wall199;
    private javax.swing.JLabel label_wall2;
    private javax.swing.JLabel label_wall20;
    private javax.swing.JLabel label_wall200;
    private javax.swing.JLabel label_wall201;
    private javax.swing.JLabel label_wall202;
    private javax.swing.JLabel label_wall203;
    private javax.swing.JLabel label_wall204;
    private javax.swing.JLabel label_wall205;
    private javax.swing.JLabel label_wall206;
    private javax.swing.JLabel label_wall207;
    private javax.swing.JLabel label_wall208;
    private javax.swing.JLabel label_wall209;
    private javax.swing.JLabel label_wall21;
    private javax.swing.JLabel label_wall210;
    private javax.swing.JLabel label_wall211;
    private javax.swing.JLabel label_wall212;
    private javax.swing.JLabel label_wall213;
    private javax.swing.JLabel label_wall214;
    private javax.swing.JLabel label_wall215;
    private javax.swing.JLabel label_wall216;
    private javax.swing.JLabel label_wall217;
    private javax.swing.JLabel label_wall218;
    private javax.swing.JLabel label_wall219;
    private javax.swing.JLabel label_wall22;
    private javax.swing.JLabel label_wall220;
    private javax.swing.JLabel label_wall221;
    private javax.swing.JLabel label_wall222;
    private javax.swing.JLabel label_wall223;
    private javax.swing.JLabel label_wall224;
    private javax.swing.JLabel label_wall225;
    private javax.swing.JLabel label_wall226;
    private javax.swing.JLabel label_wall227;
    private javax.swing.JLabel label_wall228;
    private javax.swing.JLabel label_wall229;
    private javax.swing.JLabel label_wall23;
    private javax.swing.JLabel label_wall230;
    private javax.swing.JLabel label_wall231;
    private javax.swing.JLabel label_wall232;
    private javax.swing.JLabel label_wall233;
    private javax.swing.JLabel label_wall234;
    private javax.swing.JLabel label_wall235;
    private javax.swing.JLabel label_wall236;
    private javax.swing.JLabel label_wall237;
    private javax.swing.JLabel label_wall238;
    private javax.swing.JLabel label_wall239;
    private javax.swing.JLabel label_wall24;
    private javax.swing.JLabel label_wall240;
    private javax.swing.JLabel label_wall241;
    private javax.swing.JLabel label_wall242;
    private javax.swing.JLabel label_wall243;
    private javax.swing.JLabel label_wall244;
    private javax.swing.JLabel label_wall245;
    private javax.swing.JLabel label_wall246;
    private javax.swing.JLabel label_wall247;
    private javax.swing.JLabel label_wall248;
    private javax.swing.JLabel label_wall249;
    private javax.swing.JLabel label_wall25;
    private javax.swing.JLabel label_wall250;
    private javax.swing.JLabel label_wall251;
    private javax.swing.JLabel label_wall252;
    private javax.swing.JLabel label_wall253;
    private javax.swing.JLabel label_wall254;
    private javax.swing.JLabel label_wall255;
    private javax.swing.JLabel label_wall256;
    private javax.swing.JLabel label_wall257;
    private javax.swing.JLabel label_wall258;
    private javax.swing.JLabel label_wall259;
    private javax.swing.JLabel label_wall26;
    private javax.swing.JLabel label_wall260;
    private javax.swing.JLabel label_wall261;
    private javax.swing.JLabel label_wall262;
    private javax.swing.JLabel label_wall263;
    private javax.swing.JLabel label_wall264;
    private javax.swing.JLabel label_wall265;
    private javax.swing.JLabel label_wall266;
    private javax.swing.JLabel label_wall267;
    private javax.swing.JLabel label_wall268;
    private javax.swing.JLabel label_wall269;
    private javax.swing.JLabel label_wall27;
    private javax.swing.JLabel label_wall270;
    private javax.swing.JLabel label_wall271;
    private javax.swing.JLabel label_wall272;
    private javax.swing.JLabel label_wall273;
    private javax.swing.JLabel label_wall274;
    private javax.swing.JLabel label_wall28;
    private javax.swing.JLabel label_wall29;
    private javax.swing.JLabel label_wall3;
    private javax.swing.JLabel label_wall30;
    private javax.swing.JLabel label_wall31;
    private javax.swing.JLabel label_wall32;
    private javax.swing.JLabel label_wall33;
    private javax.swing.JLabel label_wall34;
    private javax.swing.JLabel label_wall35;
    private javax.swing.JLabel label_wall36;
    private javax.swing.JLabel label_wall37;
    private javax.swing.JLabel label_wall38;
    private javax.swing.JLabel label_wall39;
    private javax.swing.JLabel label_wall4;
    private javax.swing.JLabel label_wall40;
    private javax.swing.JLabel label_wall41;
    private javax.swing.JLabel label_wall42;
    private javax.swing.JLabel label_wall43;
    private javax.swing.JLabel label_wall44;
    private javax.swing.JLabel label_wall45;
    private javax.swing.JLabel label_wall46;
    private javax.swing.JLabel label_wall47;
    private javax.swing.JLabel label_wall48;
    private javax.swing.JLabel label_wall49;
    private javax.swing.JLabel label_wall5;
    private javax.swing.JLabel label_wall50;
    private javax.swing.JLabel label_wall51;
    private javax.swing.JLabel label_wall52;
    private javax.swing.JLabel label_wall53;
    private javax.swing.JLabel label_wall54;
    private javax.swing.JLabel label_wall55;
    private javax.swing.JLabel label_wall56;
    private javax.swing.JLabel label_wall57;
    private javax.swing.JLabel label_wall58;
    private javax.swing.JLabel label_wall59;
    private javax.swing.JLabel label_wall6;
    private javax.swing.JLabel label_wall60;
    private javax.swing.JLabel label_wall61;
    private javax.swing.JLabel label_wall62;
    private javax.swing.JLabel label_wall63;
    private javax.swing.JLabel label_wall64;
    private javax.swing.JLabel label_wall65;
    private javax.swing.JLabel label_wall66;
    private javax.swing.JLabel label_wall67;
    private javax.swing.JLabel label_wall68;
    private javax.swing.JLabel label_wall69;
    private javax.swing.JLabel label_wall7;
    private javax.swing.JLabel label_wall70;
    private javax.swing.JLabel label_wall71;
    private javax.swing.JLabel label_wall72;
    private javax.swing.JLabel label_wall73;
    private javax.swing.JLabel label_wall74;
    private javax.swing.JLabel label_wall75;
    private javax.swing.JLabel label_wall76;
    private javax.swing.JLabel label_wall77;
    private javax.swing.JLabel label_wall78;
    private javax.swing.JLabel label_wall79;
    private javax.swing.JLabel label_wall8;
    private javax.swing.JLabel label_wall80;
    private javax.swing.JLabel label_wall81;
    private javax.swing.JLabel label_wall82;
    private javax.swing.JLabel label_wall83;
    private javax.swing.JLabel label_wall84;
    private javax.swing.JLabel label_wall85;
    private javax.swing.JLabel label_wall86;
    private javax.swing.JLabel label_wall87;
    private javax.swing.JLabel label_wall88;
    private javax.swing.JLabel label_wall89;
    private javax.swing.JLabel label_wall9;
    private javax.swing.JLabel label_wall90;
    private javax.swing.JLabel label_wall91;
    private javax.swing.JLabel label_wall92;
    private javax.swing.JLabel label_wall93;
    private javax.swing.JLabel label_wall94;
    private javax.swing.JLabel label_wall95;
    private javax.swing.JLabel label_wall96;
    private javax.swing.JLabel label_wall97;
    private javax.swing.JLabel label_wall98;
    private javax.swing.JLabel label_wall99;
    // End of variables declaration            
    
    public MinigameMazegame() {
        initComponents1();
        setSize(1000, 700);
        startSetup();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Initializes each component which was declared above.
     * Creates a maze.
     */
    private void initComponents1() {

        label_wall1 = new javax.swing.JLabel();
        label_wall2 = new javax.swing.JLabel();
        label_wall3 = new javax.swing.JLabel();
        label_auto = new javax.swing.JLabel();
        label_wall = new javax.swing.JLabel();
        label_wall4 = new javax.swing.JLabel();
        label_wall5 = new javax.swing.JLabel();
        label_wall6 = new javax.swing.JLabel();
        label_wall7 = new javax.swing.JLabel();
        label_wall8 = new javax.swing.JLabel();
        label_wall9 = new javax.swing.JLabel();
        label_wall10 = new javax.swing.JLabel();
        label_wall11 = new javax.swing.JLabel();
        label_wall12 = new javax.swing.JLabel();
        label_wall13 = new javax.swing.JLabel();
        label_wall14 = new javax.swing.JLabel();
        label_wall15 = new javax.swing.JLabel();
        label_wall16 = new javax.swing.JLabel();
        label_wall17 = new javax.swing.JLabel();
        label_wall18 = new javax.swing.JLabel();
        label_wall19 = new javax.swing.JLabel();
        label_wall20 = new javax.swing.JLabel();
        label_wall21 = new javax.swing.JLabel();
        label_wall22 = new javax.swing.JLabel();
        label_wall23 = new javax.swing.JLabel();
        label_wall24 = new javax.swing.JLabel();
        label_wall25 = new javax.swing.JLabel();
        label_wall26 = new javax.swing.JLabel();
        label_wall27 = new javax.swing.JLabel();
        label_wall28 = new javax.swing.JLabel();
        label_wall29 = new javax.swing.JLabel();
        label_wall30 = new javax.swing.JLabel();
        label_wall31 = new javax.swing.JLabel();
        label_wall32 = new javax.swing.JLabel();
        label_wall33 = new javax.swing.JLabel();
        label_wall34 = new javax.swing.JLabel();
        label_wall35 = new javax.swing.JLabel();
        label_wall36 = new javax.swing.JLabel();
        label_wall37 = new javax.swing.JLabel();
        label_wall38 = new javax.swing.JLabel();
        label_wall39 = new javax.swing.JLabel();
        label_wall40 = new javax.swing.JLabel();
        label_wall41 = new javax.swing.JLabel();
        label_wall42 = new javax.swing.JLabel();
        label_wall43 = new javax.swing.JLabel();
        label_wall44 = new javax.swing.JLabel();
        label_wall45 = new javax.swing.JLabel();
        label_wall46 = new javax.swing.JLabel();
        label_wall47 = new javax.swing.JLabel();
        label_wall48 = new javax.swing.JLabel();
        label_wall49 = new javax.swing.JLabel();
        label_wall50 = new javax.swing.JLabel();
        label_wall51 = new javax.swing.JLabel();
        label_wall52 = new javax.swing.JLabel();
        label_wall53 = new javax.swing.JLabel();
        label_wall54 = new javax.swing.JLabel();
        label_wall55 = new javax.swing.JLabel();
        label_wall56 = new javax.swing.JLabel();
        label_wall57 = new javax.swing.JLabel();
        label_wall58 = new javax.swing.JLabel();
        label_wall59 = new javax.swing.JLabel();
        label_wall60 = new javax.swing.JLabel();
        label_wall61 = new javax.swing.JLabel();
        label_wall62 = new javax.swing.JLabel();
        label_wall63 = new javax.swing.JLabel();
        label_wall64 = new javax.swing.JLabel();
        label_wall65 = new javax.swing.JLabel();
        label_wall66 = new javax.swing.JLabel();
        label_wall67 = new javax.swing.JLabel();
        label_wall68 = new javax.swing.JLabel();
        label_wall69 = new javax.swing.JLabel();
        label_wall70 = new javax.swing.JLabel();
        label_wall71 = new javax.swing.JLabel();
        label_wall72 = new javax.swing.JLabel();
        label_wall73 = new javax.swing.JLabel();
        label_wall74 = new javax.swing.JLabel();
        label_wall75 = new javax.swing.JLabel();
        label_wall76 = new javax.swing.JLabel();
        label_wall77 = new javax.swing.JLabel();
        label_wall78 = new javax.swing.JLabel();
        label_wall79 = new javax.swing.JLabel();
        label_wall80 = new javax.swing.JLabel();
        label_wall81 = new javax.swing.JLabel();
        label_wall82 = new javax.swing.JLabel();
        label_wall83 = new javax.swing.JLabel();
        label_wall84 = new javax.swing.JLabel();
        label_wall85 = new javax.swing.JLabel();
        label_wall86 = new javax.swing.JLabel();
        label_wall87 = new javax.swing.JLabel();
        label_wall88 = new javax.swing.JLabel();
        label_wall89 = new javax.swing.JLabel();
        label_wall90 = new javax.swing.JLabel();
        label_wall91 = new javax.swing.JLabel();
        label_wall92 = new javax.swing.JLabel();
        label_wall93 = new javax.swing.JLabel();
        label_wall94 = new javax.swing.JLabel();
        label_wall95 = new javax.swing.JLabel();
        label_wall96 = new javax.swing.JLabel();
        label_wall97 = new javax.swing.JLabel();
        label_wall98 = new javax.swing.JLabel();
        label_wall99 = new javax.swing.JLabel();
        label_wall100 = new javax.swing.JLabel();
        label_wall101 = new javax.swing.JLabel();
        label_wall102 = new javax.swing.JLabel();
        label_wall103 = new javax.swing.JLabel();
        label_wall104 = new javax.swing.JLabel();
        label_wall105 = new javax.swing.JLabel();
        label_wall106 = new javax.swing.JLabel();
        label_wall107 = new javax.swing.JLabel();
        label_wall108 = new javax.swing.JLabel();
        label_wall109 = new javax.swing.JLabel();
        label_wall110 = new javax.swing.JLabel();
        label_wall111 = new javax.swing.JLabel();
        label_wall112 = new javax.swing.JLabel();
        label_wall113 = new javax.swing.JLabel();
        label_wall114 = new javax.swing.JLabel();
        label_wall115 = new javax.swing.JLabel();
        label_wall116 = new javax.swing.JLabel();
        label_wall117 = new javax.swing.JLabel();
        label_wall118 = new javax.swing.JLabel();
        label_wall119 = new javax.swing.JLabel();
        label_wall120 = new javax.swing.JLabel();
        label_wall121 = new javax.swing.JLabel();
        label_wall122 = new javax.swing.JLabel();
        label_wall123 = new javax.swing.JLabel();
        label_wall124 = new javax.swing.JLabel();
        label_wall125 = new javax.swing.JLabel();
        label_wall126 = new javax.swing.JLabel();
        label_wall127 = new javax.swing.JLabel();
        label_wall128 = new javax.swing.JLabel();
        label_wall129 = new javax.swing.JLabel();
        label_wall130 = new javax.swing.JLabel();
        label_wall131 = new javax.swing.JLabel();
        label_wall132 = new javax.swing.JLabel();
        label_wall133 = new javax.swing.JLabel();
        label_wall134 = new javax.swing.JLabel();
        label_wall135 = new javax.swing.JLabel();
        label_wall136 = new javax.swing.JLabel();
        label_wall137 = new javax.swing.JLabel();
        label_wall138 = new javax.swing.JLabel();
        label_wall139 = new javax.swing.JLabel();
        label_wall140 = new javax.swing.JLabel();
        label_wall141 = new javax.swing.JLabel();
        label_wall142 = new javax.swing.JLabel();
        label_wall143 = new javax.swing.JLabel();
        label_wall144 = new javax.swing.JLabel();
        label_wall145 = new javax.swing.JLabel();
        label_wall146 = new javax.swing.JLabel();
        label_wall147 = new javax.swing.JLabel();
        label_wall148 = new javax.swing.JLabel();
        label_wall149 = new javax.swing.JLabel();
        label_wall150 = new javax.swing.JLabel();
        label_wall151 = new javax.swing.JLabel();
        label_wall152 = new javax.swing.JLabel();
        label_wall153 = new javax.swing.JLabel();
        label_wall154 = new javax.swing.JLabel();
        label_wall155 = new javax.swing.JLabel();
        label_wall156 = new javax.swing.JLabel();
        label_wall157 = new javax.swing.JLabel();
        label_wall158 = new javax.swing.JLabel();
        label_wall160 = new javax.swing.JLabel();
        label_wall161 = new javax.swing.JLabel();
        label_wall162 = new javax.swing.JLabel();
        label_wall163 = new javax.swing.JLabel();
        label_wall164 = new javax.swing.JLabel();
        label_wall165 = new javax.swing.JLabel();
        label_wall159 = new javax.swing.JLabel();
        label_wall166 = new javax.swing.JLabel();
        label_wall167 = new javax.swing.JLabel();
        label_wall168 = new javax.swing.JLabel();
        label_wall169 = new javax.swing.JLabel();
        label_wall170 = new javax.swing.JLabel();
        label_wall171 = new javax.swing.JLabel();
        label_wall172 = new javax.swing.JLabel();
        label_wall173 = new javax.swing.JLabel();
        label_wall174 = new javax.swing.JLabel();
        label_wall175 = new javax.swing.JLabel();
        label_wall176 = new javax.swing.JLabel();
        label_wall177 = new javax.swing.JLabel();
        label_wall178 = new javax.swing.JLabel();
        label_wall179 = new javax.swing.JLabel();
        label_wall180 = new javax.swing.JLabel();
        label_wall181 = new javax.swing.JLabel();
        label_wall182 = new javax.swing.JLabel();
        label_wall183 = new javax.swing.JLabel();
        label_wall184 = new javax.swing.JLabel();
        label_wall185 = new javax.swing.JLabel();
        label_wall186 = new javax.swing.JLabel();
        label_wall187 = new javax.swing.JLabel();
        label_wall188 = new javax.swing.JLabel();
        label_wall189 = new javax.swing.JLabel();
        label_wall190 = new javax.swing.JLabel();
        label_wall191 = new javax.swing.JLabel();
        label_wall192 = new javax.swing.JLabel();
        label_wall193 = new javax.swing.JLabel();
        label_wall194 = new javax.swing.JLabel();
        label_wall195 = new javax.swing.JLabel();
        label_wall196 = new javax.swing.JLabel();
        label_wall197 = new javax.swing.JLabel();
        label_wall198 = new javax.swing.JLabel();
        label_wall199 = new javax.swing.JLabel();
        label_goal = new javax.swing.JLabel();
        label_wall200 = new javax.swing.JLabel();
        label_wall201 = new javax.swing.JLabel();
        label_wall202 = new javax.swing.JLabel();
        label_wall203 = new javax.swing.JLabel();
        label_wall204 = new javax.swing.JLabel();
        label_wall205 = new javax.swing.JLabel();
        label_wall206 = new javax.swing.JLabel();
        label_wall207 = new javax.swing.JLabel();
        label_wall208 = new javax.swing.JLabel();
        label_wall209 = new javax.swing.JLabel();
        label_wall210 = new javax.swing.JLabel();
        label_wall211 = new javax.swing.JLabel();
        label_wall212 = new javax.swing.JLabel();
        label_wall213 = new javax.swing.JLabel();
        label_wall214 = new javax.swing.JLabel();
        label_wall215 = new javax.swing.JLabel();
        label_wall216 = new javax.swing.JLabel();
        label_wall217 = new javax.swing.JLabel();
        label_wall218 = new javax.swing.JLabel();
        label_wall219 = new javax.swing.JLabel();
        label_wall220 = new javax.swing.JLabel();
        label_wall221 = new javax.swing.JLabel();
        label_wall222 = new javax.swing.JLabel();
        label_wall223 = new javax.swing.JLabel();
        label_wall224 = new javax.swing.JLabel();
        label_wall225 = new javax.swing.JLabel();
        label_wall226 = new javax.swing.JLabel();
        label_wall227 = new javax.swing.JLabel();
        label_wall228 = new javax.swing.JLabel();
        label_wall229 = new javax.swing.JLabel();
        label_wall230 = new javax.swing.JLabel();
        label_wall231 = new javax.swing.JLabel();
        label_wall232 = new javax.swing.JLabel();
        label_wall233 = new javax.swing.JLabel();
        label_wall234 = new javax.swing.JLabel();
        label_wall235 = new javax.swing.JLabel();
        label_wall236 = new javax.swing.JLabel();
        label_wall237 = new javax.swing.JLabel();
        label_wall238 = new javax.swing.JLabel();
        label_wall239 = new javax.swing.JLabel();
        label_wall240 = new javax.swing.JLabel();
        label_wall241 = new javax.swing.JLabel();
        label_wall242 = new javax.swing.JLabel();
        label_wall243 = new javax.swing.JLabel();
        label_wall244 = new javax.swing.JLabel();
        label_wall245 = new javax.swing.JLabel();
        label_wall246 = new javax.swing.JLabel();
        label_wall247 = new javax.swing.JLabel();
        label_wall248 = new javax.swing.JLabel();
        label_wall249 = new javax.swing.JLabel();
        label_wall250 = new javax.swing.JLabel();
        label_wall251 = new javax.swing.JLabel();
        label_wall252 = new javax.swing.JLabel();
        label_wall253 = new javax.swing.JLabel();
        label_wall254 = new javax.swing.JLabel();
        label_wall255 = new javax.swing.JLabel();
        label_wall256 = new javax.swing.JLabel();
        label_wall257 = new javax.swing.JLabel();
        label_wall258 = new javax.swing.JLabel();
        label_wall259 = new javax.swing.JLabel();
        label_wall260 = new javax.swing.JLabel();
        label_wall261 = new javax.swing.JLabel();
        label_wall262 = new javax.swing.JLabel();
        label_wall263 = new javax.swing.JLabel();
        label_wall264 = new javax.swing.JLabel();
        label_wall265 = new javax.swing.JLabel();
        label_wall266 = new javax.swing.JLabel();
        label_wall267 = new javax.swing.JLabel();
        label_wall268 = new javax.swing.JLabel();
        label_wall269 = new javax.swing.JLabel();
        label_wall270 = new javax.swing.JLabel();
        label_wall271 = new javax.swing.JLabel();
        label_wall272 = new javax.swing.JLabel();
        label_wall273 = new javax.swing.JLabel();
        label_wall274 = new javax.swing.JLabel();
        label_spawn1 = new javax.swing.JLabel();
        label_spawn2 = new javax.swing.JLabel();
        label_spawn3 = new javax.swing.JLabel();
        label_spawn4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 240, 240));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        
        setLayout(null);
        
        endDialog.setLocationRelativeTo( null );
        endDialog.setSize(400, 200);
        endDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        label_wall1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall1);
        label_wall1.setBounds(40, 20, 80, 2);

        label_wall2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall2);
        label_wall2.setBounds(40, 80, 30, 2);

        label_wall3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall3);
        label_wall3.setBounds(120, 20, 2, 60);

        label_auto.setText("Auto");
        label_auto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_auto);
        label_auto.setBounds(70, 590, 30, 16);

        label_wall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall);
        label_wall.setBounds(40, 20, 2, 60);

        label_wall4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall4);
        label_wall4.setBounds(910, 80, 50, 2);

        label_wall5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall5);
        label_wall5.setBounds(860, 20, 2, 60);

        label_wall6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall6);
        label_wall6.setBounds(860, 20, 80, 2);

        label_wall7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall7);
        label_wall7.setBounds(940, 20, 2, 60);

        label_wall8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall8);
        label_wall8.setBounds(900, 570, 30, 2);

        label_wall9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall9);
        label_wall9.setBounds(850, 570, 2, 60);

        label_wall10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall10);
        label_wall10.setBounds(850, 630, 80, 2);

        label_wall11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall11);
        label_wall11.setBounds(930, 570, 2, 60);

        label_wall12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall12);
        label_wall12.setBounds(40, 570, 30, 2);

        label_wall13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall13);
        label_wall13.setBounds(40, 570, 2, 60);

        label_wall14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall14);
        label_wall14.setBounds(0, 360, 130, 2);

        label_wall15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall15);
        label_wall15.setBounds(260, 570, 2, 40);

        label_wall16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall16);
        label_wall16.setBounds(40, 630, 80, 2);

        label_wall17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall17);
        label_wall17.setBounds(120, 570, 80, 2);

        label_wall18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall18);
        label_wall18.setBounds(280, 540, 2, 30);

        label_wall19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall19);
        label_wall19.setBounds(390, 210, 80, 2);

        label_wall20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall20);
        label_wall20.setBounds(30, 450, 50, 2);

        label_wall21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall21);
        label_wall21.setBounds(200, 610, 80, 2);

        label_wall22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall22);
        label_wall22.setBounds(80, 420, 100, 2);

        label_wall23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall23);
        label_wall23.setBounds(450, 562, 40, 0);

        label_wall24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall24);
        label_wall24.setBounds(570, 570, 80, 2);

        label_wall25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall25);
        label_wall25.setBounds(530, 650, 110, 2);

        label_wall26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall26);
        label_wall26.setBounds(540, 240, 2, 20);

        label_wall27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall27);
        label_wall27.setBounds(960, 330, 2, 80);

        label_wall28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall28);
        label_wall28.setBounds(690, 430, 2, 50);

        label_wall29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall29);
        label_wall29.setBounds(0, 400, 2, 250);

        label_wall30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall30);
        label_wall30.setBounds(160, 420, 2, 50);

        label_wall31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall31);
        label_wall31.setBounds(60, 540, 2, 30);

        label_wall32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall32);
        label_wall32.setBounds(80, 390, 2, 60);

        label_wall33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall33);
        label_wall33.setBounds(160, 450, 80, 2);

        label_wall34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall34);
        label_wall34.setBounds(380, 0, 2, 50);

        label_wall35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall35);
        label_wall35.setBounds(820, 280, 140, 2);

        label_wall36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall36);
        label_wall36.setBounds(200, 600, 2, 30);

        label_wall37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall37);
        label_wall37.setBounds(530, 520, 2, 20);

        label_wall38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall38);
        label_wall38.setBounds(460, 400, 80, 2);

        label_wall39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall39);
        label_wall39.setBounds(290, 50, 2, 50);

        label_wall40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall40);
        label_wall40.setBounds(240, 420, 2, 60);

        label_wall41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall41);
        label_wall41.setBounds(490, 600, 40, 2);

        label_wall42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall42);
        label_wall42.setBounds(200, 540, 80, 2);

        label_wall43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall43);
        label_wall43.setBounds(530, 600, 20, 2);

        label_wall44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall44);
        label_wall44.setBounds(490, 340, 2, 30);

        label_wall45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall45);
        label_wall45.setBounds(220, 420, 80, 2);

        label_wall46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall46);
        label_wall46.setBounds(460, 370, 2, 70);

        label_wall47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall47);
        label_wall47.setBounds(80, 450, 30, 2);

        label_wall48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall48);
        label_wall48.setBounds(640, 650, 110, 2);

        label_wall49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall49);
        label_wall49.setBounds(40, 320, 2, 100);

        label_wall50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall50);
        label_wall50.setBounds(0, 490, 30, 2);

        label_wall51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall51);
        label_wall51.setBounds(40, 540, 70, 2);

        label_wall52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall52);
        label_wall52.setBounds(30, 450, 2, 40);

        label_wall53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall53);
        label_wall53.setBounds(160, 600, 2, 50);

        label_wall54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall54);
        label_wall54.setBounds(0, 650, 80, 2);

        label_wall55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall55);
        label_wall55.setBounds(200, 540, 2, 30);

        label_wall56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall56);
        label_wall56.setBounds(70, 480, 60, 2);

        label_wall57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall57);
        label_wall57.setBounds(120, 570, 2, 60);

        label_wall58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall58);
        label_wall58.setBounds(280, 390, 2, 30);

        label_wall59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall59);
        label_wall59.setBounds(670, 470, 20, 2);

        label_wall60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall60);
        label_wall60.setBounds(50, 442, 30, 0);

        label_wall61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall61);
        label_wall61.setBounds(350, 100, 2, 80);

        label_wall62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall62);
        label_wall62.setBounds(150, 510, 90, 2);

        label_wall63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall63);
        label_wall63.setBounds(150, 510, 2, 30);

        label_wall64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall64);
        label_wall64.setBounds(340, 560, 2, 60);

        label_wall65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall65);
        label_wall65.setBounds(540, 310, 20, 2);

        label_wall66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall66);
        label_wall66.setBounds(390, 440, 2, 30);

        label_wall67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall67);
        label_wall67.setBounds(440, 240, 30, 2);

        label_wall68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall68);
        label_wall68.setBounds(90, 480, 2, 60);

        label_wall69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall69);
        label_wall69.setBounds(310, 640, 2, 10);

        label_wall70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall70);
        label_wall70.setBounds(530, 630, 2, 20);

        label_wall71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall71);
        label_wall71.setBounds(440, 340, 100, 2);

        label_wall72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall72);
        label_wall72.setBounds(460, 370, 30, 2);

        label_wall73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall73);
        label_wall73.setBounds(530, 430, 80, 2);

        label_wall74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall74);
        label_wall74.setBounds(190, 80, 70, 2);

        label_wall75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall75);
        label_wall75.setBounds(510, 240, 30, 2);

        label_wall76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall76);
        label_wall76.setBounds(360, 390, 2, 20);

        label_wall77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall77);
        label_wall77.setBounds(440, 290, 2, 20);

        label_wall78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall78);
        label_wall78.setBounds(440, 310, 30, 2);

        label_wall79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall79);
        label_wall79.setBounds(510, 310, 30, 2);

        label_wall80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall80);
        label_wall80.setBounds(540, 290, 2, 20);

        label_wall81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall81);
        label_wall81.setBounds(440, 240, 2, 20);

        label_wall82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall82);
        label_wall82.setBounds(740, 450, 2, 50);

        label_wall83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall83);
        label_wall83.setBounds(540, 310, 2, 30);

        label_wall84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall84);
        label_wall84.setBounds(320, 530, 80, 2);

        label_wall85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall85);
        label_wall85.setBounds(400, 340, 2, 70);

        label_wall86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall86);
        label_wall86.setBounds(480, 480, 130, 2);

        label_wall87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall87);
        label_wall87.setBounds(300, 470, 2, 30);

        label_wall88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall88);
        label_wall88.setBounds(390, 440, 90, 2);

        label_wall89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall89);
        label_wall89.setBounds(860, 630, 2, 20);

        label_wall90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall90);
        label_wall90.setBounds(730, 580, 2, 40);

        label_wall91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall91);
        label_wall91.setBounds(340, 410, 80, 2);

        label_wall92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall92);
        label_wall92.setBounds(570, 480, 2, 20);

        label_wall93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall93);
        label_wall93.setBounds(470, 210, 2, 30);

        label_wall94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall94);
        label_wall94.setBounds(960, 120, 2, 60);

        label_wall95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall95);
        label_wall95.setBounds(650, 400, 80, 2);

        label_wall96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall96);
        label_wall96.setBounds(670, 470, 2, 60);

        label_wall97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall97);
        label_wall97.setBounds(60, 510, 30, 2);

        label_wall98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall98);
        label_wall98.setBounds(290, 470, 100, 2);

        label_wall99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall99);
        label_wall99.setBounds(340, 500, 2, 30);

        label_wall100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall100);
        label_wall100.setBounds(260, 570, 80, 2);

        label_wall101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall101);
        label_wall101.setBounds(450, 190, 2, 20);

        label_wall102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall102);
        label_wall102.setBounds(540, 260, 80, 2);

        label_wall103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall103);
        label_wall103.setBounds(740, 450, 80, 2);

        label_wall104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall104);
        label_wall104.setBounds(960, 480, 2, 110);

        label_wall105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall105);
        label_wall105.setBounds(290, 80, 50, 2);

        label_wall106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall106);
        label_wall106.setBounds(930, 590, 30, 2);

        label_wall107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall107);
        label_wall107.setBounds(860, 650, 100, 2);

        label_wall108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall108);
        label_wall108.setBounds(610, 510, 2, 60);

        label_wall109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall109);
        label_wall109.setBounds(610, 540, 30, 2);

        label_wall110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall110);
        label_wall110.setBounds(700, 180, 40, 2);

        label_wall111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall111);
        label_wall111.setBounds(910, 370, 2, 60);

        label_wall112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall112);
        label_wall112.setBounds(450, 570, 40, 2);

        label_wall113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall113);
        label_wall113.setBounds(530, 650, 110, 2);

        label_wall114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall114);
        label_wall114.setBounds(750, 650, 110, 2);

        label_wall115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall115);
        label_wall115.setBounds(930, 520, 30, 2);

        label_wall116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall116);
        label_wall116.setBounds(340, 600, 110, 2);

        label_wall117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall117);
        label_wall117.setBounds(440, 490, 2, 20);

        label_wall118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall118);
        label_wall118.setBounds(770, 420, 2, 60);

        label_wall119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall119);
        label_wall119.setBounds(940, 350, 20, 2);

        label_wall120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall120);
        label_wall120.setBounds(450, 540, 2, 80);

        label_wall121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall121);
        label_wall121.setBounds(790, 600, 20, 2);

        label_wall122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall122);
        label_wall122.setBounds(830, 570, 20, 2);

        label_wall123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall123);
        label_wall123.setBounds(690, 430, 20, 2);

        label_wall124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall124);
        label_wall124.setBounds(400, 510, 2, 60);

        label_wall125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall125);
        label_wall125.setBounds(400, 510, 80, 2);

        label_wall126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall126);
        label_wall126.setBounds(530, 540, 2, 60);

        label_wall127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall127);
        label_wall127.setBounds(860, 430, 100, 2);

        label_wall128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall128);
        label_wall128.setBounds(960, 180, 2, 80);

        label_wall129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall129);
        label_wall129.setBounds(960, 410, 2, 80);

        label_wall130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall130);
        label_wall130.setBounds(670, 530, 40, 2);

        label_wall131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall131);
        label_wall131.setBounds(710, 400, 2, 50);

        label_wall132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall132);
        label_wall132.setBounds(580, 620, 20, 2);

        label_wall133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall133);
        label_wall133.setBounds(960, 570, 2, 80);

        label_wall134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall134);
        label_wall134.setBounds(740, 540, 100, 2);

        label_wall135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall135);
        label_wall135.setBounds(780, 390, 130, 2);

        label_wall136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall136);
        label_wall136.setBounds(610, 420, 2, 60);

        label_wall137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall137);
        label_wall137.setBounds(420, 30, 130, 2);

        label_wall138.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall138);
        label_wall138.setBounds(800, 120, 2, 60);

        label_wall139.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall139);
        label_wall139.setBounds(780, 180, 100, 2);

        label_wall140.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall140);
        label_wall140.setBounds(690, 530, 2, 60);

        label_wall141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall141);
        label_wall141.setBounds(640, 500, 100, 2);

        label_wall142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall142);
        label_wall142.setBounds(600, 570, 2, 60);

        label_wall143.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall143);
        label_wall143.setBounds(870, 460, 2, 80);

        label_wall144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall144);
        label_wall144.setBounds(810, 490, 100, 2);

        label_wall145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall145);
        label_wall145.setBounds(750, 252, 170, 0);

        label_wall146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall146);
        label_wall146.setBounds(960, 260, 2, 80);

        label_wall147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall147);
        label_wall147.setBounds(850, 320, 2, 80);

        label_wall148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall148);
        label_wall148.setBounds(930, 150, 30, 2);

        label_wall149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall149);
        label_wall149.setBounds(500, 0, 140, 2);

        label_wall150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall150);
        label_wall150.setBounds(960, 40, 2, 80);

        label_wall151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall151);
        label_wall151.setBounds(360, 310, 40, 2);

        label_wall152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall152);
        label_wall152.setBounds(730, 580, 20, 2);

        label_wall153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall153);
        label_wall153.setBounds(610, 450, 40, 2);

        label_wall154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall154);
        label_wall154.setBounds(360, 80, 100, 2);

        label_wall155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall155);
        label_wall155.setBounds(750, 280, 20, 2);

        label_wall156.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall156);
        label_wall156.setBounds(550, 60, 2, 40);

        label_wall157.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall157);
        label_wall157.setBounds(190, 0, 2, 60);

        label_wall158.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall158);
        label_wall158.setBounds(780, 320, 140, 2);

        label_wall160.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall160);
        label_wall160.setBounds(190, 30, 100, 2);

        label_wall161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall161);
        label_wall161.setBounds(510, 460, 2, 20);

        label_wall162.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall162);
        label_wall162.setBounds(540, 370, 80, 2);

        label_wall163.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall163);
        label_wall163.setBounds(360, 310, 2, 20);

        label_wall164.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall164);
        label_wall164.setBounds(730, 340, 2, 60);

        label_wall165.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall165);
        label_wall165.setBounds(800, 120, 160, 2);

        label_wall159.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall159);
        label_wall159.setBounds(370, 0, 130, 2);

        label_wall166.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall166);
        label_wall166.setBounds(640, 570, 2, 80);

        label_wall167.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall167);
        label_wall167.setBounds(800, 0, 160, 2);

        label_wall168.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall168);
        label_wall168.setBounds(740, 120, 2, 60);

        label_wall169.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall169);
        label_wall169.setBounds(430, 650, 100, 2);

        label_wall170.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall170);
        label_wall170.setBounds(560, 460, 2, 20);

        label_wall171.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall171);
        label_wall171.setBounds(0, 0, 140, 2);

        label_wall172.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall172);
        label_wall172.setBounds(650, 50, 0, 70);

        label_wall173.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall173);
        label_wall173.setBounds(960, 0, 2, 60);

        label_wall174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall174);
        label_wall174.setBounds(740, 140, 60, 2);

        label_wall175.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall175);
        label_wall175.setBounds(520, 60, 30, 2);

        label_wall176.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall176);
        label_wall176.setBounds(210, 270, 2, 40);

        label_wall177.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall177);
        label_wall177.setBounds(340, 100, 20, 2);

        label_wall178.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall178);
        label_wall178.setBounds(650, 40, 2, 90);

        label_wall179.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall179);
        label_wall179.setBounds(710, 30, 2, 90);

        label_wall180.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall180);
        label_wall180.setBounds(90, 0, 140, 2);

        label_wall181.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall181);
        label_wall181.setBounds(820, 0, 2, 30);

        label_wall182.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall182);
        label_wall182.setBounds(0, 290, 2, 110);

        label_wall183.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall183);
        label_wall183.setBounds(640, 0, 160, 2);

        label_wall184.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall184);
        label_wall184.setBounds(340, 80, 2, 20);

        label_wall185.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall185);
        label_wall185.setBounds(750, 248, 160, 2);

        label_wall186.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall186);
        label_wall186.setBounds(300, 160, 2, 20);

        label_wall187.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall187);
        label_wall187.setBounds(230, 0, 140, 2);

        label_wall188.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall188);
        label_wall188.setBounds(90, 180, 2, 80);

        label_wall189.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall189);
        label_wall189.setBounds(600, 0, 2, 60);

        label_wall190.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall190);
        label_wall190.setBounds(820, 220, 140, 2);

        label_wall191.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall191);
        label_wall191.setBounds(460, 30, 2, 70);

        label_wall192.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall192);
        label_wall192.setBounds(140, 80, 2, 40);

        label_wall193.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall193);
        label_wall193.setBounds(340, 290, 100, 2);

        label_wall194.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall194);
        label_wall194.setBounds(700, 180, 2, 80);

        label_wall195.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall195);
        label_wall195.setBounds(850, 350, 30, 2);

        label_wall196.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall196);
        label_wall196.setBounds(230, 330, 130, 2);

        label_wall197.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall197);
        label_wall197.setBounds(270, 180, 100, 2);

        label_wall198.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall198);
        label_wall198.setBounds(340, 180, 2, 80);

        label_wall199.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall199);
        label_wall199.setBounds(890, 100, 2, 20);

        label_goal.setBackground(new java.awt.Color(255, 0, 0));
        label_goal.setOpaque(true);
        add(label_goal);
        label_goal.setBounds(440, 240, 100, 70);

        label_wall200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall200);
        label_wall200.setBounds(230, 170, 2, 100);

        label_wall201.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall201);
        label_wall201.setBounds(50, 180, 40, 2);

        label_wall202.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall202);
        label_wall202.setBounds(330, 360, 2, 30);

        label_wall203.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall203);
        label_wall203.setBounds(270, 240, 70, 2);

        label_wall204.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall204);
        label_wall204.setBounds(820, 60, 2, 60);

        label_wall205.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall205);
        label_wall205.setBounds(680, 620, 100, 2);

        label_wall206.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall206);
        label_wall206.setBounds(790, 520, 2, 80);

        label_wall207.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall207);
        label_wall207.setBounds(330, 650, 100, 2);

        label_wall208.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall208);
        label_wall208.setBounds(230, 650, 100, 2);

        label_wall209.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall209);
        label_wall209.setBounds(330, 650, 100, 2);

        label_wall210.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall210);
        label_wall210.setBounds(130, 650, 100, 2);

        label_wall211.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall211);
        label_wall211.setBounds(30, 650, 100, 2);

        label_wall212.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall212);
        label_wall212.setBounds(510, 540, 100, 2);

        label_wall213.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall213);
        label_wall213.setBounds(280, 500, 80, 2);

        label_wall214.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall214);
        label_wall214.setBounds(0, 0, 2, 110);

        label_wall215.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall215);
        label_wall215.setBounds(50, 110, 120, 2);

        label_wall216.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall216);
        label_wall216.setBounds(190, 60, 130, 2);

        label_wall217.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall217);
        label_wall217.setBounds(290, 270, 2, 80);

        label_wall218.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall218);
        label_wall218.setBounds(490, 170, 100, 2);

        label_wall219.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall219);
        label_wall219.setBounds(580, 200, 2, 60);

        label_wall220.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall220);
        label_wall220.setBounds(510, 90, 140, 2);

        label_wall221.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall221);
        label_wall221.setBounds(210, 130, 100, 2);

        label_wall222.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall222);
        label_wall222.setBounds(190, 480, 2, 30);

        label_wall223.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall223);
        label_wall223.setBounds(230, 50, 2, 60);

        label_wall224.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall224);
        label_wall224.setBounds(280, 390, 80, 2);

        label_wall225.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall225);
        label_wall225.setBounds(340, 410, 2, 60);

        label_wall226.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall226);
        label_wall226.setBounds(670, 0, 2, 20);

        label_wall227.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall227);
        label_wall227.setBounds(150, 30, 40, 2);

        label_wall228.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall228);
        label_wall228.setBounds(360, 80, 2, 20);

        label_wall229.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall229);
        label_wall229.setBounds(350, 130, 30, 2);

        label_wall230.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall230);
        label_wall230.setBounds(580, 280, 40, 2);

        label_wall231.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall231);
        label_wall231.setBounds(210, 210, 100, 2);

        label_wall232.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall232);
        label_wall232.setBounds(160, 180, 2, 50);

        label_wall233.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall233);
        label_wall233.setBounds(420, 210, 2, 20);

        label_wall234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall234);
        label_wall234.setBounds(630, 210, 140, 2);

        label_wall235.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall235);
        label_wall235.setBounds(190, 160, 2, 20);

        label_wall236.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall236);
        label_wall236.setBounds(190, 270, 100, 2);

        label_wall237.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall237);
        label_wall237.setBounds(292, 270, 0, 60);

        label_wall238.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall238);
        label_wall238.setBounds(120, 80, 30, 2);

        label_wall239.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall239);
        label_wall239.setBounds(420, 130, 140, 2);

        label_wall240.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall240);
        label_wall240.setBounds(770, 0, 2, 110);

        label_wall241.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall241);
        label_wall241.setBounds(0, 110, 2, 110);

        label_wall242.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall242);
        label_wall242.setBounds(0, 200, 2, 110);

        label_wall243.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall243);
        label_wall243.setBounds(420, 110, 2, 70);

        label_wall244.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall244);
        label_wall244.setBounds(610, 122, 130, 2);

        label_wall245.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall245);
        label_wall245.setBounds(170, 160, 20, 2);

        label_wall246.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall246);
        label_wall246.setBounds(640, 170, 2, 40);

        label_wall247.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall247);
        label_wall247.setBounds(170, 110, 2, 50);

        label_wall248.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall248);
        label_wall248.setBounds(130, 180, 100, 2);

        label_wall249.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall249);
        label_wall249.setBounds(650, 240, 100, 2);

        label_wall250.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall250);
        label_wall250.setBounds(60, 290, 80, 2);

        label_wall251.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall251);
        label_wall251.setBounds(530, 130, 2, 80);

        label_wall252.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall252);
        label_wall252.setBounds(180, 320, 2, 60);

        label_wall253.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall253);
        label_wall253.setBounds(60, 260, 2, 30);

        label_wall254.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall254);
        label_wall254.setBounds(0, 140, 100, 2);

        label_wall255.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall255);
        label_wall255.setBounds(140, 210, 20, 2);

        label_wall256.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall256);
        label_wall256.setBounds(840, 120, 2, 20);

        label_wall257.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall257);
        label_wall257.setBounds(40, 260, 110, 2);

        label_wall258.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall258);
        label_wall258.setBounds(750, 230, 2, 60);

        label_wall259.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall259);
        label_wall259.setBounds(0, 220, 40, 2);

        label_wall260.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall260);
        label_wall260.setBounds(180, 360, 40, 2);

        label_wall261.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall261);
        label_wall261.setBounds(240, 330, 2, 60);

        label_wall262.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall262);
        label_wall262.setBounds(220, 390, 20, 2);

        label_wall263.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall263);
        label_wall263.setBounds(80, 320, 100, 2);

        label_wall264.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall264);
        label_wall264.setBounds(690, 300, 2, 60);

        label_wall265.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall265);
        label_wall265.setBounds(670, 360, 130, 2);

        label_wall266.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall266);
        label_wall266.setBounds(620, 260, 2, 80);

        label_wall267.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall267);
        label_wall267.setBounds(610, 320, 100, 2);

        label_wall268.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall268);
        label_wall268.setBounds(580, 340, 2, 60);

        label_wall269.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall269);
        label_wall269.setBounds(730, 280, 20, 2);

        label_wall270.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall270);
        label_wall270.setBounds(620, 280, 40, 2);

        label_wall271.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall271);
        label_wall271.setBounds(220, 360, 2, 30);

        label_wall272.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall272);
        label_wall272.setBounds(160, 380, 20, 2);

        label_wall273.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall273);
        label_wall273.setBounds(80, 290, 2, 50);

        label_wall274.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(label_wall274);
        label_wall274.setBounds(380, 250, 2, 60);
        add(label_spawn1);
        label_spawn1.setBounds(850, 570, 80, 60);
        add(label_spawn2);
        label_spawn2.setBounds(40, 20, 80, 60);
        add(label_spawn3);
        label_spawn3.setBounds(40, 570, 80, 60);
        add(label_spawn4);
        label_spawn4.setBounds(860, 20, 80, 60);
    }
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        if(timerflag == 0){
            startTime = System.currentTimeMillis();
            timerflag = 1;
        }
          switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT:{ if(checkPosition(label_auto.getLocationOnScreen(), -2, 0) == false){
                         break;
                      }else{ 
                         label_auto.setLocation(label_auto.getX()-2, label_auto.getY());
                         break;
                      }
                    }
            case KeyEvent.VK_UP:{ if(checkPosition(label_auto.getLocationOnScreen(), 0, -2) == false){
                         break;
                      }else{ 
                         label_auto.setLocation(label_auto.getX(), label_auto.getY()-2); break;
                      }
                    }
            case KeyEvent.VK_RIGHT:{ if(checkPosition(label_auto.getLocationOnScreen(), label_auto.getWidth()+2, 0) == false){
                         break;
                      }else{ 
                         label_auto.setLocation(label_auto.getX()+2, label_auto.getY()); break;
                      }
                    }
            case KeyEvent.VK_DOWN:{ if(checkPosition(label_auto.getLocationOnScreen(), 0, label_auto.getHeight()+2) == false){
                         break;
                      }else{ 
                          label_auto.setLocation(label_auto.getX(), label_auto.getY()+2); break;
                      }
                    }    
        }
    }                               

    private void formKeyReleased(java.awt.event.KeyEvent evt) {                                 
        formKeyPressed(evt);
    }                                

    private void formKeyTyped(java.awt.event.KeyEvent evt) {                              
        formKeyPressed(evt);
    }                             

    /**
     * This function is called whenever the car-label is moved.
     * It takes the current position and looks if the next pixel is either black or red.
     * If it is red, there is a collision. If it is red, the game is finished. 
     * 
     * @param labelPoint    the paint where the car label is at the moment
     * @param lookaheadX    the next x position where the car would go
     * @param lookaheadY    the next y position where the car would go
     * @return              returns if the car is allowed to go there or if there is a collision
     */
    public boolean checkPosition(Point labelPoint, int lookaheadX, int lookaheadY){
            try {
                Robot test = new Robot();
                    Color color = test.getPixelColor(labelPoint.x+lookaheadX, labelPoint.y+lookaheadY);
                    //System.out.print("Red: "+color.getRed()+"\n");
                    //System.out.print("Green: "+color.getGreen()+"\n");
                    //System.out.print("Blue: "+color.getBlue()+"\n");
                    if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0){
                        return false;
                    }
                    if((color.getRed() == 255 && color.getGreen() == 0 && color.getBlue() == 0) || (color.getRed() == 238 && color.getGreen() == 0 && color.getBlue() == 0)){
                        endTime = System.currentTimeMillis();
                        long finalTime = (endTime - startTime)/1000;
                        gameEnd(finalTime);
                        startSetup();
                        Sims_1.button_afterGame.doClick();  // Flips to the planning phase!
                    }
            } catch (AWTException ex) {
                Logger.getLogger(MinigameMazegame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    /**
     * Whenever a game is called from another panel the start timer and the startposition are reseted.
     */
    public void startSetup(){
        startTime = 0;
        endTime = 0;
        int spawn = new RandGenerator().getRand(4);
        switch(spawn){
            case 0:{label_auto.setLocation(label_spawn1.getX()+30, label_spawn1.getY()+20);break;} 
            case 1:{label_auto.setLocation(label_spawn2.getX()+30, label_spawn2.getY()+20);break;}
            case 2:{label_auto.setLocation(label_spawn3.getX()+30, label_spawn3.getY()+20);break;}
            case 3:{label_auto.setLocation(label_spawn4.getX()+30, label_spawn4.getY()+20);break;}
        }
    }
    
    /**
     * Creates the popup that shows the result after the end of the game.
     * Updates the credits and the points as well.
     * @param time the tame that was taken to finish the game
     */
    public void gameEnd(long time){
        int points;
        int credits;
        JPanel endGameBackground = new JPanel();
        endGameBackground.setBounds(0, 0, 500, 200);
        endGameBackground.setLayout(null);
        endGameBackground.setBackground(Color.black);
        endGameBackground.setOpaque(true);
        endDialog.setTitle("Labyrinth - Gewonnen");
        endDialog.setBounds(getWidth()/2, 300, 500, 200);
        endDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        endDialog.setLayout(null);
        endDialog.setResizable(false);
        //endDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        JLabel label_headline = new JLabel("Gewonnen!");
        JLabel label_gameTime = new JLabel("Zeit: " + time + " Sekunden!");
        JLabel label_Punkte = new JLabel();
        JLabel label_credits = new JLabel();
        label_headline.setFont(new Font("Text", 1,20));
        label_headline.setBounds(0, 10, 500, 20);
        label_headline.setForeground(Color.green);
        label_headline.setHorizontalAlignment(JLabel.CENTER);
        label_gameTime.setFont(new Font("Text", 1,20));
        label_gameTime.setBounds(0, 50, 500, 20);
        label_gameTime.setHorizontalAlignment(JLabel.CENTER);
        label_gameTime.setForeground(Color.green);
        label_Punkte.setFont(new Font("Text", 1,20));
        label_Punkte.setBounds(0, 90, 500, 20);
        label_Punkte.setHorizontalAlignment(JLabel.CENTER);
        label_Punkte.setForeground(Color.green);
        if(time <= 18){
            points = 500;
            credits = 200;
        }
        else if(time >= 25 && time <= 40){
            points = 300;
            credits = 100;
        }
        else{
            points = 100;
            credits = 60;
        }
        Sims_1._maingame.points += points;
        Sims_1._maingame.credits += credits;
        Sims_1._maingame.overallCredits += credits;
        label_Punkte.setText("Punkte: " + points + "   Neuer Punktestand: " + Sims_1._maingame.points);
        label_credits.setFont(new Font("Text", 1,20));
        label_credits.setBounds(0, 130, 500, 20);
        label_credits.setHorizontalAlignment(JLabel.CENTER);
        label_credits.setForeground(Color.green);
        label_credits.setText("Credits: " + credits + "   Neuer Punktestand: " + Sims_1._maingame.credits);
        endGameBackground.add(label_headline);
        endGameBackground.add(label_gameTime);
        endGameBackground.add(label_Punkte);
        endGameBackground.add(label_credits);
        endDialog.add(endGameBackground);
        endDialog.setVisible(true);
    }
}
