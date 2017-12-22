package test;

import space.Point;
import space.Utils;

public class testUtils {
    public static void  test_distance()
    {
        Point A = new Point(1, 1, 1);
        Point B = new Point(1, 1, 1);
        if (Utils.distance(A, B) == 0)
            System.out.println("Distance seems to work");
        else
            System.out.println("Error in distance");
    }
}
