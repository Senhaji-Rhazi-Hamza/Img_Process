package scene.lighs;


import scene.Camera;
import scene.shapes.Shape;
import space.Point;

import space.Utils;

import java.awt.*;
import java.util.ArrayList;


public class Alight extends Light {
    double la;
    public Alight(Color color, double la) {
        super(color);
        this.la = la;
    }

    public Alight(Color ambColor) {
        super(ambColor);
        this.la = 0.1;
    }

    @Override
    public Color applyColor(Shape obj, Point cord_obj, ArrayList<Shape> objs, Camera camera) {
        if ((obj == null)|| (cord_obj == null))
            return Utils.multColorScalar(this.getColor(), this.la);
        return normalColor(obj, cord_obj, camera);
    }

    @Override
    public Color normalColor(Shape obj, Point cord_obj, Camera camera) {
        return  Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()), this.la);
    }
}
