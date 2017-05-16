package bai10;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Thap
 */
public class TepNhiPhan {
    public TepNhiPhan(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.exists())
            f.createNewFile();
	DataOutputStream  fOut = new DataOutputStream (new FileOutputStream(fileName));
	Random rd = new Random();
        //fOut.write(rd.nextInt(100));
	for (int i = 0; i < 100; i++) {
            fOut.write(rd.nextInt(100));
            fOut.writeUTF(" ");
        }
        fOut.flush();
	fOut.close();
    }
     public static void main(String[] args) throws IOException {
        TepNhiPhan ob = new TepNhiPhan("bai10.dat");
    }
}
