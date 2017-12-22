package space;

public class Utils {
    public static double distance(Point A, Point B)
    {
        return A.distance(B);
    }
    public static Point translate(Point A, Point vec)
    {
        Point p = new Point(A);
        p.translate(vec);
        return p;
    }
}
