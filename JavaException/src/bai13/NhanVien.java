package bai13;

/**
 *
 * @author Thap
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
    private int tuoi;
    private int luong;

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
    
    public NhanVien(String maNV, String tenNV, int tuoi, int luong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.luong = luong;
    }
    public String toString() {
        return maNV + "-" + tenNV + "-" + tuoi + "-" + luong;
    }
}
