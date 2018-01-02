import scene.Camera;
import scene.Scene;
import scene.Screen;
import scene.lighs.Alight;
import scene.lighs.DirecLight;
import scene.lighs.Light;
import scene.lighs.Plight;
import scene.shapes.Circle;
import scene.shapes.Plane;
import space.Point;
import space.Utils;
import test.testUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Camera camera = new Camera(45, new Point(1, 0,0), new Point(0,1,0), new Point(0,0,0));
        //System.out.println(camera.getW());
        Screen screen = new Screen(400, 400,camera);
       // System.out.println(screen.getCenter());
        Color color = new Color(255, 255,255);
        Plane plane = new Plane(new Point(0,1,0),new Point(0,-200,0),new Color(0, 200, 0));
        Plane plane2 = new Plane(new Point(-1,0,0), new Point(200,0,0),new Color(0, 0, 255));
       // System.out.println(screen.getCenter().toString());
        Alight ambLight = new Alight(color, 0.1);
        Circle circle = new Circle(new Color(255, 0, 0), new Point(50, -50, 600.518), 30);
        Circle circle2 = new Circle(new Color(243, 255, 91), new Point(-0, 80, screen.getCenter().getZ() + 50), 30);
        Circle circle3 = new Circle(new Color(74, 137, 255), new Point(0, 0, 500), 30);
        Circle circle4 = new Circle(new Color(255, 55, 241), new Point(-50, 30, 450), 30);

        DirecLight direcLight = new DirecLight(new Color(255, 255, 255), new Point(1, -1, 0));
        Plight plight = new Plight(new Color(255, 255, 255), new Point(180,40,500.518));
        Scene scene = new Scene(camera, screen, ambLight);
        scene.addShape(circle);
        scene.addShape(circle2);
        //
        scene.addShape(circle3);
        scene.addShape(plane);
        scene.addShape(plane2);
        scene.addShape(circle4);
        scene.addLight(direcLight);
        //scene.addLight(plight);
        scene.computeScreen();
        File outputfile = new File("saved2.png");
        try {
            ImageIO.write(screen.getBoard(), "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

     // testUtils.testIntersect();
  //  testUtils.testGetNormVecCircle();
    }

}
