package SubjectStatus;

import java.awt.*;

public interface State {
    boolean isInfected();
    boolean isImmune();
    boolean hasSymptoms();
    Color getColor();
}
