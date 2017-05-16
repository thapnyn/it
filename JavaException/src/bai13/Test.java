package bai13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Thap
 */
public class Test {
    public void ghiTapTin(String fileName, ArrayList<NhanVien> danhSach) throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
	PrintWriter fOut = new PrintWriter(new FileWriter(fileName));
        for (int i = 0; i < danhSach.size(); i++) {
            fOut.println(danhSach.get(i));
        }
	fOut.close();
    }
    public static void main(String[] args) throws IOException {
        NhanVien nv1 = new NhanVien("nv1", "Long", 24, 100000);
        NhanVien nv2 = new NhanVien("nv2", "Nga", 21, 200000);
        NhanVien nv3 = new NhanVien("nv3", "Hai", 22, 400000);
        NhanVien nv4 = new NhanVien("nv4", "Thinh", 24, 500000);
        NhanVien nv5 = new NhanVien("nv5", "Linh", 23, 100000);
        NhanVien nv6 = new NhanVien("nv6", "Van", 23, 300000);
        NhanVien nv7 = new NhanVien("nv7", "My", 25, 200000);
        NhanVien nv8 = new NhanVien("nv8", "Ha", 22, 700000);
        NhanVien nv9 = new NhanVien("nv9", "Duc", 21, 500000);
        NhanVien nv10 = new NhanVien("nv10", "Trung", 21, 700000);
        
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
        danhSach.add(nv1);
        danhSach.add(nv2);
        danhSach.add(nv3);
        danhSach.add(nv4);
        danhSach.add(nv5);
        danhSach.add(nv6);
        danhSach.add(nv7);
        danhSach.add(nv8);
        danhSach.add(nv9);
        danhSach.add(nv10);
        
        Test ob = new Test();
        ob.ghiTapTin("danhsachnhanvien.txt", danhSach);
    }
}
