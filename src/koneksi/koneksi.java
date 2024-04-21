/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bagus
 */
public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/optik";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection koneksi = null;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("berhasil koneksi database");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("gagal koneksi database, "+e);
        }
        return koneksi;
    }
}
