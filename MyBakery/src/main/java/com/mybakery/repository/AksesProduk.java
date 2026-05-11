package com.mybakery.repository;

import com.mybakery.database.KoneksiDB;
import com.mybakery.model.Produk;
import com.mybakery.model.RotiBasah;
import com.mybakery.model.RotiKering;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AksesProduk implements OperasiData<Produk> {

    @Override
    public void tambah(Produk p) {
        String sql = "INSERT INTO produk (id_produk, nama_produk, harga_dasar, stok, kategori, atribut_tambahan) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getId());
            ps.setString(2, p.getNama());
            ps.setDouble(3, p.getHargaDasar());
            ps.setInt(4, p.getStok());

            // Logika pengecekan tipe objek (Polymorphism)
            if (p instanceof RotiBasah) {
                ps.setString(5, "BASAH");
                ps.setString(6, ((RotiBasah) p).getMasaSimpan());
            } else {
                ps.setString(5, "KERING");
                ps.setString(6, ((RotiKering) p).getJenisKemasan());
            }

            ps.executeUpdate();
            System.out.println("Produk " + p.getNama() + " berhasil ditambahkan!");
        } catch (SQLException e) {
            System.err.println("Gagal tambah produk: " + e.getMessage());
        }
    }

    @Override
    public List<Produk> ambilSemua() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk";

        // JANGAN masukkan Connection ke dalam tanda kurung try-with-resources
        // karena kita menggunakan koneksi statis (Singleton) yang tidak boleh ditutup otomatis.
        try {
            Connection conn = KoneksiDB.getKoneksi();

            // Hanya Statement dan ResultSet yang boleh ditutup otomatis
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    Produk p;
                    String id = rs.getString("id_produk");
                    String nama = rs.getString("nama_produk");
                    double harga = rs.getDouble("harga_dasar");
                    int stok = rs.getInt("stok");
                    String kategori = rs.getString("kategori");
                    String atribut = rs.getString("atribut_tambahan");

                    // Mempertahankan kriteria Polimorfisme (Modul 6)
                    if (kategori != null && kategori.equalsIgnoreCase("BASAH")) {
                        p = new RotiBasah(id, nama, harga, stok, atribut);
                    } else {
                        p = new RotiKering(id, nama, harga, stok, atribut);
                    }
                    listProduk.add(p);
                }
                // Tambahkan log ini untuk memastikan data masuk
                System.out.println("DEBUG: Berhasil menarik " + listProduk.size() + " data dari DB.");

            }
        } catch (SQLException e) {
            System.err.println("Gagal ambil data: " + e.getMessage());
            e.printStackTrace();
        }
        return listProduk;
    }

    @Override
    public void update(Produk p) {
        String sql = "UPDATE produk SET nama_produk=?, harga_dasar=?, stok=?, atribut_tambahan=? WHERE id_produk=?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNama());
            ps.setDouble(2, p.getHargaDasar());
            ps.setInt(3, p.getStok());

            if (p instanceof RotiBasah) {
                ps.setString(4, ((RotiBasah) p).getMasaSimpan());
            } else {
                ps.setString(4, ((RotiKering) p).getJenisKemasan());
            }

            ps.setString(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapus(String id) {
        String sql = "DELETE FROM produk WHERE id_produk = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Produk ID " + id + " berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
