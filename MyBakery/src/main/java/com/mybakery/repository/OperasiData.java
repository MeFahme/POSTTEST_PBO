package com.mybakery.repository;

import java.util.List;

/**
 * Interface OperasiData (Penerapan Modul 6 - Abstraction)
 * Menggunakan Generic <T> agar interface ini fleksibel bisa digunakan 
 * untuk objek Produk maupun User tanpa menulis ulang kode.
 */
public interface OperasiData<T> {

    /**
     * Menambahkan data objek baru ke dalam database.
     * @param data Objek (Produk/User) yang akan disimpan.
     */
    void tambah(T data);

    /**
     * Mengambil seluruh data dari tabel database.
     * Menggunakan List (Modul 7 - Collection) sebagai wadah penampung.
     * @return List berisi objek-objek hasil query.
     */
    List<T> ambilSemua();

    /**
     * Memperbarui data yang sudah ada di database berdasarkan ID.
     * @param data Objek dengan data terbaru.
     */
    void update(T data);

    /**
     * Menghapus data dari database.
     * @param id String ID unik (id_produk atau id_user) yang akan dihapus.
     */
    void hapus(String id);
}