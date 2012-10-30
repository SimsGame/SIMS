/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Stazzer
 */
public class NumberGame extends javax.swing.JFrame {

    private JPanel contentPane;
    public JLabel label_points;
    public int counter = 0, nextNumber = counter+1;
    public final int maxNumbers = 5;
    
    /**
     * Creates new form NumberGame
     */
    public NumberGame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
                label_points = new JLabel();
                label_points.setText(" Gefundene Zahlen: 0/"+maxNumbers);
                label_points.setFont(new Font("Weiter", 1,14));
                label_points.setForeground(Color.green);
                label_points.setOpaque(true);
                label_points.setBackground(Color.black);
                label_points.setBounds(0, 0, 170, 30);
                contentPane.add(label_points);
                
		/** Field one, the first field that has to be clicked.
                 *
                 */
                
		final JLabel one = new JLabel("");
                one.setHorizontalAlignment(JLabel.CENTER);
                one.setFont(new Font("Weiter", 1,24));
                one.setBackground(Color.white);
		one.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(counter == 0) { one.setText("Eins"); counter = 1; one.setOpaque(true); updatePoints();}
				else if(counter != 1 && !one.getText().equals("Eins")) {one.setText("1"); counter = 0; one.setOpaque(true);}
			}
		});
		one.setBounds(new RandGenerator().getRand(900)/*243*/, new RandGenerator().getRand(600)/*153*/, 77, 40);
		contentPane.add(one);
		
		/** Field two, the second field that has to be clicked
		 * If it was not entered after the first one
		 * an error occures an it gets erased. */
		final JLabel two = new JLabel("");
                two.setHorizontalAlignment(JLabel.CENTER);
                two.setFont(new Font("Weiter", 1,24));
                two.setBackground(Color.white);
		two.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(one.getText().equals("Eins")) { two.setText("Zwei"); counter = 2; two.setOpaque(true); updatePoints();}
				else {two.setText("2"); counter = 0; two.setOpaque(true);}
			}
		});
		two.setBounds(new RandGenerator().getRand(900)/*433*/, new RandGenerator().getRand(600)/*53*/, 65, 40);
		contentPane.add(two);
		
		/** Field three, the third field that has to be clicked
		 * If it was not entered after the second one
		 * an error occures an it gets erased. */
		final JLabel three = new JLabel("");
                three.setHorizontalAlignment(JLabel.CENTER);
                three.setFont(new Font("Weiter", 1,24));
                three.setBackground(Color.white);
		three.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(two.getText().equals("Zwei")) { three.setText("Drei"); counter = 3; three.setOpaque(true); updatePoints();}
				else {three.setText("3"); counter = 0; three.setOpaque(true);}
			}
		});
		three.setBounds(new RandGenerator().getRand(900)/*116*/, new RandGenerator().getRand(600)/*403*/, 77, 40);
		contentPane.add(three);
		
		/** Field four, the fourth field that has to be clicked
		 * If it was not entered after the third one
		 * an error occures an it gets erased. */
		final JLabel four = new JLabel("");
                four.setHorizontalAlignment(JLabel.CENTER);
                four.setFont(new Font("Weiter", 1,24));
                four.setBackground(Color.white);
		four.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				if(three.getText().equals("Drei")) { four.setText("Vier"); counter = 4; four.setOpaque(true); updatePoints();}
				else {four.setText("4"); counter = 0; four.setOpaque(true);}
			}
		});
		four.setBounds(new RandGenerator().getRand(900)/*569*/, new RandGenerator().getRand(600)/*293*/, 72, 40);
		contentPane.add(four);
                
                /** Field five, the fifth field that has to be clicked
		 * If it was not entered after the fourth one
		 * an error occures an it gets erased. */
		final JLabel five = new JLabel("");
                five.setHorizontalAlignment(JLabel.CENTER);
                five.setFont(new Font("Weiter", 1,24));
                five.setBackground(Color.white);
		five.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				if(four.getText().equals("Vier")) { five.setText("Fünf"); counter = 5; five.setOpaque(true); updatePoints();}
				else {five.setText("5"); counter = 0; five.setOpaque(true);}
			}
		});
		five.setBounds(new RandGenerator().getRand(900)/*569*/, new RandGenerator().getRand(600)/*293*/, 72, 40);
		contentPane.add(five);
		
                final JLabel label_door = new JLabel("");
                label_door.setBackground(Color.black);
                label_door.setBounds(530, 170, 150, 200);
                label_door.setOpaque(true);
                label_door.setVisible(false);
		
		final JButton btnReset = new JButton("Nochmal");
                btnReset.setFont(new Font("Nochmal", 1,18));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				one.setText("");
                                one.setOpaque(false);
				one.setBounds(new RandGenerator().getRand(900)/*243*/, new RandGenerator().getRand(600)/*153*/, 77, 40);
				two.setText("");
                                two.setOpaque(false);
				two.setBounds(new RandGenerator().getRand(900)/*433*/, new RandGenerator().getRand(600)/*53*/, 65, 40);
				three.setText("");
                                three.setOpaque(false);
				three.setBounds(new RandGenerator().getRand(900)/*116*/, new RandGenerator().getRand(600)/*403*/, 77, 40);
				four.setText("");
                                four.setOpaque(false);
				four.setBounds(new RandGenerator().getRand(900)/*569*/, new RandGenerator().getRand(600)/*293*/, 72, 40);
                                five.setText("");
                                five.setOpaque(false);
				five.setBounds(new RandGenerator().getRand(900)/*569*/, new RandGenerator().getRand(600)/*293*/, 72, 40);
				counter = 0;
                                updatePoints();
			}
		});
		btnReset.setBounds(560, 270, 110, 43);
                btnReset.setVisible(false);
		
		
		final JButton btnWeiter = new JButton("Weiter");
                btnWeiter.setFont(new Font("Weiter", 1,18));
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
                             System.out.print("Lvl.1 Geschafft!");
			}
		});
		btnWeiter.setBounds(560, 200, 110, 43);/*890, 620*/
                btnWeiter.setVisible(false);
                
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/numberGame1000x700.png")));
		lblNewLabel.setBounds(0, 0, 1000, 700);
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(one.getText().equals("1") || two.getText().equals("2") || three.getText().equals("3") || four.getText().equals("4") || five.getText().equals("5")) {
					one.setText(""); one.setOpaque(false);
					two.setText(""); two.setOpaque(false);
					three.setText(""); three.setOpaque(false);
					four.setText(""); four.setOpaque(false);
                                        five.setText(""); five.setOpaque(false);
					counter = 0;
                                        updatePoints();
				}
                                if(counter==5){
                                    updatePoints();
                                    label_door.setVisible(true);
                                    btnWeiter.setVisible(true);
                                    btnReset.setVisible(true);
                                }
			}
		});
                
                /**
                 * Section for adding labels to pane.
                 */     
                contentPane.add(btnReset);
		contentPane.add(btnWeiter);
                contentPane.add(label_door);
                contentPane.add(lblNewLabel);
                
    }

    public void updatePoints(){
        label_points.setText(" Gefundene Zahlen: "+counter+"/"+maxNumbers);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NumberGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NumberGame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
