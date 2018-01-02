package scene.shapes;

import space.Point;
import space.Utils;

import java.awt.*;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class Circle extends Shape{

    private Point center;
    private double radius;


    public Circle(Color color, Point center, double radius) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Circle(double diff, double refl, double spec, double shin, double refr, double opac, Color color, Point center, double radius) {
        super(diff, refl, spec, shin, refr, opac, color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public  double distanceRay(Point cordRay) {
        double d = 0;
        try {
             d = Utils.distance(cordRay, this.center) - this.radius;
        } catch (Exception e)
        {

            System.out.println(e.toString());
//            System.out.println("cord Ray : " + cordRay.toString());
            System.out.println("center : " + this.center.toString());
        }
        return  d;
    }

    @Override
    public double intersect(Point cam_loc, Point vecr) {
        Point p_c = Utils.sum(cam_loc, center.getInv() );
        double a = Utils.getNorm(vecr);
        double c =  Math.pow(Utils.getNorm(p_c), 2) - Math.pow(radius,2);
        double b = 2 * Utils.dotProduct(vecr, p_c);
        double delta = b*b - 4 * a * c ;
        if (delta < 0)
          return Double.MAX_VALUE;
        else
            return min((-b + sqrt(delta))/(2*a),(-b - sqrt(delta))/(2*a));
    }
    @Override
    public String toString() {
        return "Circle :" + "Center :" + this.center +" Radius : " + this.radius + " color :" + this.getColor().toString();
    }
        @Override
    public Point getNormalVec(Point M) {
      //  if (Math.abs(Utils.distance(M, center) - radius) < Math.pow(10, -5))
            return Utils.getNormVec(Utils.sum(M, this.center.getInv()));
      //  else
        //    System.out.println(M.toString());
          //  return null;
    }

}
