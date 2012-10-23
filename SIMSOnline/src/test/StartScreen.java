/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author rusinda
 */
public class StartScreen extends javax.swing.JFrame {

    private boolean checkAlphaNumm(char[] str) {     //checks if a string contains only of numbers and letters
        int i;
        for (i = 0; i < str.length; i++) {
            if (!(Character.isDigit(str[i]) | Character.isLetter(str[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEmail(String str) {
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

    private boolean checkName(String str) {
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

    private boolean checkGlobUser(String str) {
        try {
            java.util.LinkedList<java.util.LinkedList> list = CSVHandling.readCSV("users.csv");
            for (java.util.LinkedList sublist : list) {
                if (sublist.contains(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private void checkRegister() {
        boolean check = true;
        if (textfield_rKontoname.getText().length() < 5 | textfield_rKontoname.getText().length() > 15 | checkGlobUser(textfield_rKontoname.getText())) {
            textfield_rKontoname.setBackground(Color.red);
            check = false;
        } else {
            textfield_rKontoname.setBackground(Color.white);
        }
        if (password_rPass1.getPassword().length < 5 | password_rPass1.getPassword().length > 15 | !checkAlphaNumm(password_rPass1.getPassword())) {
            password_rPass1.setBackground(Color.red);
            password_rPass2.setText("");
            check = false;
        } else {
            password_rPass1.setBackground(Color.white);
        }
        if (!new String(password_rPass1.getPassword()).equals(new String(password_rPass2.getPassword()))) {
            password_rPass1.setBackground(Color.red);
            password_rPass2.setBackground(Color.red);
            check = false;
        } else {
            password_rPass1.setBackground(Color.white);
            password_rPass2.setBackground(Color.white);
        }
        if (textfield_rEmail1.getText().length() < 5 | !checkEmail(textfield_rEmail1.getText()) | checkGlobUser(textfield_rEmail1.getText())) {
            textfield_rEmail1.setBackground(Color.red);
            check = false;
            textfield_rEmail2.setText("");
        } else {
            textfield_rEmail1.setBackground(Color.white);
        }
        if (!textfield_rEmail1.getText().equals(textfield_rEmail2.getText())) {
            textfield_rEmail1.setBackground(Color.red);
            textfield_rEmail2.setBackground(Color.red);
            check = false;
        } else {
            textfield_rEmail1.setBackground(Color.white);
            textfield_rEmail2.setBackground(Color.white);
        }
        if (!checkName(textfield_rName.getText())) {
            textfield_rName.setBackground(Color.red);
            check = false;
        } else {
            textfield_rName.setBackground(Color.white);
        }
        if (!checkName(textfield_rSurename.getText())) {
            textfield_rSurename.setBackground(Color.red);
            check = false;
        } else {
            textfield_rSurename.setBackground(Color.white);
        }

        if (check) {
            createUser(textfield_rKontoname.getText(), password_rPass1.getPassword(), textfield_rEmail1.getText(), textfield_rName.getText(), textfield_rSurename.getText());
        }
    }

    private void createUser(String accountname, char[] password, String email, String first_name, String last_name) {
    }

    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
        initComponents();
        panel_Register.setVisible(false);
//        String[] str = new String[2];
//        str[0] = "hallo";
//        str[1] = "hier";
//        try{
//        CSVHandling.writeFile(str, "testtest.csv");
//        } catch (Exception e){
//        e.printStackTrace();}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Register = new javax.swing.JPanel();
        textfield_rKontoname = new javax.swing.JTextField();
        textfield_rEmail1 = new javax.swing.JTextField();
        textfield_rEmail2 = new javax.swing.JTextField();
        textfield_rName = new javax.swing.JTextField();
        textfield_rSurename = new javax.swing.JTextField();
        password_rPass1 = new javax.swing.JPasswordField();
        password_rPass2 = new javax.swing.JPasswordField();
        button_rRegister = new javax.swing.JButton();
        panel_Login = new javax.swing.JPanel();
        textfield_Kontoname = new javax.swing.JTextField();
        textfield_Password = new javax.swing.JTextField();
        button_Login = new javax.swing.JButton();
        button_Register = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textfield_rKontoname.setText("Kontoname");
        textfield_rKontoname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rKontonameFocusGained(evt);
            }
        });

        textfield_rEmail1.setText("E-Mail");
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

        textfield_rEmail2.setText("E-Mail");
        textfield_rEmail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rEmail2FocusGained(evt);
            }
        });

        textfield_rName.setText("Name");
        textfield_rName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rNameFocusGained(evt);
            }
        });

        textfield_rSurename.setText("Nachname");
        textfield_rSurename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_rSurenameFocusGained(evt);
            }
        });

        password_rPass1.setText("PW");
        password_rPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_rPass1FocusGained(evt);
            }
        });

        password_rPass2.setText("PW");
        password_rPass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_rPass2FocusGained(evt);
            }
        });

        button_rRegister.setText("Registrieren");
        button_rRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_RegisterLayout = new javax.swing.GroupLayout(panel_Register);
        panel_Register.setLayout(panel_RegisterLayout);
        panel_RegisterLayout.setHorizontalGroup(
            panel_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegisterLayout.createSequentialGroup()
                .addGroup(panel_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textfield_rKontoname)
                        .addComponent(password_rPass2)
                        .addComponent(password_rPass1)
                        .addComponent(textfield_rEmail1)
                        .addComponent(textfield_rEmail2)
                        .addComponent(textfield_rName)
                        .addComponent(textfield_rSurename))
                    .addComponent(button_rRegister))
                .addGap(0, 376, Short.MAX_VALUE))
        );
        panel_RegisterLayout.setVerticalGroup(
            panel_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegisterLayout.createSequentialGroup()
                .addComponent(textfield_rKontoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_rPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_rPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(textfield_rEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield_rEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield_rName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield_rSurename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_rRegister)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        textfield_Kontoname.setText("Kontoname");

        textfield_Password.setText("Passwort");

        button_Login.setText("Login");

        button_Register.setText("Registrieren");
        button_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_LoginLayout = new javax.swing.GroupLayout(panel_Login);
        panel_Login.setLayout(panel_LoginLayout);
        panel_LoginLayout.setHorizontalGroup(
            panel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_LoginLayout.createSequentialGroup()
                        .addComponent(button_Login)
                        .addGap(65, 65, 65)
                        .addComponent(button_Register))
                    .addComponent(textfield_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_Kontoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        panel_LoginLayout.setVerticalGroup(
            panel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textfield_Kontoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textfield_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(panel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Login)
                    .addComponent(button_Register))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textfield_rEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_rEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_rEmail1ActionPerformed

    private void button_rRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rRegisterActionPerformed
        checkRegister();
    }//GEN-LAST:event_button_rRegisterActionPerformed

    private void button_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RegisterActionPerformed
        panel_Login.setVisible(false);
        panel_Register.setVisible(true);
    }//GEN-LAST:event_button_RegisterActionPerformed

    private void textfield_rKontonameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rKontonameFocusGained
        textfield_rKontoname.requestFocus();
        textfield_rKontoname.selectAll();
    }//GEN-LAST:event_textfield_rKontonameFocusGained

    private void textfield_rEmail1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rEmail1FocusGained
        textfield_rEmail1.requestFocus();
        textfield_rEmail1.selectAll();
    }//GEN-LAST:event_textfield_rEmail1FocusGained

    private void textfield_rEmail2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rEmail2FocusGained
        textfield_rEmail2.requestFocus();
        textfield_rEmail2.selectAll();
    }//GEN-LAST:event_textfield_rEmail2FocusGained

    private void textfield_rNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rNameFocusGained
        textfield_rName.requestFocus();
        textfield_rName.selectAll();
    }//GEN-LAST:event_textfield_rNameFocusGained

    private void textfield_rSurenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_rSurenameFocusGained
        textfield_rSurename.requestFocus();
        textfield_rSurename.selectAll();
    }//GEN-LAST:event_textfield_rSurenameFocusGained

    private void password_rPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_rPass1FocusGained
        password_rPass1.requestFocus();
        password_rPass1.selectAll();
    }//GEN-LAST:event_password_rPass1FocusGained

    private void password_rPass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_rPass2FocusGained
        password_rPass2.requestFocus();
        password_rPass2.selectAll();
    }//GEN-LAST:event_password_rPass2FocusGained

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
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new StartScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Login;
    private javax.swing.JToggleButton button_Register;
    private javax.swing.JButton button_rRegister;
    private javax.swing.JPanel panel_Login;
    private javax.swing.JPanel panel_Register;
    private javax.swing.JPasswordField password_rPass1;
    private javax.swing.JPasswordField password_rPass2;
    private javax.swing.JTextField textfield_Kontoname;
    private javax.swing.JTextField textfield_Password;
    private javax.swing.JTextField textfield_rEmail1;
    private javax.swing.JTextField textfield_rEmail2;
    private javax.swing.JTextField textfield_rKontoname;
    private javax.swing.JTextField textfield_rName;
    private javax.swing.JTextField textfield_rSurename;
    // End of variables declaration//GEN-END:variables
}
