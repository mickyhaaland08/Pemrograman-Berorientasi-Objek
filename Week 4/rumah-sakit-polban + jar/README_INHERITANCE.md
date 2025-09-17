# IMPLEMENTASI KONSEP INHERITANCE, OVERRIDE, DAN SUPER
## Sistem Rumah Sakit Polban

### Struktur Hirarki Class

```
Person (Base Class)
├── Dokter (extends Person)
│   └── DokterSpesialis (extends Dokter)
└── Pasien (extends Person)
    └── PasienDarurat (extends Pasien)
```

## 1. KONSEP INHERITANCE

### 1.1 Single Inheritance
- **Person → Dokter**: Class `Dokter` mewarisi atribut `nama` dan `umur` dari `Person`
- **Person → Pasien**: Class `Pasien` mewarisi atribut `nama` dan `umur` dari `Person`

### 1.2 Multi-level Inheritance
- **Person → Dokter → DokterSpesialis**: Class `DokterSpesialis` mewarisi dari `Dokter` yang juga mewarisi dari `Person`
- **Person → Pasien → PasienDarurat**: Class `PasienDarurat` mewarisi dari `Pasien` yang juga mewarisi dari `Person`

## 2. KONSEP SUPER

### 2.1 Constructor Chaining
Setiap constructor subclass menggunakan `super()` untuk memanggil constructor parent class:

```java
// Di class Dokter
public Dokter(String nama, int umur, String spesialis) {
    super(nama, umur); // Memanggil constructor Person
    this.spesialis = spesialis;
}

// Di class DokterSpesialis
public DokterSpesialis(String nama, int umur, String spesialis, String subSpesialis, int pengalaman) {
    super(nama, umur, spesialis); // Memanggil constructor Dokter
    this.subSpesialis = subSpesialis;
    this.pengalaman = pengalaman;
}
```

### 2.2 Method Chaining
Method `displayInfo()` menggunakan `super.displayInfo()` untuk memanggil method parent:

```java
// Di class Dokter
@Override
public void displayInfo() {
    super.displayInfo(); // Memanggil displayInfo() dari Person
    System.out.println("Spesialis: " + spesialis + ", No. Lisensi: " + noLisensi);
}

// Di class DokterSpesialis
@Override
public void displayInfo() {
    super.displayInfo(); // Memanggil displayInfo() dari Dokter (yang juga memanggil dari Person)
    System.out.println("Sub-Spesialis: " + subSpesialis + ", Pengalaman: " + pengalaman + " tahun");
}
```

## 3. KONSEP OVERRIDE

### 3.1 Method Override
Setiap subclass meng-override method dari parent class dengan implementasi yang berbeda:

#### displayInfo() Method
- **Person**: Menampilkan nama dan umur
- **Dokter**: Menampilkan info Person + spesialis dan no lisensi
- **DokterSpesialis**: Menampilkan info Dokter + sub-spesialis dan pengalaman
- **Pasien**: Menampilkan info Person + keluhan dan dokter
- **PasienDarurat**: Menampilkan info Pasien + tingkat kegawatan

#### toString() Method
- **Person**: `"Nama (Umur tahun)"`
- **Dokter**: `"Dr. Nama (Spesialis)"`
- **DokterSpesialis**: `"Prof. Dr. Nama (Spesialis - Sub-spesialis, X tahun pengalaman)"`
- **Pasien**: `"Nama (Umur tahun) - Keluhan: X"`
- **PasienDarurat**: `"[DARURAT] Nama (Umur tahun) - Keluhan: X [Tingkat]"`

### 3.2 Method Khusus Override
- **infoPasien()**: Di-override di `PasienDarurat` dengan format emergency
- **daftar()**: Di-override di `PasienDarurat` dengan prioritas khusus
- **diagnosa()**: Di-override di `DokterSpesialis` dengan informasi lebih detail

## 4. POLYMORPHISM

### 4.1 Runtime Polymorphism
Array `Person[]` dapat berisi berbagai subclass, dan method yang dipanggil akan sesuai dengan class sebenarnya:

```java
Person[] orangRumahSakit = {
    new Dokter("Agus", 38, "Kelamin"),
    new DokterSpesialis("Dedi", 47, "Mata", "Retina", 12),
    new Pasien("Budi", 35, "Sakit kepala", dokter1),
    new PasienDarurat("Rina", 28, "Sesak napas", dokterSpesialis, "Berat")
};

for (Person orang : orangRumahSakit) {
    orang.displayInfo(); // Method yang dipanggil sesuai dengan class sebenarnya
}
```

### 4.2 ArrayList Polymorphism
`ArrayList<Dokter>` dapat berisi objek `Dokter` dan `DokterSpesialis`:

```java
ArrayList<Dokter> daftarDokter = new ArrayList<>();
daftarDokter.add(new Dokter("Bambang", 45, "Bedah"));
daftarDokter.add(new DokterSpesialis("Heri", 50, "Saraf", "Neurologi", 15));
```

## 5. KEUNGGULAN IMPLEMENTASI

### 5.1 Code Reusability
- Atribut `nama` dan `umur` tidak perlu ditulis ulang di setiap class
- Method `displayInfo()` di-extend, bukan ditulis ulang dari awal

### 5.2 Maintainability
- Perubahan di base class otomatis mempengaruhi semua subclass
- Struktur yang jelas dan terorganisir

### 5.3 Extensibility
- Mudah menambah jenis dokter atau pasien baru
- Dapat menambah level inheritance baru

### 5.4 Polymorphism Benefits
- Satu interface untuk berbagai implementasi
- Fleksibilitas dalam penggunaan collection

## 6. FILE YANG DIMODIFIKASI/DIBUAT

1. **Person.java** (BARU): Base class untuk semua person
2. **Dokter.java** (DIMODIFIKASI): Sekarang extends Person
3. **Pasien.java** (DIMODIFIKASI): Sekarang extends Person  
4. **DokterSpesialis.java** (BARU): Multi-level inheritance dari Dokter
5. **PasienDarurat.java** (BARU): Multi-level inheritance dari Pasien
6. **rumahSakit.java** (DIMODIFIKASI): Demonstrasi penggunaan inheritance
7. **DemoInheritance.java** (BARU): Demo khusus untuk konsep inheritance

## 7. CARA MENJALANKAN

### 7.1 Aplikasi Utama (Interactive)
```bash
cd "c:\Users\Asus\Downloads\nganu\rumah-sakit-polban + jar"
javac -cp src src/id/ac/polban/rumahSakit.java
java -cp src id.ac.polban.rumahSakit
```

### 7.2 Demo Inheritance (Non-interactive)
```bash
cd "c:\Users\Asus\Downloads\nganu\rumah-sakit-polban + jar"
javac -cp src src/id/ac/polban/DemoInheritance.java
java -cp src id.ac.polban.DemoInheritance
```

## 8. CONTOH OUTPUT DEMO

Demo menampilkan:
- Single inheritance (Person → Dokter/Pasien)
- Multi-level inheritance (Person → Dokter → DokterSpesialis)
- Method override dengan chain super() calls
- Polymorphism dengan array berbagai subclass
- Constructor chaining menggunakan super()

Semua konsep inheritance, override, dan super telah berhasil diimplementasikan dengan lengkap dan fungsional.