package Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    
    private Connection Koneksi;

    // Metode untuk menghubungkan ke database
    public Connection connect() {
        // Cek driver JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Gunakan driver MySQL
            Koneksi = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DataSekolah", // Ganti "nama_database" dengan nama database Anda
                "root", // Ganti "root" dengan username database Anda
                ""      // Ganti "" dengan password database Anda, jika ada
            );
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi Database Gagal: " + e.getMessage());
        }
        return Koneksi;
    }
    

public static void main(String[] args) {
        Koneksi Koneksi = new Koneksi();
        Connection conn = Koneksi.connect();

        if (conn != null) {
            System.out.println("Koneksi ke database berhasil!");
        } else {
            System.out.println("Koneksi ke database gagal!");
        }
    }
}
    
