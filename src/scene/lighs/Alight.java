package scene.lighs;


import scene.shapes.Shape;
import space.Point;

import space.Utils;

import java.awt.*;


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
    public Color applyColor(Shape obj, Point cord_obj) {
        if (obj == null)
            return Utils.multColorScalar(this.getColor(), this.la);
        return Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()), this.la);
    }
}
