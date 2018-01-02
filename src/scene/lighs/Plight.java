package scene.lighs;

import scene.Camera;
import scene.shapes.Shape;
import space.Point;
import space.Utils;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.max;


public class Plight extends Light {

    private space.Point plight;

    public Plight(Color color, Point plight) {
        super(color);
        this.plight = plight;
    }

    @Override
    public Color applyColor(Shape obj, space.Point cord_obj, ArrayList<Shape> objs, Camera camera) {
        if (obj == null)
            return null;
        double ld = Utils.distance(cord_obj, plight);

        //ld  = 1;
        Point vRay =Utils.sum(plight, cord_obj.getInv());
        Point vRayNorm = Utils.getNormVec(vRay);
        for(Shape shape:objs)
        {
            if(shape.equals(obj))
                continue;
            double t  = shape.intersect(cord_obj, vRayNorm);
            if (t < Double.MAX_VALUE)
            {
                Point vRay2 = Utils.sum(cord_obj, Utils.scalarProcuct(vRayNorm, t));
                vRay2 = Utils.sum(vRay2, cord_obj.getInv());
                if ((Utils.dotProduct(vRay, vRay2 ) > 0)
                    && (Utils.getNorm(vRay) > Utils.getNorm(vRay2)))
                {
                    return null;
                }
            }
        }

        Color colD = normalColor(obj, cord_obj, camera);
        return colD;
    }


    @Override
    public Color normalColor(Shape obj, Point cord_obj, Camera camera) {
        double ld = Utils.distance(cord_obj, plight);
        Point vRay =Utils.sum(plight, cord_obj.getInv());
        Point vRayNorm = Utils.getNormVec(vRay);
        Color colD = Utils.multColorScalar(Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()),
                max(Utils.dotProduct(vRayNorm,obj.getNormalVec(cord_obj)), 0)), 1/ld)  ;
        return colD;
    }
}
