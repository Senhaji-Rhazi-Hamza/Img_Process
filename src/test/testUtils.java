package test;

import scene.shapes.Circle;
import space.Point;
import space.Utils;

import java.awt.*;

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
    public  static boolean  testGetNormVecCircle() {
        Circle c1 = new Circle(new Color(255, 14, 93), new Point(0, 0, 0), 30);
        Point Vn = c1.getNormalVec(new Point(30, 0, 0));
        System.out.println(Vn.toString());
        return Vn.equals(new Point(1,0,0));
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
    public static void testIntersect()
    {
      Point cord =  new Point(178.3132530120482, -200.0, 431.94963540224194);
      Point vecn = new Point(0, -1 , 0);
      Circle c1 = new Circle(new Color(255, 94, 51) ,new Point(50, -50, 358.518), 30);
      System.out.println(c1.intersect(cord, vecn));


    }

}
