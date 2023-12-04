package UserInterface;

import javax.swing.*;

public class Window extends JFrame {
    Panel panel;
    public Window(int width, int height) {
        panel = new Panel(width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
