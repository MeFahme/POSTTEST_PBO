package com.mybakery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Memuat file FXML dari folder resources
            // Jalurnya harus sesuai dengan struktur folder di resources
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mybakery/view/Login.fxml"));
            Parent root = loader.load();

            // Mengatur judul jendela dan ukuran scene
            stage.setTitle("BakeSmart - Login System");
            stage.setScene(new Scene(root));

            // Menampilkan jendela
            stage.show();

            System.out.println("Aplikasi Berhasil Dijalankan!");
        } catch (IOException e) {
            System.err.println("Gagal memuat file FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Meluncurkan aplikasi JavaFX
        launch(args);
    }
}