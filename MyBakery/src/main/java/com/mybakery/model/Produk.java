package com.mybakery.model;

public abstract class Produk {
    protected String id;
    protected String nama;
    protected double hargaDasar;
    protected int stok;

    public Produk(String id, String nama, double hargaDasar, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
        this.stok = stok;
    }

    // Getter
    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHargaDasar() { return hargaDasar; }
    public int getStok() { return stok; }

    // Setter
    public void setStok(int stok) { this.stok = stok; }
}
