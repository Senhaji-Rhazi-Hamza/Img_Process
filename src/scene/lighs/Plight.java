package scene.lighs;

import scene.shapes.Shape;
import space.Point;
import space.Utils;

import java.awt.*;

import static java.lang.Math.max;


public class Plight extends Light {
    private space.Point plight;

    public Plight(Color color, Point plight) {
        super(color);
        this.plight = plight;
    }

    @Override
    public Color applyColor(Shape obj, space.Point cord_obj) {
        if (obj == null)
            return null;
        space.Point vr = Utils.getNormVec(Utils.sum(cord_obj, plight));
        return Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()),
                max(Utils.dotProduct(vr,Utils.getNormVec(cord_obj)), 0))     ;
    }
}
