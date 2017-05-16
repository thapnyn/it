package bai5;

import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Thap
 */
public class Mang {

    public static void main(String[] args) {
        
        Random rd = new Random();
        int[] mang;
        mang = new int[21];
        for (int i = 0; i < 21; i++) {
            mang[i] = rd.nextInt(100);
        }
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Nhap vao chi so mang"));
            System.out.println("Mang o chi so " + n + " co gia tri la " + mang[n]);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
