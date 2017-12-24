package test;

import space.Point;
import space.Utils;

public class testUtils {
    public static boolean  testDistance()
    {
        Point A = new Point(1, 1, 1);
        Point B = new Point(1, 1, 1);
        if (Utils.distance(A, B) == 0) {
            System.out.println("Distance seems to work");
            return true;
        }
        else {
            System.out.println("Error in distance");
          return false;
        }
    }
    public static boolean  testGetNormVec()
    {
        Point A = new Point(12, 3, 1);
        double norm = Utils.getNorm(Utils.getNormVec(A));
        if (norm <= 1 + Math.pow(10, -5) && (norm >= 1 - Math.pow(10, -5)))
        {
            System.out.println("Normalize  works");
            return true;
        }
        else {
            System.out.println("else normalize doesnt work : " + Utils.getNorm(Utils.getNormVec(A)) + "does not equal 1");
            return false;
        }
    }
    public static boolean testGetCrossProduct()
    {
        Point A = new Point(1, 0, 0);
        Point B = new Point(0, 1, 0);
        return (A.getCrossProduct(B)).equals(new Point(0,0,1));
    }
    public static void testAll()
    {
        testDistance();
        testGetNormVec();

    }
}
