package scene;

import scene.lighs.Alight;
import scene.lighs.Light;
import scene.shapes.Shape;
import space.Point;
import space.Utils;


import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private Screen screen;
    private Alight ambLignt;


    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Light> lights = new ArrayList<>();

    public Scene(Camera camera, Screen screen, Alight  ambLight) {
        this.camera = camera;
        this.screen = screen;
        this.ambLignt = ambLight;

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

        Shape  minshape = null;
        double t = Double.MAX_VALUE;
        for (Shape shape:shapes)
        {

            double res = shape.intersect(camera.getLocation(), screen.getVecRay(i, j, camera));

            if (res < t)
            {


                minshape = shape;
                t = res;
            }
        }
        Point cordPixel = this.screen.getPixelCord(i,j);
        Color colPixel = ambLignt.applyColor(minshape, cordPixel);
        for(Light light:lights)
        {
            colPixel = Utils.sumColors(colPixel, light.applyColor(minshape,cordPixel));

        }
    return colPixel;
    }
    public void computeScreen(){
        for (int i = 0; i < screen.getBoard().getWidth(); i ++)
        {

            for (int j = 0; j < screen.getBoard().getHeight(); j ++)
            {

                Color color = getPixelColor(i, j);
                screen.getBoard().setRGB(i, screen.getBoard().getHeight() -1 -j, color.getRGB()) ;

            }
        }

    }
    /*
    public void dispBoard()
    {
        for (int i = 0; i < screen.getBoard().getWidth(); i ++)
        {
            for (int j = 0; j < screen.getBoard().getHeight(); j ++)
            {


            }
        }
    }*/

}
