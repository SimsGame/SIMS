/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stazzer
 */
public class MazeGame extends javax.swing.JFrame {

    /**
     * Creates new form MazeGame
     */
    public MazeGame() {
        initComponents();
        setSize(1000, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_wall1 = new javax.swing.JLabel();
        label_wall2 = new javax.swing.JLabel();
        label_wall3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_wall = new javax.swing.JLabel();
        label_auto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
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
        getContentPane().setLayout(null);

        label_wall1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(label_wall1);
        label_wall1.setBounds(210, 30, 170, 2);

        label_wall2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(label_wall2);
        label_wall2.setBounds(200, 230, 170, 2);

        label_wall3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(label_wall3);
        label_wall3.setBounds(360, 50, 2, 170);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        label_wall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(label_wall);
        label_wall.setBounds(10, 10, 10, 170);

        label_auto.setText("Auto");
        label_auto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(label_auto);
        label_auto.setBounds(30, 80, 30, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 120, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //System.out.print(evt.getKeyCode()+"\n");
        switch(evt.getKeyCode()){
            case 37:{ if(checkPosition(label_auto.getLocationOnScreen()) == false){
                         System.out.print(label_auto.getX()+" "+label_auto.getY()+"\n");
                         break;
                      }else{ 
                         label_auto.setLocation(label_auto.getX()-1, label_auto.getY());
                         System.out.print(label_auto.getX()+" "+label_auto.getY()+"\n"); break;
                      }
                    }
            case 38:{ /*if(checkPosition(label_auto.getX(),  label_auto.getY()+1) == false){
                         break;
                      }else{ 
                         label_auto.setLocation(label_auto.getX(), label_auto.getY()-1); break;
                      }*/
                      label_auto.setLocation(label_auto.getX(), label_auto.getY()-1); break;
                    }
            case 39:{ label_auto.setLocation(label_auto.getX()+1, label_auto.getY()); break;}
            case 40:{ label_auto.setLocation(label_auto.getX(), label_auto.getY()+1); break;}    
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        formKeyPressed(evt);
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        formKeyPressed(evt);
    }//GEN-LAST:event_formKeyTyped

    public boolean checkPosition(Point labelPoint){
        //if(x > label_wall.getX() && y < label_wall.getY() ){
            try {
                Robot test = new Robot();
                    //System.out.print("X: "+x+" Y :"+y);
                    Color color = test.getPixelColor(labelPoint.x, labelPoint.y);
                    //System.out.print("RGB: "+color.getRGB()+"\n");
                    System.out.print("Red: "+color.getRed()+"\n");
                    System.out.print("Green: "+color.getGreen()+"\n");
                    System.out.print("Blue: "+color.getBlue()+"\n");
                    if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0){
                        return false;
                    }
            } catch (AWTException ex) {
                Logger.getLogger(MazeGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(MazeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MazeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MazeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MazeGame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_auto;
    private javax.swing.JLabel label_wall;
    private javax.swing.JLabel label_wall1;
    private javax.swing.JLabel label_wall2;
    private javax.swing.JLabel label_wall3;
    // End of variables declaration//GEN-END:variables
}
