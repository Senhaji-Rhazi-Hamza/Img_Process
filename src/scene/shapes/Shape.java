package scene.shapes;

import space.Point;
import space.Utils;

import java.awt.*;

public abstract class Shape {
    private double diff;
    private double refl;
    private double spec;
    private double shin;
    private double refr;
    private double opac;
    private Color color ;
    public Shape(Color color) {
        this.color = color;
        this.diff = 0;
        this.refl = 0;
        this.spec = 0;
        this.shin = 0;
        this.opac = 0;
        this.refr = 0;
    }
    public abstract double intersect(Point c, Point vecr);

    public Shape(double diff, double refl, double spec, double shin, double refr, double opac, Color color) {
        this.diff = diff;
        this.refl = refl;
        this.spec = spec;
        this.shin = shin;
        this.refr = refr;
        this.opac = opac;
        this.color = color;
    }
    public abstract Point getNormalVec(Point M);
    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getRefl() {
        return refl;
    }

    public void setRefl(double refl) {
        this.refl = refl;
    }

    public double getSpec() {
        return spec;
    }

    public void setSpec(double spec) {
        this.spec = spec;
    }

    public double getShin() {
        return shin;
    }

    public void setShin(double shin) {
        this.shin = shin;
    }

    public double getRefr() {
        return refr;
    }

    public void setRefr(double refr) {
        this.refr = refr;
    }

    public double getOpac() {
        return opac;
    }

    public void setOpac(double opac) {
        this.opac = opac;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}