package space;

import java.awt.*;

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
    public static Point translate(Point A, Point vec) {
        A.translate(vec);
        return A;
    }
    public static Point dotTermByTerm(Point A, Point B)
    {
        return A.dotTermByTerm(B);
    }
    public static Color sumColors(Color A, Color B)
    {
        if(A == null)
            return new Color(B.getRed(), B.getGreen(),B.getBlue());
        else
            if(B == null)
                return new Color(A.getRed(),A.getGreen(),A.getBlue());
        //int d = 1;
        return new Color((A.getRed() + B.getRed()) % 255 ,(A.getGreen() + B.getGreen()) % 255,(A.getBlue() + B.getBlue()) %255);
    }
    public static Color multColors(Color A, Color B)
    {
        return new Color((A.getRed() * B.getRed())/255 ,(A.getGreen() * B.getGreen())/255,(A.getBlue() * B.getBlue())/255);
    }
    public static Color multColorScalar(Color A, double m)
    {
        if ((m <= 1) && (m >= 0))
        {
            int r = (int) (A.getRed()* m);
            int g = (int) (A.getGreen() * m);
            int b = (int) (A.getBlue() * m);
            return new Color(r, g, b);
        }
        else {
            System.out.println("Error on the scalar given");
            return null;
        }
    }
}
