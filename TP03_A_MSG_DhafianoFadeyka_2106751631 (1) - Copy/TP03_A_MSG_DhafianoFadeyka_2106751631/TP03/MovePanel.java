//Dhafiano Fadeyka Ghani Wiweko
//2106751631
//TP03
//DDP2A

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovePanel extends JPanel {
    private static final int JUMP = 50;
    private StickFigure stickFigure;

    // ---------------------------------------------
    // Constructor: Sets up this panel to listen for
    // key events.
    // ---------------------------------------------
    public MovePanel() {
        stickFigure = new StickFigure(200, 200, Color.BLUE, 100);

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);

        setFocusable(true);
        addKeyListener(new MoveListener());

        Timer timer = new Timer(10, new MoveListener());
        timer.start();

        setToolTipText("You can manipulate the figure using the keyboard (arrow keys, g key, s key, u key, d key, l key, r key, and m key).");
    }

    // --------------------------------------------
    // Draws the stick figure.
    // --------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        stickFigure.draw(page);
    }

    // ***************************************************
    // Represents the action listener for the timer and key events.
    // ***************************************************
    private class MoveListener extends KeyAdapter implements ActionListener {
        private static final int MOVE_AMOUNT = 10;

        // -----------------------------------------------------
        // actionPerformed: Moves the stick figure.
        // -----------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            stickFigure.move(0, 0);
            repaint();
        }

        // -----------------------------------------------------
        // keyPressed: Moves the stick figure in response to
        // arrow key presses.
        // -----------------------------------------------------
        public void keyPressed(KeyEvent event) {
            int keyCode = event.getKeyCode();

            if (keyCode == KeyEvent.VK_UP) {
                stickFigure.move(0, -JUMP);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                stickFigure.move(0, JUMP);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                stickFigure.move(-MOVE_AMOUNT, 0);
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                stickFigure.move(MOVE_AMOUNT, 0);
            } else if (keyCode == KeyEvent.VK_S) {
                stickFigure.grow(0.5);
            } else if (keyCode == KeyEvent.VK_G) {
                stickFigure.grow(2.0);
            } else if (keyCode == KeyEvent.VK_U) {
                stickFigure.setArmPosition(60);
                stickFigure.setLegPosition(40);
            } else if (keyCode == KeyEvent.VK_M) {
                stickFigure.setArmPosition(0);
                stickFigure.setLegPosition(20);
            } else if (keyCode == KeyEvent.VK_D) {
                stickFigure.setArmPosition(-60);
                stickFigure.setLegPosition(10);
            } else if (keyCode == KeyEvent.VK_L) {
                stickFigure.toggleArmsCrossed();
            } else if (keyCode == KeyEvent.VK_R) {
                stickFigure.toggleArmsCrossed();
            }
        
            repaint();
        }

        // -----------------------------------------------------
        // keyTyped: Not used.
        // -----------------------------------------------------
        public void keyTyped(KeyEvent event) {}

        // -----------------------------------------------------
        // keyReleased: Not used.
        // -----------------------------------------------------
        public void keyReleased(KeyEvent event) {}
    }
}
