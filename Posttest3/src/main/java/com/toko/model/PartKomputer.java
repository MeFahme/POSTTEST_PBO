package com.toko.model;

public class PartKomputer {
    protected String nama;
    protected int Stok;
    protected double harga;

    public PartKomputer(String nama, int Stok, double harga) {
        this.nama = nama;
        this.Stok = Stok;
        this.harga = harga;
    }

    public String getNama() { return nama; }
    public int getStok() { return Stok; }
    public void setStok(int Stok) { if (Stok >= 0) this.Stok = Stok; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public void tampilkanSpesifikasi() {
        System.out.print("Kategori: " + this.getClass().getSimpleName());
    }
}