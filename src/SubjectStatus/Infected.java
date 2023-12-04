package SubjectStatus;

import java.awt.*;

public class Infected implements State {
    Color stateColor = Color.RED;
    public Infected (Subject subject) {
        super();
    }
    public boolean isInfected() {
        return true;
    }
    public boolean isImmune() {
        return true;
    }
    public boolean hasSymptoms() {
        return true;
    }
    public Color getColor() {
        return stateColor;
    }
}
