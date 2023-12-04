package UserInterface;

import ProgressSave.CareTaker;

import javax.swing.*;

public class Window extends JFrame {
    private static Window instance;
    CareTaker careTaker;
    Panel panel;
    private Window(int width, int height) {
        careTaker = new CareTaker();
        panel = new Panel(this.careTaker, width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("Disease spread simulation");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static Window getInstance(int width, int height) {
        if (instance == null) {
            instance = new Window(width, height);
        }
        return instance;
    }

    public void refresh(int timeIndex) {
        panel.loadProgress(this.careTaker.getMemento(timeIndex));
        this.careTaker.removeSkippedMementos(timeIndex);
    }
}
