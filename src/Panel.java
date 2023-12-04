import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    private final int SUBJECT_COUNT = 1000;
    private final int CIRCLE_RADIUS = 10;
    private final int STEP_SIZE = 40;
    private final int TURN_BACK_PROBABILITY = 50;
    private final int INFECTION_RANGE = 20;
    private final int INFECTION_TIME = 3000;
    private final int RECOVERY_MIN_TIME = 20000;
    private final int RECOVERY_MAX_TIME = 30000;
    private final int INFECTION_RESPAWN_PROBABILITY = 10;
    private int panelWidth;
    private int panelHeight;
    Timer timer;
    private int currentTime = 0;

    private double xVelocity;
    private double yVelocity;

    private double xPosition;
    private double yPosition;

    private Random random;

    int timeToRecovery;

    List<Subject> subjectList;
    double[][] contactTimes;
    double[][] infectionTimes;

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
        if (currentTime % 1000 == 0) {
            System.out.println(currentTime / 1000 + "second/s");
        }

        for (Subject subject: subjectList) {
            xPosition = subject.getHorizontalPosition();
            yPosition = subject.getVerticalPosition();

            xVelocity = MoveGenerator.generateVector().getX();
            yVelocity = MoveGenerator.generateVector().getY();

            if (xPosition >= panelWidth || xPosition < 0) {
                if (DrawResultByProbability.isPositive(TURN_BACK_PROBABILITY)) {
                    xVelocity *= -1;
                } else {
                    subject.setHorizontalPosition(SubjectDistributor.generateX(panelWidth));
                    xPosition = subject.getHorizontalPosition();
                    subject.setVerticalPosition(SubjectDistributor.generateY(panelHeight));
                    yPosition = subject.getVerticalPosition();

                    if (DrawResultByProbability.isPositive(INFECTION_RESPAWN_PROBABILITY)) {
                        subject.setState(new Infected(subject));
                    }
                }
            }

            if (yPosition >= panelHeight || yPosition < 0) {
                if (DrawResultByProbability.isPositive(TURN_BACK_PROBABILITY)) {
                    yVelocity *= -1;
                } else {
                    subject.setHorizontalPosition(SubjectDistributor.generateX(panelWidth));
                    xPosition = subject.getHorizontalPosition();
                    subject.setVerticalPosition(SubjectDistributor.generateY(panelHeight));
                    yPosition = subject.getVerticalPosition();

                    if (DrawResultByProbability.isPositive(INFECTION_RESPAWN_PROBABILITY)) {
                        subject.setState(new Infected(subject));
                    }
                }
            }

            xPosition += xVelocity;
            yPosition += yVelocity;

            subject.setHorizontalPosition(xPosition);
            subject.setVerticalPosition(yPosition);

        }

        repaint();

        for (int i = 0; i < subjectList.size(); i++) {
            for (int j = i + 1; j < subjectList.size(); j++) {
                Subject subject1 = subjectList.get(i);
                Subject subject2 = subjectList.get(j);

                if (Distance.getDistance(subject1, subject2) <= INFECTION_RANGE) {
                    subject1.increaseContactTime(STEP_SIZE);
                    contactTimes[i][j] += subject1.getContactTime();
                } else {
                    contactTimes[i][j] = 0;
                    subject1.resetContactTime();
                }

                if (contactTimes[i][j] >= INFECTION_TIME) {
                    Contact.analyseSubjectsContact(subject1, subject2);
                    contactTimes[i][j] = 0;
                    infectionTimes[i][j] = 1;
                }

                random = new Random();
                timeToRecovery = random.nextInt(RECOVERY_MAX_TIME - RECOVERY_MIN_TIME + 1) + RECOVERY_MIN_TIME;

                if (infectionTimes[i][j] >= 1) {
                    infectionTimes[i][j] += STEP_SIZE;
                }

                if (infectionTimes[i][j] >= timeToRecovery && subject1.getState().isInfected()) {
                    subject1.setState(new Immune(subject1));
                }
            }
        }
        this.currentTime += STEP_SIZE;
    }
}
