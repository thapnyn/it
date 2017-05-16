package hungbia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import javax.swing.JFrame;

/**
 *
 * @author Thap
 */
public class HungBia extends JFrame {
    
    private TapVe tapve;
    private ThungBia tb = new ThungBia();
    
    public HungBia() {
        setSize(800, 500);
        setTitle("Hứng bia");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 100);
        add(new TapVe());
        
        addKeyListener(new KeyAdapter() {
            @Override
                public void keyPressed(KeyEvent arg0) {
                    if (arg0.getKeyCode() == VK_LEFT) {
                        tb.giamX();
                    }
                    if (arg0.getKeyCode() == VK_RIGHT) {
                        tb.tangX();
                    }
                }
            });
    }
    
    public static void main(String[] args) {
        HungBia hb = new HungBia();
    }
    
}
