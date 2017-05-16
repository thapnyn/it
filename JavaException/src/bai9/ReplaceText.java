package bai9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Thap
 */
public class ReplaceText {
    public ReplaceText(String sourceFile,String destFile) throws FileNotFoundException, IOException {
        BufferedReader fIn = new BufferedReader(new FileReader(sourceFile));
	PrintWriter fOut1 = new PrintWriter(new FileWriter(destFile));    
	String oldString;
        String newString = "This is new string";
        int count = 0;
	while ((oldString = fIn.readLine()) != null)
	{
            count ++;
            fOut1.println(newString);
	}
	fIn.close();
	fOut1.close();
        PrintWriter fOut2 = new PrintWriter(new FileWriter(sourceFile));
        for (int i = 0; i < count; i++) {
            fOut2.println(newString);
        }
        fOut2.close();
    }
    public static void main(String[] args) throws IOException {
        ReplaceText ob = new ReplaceText("sourceFile.txt", "destFile.txt");
    }
}
