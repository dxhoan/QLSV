/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Database;
import View.ListView;
import View.Info;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hoan.dx173125
 */
public class SaveToFile {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public void saveStudentToFile() {
        try {
            conn = Database.getConnection();
            String query = "Select * from SINHVIEN";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Danh sách sinh viên");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("MSSV");
            header.createCell(1).setCellValue("Họ Tên");
            header.createCell(2).setCellValue("Giới Tính");
            header.createCell(3).setCellValue("Ngày Sinh");
            header.createCell(4).setCellValue("Lớp");
            header.createCell(5).setCellValue("Khóa");
            header.createCell(6).setCellValue("Viện");
            header.createCell(7).setCellValue("Email");

            sheet.setColumnWidth(0, 256*10);
            sheet.setColumnWidth(1, 256 * 25);
            sheet.setColumnWidth(2, 256 * 10);
            sheet.setColumnWidth(3, 256 * 20);
            sheet.setColumnWidth(4, 256 * 10);
            sheet.setColumnWidth(5, 256 * 10);
            sheet.setColumnWidth(6, 256 * 25);
            sheet.setColumnWidth(7, 256 * 25);
            sheet.setZoom(100);

            int index = 1;

            while (rs.next()) {
                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(rs.getString("MSSV"));
                row.createCell(1).setCellValue(rs.getString("HOTEN"));
                row.createCell(2).setCellValue(rs.getString("GIOITINH"));
                row.createCell(3).setCellValue(rs.getString("NGAYSINH"));
                row.createCell(4).setCellValue(rs.getString("LOP"));
                row.createCell(5).setCellValue(rs.getString("KHOA"));
                row.createCell(6).setCellValue(rs.getString("VIEN"));
                row.createCell(7).setCellValue(rs.getString("EMAIL"));

                index++;
            }
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\hoan.dx173125\\Desktop\\DanhSachSinhVien.xlsx");

            wb.write(fileOut);
            fileOut.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Lưu danh sách thành công.");
            alert.showAndWait();
            pst.close();
            rs.close();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveSubjecToFile(String mssv) {
        try {
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
                    + "when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<4 then 'F' else 'F' end as NVARCHAR(100)) as DIEMCHU\n"
                    + "FROM HOCPHAN hp, KETQUA kq WHERE kq.MSSV='" +mssv+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Danh sách môn học");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("Mã HP");
            header.createCell(1).setCellValue("Tên HP");
            header.createCell(2).setCellValue("Kỳ Học");
            header.createCell(3).setCellValue("Tín Chỉ");
            header.createCell(4).setCellValue("Lớp HP");
            header.createCell(5).setCellValue("Điểm QT");
            header.createCell(6).setCellValue("Điểm CK");
            header.createCell(7).setCellValue("Điểm Chữ");

            sheet.setColumnWidth(0, 256*10);
            sheet.setColumnWidth(1, 256 * 25);
            sheet.setColumnWidth(2, 256 * 10);
            sheet.setColumnWidth(3, 256 * 20);
            sheet.setColumnWidth(4, 256 * 10);
            sheet.setColumnWidth(5, 256 * 10);
            sheet.setColumnWidth(6, 256 * 25);
            sheet.setColumnWidth(7, 256 * 25);
            sheet.setZoom(100);

            int index = 1;

            while (rs.next()) {
                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(rs.getString("MAHP"));
                row.createCell(1).setCellValue(rs.getString("TENHP"));
                row.createCell(2).setCellValue(rs.getString("KYHOC"));
                row.createCell(3).setCellValue(rs.getString("TINCHI"));
                row.createCell(4).setCellValue(rs.getString("LOPHP"));
                row.createCell(5).setCellValue(rs.getString("DIEMQT"));
                row.createCell(6).setCellValue(rs.getString("DIEMCK"));
                row.createCell(7).setCellValue(rs.getString("DIEMCHU"));
                index++;
            }
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\hoan.dx173125\\Desktop\\BangDiem_"+mssv+".xlsx");

            wb.write(fileOut);
            fileOut.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Lưu danh sách thành công.");
            alert.showAndWait();
            pst.close();
            rs.close();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
