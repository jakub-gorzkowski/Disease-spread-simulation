public class Subject {
    private State state;
    private boolean hasImmunity;
    private boolean isInfected;
    private boolean hasSymptoms;

    private final double immunityProbability = 1.0;
    private final double infectionProbability = 7.5;
    private final double symptomsProbability = 95.0;

    private double verticalPosition;
    private double horizontalPosition;
    private int contactTime;

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

    public double getHorizontalPosition() { // do klasy Panel
        return horizontalPosition;
    }

    public double getVerticalPosition() { // do klasy Panel
        return verticalPosition;
    }

    public void setHorizontalPosition(double horizontalPosition) { // do klasy Panel
        this.horizontalPosition = horizontalPosition;
    }

    public void setVerticalPosition(double verticalPosition) { // do klasy Panel
        this.verticalPosition = verticalPosition;
    }

    public void increaseContactTime(int time){
        this.contactTime += time;
    }

    public int getContactTime() {
        return contactTime;
    }

    public void resetContactTime(){
        this.contactTime = 0;
    }
}
