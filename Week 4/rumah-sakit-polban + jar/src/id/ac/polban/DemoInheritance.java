package id.ac.polban;

import id.ac.polban.model.Dokter;
import id.ac.polban.model.DokterSpesialis;
import id.ac.polban.model.Person;
import id.ac.polban.service.Pasien;
import id.ac.polban.service.PasienDarurat;

/**
 * Demo class untuk mendemonstrasikan konsep Inheritance, Override, dan Super
 * @author Ryzen
 */
public class DemoInheritance {
    
    public static void main(String[] args) {
        System.out.println("=== DEMO KONSEP INHERITANCE, OVERRIDE, DAN SUPER ===\n");
        
        // 1. Demonstrasi Inheritance: Person -> Dokter
        System.out.println("1. DEMONSTRASI INHERITANCE:");
        System.out.println("   Person (Base Class) -> Dokter (Child Class)");
        
        Dokter dokter1 = new Dokter("Bambang", 45, "Bedah");
        System.out.println("   Dokter: " + dokter1.toString()); // Override toString()
        dokter1.displayInfo(); // Override displayInfo() dengan super()
        
        System.out.println("\n============================================================\n");
        
        // 2. Demonstrasi Multi-level Inheritance: Person -> Dokter -> DokterSpesialis
        System.out.println("2. DEMONSTRASI MULTI-LEVEL INHERITANCE:");
        System.out.println("   Person -> Dokter -> DokterSpesialis");
        
        DokterSpesialis dokterSpesialis = new DokterSpesialis("Heri", 50, "Saraf", "Neurologi Intervensi", 15);
        System.out.println("   Dokter Spesialis: " + dokterSpesialis.toString());
        dokterSpesialis.displayInfo(); // Chain of super() calls
        dokterSpesialis.diagnosa(); // Override method diagnosa()
        
        System.out.println("\n============================================================\n");
        
        // 3. Demonstrasi Inheritance: Person -> Pasien
        System.out.println("3. DEMONSTRASI INHERITANCE PASIEN:");
        System.out.println("   Person (Base Class) -> Pasien (Child Class)");
        
        Pasien pasien1 = new Pasien("Ahmad", 30, "Demam tinggi", dokter1);
        System.out.println("   Pasien: " + pasien1.toString());
        pasien1.infoPasien(); // Override method infoPasien()
        pasien1.daftar(); // Method khusus pasien
        
        System.out.println("\n============================================================\n");
        
        // 4. Demonstrasi Inheritance: Person -> Pasien -> PasienDarurat
        System.out.println("4. DEMONSTRASI MULTI-LEVEL INHERITANCE PASIEN:");
        System.out.println("   Person -> Pasien -> PasienDarurat");
        
        PasienDarurat pasienDarurat = new PasienDarurat("Siti", 25, "Kecelakaan berat", dokterSpesialis, "Kritis");
        System.out.println("   Pasien Darurat: " + pasienDarurat.toString());
        pasienDarurat.infoPasien(); // Override method dengan format khusus
        pasienDarurat.daftar(); // Override dengan prioritas darurat
        
        System.out.println("\n============================================================\n");
        
        // 5. Demonstrasi Polymorphism
        System.out.println("5. DEMONSTRASI POLYMORPHISM:");
        System.out.println("   Satu referensi, berbagai implementasi");
        
        // Array dengan tipe parent class tapi berisi berbagai child classes
        Person[] orangRumahSakit = {
            new Dokter("Agus", 38, "Kelamin"),
            new DokterSpesialis("Dedi", 47, "Mata", "Retina dan Vitreous", 12),
            new Pasien("Budi", 35, "Sakit kepala", dokter1),
            new PasienDarurat("Rina", 28, "Sesak napas", dokterSpesialis, "Berat")
        };
        
        for (Person orang : orangRumahSakit) {
            System.out.println("\n--- " + orang.getClass().getSimpleName() + " ---");
            orang.displayInfo(); // Method yang dipanggil akan sesuai dengan class yang sebenarnya
            System.out.println("toString(): " + orang.toString());
        }
        
        System.out.println("\n============================================================\n");
        
        // 6. Demonstrasi konsep Super
        System.out.println("6. DEMONSTRASI KONSEP SUPER:");
        System.out.println("   Constructor chaining dan method calls");
        
        System.out.println("\n   Constructor chaining example:");
        System.out.println("   - Person constructor dipanggil oleh super() di Dokter");
        System.out.println("   - Dokter constructor dipanggil oleh super() di DokterSpesialis");
        
        DokterSpesialis dokterBaru = new DokterSpesialis("Ikhlas", 52, "THT", "Onkologi Kepala Leher", 18);
        System.out.println("\n   Method chaining example (displayInfo):");
        dokterBaru.displayInfo();
        
        System.out.println("\n=== DEMO SELESAI ===");
    }
}