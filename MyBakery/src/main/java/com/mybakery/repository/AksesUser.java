package com.mybakery.repository;

import com.mybakery.database.KoneksiDB;
import com.mybakery.model.User;
import com.mybakery.model.Admin;
import com.mybakery.model.Kasir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AksesUser implements OperasiData<User> {

    // Method tambahan khusus untuk fitur Login
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        // Hapus Connection dari try-with-resources
        try {
            Connection conn = KoneksiDB.getKoneksi();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id_user");
                    String role = rs.getString("role");

                    if (role.equalsIgnoreCase("ADMIN")) {
                        return new Admin(id, username, password);
                    } else {
                        return new Kasir(id, username, password);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void tambah(User u) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getUsername());
            ps.setString(2, "default123"); // Password default
            ps.setString(3, u.getRole());
            ps.executeUpdate();
            System.out.println("User baru berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> ambilSemua() {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = KoneksiDB.getKoneksi();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                User u;
                int id = rs.getInt("id_user");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("ADMIN")) {
                    u = new Admin(id, user, pass);
                } else {
                    u = new Kasir(id, user, pass);
                }
                listUser.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE users SET username = ?, role = ? WHERE id_user = ?";
        // Implementasi update hampir sama dengan tambah
    }

    @Override
    public void hapus(String id) {
        String sql = "DELETE FROM users WHERE id_user = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
