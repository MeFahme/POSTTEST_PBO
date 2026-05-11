package com.mybakery.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    // Variabel statis untuk menyimpan instansi koneksi
    private static Connection koneksi;

    // Detail konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3306/db_bakesmart";
    private static final String USER = "root"; // Sesuaikan dengan user MySQL kamu
    private static final String PASS = "";     // Sesuaikan dengan password MySQL kamu

    // Method untuk mengambil koneksi (Pola Singleton)
    public static Connection getKoneksi() {
        try {
            // Cek apakah null ATAU sudah tertutup (isClosed)
            if (koneksi == null || koneksi.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                koneksi = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Koneksi ke Database Berhasil!");
            }
        } catch (Exception e) {
            System.err.println("Gagal terhubung ke database: " + e.getMessage());
        }
        return koneksi;
    }

    // Method untuk memutus koneksi jika diperlukan
    public static void putusKoneksi() {
        if (koneksi != null) {
            try {
                koneksi.close();
                koneksi = null;
                System.out.println("Koneksi berhasil diputus.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
