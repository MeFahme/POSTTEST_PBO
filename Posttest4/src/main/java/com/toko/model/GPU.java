package com.toko.model;

public class GPU extends PartKomputer {
    private String merk;

    public GPU(String nama, int Stok, double harga, String merk) {
        super(nama, Stok, harga);
        this.merk = merk;
    }

    @Override
    public void tampilkanSpesifikasi() {
        super.tampilkanSpesifikasi();
        System.out.println("         Brand: " + this.merk);
    }
}
