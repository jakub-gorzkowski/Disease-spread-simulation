public class Vector2D implements VectorInterface {
    protected double x;
    protected double y;

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
}