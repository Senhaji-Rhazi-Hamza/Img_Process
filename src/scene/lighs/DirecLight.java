package scene.lighs;

import java.awt.*;

public class DirecLight extends Light{
    private Point direcLight;
    public DirecLight(Color color, Point direcLight) {
        super(color);
        this.direcLight = direcLight;
    }
}
