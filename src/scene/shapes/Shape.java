package scene.shapes;

import space.Point;

public abstract class Shape {
    private double diff;
    private double refl;
    private double spec;
    private double shin;
    private double refr;
    private double opac;
    private char r;
    private char g;
    private char b;

    public Shape(char r, char g, char b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.diff = 0;
        this.refl = 0;
        this.spec = 0;
        this.shin = 0;
        this.opac = 0;
        this.refr = 0;
    }
    public abstract double intersect(Point c, Point vecr);


    public Shape(double diff, double refl, double spec, double shin, double refr, double opac, char r, char g, char b) {
        this.diff = diff;
        this.refl = refl;
        this.spec = spec;
        this.shin = shin;
        this.refr = refr;
        this.opac = opac;
        this.r = r;
        this.g = g;
        this.b = b;
    }

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

    public char getR() {
        return r;
    }

    public void setR(char r) {
        this.r = r;
    }

    public char getG() {
        return g;
    }

    public void setG(char g) {
        this.g = g;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }
}