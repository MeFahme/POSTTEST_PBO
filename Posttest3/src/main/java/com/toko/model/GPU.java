package com.toko.model;

public class GPU extends PartKomputer {
    private int vram;

    public GPU(String nama, int Stok, double harga, int vram) {
        super(nama, Stok, harga);
        this.vram = vram;
    }

    @Override
    public void tampilkanSpesifikasi() {
        super.tampilkanSpesifikasi();
        System.out.println("         VRAM: " + this.vram + " GB");
    }
}