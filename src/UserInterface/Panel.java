package UserInterface;

import Handlers.SubjectContactHandler;
import Handlers.SubjectMovementHandler;
import Handlers.TimeDisplayHandler;
import ProgressSave.CareTaker;
import ProgressSave.Memento;
import SubjectState.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Random.*;

public class Panel extends JPanel implements ActionListener {
    private final int SUBJECT_COUNT = 1250;
    private final int STEP_SIZE = 40;
    private final int CIRCLE_RADIUS = 10;
    private final int STEPS_IN_SECOND = 1000;
    private final int panelWidth;
    private final int panelHeight;
    Timer timer;
    private int currentTime = 0;
    private ArrayList<Subject> subjectList;
    private double[][] contactTimes;
    private double[][] infectionTimes;
    private CareTaker careTaker;

    Panel(CareTaker careTaker, int panelWidth, int panelHeight) {
        this.careTaker = careTaker;
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
        if (currentTime % STEPS_IN_SECOND == 0) {
            careTaker.addMemento(new Memento(this.currentTime, this.subjectList, this.contactTimes, this.infectionTimes));
        }
        TimeDisplayHandler.timerDisplay(currentTime);
        SubjectMovementHandler.handleMovement(STEP_SIZE, subjectList, panelWidth, panelHeight);
        SubjectContactHandler.handleContact(STEP_SIZE, subjectList, contactTimes, infectionTimes);
        repaint();
        this.currentTime += STEP_SIZE;
    }

    public void loadProgress(Memento memento) {
        this.currentTime = memento.getTime();
        this.subjectList = memento.getSubjectList();
        this.contactTimes = memento.getContactTimes();
        this.infectionTimes = memento.getInfectionTimes();
        repaint();
    }
}
