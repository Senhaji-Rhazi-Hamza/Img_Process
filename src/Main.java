import scene.Camera;
import scene.Scene;
import scene.Screen;
import scene.lighs.Alight;
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
        Screen screen = new Screen(400, 400,camera);
        Color color = new Color(255, 255,255);
        Plane plane = new Plane(new Point(0,-1,0), -4,new Color(0, 200, 0));
        Plane plane2 = new Plane(new Point(1,0,0), -4,new Color(134, 0, 0));

        Alight ambLight = new Alight(color, 0.5);
        Circle circle = new Circle(new Color(255, 0, 0), new Point(-30, 20, 400), 30);
        Scene scene = new Scene(camera, screen, ambLight);
        scene.addShape(circle);
        scene.addShape(plane);
        scene.addShape(plane2);
        scene.computeScreen();
        File outputfile = new File("saved.png");
        try {
            ImageIO.write(screen.getBoard(), "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
