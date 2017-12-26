package scene.lighs;

import scene.shapes.Shape;
import space.Point;
import space.Utils;


import java.awt.*;

import static java.lang.Math.max;


public class DirecLight extends Light{
    private space.Point direcLight;
    public DirecLight(Color color, Point direcLight) {
        super(color);
        this.direcLight = Utils.getNormVec(direcLight);
    }

    @Override
    public Color applyColor(Shape obj, Point cord_obj) {
        if (obj == null)
            return null;
        return Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()),
                max(Utils.dotProduct(direcLight,Utils.getNormVec(cord_obj)), 0))     ;
    }
}
