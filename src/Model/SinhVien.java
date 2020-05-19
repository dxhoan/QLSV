//Chứa các thành phần thông tin
package Model;

public class SinhVien {

    private String MSSV;
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String Khoa;
    private String Lop;
    private String Vien;
    private String Email;

    public SinhVien() {
    }
    public SinhVien(String MSSV) {
        this.MSSV = MSSV;
    }

    public SinhVien(String MSSV, String HoTen, String GioiTinh, String Lop, String Khoa, String Vien) {
        this.MSSV = MSSV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.Lop = Lop;
        this.Khoa = Khoa;
        this.Vien = Vien;
    }

    public SinhVien(String MSSV, String HoTen, String GioiTinh, String NgaySinh, String Lop,
            String Khoa, String Vien, String Email) {
        this.MSSV = MSSV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Lop = Lop;
        this.Khoa = Khoa;
        this.Vien = Vien;
        this.Email = Email;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public void setVien(String Vien) {
        this.Vien = Vien;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getKhoa() {
        return Khoa;
    }

    public String getLop() {
        return Lop;
    }

    public String getVien() {
        return Vien;
    }

    public String getEmail() {
        return Email;
    }
}
