/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


public class TongKet {
    private String KyHoc;
    private String GPA;
    private String CPA;

    public TongKet(String KyHoc, String GPA, String CPA) {
        this.KyHoc = KyHoc;
        this.GPA = GPA;
        this.CPA = CPA;
    }

    public String getKyHoc() {
        return KyHoc;
    }

    public void setKyHoc(String KyHoc) {
        this.KyHoc = KyHoc;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getCPA() {
        return CPA;
    }

    public void setCPA(String CPA) {
        this.CPA = CPA;
    }
    
    
}
