package com.toko.core;

import com.toko.model.PartKomputer;
import com.toko.model.Transaksi;
import com.toko.service.Laporan;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemPartKomputer {

    ArrayList<PartKomputer> listPart = new ArrayList<>();
    ArrayList<Transaksi> riwayatTransaksi = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    void main() {
        listPart.add(new PartKomputer("Intel i9 14900KF", 5, 7950000));
        listPart.add(new PartKomputer("RTX5060TI OC 8GB", 2, 7700000));
        listPart.add(new PartKomputer("XPG 2X16GB 5600Mhz", 10, 5975000));

        int pilihan;
        do {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("|                      CORE MANAGER                     |");
            System.out.println("---------------------------------------------------------");
            System.out.println("| 1. Tambah Part Baru                                   |");
            System.out.println("| 2. Tampilkan Semua Part                               |");
            System.out.println("| 3. Update Harga                                       |");
            System.out.println("| 4. Transaksi Penjualan                                |");
            System.out.println("| 5. Hapus Part                                         |");
            System.out.println("| 6. Lihat Riwayat Penjualan                            |");
            System.out.println("| 7. Lihat Laporan Penjualan                            |");
            System.out.println("| 0. Keluar                                             |");
            System.out.println("---------------------------------------------------------");
            System.out.print("     Pilih Menu: ");
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
            } else {
                System.out.println(">> Error: Mohon masukkan angka!");
                pilihan = -1;
            }
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahPart();
                case 2 -> tampilkanPart();
                case 3 -> updateHarga();
                case 4 -> transaksiPenjualan();
                case 5 -> hapusPart();
                case 6 -> tampilkanRiwayat();
                case 7 -> new Laporan().cetakLaporan(riwayatTransaksi, listPart);
                case 0 -> System.out.println("     Keluar...");
                default -> System.out.println(">> Error: Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    void tampilkanPart() {
        if (listPart.isEmpty()) {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("|                [ DAFTAR STOK BARANG ]                 |");
            System.out.println("---------------------------------------------------------");
            System.out.println("| Tidak Ada Data Barang                                 |");
            System.out.println("---------------------------------------------------------");
        } else {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("|                [ DAFTAR STOK BARANG ]                 |");
            System.out.println("---------------------------------------------------------");
            System.out.printf("| %-3s | %-20s | %-6s | %-15s |\n", "No", "Nama Part", "Stok", "Harga");
            System.out.println("---------------------------------------------------------");

            for (int i = 0; i < listPart.size(); i++) {
                PartKomputer p = listPart.get(i);
                System.out.printf("| %-3d | %-20s | %-6d | Rp%,13.0f |\n", (i + 1), p.getNama(), p.getStok(), p.getHarga());
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    void tambahPart() {
        tampilkanPart();
        System.out.println("\n---------------------------------------------------------");
        System.out.println("|                [ TAMBAH PART BARU ]                   |");
        System.out.println("---------------------------------------------------------");
        System.out.print("Masukkan Nama Part : "); String nama = input.nextLine();
        System.out.print("Masukkan Stok      : "); int stok = input.nextInt();
        System.out.print("Masukkan Harga     : "); double harga = input.nextDouble();

        listPart.add(new PartKomputer(nama, stok, harga));
        System.out.println(">> Part berhasil ditambahkan!");
    }

    void updateHarga() {
        tampilkanPart();
        if (listPart.isEmpty()) return;

        System.out.print("\nMasukkan Nomor Part yang akan diubah harganya: ");
        int nomor = input.nextInt();
        int indeks = nomor - 1;

        if (indeks >= 0 && indeks < listPart.size()) {
            PartKomputer p = listPart.get(indeks);

            System.out.println("Part terpilih: " + p.getNama());
            System.out.print("Masukkan Harga Baru: ");
            double hargaBaru = input.nextDouble();

            p.setHarga(hargaBaru);

            System.out.println(">> Berhasil: Harga " + p.getNama() + " diperbarui.");
        } else {
            System.out.println(">> Error: Nomor tidak valid!");
        }
    }

    void transaksiPenjualan() {
        tampilkanPart();
        if (listPart.isEmpty()) return;

        System.out.print("\nMasukkan nomor part yang dibeli: ");
        int nomor = input.nextInt();
        int indeks = nomor - 1;

        if (indeks >= 0 && indeks < listPart.size()) {
            PartKomputer p = listPart.get(indeks);

            System.out.println("Part terpilih: " + p.getNama());
            System.out.print("Jumlah beli: ");
            int jumlah = input.nextInt();

            if (p.getStok() >= jumlah) {
                int stok = p.getStok() - jumlah;
                p.setStok(stok);
                double total = jumlah * p.getHarga();

                Transaksi t = new Transaksi(p.getNama(), jumlah, total);
                riwayatTransaksi.add(t);

                System.out.println("\n>> Transaksi Berhasil!");
                t.cetakStruk();
            } else {
                System.out.println(">> Gagal: Stok tidak mencukupi (Tersisa: " + p.getStok() + ")");
            }
        } else {
            System.out.println(">> Error: Nomor tidak valid!");
        }
    }

    void tampilkanRiwayat() {
        System.out.println("\n---------------------------------------------------------");
        System.out.println("|                 [ RIWAYAT PENJUALAN ]                 |");
        System.out.println("---------------------------------------------------------");

        if (riwayatTransaksi.isEmpty()) {
            System.out.println("| Belum ada transaksi yang dilakukan.                   |");
        } else {
            for (Transaksi t : riwayatTransaksi) {
                t.cetakStruk();
            }
        }
        System.out.println("|-------------------------------------------------------|");
    }

    void hapusPart() {
        tampilkanPart();
        if (listPart.isEmpty()) return;

        System.out.print("\nMasukkan Nomor Part yang ingin dihapus: ");
        int no = input.nextInt();
        int indeks = no - 1;

        if (indeks >= 0 && indeks < listPart.size()) {
            PartKomputer p = listPart.remove(indeks);
            System.out.println(">> Berhasil menghapus: " + p.getNama());
        } else {
            System.out.println(">> Nomor tidak valid!");
        }
    }
}