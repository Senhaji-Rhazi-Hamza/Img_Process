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
        this.x = A.getX();
        this.y = A.getY();
        this.z = A.getZ();
    }
    public double distance(Point B)
    {
        return Math.sqrt(Math.pow((this.x - B.getX()), 2) + Math.pow((this.y - B.getY()), 2) +Math.pow((this.z - B.getZ()), 2));

    }
    public double getDotProduct(Point vec)
    {
        return this.x * vec.getX() + this.y * vec.getY() + this.z * vec.getZ();
    }
    public Point  getScalarProduct(double scalar)
    {
       return new Point(this.x * scalar , this.y * scalar , this.z * scalar);
    }
    public Point getCrossProduct(Point vec)
    {
        Point tmp = new Point(0, 0, 0);
        tmp.x = vec.getZ() * this.y - vec.getY() * this.z;
        tmp.y = vec.getX() * this.z + vec.getZ() * this.x;
        tmp.z = vec.getY() * this.x - vec.getX() * this.y ;
        return tmp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;



        return (Double.compare(point.getZ(), getZ()) == 0) && (Double.compare(point.getX(), getX()) != 0) ;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getZ());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Point getInv()
    {
        Point tmp = new Point(this);
        tmp.x =tmp.x * -1;
        tmp.y =tmp.y * -1;
        tmp.z =tmp.z * -1;
        return tmp;
    }

    public Point getSum(Point vec)
    {
        Point tmp = new Point(this);
        tmp.translate(vec);
        return tmp;
    }
    public void translate(Point vec)
    {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
    }
    public Point dotTermByTerm(Point B)
    {
        return new Point(this.x * B.getX(), this.y * B.getY(), this.z * B.getZ());
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
