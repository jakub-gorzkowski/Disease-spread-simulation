import java.awt.*;

public class Healthy implements State {
    Color stateColor = Color.GREEN;
    Healthy (Subject subject) {

    }
    public boolean isInfected() {
        return false;
    }
    public boolean isImmune() {
        return false;
    }
    public boolean hasSymptoms() {
        return false;
    }
    public Color getColor() {
        return stateColor;
    }
}
