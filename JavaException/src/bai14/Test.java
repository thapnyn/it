package bai14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Thap
 */
public class Test {
    public void xuLi(String fileName) throws IOException {
	BufferedReader fIn = new BufferedReader(new FileReader(fileName));
        String s;
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
	while ((s = fIn.readLine()) != null)
	{
            NhanVien nv = new NhanVien();
            StringTokenizer st = new StringTokenizer(s, "-");
            nv.setMaNV(st.nextToken());
            nv.setTenNV(st.nextToken());
            nv.setTuoi(Integer.parseInt(st.nextToken()));
            nv.setLuong(Integer.parseInt(st.nextToken()));
            danhSach.add(nv);
	}
	fIn.close();
        NhanVien nvLonTuoiNhat = danhSach.get(0);
        int tongTuoi = danhSach.get(0).getTuoi();
        for (int i = 1; i < danhSach.size(); i++) {
            tongTuoi += danhSach.get(i).getTuoi();
            if (nvLonTuoiNhat.getTuoi() < danhSach.get(i).getTuoi()) {
                nvLonTuoiNhat = danhSach.get(i);
            }
        }
        System.out.println("Nhan vien lon tuoi nhat: " + nvLonTuoiNhat);
        System.out.println("Tong so tuoi cua nhan vien: " + tongTuoi);
    }
    public static void main(String[] args) throws IOException {    
        Test ob = new Test();
        ob.xuLi("danhsachnhanvien.txt");
    }
}
