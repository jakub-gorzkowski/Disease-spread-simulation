import java.awt.*;

public class Infected implements State {
    Color stateColor = Color.RED;
    Infected (Subject subject) {
        super();
    }
    public boolean isInfected() {
        return true;
    }

    public Color getColor() {
        return stateColor;
    }
}
