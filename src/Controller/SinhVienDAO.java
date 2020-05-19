/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static View.Main.*;
import Controller.Database;
import Model.SinhVien;
import View.ListView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 *
 * @author hoan.dx173125
 */
public class SinhVienDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public boolean check_mssv(String mssv) throws SQLException {
        if (mssv.equals("")) {
            return false;
        } else {
            conn = Database.getConnection();
            String sql = "Select MSSV from SINHVIEN where MSSV ='" + mssv + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int count_student() throws SQLException {
        conn = Database.getConnection();
        String sql = "Select count(MSSV) as SOLUONG from SINHVIEN";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            //System.out.println(rs.getInt(1));
            return rs.getInt("SOLUONG");
        } else {
            return 0;
        }
    }

    public SinhVien loadInfoStudent(String mssv) throws SQLException {
        conn = Database.getConnection();
        String sql = "select * from SINHVIEN where MSSV=" + mssv + "";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            SinhVien sv = new SinhVien(rs.getString("MSSV"), rs.getString("HOTEN"), rs.getString("GIOITINH"), rs.getString("NGAYSINH"), rs.getString("LOP"), rs.getString("KHOA"), rs.getString("VIEN"), rs.getString("EMAIL"));
            return sv;
        } else {
            SinhVien sv = new SinhVien();
            return sv;
        }
    }

    public void loadInfoToLabel(Label label1, Label label2, Label label3, Label label4, Label label5, Label label6, Label label7, Label label8) throws SQLException {
        conn = Database.getConnection();
        String sql = "select * from SINHVIEN where MSSV=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, mssv);
        rs = pst.executeQuery();
        while (rs.next()) {
            label1.setText(rs.getString("HOTEN"));
            label2.setText(rs.getString("MSSV"));
            label3.setText(rs.getString("GIOITINH"));
            label4.setText(rs.getString("NGAYSINH"));
            label5.setText(rs.getString("LOP"));
            label6.setText(rs.getString("KHOA"));
            label7.setText(rs.getString("VIEN"));
            label8.setText(rs.getString("EMAIL"));
        }
    }

    public void loadSinhVienFromDatabase(ObservableList<SinhVien> data) throws SQLException {

        data.clear();
        conn = Database.getConnection();
        String sql = "SELECT  sv.MSSV, sv.HOTEN , sv.GIOITINH, sv.LOP, sv.KHOA, sv.VIEN  FROM SINHVIEN sv ";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            data.add(new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
    }

    public void searchStudent(ObservableList<SinhVien> data, String searchTextField) throws SQLException {

        data.clear();
        String sql = "Select  MSSV, HOTEN, GIOITINH, LOP, KHOA, VIEN FROM SINHVIEN WHERE MSSV LIKE '%" + searchTextField + "%'"
                + "OR HOTEN LIKE '%" + searchTextField + "%'"
                + "OR LOP LIKE '%" + searchTextField + "%'"
                + "OR VIEN LIKE '%" + searchTextField + "%'";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            data.add(new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
    }

    public void addStudent(SinhVien sinhvien) throws SQLException {
        conn = Database.getConnection();
        String sql = "INSERT INTO dbo.SINHVIEN(MSSV,HOTEN,GIOITINH,NGAYSINH,KHOA,LOP,VIEN,EMAIL) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, sinhvien.getMSSV());
            pst.setString(2, sinhvien.getHoTen());
            pst.setString(3, sinhvien.getGioiTinh());
            pst.setString(4, sinhvien.getNgaySinh());
            pst.setString(5, sinhvien.getKhoa());
            pst.setString(6, sinhvien.getLop());
            pst.setString(7, sinhvien.getVien());
            pst.setString(8, sinhvien.getEmail());
            pst.executeUpdate();

            //setCellTable();
            //loadSinhVienFromDatabase(data);
        } catch (SQLException ex) {
            Logger.getLogger(ListView.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
    }

    public void editStudent(SinhVien sv, String mssv) throws SQLException {
        conn = Database.getConnection();
        String sql = "UPDATE SINHVIEN SET MSSV=?, HOTEN=?, GIOITINH=?, NGAYSINH=?, KHOA=?, LOP=?, VIEN=?, EMAIL=? where MSSV=?";
        try {
            pst = conn.prepareStatement(sql);
            //
            pst.setString(1, sv.getMSSV());
            pst.setString(2, sv.getHoTen());
            pst.setString(3, sv.getGioiTinh());
            pst.setString(4, sv.getNgaySinh());
            pst.setString(5, sv.getKhoa());
            pst.setString(6, sv.getLop());
            pst.setString(7, sv.getVien());
            pst.setString(8, sv.getEmail());
            pst.setString(9, mssv);
            //
            pst.executeUpdate();

            System.out.println(pst.executeUpdate());
            String x = String.valueOf(pst.executeUpdate());
            System.out.println(x);
            /*
            if (pst.executeUpdate().equals("false")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("MSSV đã bị trùng");
                alert.showAndWait();
            }
             */

            //setCellTable();
            //loadSinhVienFromDatabase(data);
        } catch (SQLException ex) {
            Logger.getLogger(ListView.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
    }

    public void deleteStudent(SinhVien sinhvien) throws SQLException {
        conn = Database.getConnection();
        String sql = "DELETE FROM SINHVIEN WHERE MSSV=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, sinhvien.getMSSV());
            pst.executeUpdate();

            //setCellTable();
            //loadDataFromDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(ListView.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
    }
}
