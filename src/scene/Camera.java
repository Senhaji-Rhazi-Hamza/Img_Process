package scene;

import space.Point;
import space.Utils;

public class Camera {
    private double angle;
    private Point location;
    private Point U, V, W;
    public Camera(double angle, Point U, Point V, Point location)
    {
        this.angle = angle;
        this.U = Utils.getNormVec(U);
        this.V = Utils.getNormVec(V);
        W = Utils.crossProduct(U, V);
        this.location = location;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getU() {
        return U;
    }

    public void setU(Point u) {
        U = u;
    }

    public Point getV() {
        return V;
    }

    public void setV(Point v) {
        V = v;
    }

    public Point getW() {
        return W;
    }

    public void setW(Point w) {
        W = w;
    }
}