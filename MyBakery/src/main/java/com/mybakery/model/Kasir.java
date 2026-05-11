package com.mybakery.model;

public class Kasir extends User {

    // Constructor Kasir otomatis memberikan role "KASIR" ke parent
    public Kasir(int id, String username, String password) {
        super(id, username, password, "KASIR");
    }

    // Di sini kamu bisa menambah method spesifik Kasir nantinya,
    // misalnya: buatTransaksi()
}
