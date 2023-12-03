import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel implements ActionListener {
    private final int SUBJECT_COUNT = 10000;
    private final int CIRCLE_RADIUS = 10;
    int panelWidth;
    int panelHeight;
    Timer timer;

    int xVelocity;
    int yVelocity;

    int xPosition;
    int yPosition;

    List<Subject> subjectList;

    Panel(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.WHITE);

        subjectList = new ArrayList<>();

        for(int i = 0; i < SUBJECT_COUNT; i++) {
            Subject subject = new Subject();
            subject.setHorizontalPosition(SubjectDistributor.generateX(panelWidth));
            subject.setVerticalPosition(SubjectDistributor.generateY(panelHeight));
            subjectList.add(subject);
        }

        timer = new Timer(1, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Subject subject: subjectList) {
            g.setColor(subject.getState().getColor());
            g.fillOval(subject.getHorizontalPosition(), subject.getVerticalPosition(), CIRCLE_RADIUS, CIRCLE_RADIUS);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Subject subject: subjectList) {
            xPosition = subject.getHorizontalPosition();
            yPosition = subject.getVerticalPosition();

            xVelocity = (int) MoveGenerator.generateVector().getX();
            yVelocity = (int) MoveGenerator.generateVector().getY();

            if (xPosition >= panelWidth || xPosition < 0) {
                xVelocity *= -1;
            }

            if (yPosition >= panelHeight || yPosition < 0) {
                yVelocity *= -1;
            }

            xPosition += xVelocity;
            yPosition += yVelocity;

            subject.setHorizontalPosition(xPosition);
            subject.setVerticalPosition(yPosition);

        }
        repaint();
    }
}
