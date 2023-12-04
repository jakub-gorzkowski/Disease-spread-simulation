package Handlers;

import Random.DrawResultByProbability;
import Random.MoveGenerator;
import Random.RecoveryTimeGenerator;
import Random.SubjectDistributor;
import SubjectState.Immune;
import SubjectState.Infected;
import SubjectState.Subject;

import java.util.ArrayList;

public class SubjectMovementHandler {
    private final static int TURN_BACK_PROBABILITY = 50;
    private final static int INFECTION_RESPAWN_PROBABILITY = 10;
    public static void handleMovement(int stepSize, ArrayList<Subject> subjectList, int panelWidth, int panelHeight) {
        for (Subject subject: subjectList) {
            double xPosition = subject.getHorizontalPosition();
            double yPosition = subject.getVerticalPosition();

            double xVelocity = MoveGenerator.generateVector().getX();
            double yVelocity = MoveGenerator.generateVector().getY();

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

            if (subject.getState().isInfected()) {
                subject.increaseSicknessTime(stepSize);
            }

            if (subject.getSicknessTime() >= RecoveryTimeGenerator.generateTime() && subject.getState().isInfected()) {
                subject.setState(new Immune(subject));
                subject.resetSicknessTime();
            }

            xPosition += xVelocity;
            yPosition += yVelocity;

            subject.setHorizontalPosition(xPosition);
            subject.setVerticalPosition(yPosition);
        }
    }
}
