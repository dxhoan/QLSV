package Controller;

import Controller.Database;
import Model.User;
import View.ListView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public boolean check_login(User user) throws SQLException {
        conn = Database.getConnection();
        String sql = "SELECT * FROM dbo.TAIKHOAN WHERE USERNAME=? AND PASSWOD=?";
        pst = conn.prepareStatement(sql);
        //
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        //
        rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("USERNAME"));
            System.out.println(rs.getString("PASSWOD"));
            conn.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdmin(User user) throws SQLException {
        conn = Database.getConnection();
        String sql = "SELECT ROLEID FROM dbo.TAIKHOAN WHERE USERNAME=? AND PASSWOD=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        rs = pst.executeQuery();
        if (rs.next()) {
            if (rs.getInt("ROLEID") == 1) {
                conn.close();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void changePassword(String username, String password) throws SQLException {
        conn = Database.getConnection();
        String sql = "update TAIKHOAN set PASSWOD=? where USERNAME=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, password);
        pst.setString(2, username);
        pst.executeUpdate();
    }

    public void loadUser(String username) throws SQLException {
        conn = Database.getConnection();
        String sql = "SELECT  *  FROM TAIKHOAN WHERE USERNAME=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("USERNAME"));
            System.out.println(rs.getString("PASSWOD"));
        }
    }
}
