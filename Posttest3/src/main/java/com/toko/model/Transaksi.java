package com.toko.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaksi {
    private String namaPart;
    private int jumlah;
    private double totalHarga;
    private LocalDateTime waktu;

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

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

}