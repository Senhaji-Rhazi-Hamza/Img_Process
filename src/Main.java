import scene.Camera;
import scene.Scene;
import scene.Screen;
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

        Camera camera = new Camera(45, new Point(1, 0,0), new Point(0,1,1), new Point(0,0,0));
        Screen screen = new Screen(400, 400,camera);
        Color color = new Color(255, 0,0);
        Scene scene = new Scene(camera, screen, color);
        scene.computeScreen();
        File outputfile = new File("saved.png");
        try {
            ImageIO.write(screen.getBoard(), "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
