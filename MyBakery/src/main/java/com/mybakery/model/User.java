package com.mybakery.model;

/**
 * Konsep: Inheritance (Modul 5) & Encapsulation (Modul 3)
 */
public abstract class User {
    protected int id;
    protected String username;
    protected String password;
    protected String role;

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter (Diperlukan oleh AksesUser dan GUI)
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // Setter (Opsional, jika ingin mengubah data di kemudian hari)
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}