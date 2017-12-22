package scene.shapes;

import space.Point;

public class Circle extends Shape{

    private Point center;
    private double radius;

    public Circle(char r, char g, char b, Point center, double radius) {
        super(r, g, b);
        this.center = center;
        this.radius = radius;
    }
    public Circle(double diff, double refl, double spec, double shin, double refr, double opac, char r, char g, char b,Point center, double radius) {
        super(diff, refl, spec, shin, refr, opac, r, g, b);
        this.center = center;
        this.radius = radius;
    }
    @Override
    public double intersect(Point c, Point vecr) {
        return 0;
    }
}
