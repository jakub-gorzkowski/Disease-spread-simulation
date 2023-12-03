public class Subject {
    private State state;
    private boolean hasImmunity;
    private boolean isInfected;
    private boolean hasSymptoms;

    private final double immunityProbability = 50.0;
    private final double infectionProbability = 50.0;
    private final double symptomsProbability = 50.0;

    private int verticalPosition;
    private int horizontalPosition;

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
        return this.state;
    } // potrzebne do klasy Contact

    public void setState(State state) {
        this.state = state;
    } // potrzebne do klasy Contact

    public int getHorizontalPosition() { // do klasy Panel
        return horizontalPosition;
    }

    public int getVerticalPosition() { // do klasy Panel
        return verticalPosition;
    }

    public void setHorizontalPosition(int horizontalPosition) { // do klasy Panel
        this.horizontalPosition = horizontalPosition;
    }

    public void setVerticalPosition(int verticalPosition) { // do klasy Panel
        this.verticalPosition = verticalPosition;
    }

    public void moveSubject(Vector2D param) {
        this.verticalPosition += param.getX();
        this.horizontalPosition += param.getY();
    }
}
