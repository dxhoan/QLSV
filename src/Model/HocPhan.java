package Model;

public class HocPhan {

    private String MaHP;
    private String TenHP;
    private String KyHoc;
    private String TinChi;
    private String LopHP;
    private String DiemQT;
    private String DiemCK;
    private String DiemChu;

    public HocPhan() {
    };

    public HocPhan(String MaHP, String TenHP, String KyHoc, String TinChi, String LopHP,
             String DiemQT, String DiemCK) {
        this.MaHP = MaHP;
        this.TenHP = TenHP;
        this.KyHoc = KyHoc;
        this.TinChi = TinChi;
        this.LopHP = LopHP;
        this.DiemQT = DiemQT;
        this.DiemCK = DiemCK;
        //this.DiemTongKet = DiemTongKet;
    }

    public HocPhan(String MaHP, String TenHP, String KyHoc, String TinChi, String LopHP, String DiemQT, String DiemCK, String DiemChu) {
        this.MaHP = MaHP;
        this.TenHP = TenHP;
        this.KyHoc = KyHoc;
        this.TinChi = TinChi;
        this.LopHP = LopHP;
        this.DiemQT = DiemQT;
        this.DiemCK = DiemCK;
        this.DiemChu = DiemChu;
    }

    
    public String getDiemChu() {
        return DiemChu;
    }

    public void setDiemChu(String DiemChu) {
        this.DiemChu = DiemChu;
    }
    
    

    public void setMaHP(String MaHP) {
        this.MaHP = MaHP;
    }

    public void setTenHP(String TenHP) {
        this.TenHP = TenHP;
    }

    public void setKyHoc(String KyHoc) {
        this.KyHoc = KyHoc;
    }

    public void setTinChi(String TinChi) {
        this.TinChi = TinChi;
    }

    public void setLopHP(String LopHP) {
        this.LopHP = LopHP;
    }

    public void setDiemQT(String DiemQT) {
        this.DiemQT = DiemQT;
    }

    public void setDiemCK(String DiemCK) {
        this.DiemCK = DiemCK;
    }

    public String getMaHP() {
        return MaHP;
    }

    public String getTenHP() {
        return TenHP;
    }

    public String getKyHoc() {
        return KyHoc;
    }

    public String getTinChi() {
        return TinChi;
    }

    public String getLopHP() {
        return LopHP;
    }

    public String getDiemQT() {
        return DiemQT;
    }

    public String getDiemCK() {
        return DiemCK;
    }
}
