package DiseaseFactor;

import SubjectState.Subject;

public class Distance {
    public static double getDistance(Subject subject1, Subject subject2) {
        double subject1X = subject1.getHorizontalPosition();
        double subject1Y = subject1.getVerticalPosition();
        double subject2X = subject2.getHorizontalPosition();
        double subject2Y = subject2.getVerticalPosition();
        return Math.sqrt(Math.pow(subject2X - subject1X, 2) + Math.pow(subject2Y - subject1Y, 2));
    }
}
