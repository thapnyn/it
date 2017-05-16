package hungbia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Thap
 */
public class TapVe extends JPanel implements Runnable {

    private ChaiBia cb1 = new ChaiBia();
    private ChaiBia cb2 = new ChaiBia();
    private ChaiBia cb3 = new ChaiBia();
    private ChaiBia cb4 = new ChaiBia();
    private ChaiBia cb5 = new ChaiBia();
    
    private ThungBia tb = new ThungBia();
    private Thread threadT;
    private int count = 3; // so mang
    private int diem = 0; // diem so
    private int level = 1; // key cua hinh anh
    
    private Hinh hinh = new Hinh();
    public TapVe() {
        threadT = new Thread(this);
        threadT.start();
    }
    
    @Override
    public void paint(Graphics g) {
        
        try {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.red);
            g.setFont(new Font("Courier New", Font.ITALIC, 18));
            g.drawString("Điểm: " + diem, 20, 20);
            g.drawString("Mạng: " + count, 20, 40);
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.drawLine(500, 0, 500, 500);
            
            hinh.paint(g, level);
            
            cb1.paint(g);
            cb2.paint(g);
            cb3.paint(g);
            cb4.paint(g);
            cb5.paint(g);
            
            tb.paint(g);
        } catch (IOException ex) {
            Logger.getLogger(TapVe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop() {

    }
    
    @Override
    public void run() {
        while (true) {
            repaint();
            cb1.tangY();
            cb2.tangY();
            cb3.tangY();
            cb4.tangY();
            cb5.tangY();
            
            try {
                if (diem < 50) {
                    Thread.sleep(17);
                }
                else {
                    if (diem < 50 && diem < 100) {
                        Thread.sleep(13);
                    }
                    else
                    {
                        Thread.sleep(10);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TapVe.class.getName()).log(Level.SEVERE, null, ex);
            }
            hungDuocBia();
            demSoChaiKoHungDuoc();
            tangLevel();
            cb1.lapLai();
            cb2.lapLai();
            cb3.lapLai();
            cb4.lapLai();
            cb5.lapLai();
            if (over() == true || diem == 100) {
                repaint();
                threadT.stop();
            }
        }
    }
    
    public void hungDuocBia() {
		//kiem tra xem co hung duoc bia hay ko de tang diem va lap lai
        if ((ThungBia.getY() <=  cb1.getY() + ChaiBia.getCao())
                && (cb1.getY() + ChaiBia.getCao() < getHeight())
                && (ThungBia.getX() <=  cb1.getX() + ChaiBia.getRong())
                && (cb1.getX() + ChaiBia.getRong() < ThungBia.getX() + ThungBia.w)) {
            diem ++;
            cb1.lapLai2();
        }
        if ((ThungBia.getY() <=  cb2.getY() + ChaiBia.getCao())
                && (cb2.getY() + ChaiBia.getCao() < getHeight())
                && (ThungBia.getX() <=  cb2.getX() + ChaiBia.getRong())
                && (cb2.getX() + ChaiBia.getRong() < ThungBia.getX() + ThungBia.w)) {
            diem ++;
            cb2.lapLai2();
        }
        if ((ThungBia.getY() <=  cb3.getY() + ChaiBia.getCao())
                && (cb3.getY() + ChaiBia.getCao() < getHeight())
                && (ThungBia.getX() <=  cb3.getX() + ChaiBia.getRong())
                && (cb3.getX() + ChaiBia.getRong() < ThungBia.getX() + ThungBia.w)) {
            diem ++;
            cb3.lapLai2();
        }
        if ((ThungBia.getY() <=  cb4.getY() + ChaiBia.getCao())
                && (cb4.getY() + ChaiBia.getCao() < getHeight())
                && (ThungBia.getX() <=  cb4.getX() + ChaiBia.getRong())
                && (cb4.getX() + ChaiBia.getRong() < ThungBia.getX() + ThungBia.w)) {
            diem ++;
            cb4.lapLai2();
        }
        if ((ThungBia.getY() <=  cb5.getY() + ChaiBia.getCao())
                && (cb5.getY() + ChaiBia.getCao() < getHeight())
                && (ThungBia.getX() <=  cb5.getX() + ChaiBia.getRong())
                && (cb5.getX() + ChaiBia.getRong() < ThungBia.getX() + ThungBia.w)) {
            diem ++;
            cb5.lapLai2();
        }
    }
    
    public void demSoChaiKoHungDuoc() {
		//neu khong hung duoc bia thi so mang se bi tru di 1
        if (cb1.getY() == getHeight()) {
            count--;
        }
        if (cb2.getY() == getHeight()) {
            count--;
        }
        if (cb3.getY() == getHeight()) {
            count--;
        }
        if (cb4.getY() == getHeight()) {
            count--;
        }
        if (cb5.getY() == getHeight()) {
            count--;
        }
    }
    
    public void tangLevel() {
        if (diem >= 20 && diem < 50) {
            level = 2;
        }
        if (diem >= 50 && diem < 80) {
            level = 3;
        }
        if (diem >= 80 && diem < 100) {
            level = 4;
        }
        if (diem >= 100) {
            level = 5;
        }
    }
    
    public boolean over() {
        if (count <= 0) {
            return true;
        }
        return false;
    }
    
}
