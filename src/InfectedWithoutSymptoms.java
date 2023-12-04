import java.awt.*;

public class InfectedWithoutSymptoms implements State {
    Color stateColor = Color.ORANGE;
    InfectedWithoutSymptoms (Subject subject) {

    }
    public boolean isInfected() {
        return true;
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
