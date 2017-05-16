package sql_quanlisinhvien;

/**
 *
 * @author Thap
 */
class SinhVien {
    private String MSSV;
    private String ten;
    private int namSinh;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(String MSSV, String ten, int namSinh, String diaChi) {
        this.MSSV = MSSV;
        this.ten = ten;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getTen() {
        return ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
