package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    private static Statement stm;
    private static ResultSet rs;

    private static final String url = "jdbc:sqlserver://localhost:1433;"+"databaseName=PROJECT2";
    private static final String username = "sa";
    private static final String password = "123456";
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url,username,password);
        return conn;
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
        /*
        Connection conn = ConnectDB.getConnection();
        stm = conn.createStatement();
        String sql = "SELECT * FROM dbo.TAIKHOAN";
        rs = stm.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("USERNAME"));
            System.out.println(rs.getString("PASSWORD"));
        }
        */
    } 
}
