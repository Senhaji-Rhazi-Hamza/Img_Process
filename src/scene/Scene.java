package scene;

import scene.lighs.Light;
import scene.shapes.Shape;
import space.Point;


import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private Camera camera;
    public Screen screen;
    private Color ambColor;

    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Light> lights = new ArrayList<>();

    public Scene(Camera camera, Screen screen, Color ambColor) {
        this.camera = camera;
        this.screen = screen;
        this.ambColor = ambColor;
    }
    public void addShape(Shape shape)
    {
        this.shapes.add(shape);
    }
    public void addLight(Light light)
    {
        this.lights.add(light);
    }
    public Color getPixelColor(int i, int j)
    {
        Point cordPixel = screen.getPixelCord(i, j);
        Shape  minshape = null;
        double t = Double.MAX_VALUE;
        for (Shape shape:shapes)
        {
            double res = shape.intersect(cordPixel, screen.getVecRay(i, j, camera));
            if (res < t)
            {
                minshape = shape;
                t = res;
            }
        }

        return ambColor;
    }
    public void computeScreen(){
        for (int i = 0; i < screen.getBoard().getWidth(); i ++)
        {
            for (int j = 0; j < screen.getBoard().getHeight(); j ++)
            {
                Color color = getPixelColor(i, j);
                screen.getBoard().setRGB(i, j, color.getRGB()) ;
            }
        }

    }
    public void dispBoard()
    {
        for (int i = 0; i < screen.getBoard().getWidth(); i ++)
        {
            for (int j = 0; j < screen.getBoard().getHeight(); j ++)
            {


            }
        }
    }

}
