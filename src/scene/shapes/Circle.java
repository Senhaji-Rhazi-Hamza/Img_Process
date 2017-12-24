package scene.shapes;

import space.Point;
import space.Utils;

import java.awt.*;

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
    public double intersect(Point c, Point vecr) {
        return 0;
    }

    @Override
    public Point getNormalVec(Point M) {
        if (Math.abs(Utils.distance(M, center) - radius) < Math.pow(10, -5))
            return Utils.getNormVec(Utils.sum(M, this.center.getInv()));
        else
            return null;
    }

}
