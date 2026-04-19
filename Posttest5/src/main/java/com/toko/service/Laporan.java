package com.toko.service;

import com.toko.model.PartKomputer;
import com.toko.model.Transaksi;
import java.util.ArrayList;

public class Laporan {

    public void cetakLaporan(ArrayList<Transaksi> riwayat, ArrayList<PartKomputer> listPart) {
        double totalPendapatan = 0;
        int totalItemTerjual = 0;
        int totalStok = 0;

        for (PartKomputer p : listPart) totalStok += p.getStok();
        for (Transaksi t : riwayat) {
            totalPendapatan += t.getTotalHarga();
            totalItemTerjual += t.getJumlah();
        }

        System.out.println("\n---------------------------------------------------------");
        System.out.println("|              [ LAPORAN KINERJA TOKO ]                 |");
        System.out.println("---------------------------------------------------------");
        System.out.printf("  Total Transaksi    : %d transaksi\n", riwayat.size());
        System.out.printf("  Total Pendapatan   : Rp %,.0f\n", totalPendapatan);
        System.out.println("---------------------------------------------------------");
        System.out.println("  Barang Terjual     : " + totalItemTerjual + " unit.");
        System.out.println("  Sisa Stok          : " + totalStok + " unit.");
        System.out.println("---------------------------------------------------------");
    }

    public void cetakLaporan(ArrayList<Transaksi> riwayat, double minPendapatan) {
        double totalPendapatan = 0;
        int jumlahTransaksiFilter = 0;

        System.out.println("\n---------------------------------------------------------");
        System.out.printf ("|        [ LAPORAN TRANSAKSI >= Rp %,-1.0f ]          |\n", minPendapatan);
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-30s | %-5s | %-12s |\n", "Item", "Qty", "Total");
        System.out.println("---------------------------------------------------------");

        for (Transaksi t : riwayat) {
            if (t.getTotalHarga() >= minPendapatan) {
                System.out.printf("| %-30s | %-5d | Rp %,9.0f |\n",
                        t.getNamaPart(), t.getJumlah(), t.getTotalHarga());
                totalPendapatan += t.getTotalHarga();
                jumlahTransaksiFilter++;
            }
        }

        if (jumlahTransaksiFilter == 0) {
            System.out.println("| Tidak ada transaksi memenuhi kriteria.               |");
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("  Total (%d transaksi) : Rp %,.0f\n",
                jumlahTransaksiFilter, totalPendapatan);
        System.out.println("---------------------------------------------------------");
    }
}
