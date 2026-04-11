B2 2409106079 Muhammad Ilma Yusrian Fahmi

TAMPILAN UTAMA PROGRAM

![img_1.png](assets/img_1.png)

TAMPILAN MENU BARU LIHAT LAPORAN TRANSAKSI BESAR

![img_2.png](assets/img_2.png)


menerapkan konsep Polymorphism merupakan sebuah konsep OOP di mana class memiliki
banyak “bentuk” method yang berbeda, meskipun namanya sama. Maksud dari “bentuk”
adalah isinya yang berbeda, namun tipe data dan parameternya sama.


METHOD OVERRIDING

Class PartKomputer

![img_3.png](assets/img_3.png)

![img_4.png](assets/img_4.png)

contoh nya disini adalah part komputer memiliki atribut nama, stok, dan harga dan method tampilkan spesifikasi untuk
menampilkan class nya sendiri

Class Processor

![img_5.png](assets/img_5.png)
pada class processor akan digunakan atribut dari part komputer seperti nama, stok, dan harga, kemudian menambahkan 
atribut milik processor yaitu socket, lalu meng override method dari part komputer untuk menampilkan classnya sendiri 
yaitu processor dan menampilkan detail uniknya sendiri yaitu socket

Class GPU

![img_6.png](assets/img_6.png)

begitupun pada GPU, menggunakan atribut turunan dari partkomputer nama, stok, dan harga, kemudian menambahkan
atribut milik GPU yaitu merk, alu meng override method dari part komputer untuk menampilkan classnya sendiri yaitu GPU
dan menampilkan detail uniknya sendiri yaitu merk

Class RAM

![img_7.png](assets/img_7.png)

pada ram menambahkan atribut socket, dan menampilkannya

OUTPUT

![img_8.png](assets/img_8.png)


METHOD OVERLOADING

Class Laporan

![img_9.png](assets/img_9.png)

![img_11.png](assets/img_11.png)

pada method cetakLaporan pertama ini memiliki 2 parameter untuk menampilkan semua transaksi yang ada dan menampilkan 
stok barang yang tersisa dari listPart


![img_13.png](assets/img_13.png)

![img_12.png](assets/img_12.png)

dan pada method cetakLaporan kedua memiliki parameter untuk menampilkan riwayat dan yang berbeda yaitu min, untuk
mencari minimal transaksi yang dilakukan.





