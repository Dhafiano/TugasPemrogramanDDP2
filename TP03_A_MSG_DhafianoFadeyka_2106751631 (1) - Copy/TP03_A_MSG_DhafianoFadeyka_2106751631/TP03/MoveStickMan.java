//Dhafiano Fadeyka Ghani Wiweko
//2106751631
//TP03
//DDP2A

import javax.swing.*;

public class MoveStickMan {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Moving a Stick Man with the Keyboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MovePanel());

        frame.pack();
        frame.setVisible(true);
    }
}
