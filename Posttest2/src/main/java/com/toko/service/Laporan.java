package com.toko.service;

import com.toko.model.PartKomputer;
import com.toko.model.Transaksi;
import java.util.ArrayList;

public class Laporan {
    public void cetakLaporan(ArrayList<Transaksi> riwayat, ArrayList<PartKomputer> listPart) {
        double totalPendapatan = 0;
        int totalItemTerjual = 0;
        int totalStok = 0;

        for (PartKomputer p : listPart) {
            totalStok += p.getStok();
        }
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
}