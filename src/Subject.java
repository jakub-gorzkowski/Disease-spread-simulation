public class Subject {
    private State state;
    private boolean hasImmunity;
    private boolean isInfected;
    private boolean hasSymptoms;

    private final double immunityProbability = 50.0;
    private final double infectionProbability = 50.0;
    private final double symptomsProbability = 50.0;

     /**
      * Jakie prawdopodobieństwa mają być na dane scenariusze?
      * Czy ustalanie położenia w tej konkretnej klasie to dobry pomysł?
     */

    public Subject() {
        hasImmunity = DrawResultByProbability.isPositive(immunityProbability);

        if (hasImmunity) {
            state = new Immune(this);
        } else {
            isInfected = DrawResultByProbability.isPositive(infectionProbability);
            if (isInfected) {
                hasSymptoms = DrawResultByProbability.isPositive(symptomsProbability);
                if (hasSymptoms) {
                    state = new Infected(this);
                } else {
                    state = new InfectedWithoutSymptoms(this);
                }
            } else {
                state = new Healthy(this);
            }
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
