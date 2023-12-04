package Handlers;

import DiseaseFactor.Contact;
import DiseaseFactor.Distance;
import SubjectState.Immune;
import SubjectState.Subject;
import Random.RecoveryTimeGenerator;

import java.util.List;

public class SubjectContactHandler {
    private final static int INFECTION_RANGE = 20;
    private final static int INFECTION_TIME = 3000;
    public static void handleContact(int stepSize, List<Subject> subjectList, double[][] contactTimes, double[][] infectionTimes) {
        for (int i = 0; i < subjectList.size(); i++) {
            for (int j = i + 1; j < subjectList.size(); j++) {
                int timeToRecovery;
                Subject subject1 = subjectList.get(i);
                Subject subject2 = subjectList.get(j);

                if (Distance.getDistance(subject1, subject2) <= INFECTION_RANGE) {
                    subject1.increaseContactTime(stepSize);
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

                timeToRecovery = RecoveryTimeGenerator.generateTime();

                if (infectionTimes[i][j] >= 1) {
                    infectionTimes[i][j] += stepSize;
                }

                if (infectionTimes[i][j] >= timeToRecovery && subject1.getState().isInfected()) {
                    subject1.setState(new Immune(subject1));
                }
            }
        }
    }
}
