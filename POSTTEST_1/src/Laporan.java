import java.util.ArrayList;

public class Laporan {

    public void cetakLaporan(ArrayList<Transaksi> riwayat, ArrayList<PartKomputer> listPart) {
        double totalPendapatan = 0;
        int totalItemTerjual = 0;
        int totalStok = 0;

        for (PartKomputer p : listPart) {
            totalStok += p.stok;
        }
        for (Transaksi t : riwayat) {
            totalPendapatan += t.totalHarga;
            totalItemTerjual += t.jumlah;
        }

        System.out.println("\n---------------------------------------------------------");
        System.out.println("|              [ LAPORAN KINERJA TOKO ]                 |");
        System.out.println("---------------------------------------------------------");
        System.out.printf("  Total Transaksi    : %d transaksi\n", riwayat.size());
        System.out.printf("  Total Item Terjual : %d item\n", totalItemTerjual);
        System.out.printf("  Total Pendapatan   : Rp %,.0f\n", totalPendapatan);
        System.out.println("---------------------------------------------------------");
        System.out.println("  Stok Barang        : " + totalStok + " unit tersisa.");
        System.out.println("---------------------------------------------------------");
    }
}