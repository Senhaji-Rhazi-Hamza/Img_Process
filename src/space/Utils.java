package space;

public class Utils {
    public static double distance(Point A, Point B)
    {
        return A.distance(B);
    }
    public static Point getVec(Point A, Point B)
    {
        return B.getSum(A.getInv());
    }
    public static double getNorm(Point vec)
    {
     return   vec.distance(new Point(0,0,0));
    }
    public static Point getNormVec(Point vec)
    {
        Point tmp = new Point(vec);
        double norm = getNorm(vec);
        tmp.setX(vec.getX()/norm);
        tmp.setY(vec.getY()/norm);
        tmp.setZ(vec.getZ()/norm);
        return tmp;
    }
    public static Point sum(Point A, Point B)
    {
        return A.getSum(B);
    }
    public static Point crossProduct(Point A, Point B)
    {
        return A.getCrossProduct(B);
    }
    public static double dotProduct(Point A, Point B)
    {
        return A.getDotProduct(B);
    }
    public static Point scalarProcuct(Point vec, double scalar) {return vec.getScalarProduct(scalar);}
    public static Point translate(Point A, Point vec)
    {
        A.translate(vec);
        return A;
    }
}
