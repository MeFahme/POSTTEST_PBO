package com.toko.model;

public class RAM extends PartKomputer {
    private String tipeMemory;

    public RAM(String nama, int Stok, double harga, String tipeMemory) {
        super(nama, Stok, harga);
        this.tipeMemory = tipeMemory;
    }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.print("Kategori: " + this.getClass().getSimpleName());
        System.out.println("        | Tipe: " + this.tipeMemory);
    }
}
