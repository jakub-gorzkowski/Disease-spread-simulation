package Handlers;

import Random.DrawResultByProbability;
import Random.MoveGenerator;
import Random.SubjectDistributor;
import SubjectStatus.Infected;
import SubjectStatus.Subject;

import java.util.List;

public class SubjectMovementHandler {
    private final static int TURN_BACK_PROBABILITY = 50;
    private final static int INFECTION_RESPAWN_PROBABILITY = 10;
    private static double xPosition;
    private static double yPosition;
    private static double xVelocity;
    private static double yVelocity;
    public static void handleMovement(List<Subject> subjectList, int panelWidth, int panelHeight) {
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
    }
}
