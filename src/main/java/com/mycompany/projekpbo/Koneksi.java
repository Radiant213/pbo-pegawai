 
package com.mycompany.projekpbo;

import java.sql.*;

 
public class Koneksi {
    public static String URL = "jdbc:mysql://localhost:3306/db_pegawai";
    public static String USER = "root";
    public static String PW = "";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PW);
    }
    
    public static void main(String [] args) {
        try (Connection koneksi = getConnection()) {
            if (koneksi != null) {
                System.out.println("Koneksi Berhasil");
            }
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal Karena " + e.getMessage());
        }
    }
}
