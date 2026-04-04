B2 2409106079 Muhammad Ilma Yusrian Fahmi

TAMPILAN UTAMA PROGRAM

![img_6.png](assets/img_6.png)

TAMPILAN MENU TAMBAH PART BARU

![img_7.png](assets/img_7.png)

TAMPILAN MENU TAMPILKAN DAFTAR PART

![img_8.png](assets/img_8.png)

TAMPILAN MENU UPDATE HARGA

![img_9.png](assets/img_9.png)

TAMPILAN MENU TRANSAKSI

![img_10.png](assets/img_10.png)

TAMPILAN MENU HAPUS PART

![img_11.png](assets/img_11.png)

TAMPILAN MENU LIHAT RIWAYAT PENJUALAN 

![img_12.png](assets/img_12.png)

TAMPILAN MENU LIHAT LAPORAN PENJUALAN

![img_13.png](assets/img_13.png)

![img.png](assets/img.png)

Menggunakan build tools Maven, dan membagi menjadi 3 package (core, model, dan service).

Menggunakan Atribut modifier private untuk mencegah perubahan data yang tidak sah dan
menerapkan konsep encapsulation

![img_1.png](assets/img_1.png)

Class PartKomputer Menggunakan Atribut modifier private, dan menggunakan getter untuk mengambil nilai,
setter untuk mengubah nilai, dan menggunakan method dengan  access modifier public agar bisa digunakan oleh class lain

![img_2.png](assets/img_2.png)
![img_3.png](assets/img_3.png)

Class Transaksi Menggunakan Atribut modifier private, dan menggunakan getter untuk mengambil nilai,dan menggunakan 
method dengan  access modifier public agar bisa digunakan oleh class lain

![img_4.png](assets/img_4.png)

Class Laporan hanya digunakan sebagai tempat untuk menghitung dan tidak menyimpan data

![img_5.png](assets/img_5.png)
tidak seperti sebelumnya dimana ketika ingin mengambil suatu nilai langsung dengan p.nama(), sekarang harus menggunakan
p.getNama() karna atribut nya sudah menjadi private, dan untuk mengubahnya juga harus menggunakan p.setHarga(hargabaru) 
yang  sebelumnya langsung dengan p.harga = hargaBaru. begitupun pada fungsi fungsi lainnya harus menggunakan getter dan
setter jika ingin mengambil dan mengubah nilai.