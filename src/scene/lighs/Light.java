package scene.lighs;


import scene.shapes.Shape;
import space.Point;

import java.awt.*;


public abstract class Light {
private Color color ;

    public Light(Color color) {
        this.color = color;
    }

    public abstract Color applyColor(Shape obj, Point cord_obj);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
