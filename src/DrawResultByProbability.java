public class DrawResultByProbability {
    private static final double probabilityBase = 100.0;

    public static boolean isPositive(double givenProbability) {
        double drawnNumber = Math.random() % probabilityBase;
        if (drawnNumber < givenProbability) {
            return true;
        } else {
            return false;
        }
    }
}
