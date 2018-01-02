package scene.lighs;


import scene.Camera;
import scene.shapes.Shape;
import space.Point;

import java.awt.*;
import java.util.ArrayList;


public abstract class Light {
private Color color ;

    public Light(Color color) {
        this.color = color;
    }

    public abstract Color applyColor(Shape obj, Point cord_obj, ArrayList<Shape> objs, Camera camera);

    public  Color specularColor(Shape obj, Point cord_obj, Camera camera, double msm){return null;}
    public  abstract Color normalColor(Shape obj, Point cord_obj, Camera camera);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
