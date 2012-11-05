/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author Stazzer
 */
public class Board extends javax.swing.JPanel implements ActionListener {

    private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 1500;
    private final int RAND_POS_X = 63;
    private final int RAND_POS_Y = 63;
    private final int DELAY = 140;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    
    public JDialog endDialog = new JDialog();
    static long startTime = 0;
    static long endTime = 0;
    private int endCounter = 0;
    
   public Board() {
        addKeyListener(new TAdapter());

        setBackground(Color.black);

        ImageIcon iid = new ImageIcon(this.getClass().getResource("/game/dot.png"));
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(this.getClass().getResource("/game/apple_1.png"));
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon(this.getClass().getResource("/game/head.png"));
        head = iih.getImage();

        setFocusable(true);
        initGame();
    }


    public void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z*10;
            y[z] = 50;
        }

        locateApple();
        
        startTime = System.currentTimeMillis();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0)
                    g.drawImage(head, x[z], y[z], this);
                else g.drawImage(ball, x[z], y[z], this);
            }

            Toolkit.getDefaultToolkit().sync();
            g.dispose();

        } else {
            gameOver(g);
        }
    }


    public void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2, HEIGHT / 2);
        endTime = System.currentTimeMillis();
        long finalTime = (endTime - startTime)/1000;
        if(endCounter == 0){
            gameEnd(finalTime, g);
        }
        if(endCounter == 1){
            Sims_1.button_afterGame.doClick();
        }
    }


    public void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots += 4;
            locateApple();
        }
    }


    public void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (left) {
            x[0] -= DOT_SIZE;
        }

        if (right) {
            x[0] += DOT_SIZE;
        }

        if (up) {
            y[0] -= DOT_SIZE;
        }

        if (down) {
            y[0] += DOT_SIZE;
        }
    }


    public void checkCollision() {

          for (int z = dots; z > 0; z--) {

              if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                  inGame = false;
              }
          }

        if (y[0] > HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] > WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
    }

    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS_X);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS_Y);
        apple_y = ((r * DOT_SIZE));
    }

    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }


    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }
    
    public void gameEnd(long time, final Graphics g){
        int points;
        int credits;
        JPanel endGameBackground = new JPanel();
        endGameBackground.setBounds(0, 0, 500, 300);
        endGameBackground.setLayout(null);
        endGameBackground.setBackground(Color.black);
        endGameBackground.setOpaque(true);
        endDialog.setTitle("Snake - Gewonnen");
        endDialog.setBounds(getWidth()/2-40, 220, 500, 300);
        endDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        endDialog.setLayout(null);
        endDialog.setResizable(false);
        endDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        JLabel label_headline = new JLabel("Gewonnen!");
        JLabel label_gameTime = new JLabel("Zeit: " + time + " Sekunden!");
        JLabel label_Punkte = new JLabel();
        JLabel label_credits = new JLabel();
        JButton button_dismissGameLabel = new JButton();
        button_dismissGameLabel.setText("Weiter");
        button_dismissGameLabel.setBounds(210, 200, 100, 40);
        button_dismissGameLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endDialog.setVisible(false);
                endCounter = 1;
                gameOver(g);
            }});
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
        points = dots * 6;
        credits = dots * 2;
        Sims_1._maingame.points += points;
        Sims_1._maingame.credits += credits;
        label_Punkte.setText("Punkte: " + points + "   Neuer Punktestand: " + Sims_1._maingame.points);
        label_credits.setFont(new Font("Text", 1,20));
        label_credits.setBounds(0, 130, 500, 20);
        label_credits.setHorizontalAlignment(JLabel.CENTER);
        label_credits.setForeground(Color.green);
        label_credits.setText("Credits: " + credits + "   Neuer Punktestand: " + Sims_1._maingame.credits);
        endGameBackground.add(button_dismissGameLabel);
        endGameBackground.add(label_headline);
        endGameBackground.add(label_gameTime);
        endGameBackground.add(label_Punkte);
        endGameBackground.add(label_credits);
        endDialog.add(endGameBackground);
        endDialog.setVisible(true);
    }

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
}
