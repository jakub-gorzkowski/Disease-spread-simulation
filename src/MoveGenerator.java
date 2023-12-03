public class MoveGenerator {
    public static Vector2D generateVector() {
        int directionFactor = (int) (100 * Math.random());
        double x = (100 * Math.random() % 11); // generujemy dla każdego kroku symulacji przesunięcie wynoszące maksymalnie 10 cm (w sekundzie jest 25 kroków, więc maks szybkość to 2,5 m/s)
        double y = (100 * Math.random() % 11);

        System.out.println("Direction factor: " + directionFactor);

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
