import java.awt.*;

public class Immune implements State {
    Color stateColor = Color.BLUE;
    Immune (Subject subject) {

    }
    public boolean isInfected() {
        return false;
    }

    public Color getColor() {
        return stateColor;
    }
}