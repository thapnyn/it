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
public class Hinh {
    
    private int x = 500;
    private int y = 0;
    private BufferedImage hinh1;
    private BufferedImage hinh2;
    private BufferedImage hinh3;
    private BufferedImage hinh4;
    private BufferedImage hinh5;
    
    public void paint(Graphics g, int key) throws IOException {
		//ve cac hinh anh theo key truyen vao
        if (key == 1) {
            hinh1 = ImageIO.read(new File(".\\res\\1.png"));
            g.drawImage(hinh1, x, y, null);
        }
        if (key == 2) {
            hinh2 = ImageIO.read(new File(".\\res\\2.png"));
            g.drawImage(hinh2, x, y, null);
        }
        if (key == 3) {
            hinh3 = ImageIO.read(new File(".\\res\\3.png"));
            g.drawImage(hinh3, x, y, null);
        }
        if (key == 4) {
            hinh4 = ImageIO.read(new File(".\\res\\4.png"));
            g.drawImage(hinh4, x, y, null);
        }
        if (key == 5) {
            hinh5 = ImageIO.read(new File(".\\res\\5.png"));
            g.drawImage(hinh5, x, y, null);
        }
    }
}
