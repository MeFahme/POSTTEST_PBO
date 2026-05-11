import java.sql.Connection;
import com.mybakery.database.KoneksiDB;
public class TestKoneksi {
    public static void main(String[] args) {
        System.out.println("--- Mencoba Koneksi ke MySQL ---");

        // Memanggil method static getKoneksi
        Connection conn = KoneksiDB.getKoneksi();

        if (conn != null) {
            System.out.println("Status: Aplikasi Terhubung ke Database!");
        } else {
            System.out.println("Status: Koneksi Gagal. Cek Driver atau URL Database.");
        }
    }
}
