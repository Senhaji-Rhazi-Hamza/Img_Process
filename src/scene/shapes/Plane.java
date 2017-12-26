package scene.shapes;

import space.Point;
import space.Utils;

import java.awt.*;

public class Plane extends Shape {
    Point vecN;
    double d;
    public Plane(Point vecN, double d, Color color)
    {
        this(color);
        this.vecN = Utils.getNormVec(vecN);

        this.d = d;

    }
    public Plane(Point vecN, Point belong, Color color)
    {
        this(color);
        this.vecN = Utils.getNormVec(vecN);
        this.d = - Utils.dotProduct(this.vecN, belong);

    }


    @Override
    public  double intersect(Point cam_loc, Point vecr){

        double den = Utils.dotProduct(this.vecN, vecr);
        if (den == 0)
            return Double.MAX_VALUE;
        double t = - (Utils.dotProduct(this.vecN, cam_loc) + this.d)/den ;
        if (t < 0)
            return Double.MAX_VALUE;
        else
            return t;
    }

    public Plane(Color color) {
        super(color);
    }

    public Plane(double diff, double refl, double spec, double shin, double refr, double opac, Color color) {
        super(diff, refl, spec, shin, refr, opac, color);
    }


    @Override
    public Point getNormalVec(Point M) {
        return null;
    }
}
