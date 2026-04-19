package com.toko.model;

public class Processor extends PartKomputer {
    private String socket;

    public Processor(String nama, int Stok, double harga, String socket) {
        super(nama, Stok, harga);
        this.socket = socket;
    }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.print("Kategori: " + this.getClass().getSimpleName());
        System.out.println("  | Socket: " + this.socket);
    }
}
