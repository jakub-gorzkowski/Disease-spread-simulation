import java.util.Random;

public class SubjectDistributor {
    public static int generateX(int xSize) {
        Random generatedX = new Random();
        return generatedX.nextInt(xSize);
    }
    public static int generateY(int ySize) {
        Random generatedY = new Random();
        return generatedY.nextInt(ySize);
    }
}
