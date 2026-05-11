# ============================================================
# PROGRAM MANAJEMEN PART KOMPUTER YANG MELANGGAR SEMUA SOLID
# ============================================================

class ComputerPart:
    def __init__(self, name, price, stock):
        self.name = name
        self.price = price
        self.stock = stock

    # 1. MELANGGAR S: Mengurus harga, database, dan notifikasi sekaligus.
    # 2. MELANGGAR O: Jika ada diskon baru (misal: Ramadhan), kita harus ubah if-else di sini.
    def process_part(self, action, discount_type="none"):
        # Logika Perhitungan (Business Logic)
        final_price = self.price
        if discount_type == "member":
            final_price = self.price * 0.9
        elif discount_type == "clearance":
            final_price = self.price * 0.5
        
        if action == "save_and_notify":
            # Logika Database (Data Access)
            print(f"[DB] Menyimpan {self.name} (Harga: {final_price}) ke MySQL Database...")
            
            # Logika Notifikasi (Communication)
            print(f"[Email] Mengirim laporan stok {self.name} ke Manager...")

    # 3. MELANGGAR I: Memaksa semua part punya fungsi yang tidak relevan.
    # Tidak semua part punya RGB atau bisa di-overclock, tapi dipaksa ada di kelas induk.
    def set_rgb_lighting(self):
        print(f"Mengaktifkan RGB pada {self.name}...")

    def overclock(self):
        print(f"Melakukan overclocking pada {self.name}...")

# 4. MELANGGAR L: Subclass merusak ekspektasi program.
class PowerSupply(ComputerPart):
    def overclock(self):
        # Power Supply tidak bisa di-overclock. Jika dipanggil, program akan error.
        # Ini melanggar Liskov karena anak tidak bisa menggantikan induk dengan aman.
        raise RuntimeError("BOOM! Power Supply meledak jika di-overclock!")

# 5. MELANGGAR D: Bergantung pada kelas konkret, bukan abstraksi.
class ComputerShopApp:
    def __init__(self):
        # Tightly Coupled: Toko ini 'terkunci' hanya untuk Power Supply tertentu.
        # Kita tidak bisa mengganti ke part lain tanpa mengubah constructor ini.
        self.part = PowerSupply("Corsair 650W", 1200000, 10)
        self.part = PowerSupply("Deepcool 1000W", 2000000, 5)

    def run_business(self):
        print("=== APLIKASI TOKO KOMPUTER (UN-SOLID) ===")
        # Memproses data
        self.part.process_part("save_and_notify", "member")
        
        # Mencoba fitur overclock (Akan menyebabkan CRASH karena pelanggaran LSP)
        print("\nMencoba fitur Overclock...")
        try:
            self.part.overclock()
        except Exception as e:
            print(f"CRITICAL ERROR: {e}")

# --- EKSEKUSI PROGRAM ---
if __name__ == "__main__":
    app = ComputerShopApp()
    app.run_business()