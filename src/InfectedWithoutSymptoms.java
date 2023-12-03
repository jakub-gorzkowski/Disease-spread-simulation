import java.awt.*;

public class InfectedWithoutSymptoms implements State {
    Color stateColor = Color.ORANGE;
    InfectedWithoutSymptoms (Subject subject) {

    }
    public boolean isInfected() {
        return true;
    }

    public Color getColor() {
        return stateColor;
    }
}
