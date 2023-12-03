public class MoveGenerator {
    public static Vector2D generateVector() {
        int directionFactor = (int) (100 * Math.random());
        double x;
        double y;
        Vector2D test;

        do {
            x = (Math.random() % 11);
            y = (Math.random() % 11);
            test = new Vector2D(x, y);
        } while (test.abs() > 1);

        if (directionFactor % 4 == 1) {
            return new Vector2D(-x, y);
        } else if (directionFactor % 4 == 2) {
            return new Vector2D(x, -y);
        } else if (directionFactor % 4 == 3) {
            return new Vector2D(-x, -y);
        }
        return new Vector2D(x, y);
    }
}
