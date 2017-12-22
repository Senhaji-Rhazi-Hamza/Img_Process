package space;

public class Point {
    private double x;
    private  double y;
    private  double z;

    public Point()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;

    }

    public Point(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;

    }
    public Point(Point A)
    {
        new Point(A.getX(), A.getY(), A.getZ());
    }
    public double distance(Point B)
    {
        return Math.sqrt(Math.pow((this.x - B.getX()), 2) + Math.pow((this.y - B.getY()), 2) +Math.pow((this.z - B.getZ()), 2));

    }
    public void translate(Point vec)
    {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
