package com.mybakery.gui.controller;

import com.mybakery.model.Produk;
import com.mybakery.repository.AksesProduk;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML private Label lblWelcome;
    @FXML private TableView<Produk> tableProduk;
    @FXML private TableColumn<Produk, String> colId;
    @FXML private TableColumn<Produk, String> colNama;
    @FXML private TableColumn<Produk, Double> colHarga;
    @FXML private TableColumn<Produk, Integer> colStok;

    private AksesProduk aksesProduk = new AksesProduk();

    /**
     * Method ini otomatis dipanggil saat Dashboard.fxml dimuat.
     */
    @FXML
    public void initialize() {
        // 1. Mapping kolom tabel dengan atribut di class Produk
        // Penting: String di dalam PropertyValueFactory harus sama dengan nama variabel di Produk.java
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("hargaDasar"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        // 2. Muat data dari database ke tabel
        loadDataProduk();
    }

    public void loadDataProduk() {
        try {
            ObservableList<Produk> listProduk = FXCollections.observableArrayList(aksesProduk.ambilSemua());
            System.out.println("Jumlah data yang diambil: " + listProduk.size());
            tableProduk.setItems(listProduk);

            if (listProduk.isEmpty()) {
                System.out.println("Info: Database terbaca tapi tidak ada data produk.");
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat data produk: " + e.getMessage());
        }
    }

    /**
     * Mengatur teks ucapan selamat datang.
     * Dipanggil dari LoginController.
     */
    public void setDisplayName(String nama, String role) {
        lblWelcome.setText("Selamat Datang, " + nama + " (" + role + ")");
    }

    // --- LOGIKA NAVIGASI SIDEBAR ---

    @FXML
    public void menuKelolaProduk() {
        System.out.println("Navigasi ke Menu Kelola Produk...");
        // Di sini nanti kamu bisa load FXML untuk manajemen produk
    }

    @FXML
    public void menuTransaksi() {
        System.out.println("Navigasi ke Menu Transaksi...");
        // Di sini nanti kamu bisa load FXML untuk kasir
    }

    @FXML
    public void handleLogout() {
        try {
            // Kembali ke halaman Login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mybakery/view/Login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) lblWelcome.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("BakeSmart - Login");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}