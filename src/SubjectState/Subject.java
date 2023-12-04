package SubjectState;
import Random.*;

public class Subject implements Cloneable{
    private State state;
    private boolean hasImmunity;
    private boolean isInfected;
    private boolean hasSymptoms;

    private final double IMMUNITY_PROBABILITY = 1.0;
    private final double INFECTION_PROBABILITY = 7.5;
    private final double SYMPTOMS_PROBABILITY = 95.0;

    private double verticalPosition;
    private double horizontalPosition;
    private int contactTime;
    private int sicknessTime;

    public Subject() {
        hasImmunity = DrawResultByProbability.isPositive(IMMUNITY_PROBABILITY);

        if (hasImmunity) {
            state = new Immune(this);
        } else {
            isInfected = DrawResultByProbability.isPositive(INFECTION_PROBABILITY);
            if (isInfected) {
                hasSymptoms = DrawResultByProbability.isPositive(SYMPTOMS_PROBABILITY);
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
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getHorizontalPosition() { // do klasy UserInterface.Panel
        return horizontalPosition;
    }

    public double getVerticalPosition() { // do klasy UserInterface.Panel
        return verticalPosition;
    }

    public void setHorizontalPosition(double horizontalPosition) { // do klasy UserInterface.Panel
        this.horizontalPosition = horizontalPosition;
    }

    public void setVerticalPosition(double verticalPosition) { // do klasy UserInterface.Panel
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
    public int getSicknessTime() {
        return this.sicknessTime;
    }
    public void increaseSicknessTime(int time) {
        this.sicknessTime += time;
    }
    public void resetSicknessTime() {
        this.sicknessTime = 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
