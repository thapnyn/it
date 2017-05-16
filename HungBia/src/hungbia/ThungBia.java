package hungbia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Thap
 */
public class ThungBia {
    public static int h = 100;
    public static int w = 150;
    private static int x = 100;
    private static int y = 370;
    private BufferedImage thungBia;
    
     public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    
    public void paint(Graphics g) throws IOException {
        thungBia = ImageIO.read(new File(".\\res\\Thungbia.png"));
        g.drawImage(thungBia, x, y, null);
    }
    
    public void tangX() {
		//di chuyen thung bia qua phai
        if(x + w < 500) {
            x += 10;
        }
    }
    
    public void giamX() {
		//di chuyen thung bia qua trai
        if(x >= 10) {
            x -= 10;
        }
    }
}
