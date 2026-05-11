package com.mybakery.model;

public class Admin extends User {

    // Constructor Admin otomatis memberikan role "ADMIN" ke parent
    public Admin(int id, String username, String password) {
        super(id, username, password, "ADMIN");
    }

    // Di sini kamu bisa menambah method spesifik Admin nantinya,
    // misalnya: tambahUser() atau hapusUser()
}
