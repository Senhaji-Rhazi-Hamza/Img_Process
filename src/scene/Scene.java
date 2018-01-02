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
        Point cordObj = null;
        double distmin = Double.MAX_VALUE;
        Point vecRay = screen.getVecRay(i, j, camera);

        if (rayTrace) {
            for (Shape shape : shapes) {
                double dist = shape.intersect(cordPixel, vecRay);
                if (dist < distmin) {
                    minshape = shape;
                    distmin = dist;
                    cordObj = Utils.sum(cordPixel, Utils.scalarProcuct(vecRay, distmin));
                }
            }
        }
        else {
            cordObj = cordPixel;
            outer:
            for (int p = 0; p < 10 * shapes.size(); p++) {
                for (Shape obj : shapes) {
                    double dist = obj.distanceRay(cordObj);

                    if (dist < distmin) {
                        distmin = dist;
                        if (distmin < Math.pow(10, -4)) {
                            minshape = obj;
                            break outer;
                        }


                    }
                }
                if (distmin < Double.MAX_VALUE)
                    cordObj = Utils.sum(cordObj, Utils.scalarProcuct(vecRay, distmin));
            }
        }


        colPixel = ambLignt.applyColor(minshape, cordObj, shapes, camera);



        for (Light light : lights) {

            colPixel = Utils.sumColors(colPixel, light.applyColor(minshape, cordObj, shapes, camera));

        }


        return colPixel;
    }

    public void computeScreen() {
        for (int i = 0; i < screen.getBoard().getWidth(); i++) {

            for (int j = 0; j < screen.getBoard().getHeight(); j++) {

                Color color = getPixelColor(i, j, false);
                screen.getBoard().setRGB(i, screen.getBoard().getHeight() - 1 - j, color.getRGB());
            }
        }

    }


}
