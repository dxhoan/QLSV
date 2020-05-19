/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static View.Main.*;
import Controller.Database;
import Model.TongKet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author hoan.dx173125
 */
public class TongKetDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public void loadDataFromDatabase(ObservableList<TongKet> data, XYChart.Series<String, Number> series) throws SQLException {
        data.clear();
        conn = Database.getConnection();
        String sql = "Select  b.KYHOC, ROUND(AVG(b.DIEMSO),2) as GPA, ROUND(AVG(b.DIEMSO),2) as CPA\n"
                + "   from (Select  a.MAHP, a.TENHP, a.KYHOC, a.TINCHI, a.LOPHP, a.DIEMQT, a.DIEMCK, a.DIEMCHU, cast(case\n"
                + "														when a.DIEMCHU='A+' then 4.0\n"
                + "   													when a.DIEMCHU='A' then 4.0\n"
                + "														when a.DIEMCHU='B+' then 3.5\n"
                + "  													when a.DIEMCHU='B' then 3.0\n"
                + "    													when a.DIEMCHU='C+' then 2.5\n"
                + "     													when a.DIEMCHU='C' then 2.0\n"
                + "     													when a.DIEMCHU='D+' then 1.5\n"
                + " 														when a.DIEMCHU='D' then 1.0\n"
                + "      														when a.DIEMCHU='F' then 0 else 0 end as float) as DIEMSO\n"
                + "         from  (Select  hp.MAHP, hp.TENHP, kq.KYHOC, hp.TINCHI, kq.LOPHP, kq.DIEMQT, kq.DIEMCK,\n"
                + "    			cast(case\n"
                + "       			when kq.DIEMQT<3 OR kq.DIEMCK<3 then 'F'\n"
                + "         			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=9.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<=10 then 'A+'\n"
                + "      			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<9.5 then 'A'\n"
                + "       			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=8 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8.5 then 'B+'\n"
                + "     		when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=7 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<8 then 'B'\n"
                + "     			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=6.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<7 then 'C+'\n"
                + "  				when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5.5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<6.5 then 'C'\n"
                + "         			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=5 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5.5 then 'D+'\n"
                + "      			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)>=4 AND (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<5 then 'D'\n"
                + "       			when (kq.DIEMQT*0.3+kq.DIEMCK*0.7)<4 then 'F' else 'F' end as NVARCHAR(100)) as DIEMCHU\n"
                + "     			from HOCPHAN hp,KETQUA kq where kq.MSSV = ?) a\n"
                + "       ) b\n"
                + "        group by b.KYHOC";
        pst = conn.prepareStatement(sql);
        pst.setString(1, mssv);
        rs = pst.executeQuery();
        while (rs.next()) {
            data.add(new TongKet(rs.getString(1), rs.getString(2), rs.getString(3)));
            series.getData().add(new XYChart.Data<String, Number>(rs.getString(1), Float.valueOf(rs.getString(2))));
        }
    }

}
