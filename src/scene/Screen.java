package scene;

import space.Point;
import space.Utils;

import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_3BYTE_BGR;

public class Screen{
    private BufferedImage board;
    private Point center;
    public Screen(int w, int h)
    {
        this.board = new BufferedImage(w, h, TYPE_3BYTE_BGR);
        this.center = new Point(0, 0, 0);
    }
    public Screen(int w, int h, Camera camera)
    {
        this.board = new BufferedImage(w, h, TYPE_3BYTE_BGR);
        double L = (board.getWidth()/2)/ Math.tan(camera.getAngle()/2);


        this.center = Utils.sum(camera.getLocation(), Utils.scalarProcuct(camera.getW(), L));
    }
    public Point getPixelCord(int i, int j)
    {

        return Utils.sum(this.center, new Point(i - board.getWidth()/2, j - board.getHeight()/2, 0));
    }
    public Point getVecRay(int i, int j, Camera camera)
    {
        return Utils.getNormVec(Utils.sum(getPixelCord(i, j),camera.getLocation().getInv()));
    }

    public BufferedImage getBoard() {
        return board;
    }

    public void setBoard(BufferedImage board) {
        this.board = board;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}
