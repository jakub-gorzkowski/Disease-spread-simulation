package Handlers;

import DiseaseFactor.Contact;
import DiseaseFactor.Distance;
import SubjectStatus.Immune;
import SubjectStatus.Subject;

import java.util.List;
import java.util.Random;

public class SubjectContactHandler {
    private final static int INFECTION_RANGE = 20;
    private final static int INFECTION_TIME = 3000;
    private final static int RECOVERY_MIN_TIME = 20000;
    private final static int RECOVERY_MAX_TIME = 30000;
    private static Random random;
    private static int timeToRecovery;
    public static void handleContact(int STEP_SIZE, List<Subject> subjectList, double[][] contactTimes, double[][] infectionTimes) {
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
    }
}
