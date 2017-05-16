package hungbia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Thap
 */
public class ChaiBia {
    public static int rong = 30;
    public static int cao = 80;
    private int x, y;
    private BufferedImage chaiBia;

    public ChaiBia() {
		//khoi tao 1 chai bia voi toa do ngau nhien
        Random rd = new Random();
        this.x = rd.nextInt(470);
        this.y = rd.nextInt(100) - 300;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getRong() {
        return rong;
    }

    public static int getCao() {
        return cao;
    }
    
    public void paint(Graphics g) throws IOException {
        chaiBia = ImageIO.read(new File(".\\res\\Chaibia.png"));
        g.drawImage(chaiBia, x, y, null);
    }
    
    public void tangY() {
		//chia bia roi
        y++;
    }
    
    public void lapLai() {
		//lap lai khi chai bia cham dat
        Random rd = new Random();
        if (y == 500) {
            x = rd.nextInt(470);
            y = rd.nextInt(200) - 600;
        }
    }
    
    public void lapLai2() {
		//lap lai khi chai bia duoc hung boi thung bia
        Random rd = new Random();
        x = rd.nextInt(470);
        y = rd.nextInt(200) - 600;
    }
}
