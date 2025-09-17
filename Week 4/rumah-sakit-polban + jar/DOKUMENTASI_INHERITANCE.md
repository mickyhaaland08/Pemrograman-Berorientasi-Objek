# IMPLEMENTASI INHERITANCE, OVERRIDE, DAN SUPER
## Sistem Rumah Sakit dengan Konsep OOP Lanjutan

---

## 📋 DAFTAR ISI
1. [Struktur Class Hierarchy](#struktur-class-hierarchy)
2. [Implementasi Base Class Person](#implementasi-base-class-person)
3. [Implementasi Single Inheritance](#implementasi-single-inheritance)
4. [Implementasi Multi-Level Inheritance](#implementasi-multi-level-inheritance)
5. [Demonstrasi Konsep Override](#demonstrasi-konsep-override)
6. [Demonstrasi Konsep Super](#demonstrasi-konsep-super)
7. [Demonstrasi Polymorphism](#demonstrasi-polymorphism)
8. [Output Program](#output-program)
9. [Analisis Konsep](#analisis-konsep)

---

## 🏗️ STRUKTUR CLASS HIERARCHY

```
Person (Base Class)
├── Dokter (extends Person)
│   └── DokterSpesialis (extends Dokter)
└── Pasien (extends Person)
    └── PasienDarurat (extends Pasien)
```

---

## 👤 IMPLEMENTASI BASE CLASS PERSON

### Code:
```java
public class Person {
    protected String nama;
    protected int umur;
    
    // Constructor untuk Person
    public Person(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
    
    // Default constructor
    public Person() {
        this.nama = "";
        this.umur = 0;
    }
    
    // Method yang akan di-override oleh subclass
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", Umur: " + umur);
    }
    
    // Override toString method
    @Override
    public String toString() {
        return nama + " (" + umur + " tahun)";
    }
}
```

### Penjelasan:
- **Atribut `protected`**: Memungkinkan subclass mengakses langsung atribut `nama` dan `umur`
- **Constructor overloading**: Menyediakan constructor dengan parameter dan default constructor
- **Method `displayInfo()`**: Method virtual yang akan di-override oleh subclass
- **Override `toString()`**: Memberikan representasi string yang meaningful

---

## 👨‍⚕️ IMPLEMENTASI SINGLE INHERITANCE

### 1. Class Dokter extends Person

#### Code:
```java
public class Dokter extends Person {
    protected String spesialis;
    protected String noLisensi;
    
    // Constructor menggunakan super() untuk memanggil constructor parent
    public Dokter(String nama, int umur, String spesialis) {
        super(nama, umur); // Memanggil constructor Person
        this.spesialis = spesialis;
        this.noLisensi = "LIC-" + nama.substring(0, 3).toUpperCase() + "001";
    }
    
    // Override method displayInfo dari Person
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent menggunakan super
        System.out.println("Spesialis: " + spesialis + ", No. Lisensi: " + noLisensi);
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "Dr. " + nama + " (" + spesialis + ")";
    }
}
```

#### Penjelasan:
- **`extends Person`**: Dokter mewarisi semua atribut dan method dari Person
- **`super(nama, umur)`**: Memanggil constructor parent untuk inisialisasi atribut yang diwariskan
- **`super.displayInfo()`**: Memanggil method parent sebelum menambahkan informasi khusus Dokter
- **Override `toString()`**: Format khusus untuk Dokter dengan prefix "Dr."

### 2. Class Pasien extends Person

#### Code:
```java
public class Pasien extends Person {
    private String penyakit;
    private Dokter dokter;
    private String nomorRekamMedis;
    
    // Constructor menggunakan super() untuk memanggil constructor parent
    public Pasien(String nama, int umur, String penyakit, Dokter dokter) {
        super(nama, umur); // Memanggil constructor Person menggunakan super
        this.penyakit = penyakit;
        this.dokter = dokter;
        this.nomorRekamMedis = "RM-" + nama.substring(0, 3).toUpperCase() + String.format("%03d", umur);
    }
    
    // Override method displayInfo dari Person
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent menggunakan super
        System.out.println("Keluhan: " + penyakit + ", Dokter: " + dokter);
        System.out.println("No. Rekam Medis: " + nomorRekamMedis);
    }
    
    // Method khusus yang menggunakan konsep override
    public void infoPasien() {
        System.out.println("=== Informasi Pasien ===");
        displayInfo(); // Memanggil method yang sudah di-override
    }
}
```

#### Penjelasan:
- **Atribut tambahan**: `penyakit`, `dokter`, `nomorRekamMedis` spesifik untuk Pasien
- **Auto-generated**: Nomor rekam medis dibuat otomatis dari nama dan umur
- **Method chaining**: `infoPasien()` memanggil `displayInfo()` yang sudah di-override

---

## 🎓 IMPLEMENTASI MULTI-LEVEL INHERITANCE

### 1. DokterSpesialis extends Dokter

#### Code:
```java
public class DokterSpesialis extends Dokter {
    private String subSpesialis;
    private int pengalaman; // dalam tahun
    
    // Constructor menggunakan super() untuk memanggil constructor Dokter
    public DokterSpesialis(String nama, int umur, String spesialis, String subSpesialis, int pengalaman) {
        super(nama, umur, spesialis); // Memanggil constructor Dokter
        this.subSpesialis = subSpesialis;
        this.pengalaman = pengalaman;
    }
    
    // Override method displayInfo dengan chain dari Person -> Dokter -> DokterSpesialis
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil displayInfo dari Dokter (yang juga memanggil dari Person)
        System.out.println("Sub-Spesialis: " + subSpesialis + ", Pengalaman: " + pengalaman + " tahun");
    }
    
    // Override toString method dengan informasi lengkap
    @Override
    public String toString() {
        return "Prof. Dr. " + nama + " (" + spesialis + " - " + subSpesialis + ", " + pengalaman + " tahun pengalaman)";
    }
}
```

#### Penjelasan Chain Inheritance:
1. **Person constructor** → inisialisasi `nama`, `umur`
2. **Dokter constructor** → memanggil Person constructor + inisialisasi `spesialis`, `noLisensi`
3. **DokterSpesialis constructor** → memanggil Dokter constructor + inisialisasi `subSpesialis`, `pengalaman`

### 2. PasienDarurat extends Pasien

#### Code:
```java
public class PasienDarurat extends Pasien {
    private String tingkatKegawatan; // Ringan, Sedang, Berat, Kritis
    private boolean perluOperasi;
    
    // Constructor menggunakan super() 
    public PasienDarurat(String nama, int umur, String penyakit, Dokter dokter, String tingkatKegawatan) {
        super(nama, umur, penyakit, dokter); // Memanggil constructor Pasien
        this.tingkatKegawatan = tingkatKegawatan;
        this.perluOperasi = tingkatKegawatan.equals("Kritis") || tingkatKegawatan.equals("Berat");
    }
    
    // Override method displayInfo dengan informasi darurat
    @Override
    public void displayInfo() {
        System.out.println("=== PASIEN DARURAT ===");
        super.displayInfo(); // Memanggil method dari Pasien
        System.out.println("Tingkat Kegawatan: " + tingkatKegawatan);
        System.out.println("Perlu Operasi: " + (perluOperasi ? "YA" : "TIDAK"));
        
        if (tingkatKegawatan.equals("Kritis")) {
            System.out.println("WARNING: PRIORITAS TERTINGGI - TANGANI SEGERA!");
        }
    }
    
    // Override method infoPasien dengan format darurat
    @Override
    public void infoPasien() {
        System.out.println("*** EMERGENCY ALERT ***");
        displayInfo();
        
        if (perluOperasi) {
            System.out.println("NOTE: Pasien memerlukan persiapan operasi segera!");
        }
    }
}
```

---

## 🔄 DEMONSTRASI KONSEP OVERRIDE

### Method `displayInfo()` Chain:

#### 1. Person.displayInfo()
```java
public void displayInfo() {
    System.out.println("Nama: " + nama + ", Umur: " + umur);
}
```

#### 2. Dokter.displayInfo() (Override)
```java
@Override
public void displayInfo() {
    super.displayInfo(); // Output: "Nama: X, Umur: Y"
    System.out.println("Spesialis: " + spesialis + ", No. Lisensi: " + noLisensi);
}
```

#### 3. DokterSpesialis.displayInfo() (Override)
```java
@Override
public void displayInfo() {
    super.displayInfo(); // Memanggil Dokter.displayInfo() yang juga memanggil Person.displayInfo()
    System.out.println("Sub-Spesialis: " + subSpesialis + ", Pengalaman: " + pengalaman + " tahun");
}
```

### Hasil Output untuk DokterSpesialis:
```
Nama: Heri, Umur: 50                                    // Dari Person.displayInfo()
Spesialis: Saraf, No. Lisensi: LIC-HER001              // Dari Dokter.displayInfo()
Sub-Spesialis: Neurologi Intervensi, Pengalaman: 15 tahun  // Dari DokterSpesialis.displayInfo()
```

---

## ⚡ DEMONSTRASI KONSEP SUPER

### 1. Constructor Chaining dengan Super

#### Alur Pemanggilan Constructor:
```java
// 1. DokterSpesialis constructor dipanggil
public DokterSpesialis(String nama, int umur, String spesialis, String subSpesialis, int pengalaman) {
    super(nama, umur, spesialis); // 2. Memanggil Dokter constructor
    // ...
}

// 2. Dokter constructor dipanggil
public Dokter(String nama, int umur, String spesialis) {
    super(nama, umur); // 3. Memanggil Person constructor
    // ...
}

// 3. Person constructor dipanggil
public Person(String nama, int umur) {
    this.nama = nama;  // 4. Inisialisasi atribut
    this.umur = umur;
}
```

### 2. Method Chaining dengan Super

#### Urutan Pemanggilan displayInfo():
```java
DokterSpesialis obj = new DokterSpesialis("Heri", 50, "Saraf", "Neurologi Intervensi", 15);
obj.displayInfo(); // Memanggil DokterSpesialis.displayInfo()

// Di dalam DokterSpesialis.displayInfo():
super.displayInfo(); // Memanggil Dokter.displayInfo()

// Di dalam Dokter.displayInfo():
super.displayInfo(); // Memanggil Person.displayInfo()

// Hasil: Output gabungan dari semua level hierarchy
```

---

## 🎭 DEMONSTRASI POLYMORPHISM

### Code Polymorphism:
```java
// Array dengan tipe parent class tapi berisi berbagai child classes
Person[] orangRumahSakit = {
    new Dokter("Agus", 38, "Kelamin"),
    new DokterSpesialis("Dedi", 47, "Mata", "Retina dan Vitreous", 12),
    new Pasien("Budi", 35, "Sakit kepala", dokter1),
    new PasienDarurat("Rina", 28, "Sesak napas", dokterSpesialis, "Berat")
};

for (Person orang : orangRumahSakit) {
    System.out.println("\n--- " + orang.getClass().getSimpleName() + " ---");
    orang.displayInfo(); // Method yang dipanggil sesuai dengan class sebenarnya
    System.out.println("toString(): " + orang.toString());
}
```

### Penjelasan Polymorphism:
- **Runtime Binding**: Method yang dipanggil ditentukan saat runtime berdasarkan tipe objek sebenarnya
- **One Interface, Multiple Implementations**: Satu referensi `Person` dapat menampung berbagai subclass
- **Dynamic Method Dispatch**: JVM secara otomatis memilih implementasi method yang tepat

---

## 📺 OUTPUT PROGRAM

### Hasil Eksekusi Lengkap:

```
=== DEMO KONSEP INHERITANCE, OVERRIDE, DAN SUPER ===

1. DEMONSTRASI INHERITANCE:
   Person (Base Class) -> Dokter (Child Class)
   Dokter: Dr. Bambang (Bedah)
Nama: Bambang, Umur: 45
Spesialis: Bedah, No. Lisensi: LIC-BAM001

============================================================

2. DEMONSTRASI MULTI-LEVEL INHERITANCE:
   Person -> Dokter -> DokterSpesialis
   Dokter Spesialis: Prof. Dr. Heri (Saraf - Neurologi Intervensi, 15 tahun pengalaman)
Nama: Heri, Umur: 50
Spesialis: Saraf, No. Lisensi: LIC-HER001
Sub-Spesialis: Neurologi Intervensi, Pengalaman: 15 tahun
Prof. Dr. Heri (Spesialis Saraf - Neurologi Intervensi) sedang melakukan diagnosa lanjutan dengan pengalaman 15 tahun...

============================================================

3. DEMONSTRASI INHERITANCE PASIEN:
   Person (Base Class) -> Pasien (Child Class)
   Pasien: Ahmad (30 tahun) - Keluhan: Demam tinggi
=== Informasi Pasien ===
Nama: Ahmad, Umur: 30
Keluhan: Demam tinggi, Dokter: Dr. Bambang (Bedah)
No. Rekam Medis: RM-AHM030
Pasien Ahmad telah terdaftar dengan dokter Bambang

============================================================

4. DEMONSTRASI MULTI-LEVEL INHERITANCE PASIEN:
   Person -> Pasien -> PasienDarurat
   Pasien Darurat: [DARURAT] Siti (25 tahun) - Keluhan: Kecelakaan berat [Kritis]
*** EMERGENCY ALERT ***
=== PASIEN DARURAT ===
Nama: Siti, Umur: 25
Keluhan: Kecelakaan berat, Dokter: Prof. Dr. Heri (Saraf - Neurologi Intervensi, 15 tahun pengalaman)
No. Rekam Medis: RM-SIT025
Tingkat Kegawatan: Kritis
Perlu Operasi: YA
WARNING: PRIORITAS TERTINGGI - TANGANI SEGERA!
NOTE: Pasien memerlukan persiapan operasi segera!
HOSPITAL: Pasien darurat Siti didaftarkan dengan PRIORITAS Kritis
   Ditangani oleh: Heri
   Status: SEGERA - Masuk ruang operasi

============================================================

5. DEMONSTRASI POLYMORPHISM:
   Satu referensi, berbagai implementasi

--- Dokter ---
Nama: Agus, Umur: 38
Spesialis: Kelamin, No. Lisensi: LIC-AGU001
toString(): Dr. Agus (Kelamin)

--- DokterSpesialis ---
Nama: Dedi, Umur: 47
Spesialis: Mata, No. Lisensi: LIC-DED001
Sub-Spesialis: Retina dan Vitreous, Pengalaman: 12 tahun
toString(): Prof. Dr. Dedi (Mata - Retina dan Vitreous, 12 tahun pengalaman)

--- Pasien ---
Nama: Budi, Umur: 35
Keluhan: Sakit kepala, Dokter: Dr. Bambang (Bedah)
No. Rekam Medis: RM-BUD035
toString(): Budi (35 tahun) - Keluhan: Sakit kepala

--- PasienDarurat ---
=== PASIEN DARURAT ===
Nama: Rina, Umur: 28
Keluhan: Sesak napas, Dokter: Prof. Dr. Heri (Saraf - Neurologi Intervensi, 15 tahun pengalaman)
No. Rekam Medis: RM-RIN028
Tingkat Kegawatan: Berat
Perlu Operasi: YA
toString(): [DARURAT] Rina (28 tahun) - Keluhan: Sesak napas [Berat]

============================================================

6. DEMONSTRASI KONSEP SUPER:
   Constructor chaining dan method calls

   Constructor chaining example:
   - Person constructor dipanggil oleh super() di Dokter
   - Dokter constructor dipanggil oleh super() di DokterSpesialis

   Method chaining example (displayInfo):
Nama: Ikhlas, Umur: 52
Spesialis: THT, No. Lisensi: LIC-IKH001
Sub-Spesialis: Onkologi Kepala Leher, Pengalaman: 18 tahun

=== DEMO SELESAI ===
```

---

## 🔍 ANALISIS KONSEP

### ✅ INHERITANCE (Pewarisan)
| Konsep | Implementasi | Manfaat |
|--------|-------------|---------|
| **Single Inheritance** | Person → Dokter<br>Person → Pasien | Code reusability, struktur yang jelas |
| **Multi-level Inheritance** | Person → Dokter → DokterSpesialis<br>Person → Pasien → PasienDarurat | Hierarki yang kompleks, spesialisasi bertingkat |

### ✅ OVERRIDE (Penimpaan Method)
| Method | Class | Behavior |
|--------|-------|----------|
| `displayInfo()` | Person | Menampilkan nama dan umur |
| `displayInfo()` | Dokter | Info Person + spesialis dan lisensi |
| `displayInfo()` | DokterSpesialis | Info Dokter + sub-spesialis dan pengalaman |
| `displayInfo()` | Pasien | Info Person + keluhan dan dokter |
| `displayInfo()` | PasienDarurat | Info Pasien + format emergency |

### ✅ SUPER (Pemanggilan Parent)
| Penggunaan | Tujuan | Contoh |
|------------|--------|--------|
| **Constructor** | Inisialisasi atribut parent | `super(nama, umur)` |
| **Method** | Melanjutkan fungsi parent | `super.displayInfo()` |
| **Chain Calls** | Hierarki pemanggilan | Person → Dokter → DokterSpesialis |

### ✅ POLYMORPHISM (Polimorfisme)
- **Runtime Polymorphism**: Method yang dipanggil ditentukan saat runtime
- **Array Heterogen**: Array `Person[]` berisi berbagai subclass
- **Dynamic Binding**: JVM memilih implementasi method yang tepat
- **Interface Unification**: Satu interface untuk berbagai implementasi

---

## 🎯 KESIMPULAN

Implementasi ini berhasil mendemonstrasikan:

1. **Inheritance Hierarchy** yang terstruktur dengan baik
2. **Constructor Chaining** menggunakan `super()`
3. **Method Override** dengan fungsionalitas yang diperluas
4. **Method Chaining** menggunakan `super.methodName()`
5. **Polymorphism** dengan dynamic method dispatch
6. **Code Reusability** dan maintainability yang tinggi

Sistem rumah sakit ini menjadi contoh nyata bagaimana konsep OOP lanjutan dapat diterapkan dalam aplikasi real-world dengan hierarki yang logis dan fungsionalitas yang kaya.