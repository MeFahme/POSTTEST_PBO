package com.mybakery.model;

public class RotiBasah extends Produk {
    private String masaSimpan; // Contoh: "2 Hari"

    public RotiBasah(String id, String nama, double hargaDasar, int stok, String masaSimpan) {
        super(id, nama, hargaDasar, stok);
        this.masaSimpan = masaSimpan;
    }

    public String getMasaSimpan() { return masaSimpan; }
    public void setMasaSimpan(String masaSimpan) { this.masaSimpan = masaSimpan; }
}
