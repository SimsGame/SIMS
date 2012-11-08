/*
 * This jPanel holds the snake game.
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
 * @author Jannik
 */
public class Board extends javax.swing.JPanel implements ActionListener {

    /**
     * Setting up the constants and variabels for the field and
     * for further settings.
     */
    
    private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 8000;
    private final int RAND_POS_X = 63;
    private final int RAND_POS_Y = 63;
    private final int DELAY = 40;

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
   
   /**
    * Creates a new Board, loads the images and calls the init methode.  
    */ 
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

    /**
     * Initializes the entire field on load.
     * Sets the snake length and starts the timer to move the snake.
     * Sets the first apple.
     */
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

    /**
     * Paints the board, the snake and the apple. Calls the gameOver method if inGame is false. 
     * @param g the board field, the snake dots and the apple that have to be painted
     */
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

    /**
     * Is called if the game is over and inGame is false. Prints "Game Over" and
     * opens the popup which shows the earned points and credits. Leaves the game.
     * @param g the field where the text has to be printed
     */
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
    }

    /**
     * If there are not enough dots yet the position of the snakes head is checked.
     * If the head position equals the apple new dots are added to the snake.
     * After that a new apple is located.
     */
    public void checkApple() {

        if(dots >= ALL_DOTS-8){
            inGame = false; 
        }
        
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots += 6;
            locateApple();
        }
    }

    /**
     * Moves the snake in one direction by using the timer.
     */
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

    /**
     * Checks if the snakes head has hit itself or a wall.
     * Sets the inGame to false if that happens.
     */
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
    
    /**
     * Sets a new apple to a random position.
     */
    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS_X);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS_Y);
        apple_y = ((r * DOT_SIZE));
    }
    
    /**
     * The order of activities that is called by the timer after the delay is over.
     * First chekcs for an apple, than for collision and moves in the end.
     * @param e unused 
     */
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    /**
     * This class recognizes keys. If the key was an arrow this is recognized and
     * given to the Boardgame.
     */
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
    
    /**
     * Creates the popup that shows the result of points, time and credits in the end.
     * @param time thate time that was used to finish the game
     * @param g the graphics where the "GameOver" was printed
     */
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
        JLabel label_headline = new JLabel("Spiel vorbei!");
        JLabel label_gameTime = new JLabel("Zeit: " + time + " Sekunden!");
        JLabel label_Punkte = new JLabel();
        JLabel label_credits = new JLabel();
        JButton button_dismissGameLabel = new JButton();
        button_dismissGameLabel.setText("Weiter");
        button_dismissGameLabel.setBounds(210, 200, 100, 40);
        button_dismissGameLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                endDialog.setVisible(false);
                endCounter = 1;
                Sims_1.button_afterGame.doClick();
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
        if(!(dots >= ALL_DOTS-8)){
            endGameBackground.add(button_dismissGameLabel);
            endGameBackground.add(label_headline);
            endGameBackground.add(label_gameTime);
            endGameBackground.add(label_Punkte);
            endGameBackground.add(label_credits);
        }
        else{
            label_headline.setText("SECRET!");
            label_gameTime.setText("Na, wie viele Credits dürfens sein?");
            label_Punkte.setText("Oder sollens doch lieber DIE Credits sein?");
            endGameBackground.add(label_headline);
            endGameBackground.add(label_gameTime);
            endGameBackground.add(label_Punkte);
            endGameBackground.add(button_dismissGameLabel);
        }
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
