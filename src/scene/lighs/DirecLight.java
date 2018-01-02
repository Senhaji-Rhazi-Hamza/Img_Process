package scene.lighs;

import scene.Camera;
import scene.shapes.Circle;
import scene.shapes.Plane;
import scene.shapes.Shape;
import space.Point;
import space.Utils;


import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.max;


public class DirecLight extends Light{
    private space.Point direcLight;
    public DirecLight(Color color, Point direcLight) {
        super(color);
        this.direcLight = Utils.getNormVec(direcLight);
    }

    @Override
    public Color applyColor(Shape obj, Point cord_obj, ArrayList<Shape> objs, Camera camera) {
        if ((obj == null)|| (cord_obj == null))
            return null;
        for(Shape shape:objs)
        {
            if(shape.equals(obj))
                continue;
            double t  = shape.intersect(cord_obj, this.direcLight);
            if (t < Double.MAX_VALUE)
            {
                Point vRay2 = Utils.sum(Utils.sum(cord_obj, Utils.scalarProcuct(this.direcLight, t)), cord_obj.getInv());

                if (Utils.dotProduct(vRay2, this.direcLight) < 0)
                {
                    return null;
                }
            }
        }
        Color colD =  normalColor(obj, cord_obj, camera);

        Color colS = specularColor(obj, cord_obj, camera, 0.5);

        if (colD.equals(new Color(0,0,0)))
            return null;
        return Utils.sumColors(colD,colS);
    }


    @Override
    public  Color specularColor(Shape obj, Point cord_obj, Camera camera, double msm)
    {

        double ms = obj.getSpec();
        double msp = obj.getShin();
        Point viewRay = Utils.getNormVec(Utils.sum(cord_obj, camera.getLocation().getInv()));
        Color S = Utils.sumColors(Utils.multColorScalar(obj.getColor(),msm), Utils.multColorScalar(new Color(255,255,255),1 -msm));
        Point R = Utils.sum(this.direcLight,Utils.scalarProcuct(obj.getNormalVec(cord_obj),
                2 * max(Utils.dotProduct(this.direcLight.getInv(), obj.getNormalVec(cord_obj)), 0)));
        Color colS = Utils.multColorScalar(Utils.multColors(S, this.getColor()),
                ms * max(Math.pow(Utils.dotProduct(R.getInv(), viewRay),msp), 0));
        return colS;
    }

    @Override
    public Color normalColor(Shape obj, Point cord_obj, Camera camera) {
        Color colD =  Utils.multColorScalar(Utils.multColors(obj.getColor(), this.getColor()),
                max(Utils.dotProduct(direcLight.getInv(),obj.getNormalVec(cord_obj)), 0))     ;
    return  colD;
    }
}
