from abc import ABC, abstractmethod

# ============================================================
# 1. INTERFACE SEGREGATION PRINCIPLE (ISP)
# Memisahkan kemampuan khusus ke dalam interface (ABC) yang berbeda.
# ============================================================

class RGBSupport(ABC):
    @abstractmethod
    def set_rgb(self):
        pass

class Overclockable(ABC):
    @abstractmethod
    def overclock(self):
        pass

# ============================================================
# 2. OPEN/CLOSED PRINCIPLE (OCP)
# Gunakan strategi untuk diskon agar bisa ditambah tanpa ubah kelas utama.
# ============================================================

class DiscountStrategy(ABC):
    @abstractmethod
    def apply(self, price):
        pass

class MemberDiscount(DiscountStrategy):
    def apply(self, price): return price * 0.9

class NoDiscount(DiscountStrategy):
    def apply(self, price): return price

# ============================================================
# 3. SINGLE RESPONSIBILITY PRINCIPLE (SRP)
# Memisahkan urusan Database dan Notifikasi dari kelas Part.
# ============================================================

class DatabaseManager:
    def save(self, data):
        print(f"[DB] Menyimpan data {data} ke PostgreSQL...")

class NotificationService:
    def send_report(self, message):
        print(f"[Email] Notifikasi Manager: {message}")

# ============================================================
# 4. LISKOV SUBSTITUTION PRINCIPLE (LSP)
# Subclass hanya mengimplementasikan apa yang benar-benar bisa mereka lakukan.
# ============================================================

class ComputerPart:
    def __init__(self, name, price):
        self.name = name
        self.price = price

class Processor(ComputerPart, Overclockable):
    def overclock(self):
        print(f"Overclocking {self.name} ke 5.0 GHz...")


class PowerSupply(ComputerPart, RGBSupport):
    def set_rgb(self):
        print(f"Mengatur warna pelangi pada {self.name}...")


# ============================================================
# 5. DEPENDENCY INVERSION PRINCIPLE (DIP)
# Aplikasi bergantung pada abstraksi, bukan kelas konkret.
# ============================================================

class ComputerShopApp:
    def __init__(self, part: ComputerPart, discount: DiscountStrategy, db: DatabaseManager, mail: NotificationService):
        self.part = part
        self.discount = discount
        self.db = db
        self.mail = mail

    def run(self):
        print(f"=== Memproses: {self.part.name} ===")
        
        # Hitung harga (SRP & OCP)
        final_price = self.discount.apply(self.part.price)
        print(f"Harga Final: Rp{final_price}")
        
        # Simpan & Notifikasi (SRP)
        self.db.save(self.part.name)
        self.mail.send_report(f"Stok {self.part.name} telah diperbarui.")

        # Fitur khusus (ISP & LSP) - Mengecek kemampuan secara aman
        if isinstance(self.part, Overclockable):
            self.part.overclock()
        if isinstance(self.part, RGBSupport):
            self.part.set_rgb()

# --- EKSEKUSI PROGRAM ---
if __name__ == "__main__":
    # Injeksi dependensi (Dependency Injection)
    db = DatabaseManager()
    notif = NotificationService()
    
    # Skenario 1: Processor dengan diskon member
    cpu = Processor("Intel i9", 8000000)
    app1 = ComputerShopApp(cpu, MemberDiscount(), db, notif)
    app1.run()

    print("-" * 40)

    # Skenario 2: Power Supply tanpa diskon
    psu = PowerSupply("Seasonic 750W", 1500000)
    app2 = ComputerShopApp(psu, NoDiscount(), db, notif)
    app2.run()

    cpu_amd = Processor("AMD Ryzen 9", 7000000)
    app3 = ComputerShopApp(cpu_amd, NoDiscount(), db, notif)
    app3.run()