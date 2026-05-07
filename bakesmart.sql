CREATE DATABASE db_bakesmart;
USE db_bakesmart;

-- 1. Tabel Users (Untuk Modul 4 & Inheritance Admin/Kasir)
CREATE TABLE users (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    nama_lengkap VARCHAR(100),
    role ENUM('ADMIN', 'KASIR') NOT NULL
);

-- 2. Tabel Produk (Untuk Modul 2, 3, dan 5)
CREATE TABLE produk (
    id_produk VARCHAR(10) PRIMARY KEY,
    nama_produk VARCHAR(100) NOT NULL,
    harga_dasar DOUBLE NOT NULL,
    stok INT NOT NULL,
    kategori ENUM('BASAH', 'KERING') NOT NULL, -- Sudah diperbaiki di sini
    atribut_tambahan VARCHAR(50) -- Contoh: masa_simpan untuk roti basah
);

-- 3. Tabel Transaksi (Header)
CREATE TABLE transaksi (
    id_transaksi INT PRIMARY KEY AUTO_INCREMENT,
    tgl_transaksi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_user INT,
    total_bayar DOUBLE,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- 4. Tabel Detail Transaksi (Untuk Modul 7 - Java Collection)
CREATE TABLE detail_transaksi (
    id_detail INT PRIMARY KEY AUTO_INCREMENT,
    id_transaksi INT,
    id_produk VARCHAR(10),
    jumlah INT,
    subtotal DOUBLE,
    FOREIGN KEY (id_transaksi) REFERENCES transaksi(id_transaksi),
    FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);

-- Tambah User Default
INSERT INTO users (username, password, nama_lengkap, role) VALUES 
('admin1', 'admin123', 'Kepala Toko', 'ADMIN'),
('kasir1', 'kasir123', 'Staf Kasir', 'KASIR');

-- Tambah Produk Awal
INSERT INTO produk VALUES 
('P001', 'Roti Coklat Lumer', 5000, 20, 'BASAH', '3 Hari'),
('P002', 'Bagelen Kering', 15000, 10, 'KERING', '30 Hari');