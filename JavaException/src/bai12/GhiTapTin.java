package bai12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Thap
 */
public class GhiTapTin {
    public GhiTapTin(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
	PrintWriter fOut = new PrintWriter(new FileWriter(fileName));
        int arrSoNguyen[] = {1, 2, 3, 4, 5};
        Date date = new Date();
        double n = 5.5;
        fOut.println(arrSoNguyen[0] + " " + arrSoNguyen[1] + " " 
                + arrSoNguyen[2] + " " + arrSoNguyen[3] + " " + arrSoNguyen[4]);
        fOut.println(date.toString());
        fOut.print(n);
	fOut.close();
    }
    public static void main(String[] args) throws IOException {
        GhiTapTin ob = new GhiTapTin("bai12.txt");
    }
}
