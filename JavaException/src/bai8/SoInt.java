package bai8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Thap
 */
public class SoInt {
    public SoInt(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
	PrintWriter fOut = new PrintWriter(new FileWriter(fileName));
        Random rd = new Random();
        //write
        fOut.print(rd.nextInt(100));
	for (int i = 0; i < 99; i++) {
            fOut.print(" " + rd.nextInt(100));
        }
        
	
	fOut.close();
        BufferedReader fIn = new BufferedReader(new FileReader(fileName));
        //read
        String daySo = fIn.readLine();
        String[] arrSoInt = daySo.split(" ");
        for (int i = 0; i < arrSoInt.length - 1; i++) {
            for (int j = arrSoInt.length - 2; j > i; j--) {
                if (Integer.parseInt(arrSoInt[j - 1]) > Integer.parseInt(arrSoInt[j])) {
                    String tpm = arrSoInt[j - 1];
                    arrSoInt[j - 1] = arrSoInt[j];
                    arrSoInt[j] = tpm;
                }
            }
        }
        System.out.println("Mang so int da duoc sap xep");
        for (int i = 0; i < arrSoInt.length - 1; i++) {
            System.out.print(arrSoInt[i] + " ");
        }
        fIn.close();
    }
    public static void main(String[] args) throws IOException {
        SoInt ob = new SoInt("IntData.txt");
    }
}
