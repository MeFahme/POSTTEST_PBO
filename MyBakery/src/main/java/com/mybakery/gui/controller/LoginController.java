package com.mybakery.gui.controller;

import com.mybakery.model.User;
import com.mybakery.repository.AksesUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    public void handleLogin() {
        String user = txtUsername.getText();
        String pass = txtPassword.getText();

        // Validasi input kosong
        if (user.isEmpty() || pass.isEmpty()) {
            System.out.println("Peringatan: Username dan Password tidak boleh kosong!");
            return;
        }

        System.out.println("Mencoba login untuk user: " + user);

        // Memanggil repository untuk cek ke database MySQL
        AksesUser aksesUser = new AksesUser();
        User loginUser = aksesUser.login(user, pass);

        if (loginUser != null) {
            System.out.println("Login Berhasil! Role: " + loginUser.getRole());

            try {
                // 1. Memuat file FXML Dashboard
                // Pastikan file berada di: src/main/resources/com/mybakery/view/Dashboard.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mybakery/view/Dashboard.fxml"));
                Parent root = loader.load();

                // 2. Mengambil controller Dashboard untuk mengirim data
                DashboardController dashCtrl = loader.getController();

                // 3. Mengirim username dan role ke Dashboard (agar muncul di Label Welcome)
                dashCtrl.setDisplayName(loginUser.getUsername(), loginUser.getRole());

                // 4. Mengambil Stage (jendela) saat ini dari tombol login
                Stage currentStage = (Stage) btnLogin.getScene().getWindow();

                // 5. Mengganti isi jendela dengan Dashboard
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("BakeSmart - Dashboard (" + loginUser.getRole() + ")");
                currentStage.centerOnScreen(); // Membuat jendela muncul di tengah layar
                currentStage.show();

            } catch (IOException e) {
                System.err.println("Gagal memuat halaman Dashboard! Periksa lokasi file FXML.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Login Gagal! Username atau Password salah di database.");
        }
    }
}