package com.mybakery.model;

public class RotiKering extends Produk {
    private String jenisKemasan; // Contoh: "Plastik" atau "Kaleng"

    public RotiKering(String id, String nama, double hargaDasar, int stok, String jenisKemasan) {
        super(id, nama, hargaDasar, stok);
        this.jenisKemasan = jenisKemasan;
    }

    public String getJenisKemasan() { return jenisKemasan; }
    public void setJenisKemasan(String jenisKemasan) { this.jenisKemasan = jenisKemasan; }
}
