/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Database;
import Model.HocPhan;
import View.ListView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author hoan.dx173125
 */
public class HocPhanDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst1 = null;
    private ResultSet rs = null;

    public boolean check_mahp(String mssv, String mahp) throws SQLException {
        if (mahp.equals("")) {
            return false;
        } else {
            conn = Database.getConnection();
            String sql = "Select MAHP from KETQUA where MAHP ='" + mahp + "' and MSSV='" + mssv + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean check_mahp2(String mssv, String mahp) throws SQLException {
        if (mahp.equals("")) {
            return false;
        } else {
            conn = Database.getConnection();
            String sql = "Select hp.MAHP from KETQUA kq, HOCPHAN hp where hp.MAHP=kq.MAHP and hp.MAHP ='" + mahp + "' and kq.MSSV='" + mssv + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public HocPhan loadInfoSubject(String mssv, String mahp) throws SQLException {
        conn = Database.getConnection();
        String sql = "select hp.MAHP, hp.TENHP, kq.KYHOC , hp.TINCHI, kq.LOPHP, kq.DIEMQT, kq.DIEMCK\n"
                + "from HOCPHAN hp, KETQUA kq\n"
                + "where hp.MAHP = kq.MAHP and kq.MSSV='" + mssv + "' and hp.MAHP='" + mahp + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            HocPhan hp = new HocPhan(rs.getString("MAHP"), rs.getString("TENHP"), rs.getString("KYHOC"), rs.getString("TINCHI"), rs.getString("LOPHP"), rs.getString("DIEMQT"), rs.getString("DIEMCK"));
            return hp;
        } else {
            HocPhan hp = new HocPhan();
            return hp;
        }
    }

    public void loadSubjectFromDatabase(String mssv, ObservableList<HocPhan> data) throws SQLException {
        data.clear();
        conn = Database.getConnection();
        String sql = "SELECT  hp.MAHP, hp.TENHP , kq.KYHOC, hp.TINCHI, kq.LOPHP, kq.DIEMQT, kq.DIEMCK, \n"
                + "cast(case \n"
                + "when kq.DIEMQT<3 OR kq.DIEMCK<3 then 'F'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=9.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<=10 then 'A+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<9.5 then 'A'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8.5 then 'B+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=7 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8 then 'B'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=6.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<7 then 'C+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<6.5 then 'C'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5.5 then 'D+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=4 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5 then 'D'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<4 then 'F' else 'NULL' end as NVARCHAR(100)) as DIEMCHU\n"
                + "FROM HOCPHAN hp, KETQUA kq WHERE hp.MAHP=kq.MAHP and MSSV=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, mssv);
        rs = pst.executeQuery();
        while (rs.next()) {
            if (rs.getString("DIEMQT").equals("0.0") && rs.getString("DIEMCK").equals("0.0")) {
                data.add(new HocPhan(rs.getString("MAHP"), rs.getString("TENHP"), rs.getString("KYHOC"), rs.getString("TINCHI"), rs.getString("LOPHP"), rs.getString("DIEMQT"), rs.getString("DIEMCK"), "NULL"));
            } else {
                data.add(new HocPhan(rs.getString("MAHP"), rs.getString("TENHP"), rs.getString("KYHOC"), rs.getString("TINCHI"), rs.getString("LOPHP"), rs.getString("DIEMQT"), rs.getString("DIEMCK"), rs.getString("DIEMCHU")));
            }
        }
    }

    public void searchSubject(String mssv, ObservableList<HocPhan> data, String searchTextField) throws SQLException {
        data.clear();
        String sql = "Select  hp.MAHP, hp.TENHP, kq.KYHOC, hp.TINCHI, kq.LOPHP, kq.DIEMQT, kq.DIEMCK, \n"
                + "cast(case \n"
                + "when kq.DIEMQT<3 OR kq.DIEMCK<3 then 'F'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=9.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<=10 then 'A+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<9.5 then 'A'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8.5 then 'B+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=7 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8 then 'B'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=6.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<7 then 'C+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<6.5 then 'C'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5.5 then 'D+'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=4 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5 then 'D'\n"
                + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<4 then 'F' else 'F' end as NVARCHAR(100)) as DIEMCHU "
                + "FROM HOCPHAN hp, KETQUA kq "
                + "WHERE hp.MAHP=kq.MAHP and (hp.MAHP LIKE '%" + searchTextField + "%' OR hp.TENHP LIKE '%" + searchTextField + "%' OR kq.KYHOC LIKE '%" + searchTextField
                + "%') AND kq.MSSV='" + mssv + "'";
        // OR DIEMCHU='%"+searchTextField+"%'
        pst = conn.prepareStatement(sql);
        //pst.setString(1, mssv);
        rs = pst.executeQuery();
        while (rs.next()) {
            data.add(new HocPhan(rs.getString("MAHP"), rs.getString("TENHP"), rs.getString("KYHOC"), rs.getString("TINCHI"), rs.getString("LOPHP"), rs.getString("DIEMQT"), rs.getString("DIEMCK"), rs.getString("DIEMCHU")));
        }
    }

    public void addSubject(String mssv, HocPhan hocphan) throws SQLException {
        conn = Database.getConnection();
        String sql = "insert into HOCPHAN(MAHP,TENHP,TINCHI) values (?,?,?)\n"
                + "insert into KETQUA(MSSV,MAHP,KYHOC,LOPHP,DIEMQT,DIEMCK) values (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, hocphan.getMaHP());
            pst.setString(2, hocphan.getTenHP());
            pst.setString(3, hocphan.getTinChi());
            pst.setString(4, mssv);
            pst.setString(5, hocphan.getMaHP());
            pst.setString(6, hocphan.getKyHoc());
            pst.setString(7, hocphan.getLopHP());
            pst.setString(8, hocphan.getDiemQT());
            pst.setString(9, hocphan.getDiemCK());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
    }

    public void editSubject(String mssv, String mahp, HocPhan hocphan, ObservableList<HocPhan> data) throws SQLException {
        conn = Database.getConnection();
        /*String sql = "UPDATE HOCPHAN(TENHP,TINCHI) SET MAHP='"+hocphan.getMaHP()+"', TENHP=?, TINCHI=? WHERE MAHP=?\n"
                + "UPDATE KETQUA SET MAHP='"+hocphan.getMaHP()+"', LOPHP=?, DIEMQT=?, DIEMCK=? where MSSV='"+mssv+"' and MAHP='"+hocphan.getMaHP()+"'";*/
 /*String sql = "UPDATE HOCPHAN SET MAHP=?, TENHP=?, TINCHI=? WHERE MAHP=?\n"
                + "UPDATE KETQUA SET MSSV=?,KYHOC=?, LOPHP=?, DIEMQT=?, DIEMCK=? where MSSV='"+mssv+"'"; */

        if (!check_mahp2(mssv, mahp)) {
            addSubject(mssv, hocphan);
        } else {
            String sql = "UPDATE HOCPHAN SET MAHP=?, TENHP=?, TINCHI=? WHERE MAHP='" + mahp + "'";
            String sql2 = "UPDATE KETQUA SET KYHOC=?, LOPHP=?, DIEMQT=?, DIEMCK=? where MSSV='" + mssv + "' and MAHP='" + mahp + "'";
            try {
                pst = conn.prepareStatement(sql);
                //
                pst.setString(1, hocphan.getMaHP());
                pst.setString(2, hocphan.getTenHP());
                pst.setString(3, hocphan.getTinChi());
                pst.executeUpdate();

                pst1 = conn.prepareStatement(sql2);

                pst1.setString(1, hocphan.getKyHoc());
                pst1.setString(2, hocphan.getLopHP());
                pst1.setString(3, hocphan.getDiemQT());
                pst1.setString(4, hocphan.getDiemCK());

                //pst.setString(7, hocphan.getDiemCK());
                //pst.setString(8, hocphan.getMaHP());
                //
                pst1.executeUpdate();

                //setCellTable();
                //loadDataFromDatabase(data);
            } catch (SQLException ex) {
                Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pst.close();
            }
        }
    }

    public void deleteSubject(String mssv, HocPhan hocphan, ObservableList<HocPhan> data) throws SQLException {
        conn = Database.getConnection();
        String sql = "DELETE FROM KETQUA WHERE MAHP=? AND MSSV=" + mssv + "";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, hocphan.getMaHP());
            pst.executeUpdate();

            // setCellTable();
            //loadDataFromDatabase(data);
        } catch (SQLException ex) {
            Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
    }
}
