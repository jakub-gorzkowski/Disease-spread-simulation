package UserInterface;

import Handlers.SubjectContactHandler;
import Handlers.SubjectMovementHandler;
import Handlers.TimeDisplayHandler;
import SubjectStatus.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Random.*;

public class Panel extends JPanel implements ActionListener {
    private final int SUBJECT_COUNT = 1000;
    private final int STEP_SIZE = 40;
    private final int CIRCLE_RADIUS = 10;
    private int panelWidth;
    private int panelHeight;
    Timer timer;
    private int currentTime = 0;
    private List<Subject> subjectList;
    private double[][] contactTimes;
    private double[][] infectionTimes;

    Panel(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);

        subjectList = new ArrayList<>();

        for(int i = 0; i < SUBJECT_COUNT; i++) {
            Subject subject = new Subject();
            subject.setHorizontalPosition(SubjectDistributor.generateX(panelWidth));
            subject.setVerticalPosition(SubjectDistributor.generateY(panelHeight));
            subjectList.add(subject);
        }

        timer = new Timer(STEP_SIZE, this);
        contactTimes = new double[subjectList.size()][subjectList.size()];
        infectionTimes = new double[subjectList.size()][subjectList.size()];
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Subject subject: subjectList) {
            g.setColor(subject.getState().getColor());
            g.fillOval((int)subject.getHorizontalPosition(), (int)subject.getVerticalPosition(), CIRCLE_RADIUS, CIRCLE_RADIUS);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TimeDisplayHandler.timerDisplay(currentTime);
        SubjectMovementHandler.handleMovement(subjectList, panelWidth, panelHeight);
        SubjectContactHandler.handleContact(STEP_SIZE, subjectList, contactTimes, infectionTimes);
        repaint();
        this.currentTime += STEP_SIZE;
    }
}
