package sql_quanlisinhvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Thap
 */
public final class QuanLiSinhVien extends JFrame {

    private final JButton btnThoat;
    private final JButton btnTatCa;
    private final JButton btnThem;
    private final JButton btnNext;
    private final JButton btnPrevious;
    private final JButton btnXoa;
    private final JButton btnSua;
    private JTextField txtMa, txtTen, txtNS, txtDC;
    private JRadioButton radNhap, radXoa, radSua;

    private ArrayList<SinhVien> dssv;
    private int vitrihientai;

    public QuanLiSinhVien() throws ClassNotFoundException, SQLException {
        dssv = new ArrayList<SinhVien>();
        vitrihientai = 0;
        dssv = getData();
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quan li san Pham");

        JPanel tren = new JPanel();
        tren.setBackground(Color.yellow);

        JPanel trai = new JPanel();
        trai.setBackground(Color.red);

        JPanel duoi = new JPanel();
        duoi.setBackground(Color.cyan);

        JPanel giua = new JPanel();
        giua.setBackground(Color.pink);

        tren.add(new JLabel("Quản Lí Sinh Viên"));
        btnThoat = new JButton("Thoát");
        trai.add(btnThoat);
        trai.setLayout(new BoxLayout(trai, BoxLayout.Y_AXIS));
        btnTatCa = new JButton("Tất cả Sinh Viên");
        trai.add(btnTatCa);    
        

        radNhap = new JRadioButton("Thêm sinh viên");
        radXoa = new JRadioButton("Xóa sinh viên");
        radSua = new JRadioButton("Thay đổi thông tin sinh siên");
        
        ButtonGroup bgp = new ButtonGroup();
        bgp.add(radNhap);
        bgp.add(radXoa);
        bgp.add(radSua);
        
        trai.add(radNhap);
        trai.add(radXoa);
        trai.add(radSua);

        giua.setLayout(new GridLayout(5, 2));

        JLabel lbma = new JLabel("Mã sinh viên:");
        txtMa = new JTextField(15);

        giua.add(lbma);
        giua.add(txtMa);

        giua.add(new JLabel("Tên sinh viên"));
        txtTen = new JTextField(15);
        giua.add(txtTen);

        giua.add(new JLabel("Năm sinh"));
        txtNS = new JTextField(15);
        giua.add(txtNS);

        giua.add(new JLabel("Địa chỉ"));
        txtDC = new JTextField(15);
        giua.add(txtDC);

        btnXoa = new JButton("Xóa");
        btnSua = new JButton("Sửa");
        btnThem = new JButton("Thêm");
        btnNext = new JButton(">>");
        btnPrevious = new JButton("<<");

        duoi.add(btnXoa);
        duoi.add(btnSua);
        duoi.add(btnThem);
        duoi.add(btnPrevious);
        duoi.add(btnNext);

        add(tren, BorderLayout.NORTH);
        add(trai, BorderLayout.WEST);
        add(giua, BorderLayout.CENTER);
        add(duoi, BorderLayout.SOUTH);

        btnTatCa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                SinhVien sv = dssv.get(0);

                txtMa.setText(sv.getMSSV());
                txtTen.setText(sv.getTen());
                txtNS.setText(sv.getNamSinh() + "");
                txtDC.setText(sv.getDiaChi());
            }
        });

        btnNext.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (vitrihientai != dssv.size() - 1) {
                    vitrihientai++;
                    SinhVien sv = dssv.get(vitrihientai);

                    txtMa.setText(sv.getMSSV());
                    txtTen.setText(sv.getTen());
                    txtNS.setText(sv.getNamSinh() + "");
                    txtDC.setText(sv.getDiaChi());
                }
            }
        });

        btnPrevious.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (vitrihientai != 0) {
                    vitrihientai--;
                    SinhVien sv = dssv.get(vitrihientai);

                    txtMa.setText(sv.getMSSV());
                    txtTen.setText(sv.getTen());
                    txtNS.setText(sv.getNamSinh() + "");
                    txtDC.setText(sv.getDiaChi());
                }

            }
        });
        
        btnThoat.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                

            }
        });
        
        btnThem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                System.out.println(radNhap.isSelected());
                if (radNhap.isSelected()) {
                    SinhVien sv = new SinhVien(txtMa.getText(), txtTen.getText(), Integer.parseInt(txtNS.getText()), txtDC.getText());
                    try {
                        addSinhVien(sv);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
        btnSua.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (radSua.isSelected() == true) {
                    SinhVien sv = new SinhVien(txtMa.getText(), txtTen.getText(), Integer.parseInt(txtNS.getText()), txtDC.getText());
                    try {
                        update(sv);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
        btnXoa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (radXoa.isSelected() == true) {
                    SinhVien sv = new SinhVien(txtMa.getText(), txtTen.getText(), Integer.parseInt(txtNS.getText()), txtDC.getText());
                    try {
                        deleteSVTheoMSSV(sv.getMSSV());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

    }
    

    public ArrayList<SinhVien> getData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/quanlisinhvien";
            conn = (Connection) DriverManager.getConnection(url, "root", "Thap");
            String sql1 = "select * from sinhvien";
            ResultSet rs;
            try (Statement stmt = (Statement) conn.createStatement()) {
                rs = stmt.executeQuery(sql1);
                while (rs.next()) {
                    SinhVien sv = new SinhVien(rs.getString("MSSV"), rs.getString("TenSV"), rs.getInt("NamSinh"), rs.getString("DiaChi"));
                    dssv.add(sv);
                }
            }
            rs.close();
            return dssv;

        } catch (SQLException e) {
        } finally {
            conn.close();
        }
        return null;
    }
    
    public void addSinhVien(SinhVien sv) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/quanlisinhvien";
            conn = (Connection) DriverManager.getConnection(url, "root", "Thap");
            String sql1 = "insert into sinhvien "
                    + "values ('" + sv.getMSSV() + "'," + "'" + sv.getTen() + "'," + sv.getNamSinh() + ",'" + sv.getDiaChi() + "')";
            Statement stmt = (Statement) conn.createStatement();
            int tpm = stmt.executeUpdate(sql1);
            if (tpm == 1) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                dssv = getData();
            }
            stmt.close();
        } catch (SQLException e) {
        } finally {
            conn.close();
        }
    }
    
    public void update(SinhVien sv) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/quanlisinhvien";
            conn = (Connection) DriverManager.getConnection(url, "root", "Thap");
            String sql1 = "update sinhvien set MSSV='" + sv.getMSSV() + "' TenSV='" + sv.getTen() + "' NamSinh=" + sv.getNamSinh() + " DiaChi='" + sv.getDiaChi() + "'";
            Statement stmt = (Statement) conn.createStatement();
            int tpm = stmt.executeUpdate(sql1);
            if (tpm == 1) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                dssv = getData();
            }
            stmt.close();

        } catch (SQLException e) {
        } finally {
            conn.close();
        }
    }
    
    public void deleteSVTheoMSSV(String mssv) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/quanlisinhvien";
            conn = (Connection) DriverManager.getConnection(url, "root", "Thap");
            String sql1 = "delete from sinhvien where MSSV='" + mssv + "'";
            Statement stmt = (Statement) conn.createStatement();
            int tpm = stmt.executeUpdate(sql1);
            if (tpm == 1) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                txtMa.setText("");
                txtTen.setText("");
                txtNS.setText("");
                txtDC.setText("");
                dssv = getData();
            }
            stmt.close();

        } catch (SQLException e) {
        } finally {
            conn.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        QuanLiSinhVien qlsv = new QuanLiSinhVien();
        qlsv.setVisible(true);
    }

}