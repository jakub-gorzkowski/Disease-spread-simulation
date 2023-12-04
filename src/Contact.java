public class Contact {
    private static final int SYMPTOMS_PROBABILITY = 90;
    private static final int NOSYMPTOMS_INFECTION_PROBABILITY = 50;
    static void analyseSubjectsContact(Subject subject1, Subject subject2) {
        State subject1State = subject1.getState();
        State subject2State = subject2.getState();

        if (subject1State.hasSymptoms() && subject1State.isInfected() && !subject2State.isImmune()) {
            if(DrawResultByProbability.isPositive(SYMPTOMS_PROBABILITY)) {
                subject2.setState(new Infected(subject2));
            } else {
                subject2.setState(new InfectedWithoutSymptoms(subject2));
            }
        } else if (subject2State.hasSymptoms() && subject2State.isInfected() && !subject1State.isImmune()) {
            if(DrawResultByProbability.isPositive(SYMPTOMS_PROBABILITY)) {
                subject1.setState(new Infected(subject1));
            } else {
                subject1.setState(new InfectedWithoutSymptoms(subject1));
            }
        } else if (!subject1State.hasSymptoms() && subject1State.isInfected() && !subject2State.isImmune()) {
            if(DrawResultByProbability.isPositive(NOSYMPTOMS_INFECTION_PROBABILITY)) {
                if (DrawResultByProbability.isPositive(SYMPTOMS_PROBABILITY)) {
                    subject2.setState(new Infected(subject2));
                } else {
                    subject2.setState(new InfectedWithoutSymptoms(subject2));
                }
            }
        } else if (!subject2State.hasSymptoms() && subject2State.isInfected() && !subject1State.isImmune()) {
            if(DrawResultByProbability.isPositive(NOSYMPTOMS_INFECTION_PROBABILITY)) {
                if (DrawResultByProbability.isPositive(SYMPTOMS_PROBABILITY)) {
                    subject1.setState(new Infected(subject1));
                } else {
                    subject1.setState(new InfectedWithoutSymptoms(subject1));
                }
            }
        }
    }
}
