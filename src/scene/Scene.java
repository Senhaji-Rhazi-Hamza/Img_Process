package scene;

import scene.lighs.Alight;
import scene.lighs.Light;
import scene.shapes.Plane;
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

    public Scene(Camera camera, Screen screen, Alight ambLight) {
        this.camera = camera;
        this.screen = screen;
        this.ambLignt = ambLight;

    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void addLight(Light light) {
        this.lights.add(light);
    }

    public Color getPixelColor(int i, int j, Boolean rayTrace) {

        Color colPixel;
        Point cordPixel = this.screen.getPixelCord(i, j);
        Shape minshape = null;
        if (rayTrace) {

            
            Point cordObj = null;
            double t = Double.MAX_VALUE;
            
            for (Shape shape : shapes) {

                Point vecRay = screen.getVecRay(i, j, camera);
                double res = shape.intersect(cordPixel, vecRay);

                if (res < t) {
                    minshape = shape;
                    t = res;
                    cordObj = Utils.sum(cordPixel, Utils.scalarProcuct(vecRay, res));
                }
            }
            
            colPixel = ambLignt.applyColor(minshape, cordObj, shapes, camera);

            for (Light light : lights) {

                colPixel = Utils.sumColors(colPixel, light.applyColor(minshape, cordObj, shapes, camera));

            }
        } else {
            Point viewRay = Utils.getNormVec(Utils.sum(cordPixel, camera.getLocation().getInv()));
            Point cordRay = cordPixel;

            double distmin = Double.MAX_VALUE;
            for(int p = 0; p < shapes.size() ; p++)
            {
                for(Shape obj:shapes)
                {
                    double dist = obj.distanceRay(cordRay);
                    
                    if (dist < distmin)
                    {
                        distmin = dist;
                        if (distmin < Math.pow(10, -5))
                        {
                            
                        }
                       
                        // Color normC = normalColor()
                    }
                }
                if (distmin < Double.MAX_VALUE)
                    cordRay = Utils.sum(cordRay ,Utils.scalarProcuct(viewRay, distmin));


            }
            
            return null;
        }
        return colPixel;
    }

    public void computeScreen() {
        for (int i = 0; i < screen.getBoard().getWidth(); i++) {

            for (int j = 0; j < screen.getBoard().getHeight(); j++) {

                Color color = getPixelColor(i, j, true);
                screen.getBoard().setRGB(i, screen.getBoard().getHeight() - 1 - j, color.getRGB());
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
