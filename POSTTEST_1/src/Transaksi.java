import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaksi {
    String namaPart;
    int jumlah;
    double totalHarga;
    LocalDateTime waktu;

    public Transaksi(String namaPart, int jumlah, double totalHarga) {
        this.namaPart = namaPart;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.waktu = LocalDateTime.now();
    }

    public void cetakStruk() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("\n---------------------------------------------------------");
        System.out.println("|                 [ STRUK PENJUALAN ]                   |");
        System.out.println("---------------------------------------------------------");
        System.out.println("  Waktu       : " + waktu.format(dtf));
        System.out.println("  Item        : " + namaPart);
        System.out.println("  Jumlah      : " + jumlah);
        System.out.println("  Total Bayar : Rp " + String.format("%,.0f", totalHarga));
        System.out.println("---------------------------------------------------------");
    }
}