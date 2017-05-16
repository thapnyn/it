package bai7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Thap
 */
public class DocSoThuc {
    public void fileSoThuc(String nameFile) throws IOException {
        BufferedReader fIn = new BufferedReader(new FileReader(nameFile));
        String daySoThuc = fIn.readLine();
        StringTokenizer st = new StringTokenizer(daySoThuc, " ");
        int soLuongTK = st.countTokens();
        int tongTK = 0;
        for (int i = 0; i < soLuongTK; i++) {
            double n = Double.parseDouble(st.nextToken());
            tongTK += n;
        }
        System.out.println("Tong: " + tongTK);
        System.out.println("Trung binh cong: " + tongTK/soLuongTK);
        fIn.close();
    }
    public static void main(String[] args) throws IOException {
        DocSoThuc dst = new DocSoThuc();
        try {
            dst.fileSoThuc("data.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
