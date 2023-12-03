public class Vector2D implements VectorInterface {
    private double x;
    private double y;

    Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.pow(x * x + y * y, 0.5);
    }
    @Override
    public double cdot(VectorInterface param) {
        double[] paramsArray = param.getComponents();
        double paramX = paramsArray[0];
        double paramY = paramsArray[1];
        return this.x * paramX + this.y * paramY;
    }
    @Override
    public double[] getComponents() {
        return new double[]{x, y};
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}