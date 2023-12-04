package SubjectStatus;

import java.awt.*;

public class Immune implements State {
    Color stateColor = Color.BLUE;
    public Immune (Subject subject) {

    }
    public boolean isInfected() {
        return false;
    }
    public boolean isImmune() {
        return true;
    }
    public boolean hasSymptoms() {
        return false;
    }
    public Color getColor() {
        return stateColor;
    }
}
