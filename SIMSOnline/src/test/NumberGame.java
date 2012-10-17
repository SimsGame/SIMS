/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Stazzer
 */
public class NumberGame extends javax.swing.JFrame {

    private JPanel contentPane;
    private JPanel secondPane;
    public int counter = 0, nextNumber = counter+1;
    
    /**
     * Creates new form NumberGame
     */
    public NumberGame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/** Field one, the first field that has to be clicked*/
		final JLabel one = new JLabel("");
		one.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(counter == 0) { one.setText("Eins"); counter = 1;}
				else if(counter != 1 && !one.getText().equals("Eins")) {one.setText("1"); counter = 0;}
			}
		});
		one.setBounds(new RandGenerator().getRand(770)/*243*/, new RandGenerator().getRand(380)/*153*/, 77, 40);
		contentPane.add(one);
		
		/** Field two, the second field that has to be clicked
		 * If it was not entered after the first one
		 * an error occures an it gets erased */
		final JLabel two = new JLabel("");
		two.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(one.getText().equals("Eins")) { two.setText("Zwei"); counter = 2;}
				else {two.setText("2"); counter = 0;}
			}
		});
		two.setBounds(new RandGenerator().getRand(770)/*433*/, new RandGenerator().getRand(380)/*53*/, 65, 40);
		contentPane.add(two);
		
		/** Field three, the third field that has to be clicked
		 * If it was not entered after the second one
		 * an error occures an it gets erased */
		final JLabel three = new JLabel("");
		three.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(two.getText().equals("Zwei")) { three.setText("Drei"); counter = 3;}
				else {three.setText("3"); counter = 0;}
			}
		});
		three.setBounds(new RandGenerator().getRand(770)/*116*/, new RandGenerator().getRand(380)/*403*/, 77, 40);
		contentPane.add(three);
		
		/** Field four, the fourth field that has to be clicked
		 * If it was not entered after the third one
		 * an error occures an it gets erased */
		final JLabel four = new JLabel("");
		four.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				if(three.getText().equals("Drei")) { four.setText("Vier"); counter = 4;}
				else {four.setText("4"); counter = 0;}
			}
		});
		four.setBounds(new RandGenerator().getRand(770)/*569*/, new RandGenerator().getRand(380)/*293*/, 72, 40);
		contentPane.add(four);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(NumberGame.class.getResource("/com/company/jannik/3.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 562);
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(one.getText().equals("1") || two.getText().equals("2") || three.getText().equals("3") || four.getText().equals("4")) {
					one.setText("");
					two.setText("");
					three.setText("");
					four.setText("");
					counter = 0;
				}
			}
		});
		
		JButton btnReset = new JButton("Nochmal");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				one.setText("");
				one.setBounds(new RandGenerator().getRand(770)/*243*/, new RandGenerator().getRand(380)/*153*/, 77, 40);
				two.setText("");
				two.setBounds(new RandGenerator().getRand(770)/*433*/, new RandGenerator().getRand(380)/*53*/, 65, 40);
				three.setText("");
				three.setBounds(new RandGenerator().getRand(770)/*116*/, new RandGenerator().getRand(380)/*403*/, 77, 40);
				four.setText("");
				four.setBounds(new RandGenerator().getRand(770)/*569*/, new RandGenerator().getRand(380)/*293*/, 72, 40);
				counter = 0;
			}
		});
		btnReset.setBounds(587, 509, 91, 23);
		contentPane.add(btnReset);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				/*//contentPane.removeAll();
				secondPane = new ;
				secondPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(secondPane);
				secondPane.setLayout(null);
				revalidate();
			    repaint();*/
                             System.out.print("Lvl.1 Geschafft!");
			}
		});
		btnWeiter.setBounds(688, 509, 78, 23);
		contentPane.add(btnWeiter);
		
                JTextPane introduction = new JTextPane();
		introduction.setEditable(false);
		introduction.setText("Vor langer, langer Zeit, weit vor aller Zivilisation...\r\n\r\nSpiel: Ich bin ein Spiel!\r\nSpiel: Finde die Zahlen in der richtigen Reihenfolge. Kannst du z\u00E4hlen?!");
		introduction.setBackground(new Color(60, 0, 0));
                introduction.setForeground(new Color(0, 0, 0));
		introduction.setBounds(0, (getHeight()-162)/*438*/, getWidth()/*784*/, 109);
		contentPane.add(introduction);
                
		/*JTextPane introduction_Border = new JTextPane();
		introduction_Border.setText("  Vor langer, langer Zeit, weit vor aller Zivilisation...\r\n\r\n  Spiel: Ich bin ein Spiel!\r\n  Spiel: Finde die Zahlen in der richtigen Reihenfolge. Kannst du z\u00E4hlen?!");
		introduction_Border.setEditable(false);
		introduction_Border.setBackground(new Color(0, 0, 0));
                introduction_Border.setForeground(new Color(255, 255, 255));
		introduction_Border.setBounds(10, 446, 764, 92);
		contentPane.add(introduction_Border);*/
		
		contentPane.add(lblNewLabel);
		
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
