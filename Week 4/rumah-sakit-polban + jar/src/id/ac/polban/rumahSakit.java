/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package id.ac.polban;

/**
 * Main class yang mendemonstrasikan konsep Inheritance, Override, dan Super
 * @author Ryzen
 */

import id.ac.polban.model.Dokter;
import id.ac.polban.model.DokterSpesialis;
import id.ac.polban.service.Pasien;
import id.ac.polban.service.PasienDarurat;
import java.util.ArrayList;
import java.util.Scanner;

public class rumahSakit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        
        // Demonstrasi inheritance: Person -> Dokter -> DokterSpesialis
        System.out.println("=== DEMONSTRASI KONSEP INHERITANCE, OVERRIDE, DAN SUPER ===\n");
        
        // Membuat ArrayList dengan berbagai jenis dokter (polymorphism)
        ArrayList<Dokter> daftarDokter = new ArrayList<>();
        
        // Dokter biasa (inheritance dari Person)
        daftarDokter.add(new Dokter("Bambang", 45, "Bedah"));
        daftarDokter.add(new Dokter("Agus", 38, "Kelamin"));
        daftarDokter.add(new Dokter("Yusuf", 42, "Penyakit Dalam"));
        
        // Dokter spesialis (multi-level inheritance: Person -> Dokter -> DokterSpesialis)
        daftarDokter.add(new DokterSpesialis("Heri", 50, "Saraf", "Neurologi Intervensi", 15));
        daftarDokter.add(new DokterSpesialis("Dedi", 47, "Mata", "Retina dan Vitreous", 12));
        daftarDokter.add(new DokterSpesialis("Ikhlas", 52, "THT", "Onkologi Kepala Leher", 18));
        
        System.out.println("=== | Daftar Dokter (Demonstrasi Polymorphism) | ===");
        for (int i = 0; i < daftarDokter.size(); i++){
            // toString() method yang di-override akan dipanggil sesuai dengan class masing-masing
            System.out.println((i + 1) + ". " + daftarDokter.get(i));
        }
        
        System.out.println("\n=== | Demonstrasi Method Override dan Super | ===");
        
        // Menampilkan informasi detail dengan method yang di-override
        System.out.println("\n--- Informasi Dokter Biasa ---");
        daftarDokter.get(0).displayInfo(); // Method dari Dokter yang override dari Person
        
        System.out.println("\n--- Informasi Dokter Spesialis ---");
        daftarDokter.get(3).displayInfo(); // Method dari DokterSpesialis yang override dari Dokter
        
        System.out.println("\n=== | Input Data Pasien | ===");
        
        System.out.print("Masukkan nama pasien: ");
        String namaPasien = Input.nextLine();
        
        System.out.print("Masukkan umur pasien: ");
        int umurPasien = Input.nextInt();
        Input.nextLine();
        
        System.out.print("Masukkan keluhan anda: ");
        String penyakit = Input.nextLine();
        
        System.out.print("Apakah ini kasus darurat? (y/n): ");
        String isDarurat = Input.nextLine();
        
        System.out.print("Pilih nomor Dokter (1-" + daftarDokter.size() + "): ");
        int pilih = Input.nextInt();
        Input.nextLine();
        
        Dokter dokterDipilih = daftarDokter.get(pilih - 1);
        
        // Demonstrasi polymorphism: Pasien vs PasienDarurat
        Pasien pasien;
        
        if (isDarurat.equalsIgnoreCase("y")) {
            System.out.print("Masukkan tingkat kegawatan (Ringan/Sedang/Berat/Kritis): ");
            String tingkatKegawatan = Input.nextLine();
            
            // Membuat objek PasienDarurat (inheritance dari Pasien)
            pasien = new PasienDarurat(namaPasien, umurPasien, penyakit, dokterDipilih, tingkatKegawatan);
        } else {
            // Membuat objek Pasien biasa
            pasien = new Pasien(namaPasien, umurPasien, penyakit, dokterDipilih);
        }
        
        System.out.println("\n=== | Demonstrasi Override Method | ===");
        
        // Method infoPasien() akan dipanggil sesuai dengan class yang sebenarnya (runtime polymorphism)
        pasien.infoPasien();
        
        // Demonstrasi method daftar() yang di-override
        System.out.println("\n=== | Proses Pendaftaran | ===");
        pasien.daftar();
        
        // Demonstrasi method diagnosa() dokter
        System.out.println("\n=== | Proses Diagnosa | ===");
        dokterDipilih.diagnosa();
        
        // Jika dokter spesialis, tampilkan method khusus
        if (dokterDipilih instanceof DokterSpesialis) {
            DokterSpesialis dokSpesialis = (DokterSpesialis) dokterDipilih;
            dokSpesialis.konsultasiLanjutan();
        }
        
        // Jika pasien darurat, tampilkan prosedur khusus
        if (pasien instanceof PasienDarurat) {
            PasienDarurat pasienDarurat = (PasienDarurat) pasien;
            pasienDarurat.prosedurDarurat();
        }
        
        System.out.println("\n=== | Demonstrasi Class Hierarchy | ===");
        demonstrasiInheritance();
        
        Input.close();
    }
    
    // Method tambahan untuk mendemonstrasikan konsep inheritance
    private static void demonstrasiInheritance() {
        System.out.println("\n--- Hierarchy Class ---");
        System.out.println("Person (Base Class)");
        System.out.println("├── Dokter (extends Person)");
        System.out.println("│   └── DokterSpesialis (extends Dokter)");
        System.out.println("└── Pasien (extends Person)");
        System.out.println("    └── PasienDarurat (extends Pasien)");
        
        System.out.println("\n--- Konsep yang Diimplementasikan ---");
        System.out.println("✓ Inheritance: Semua class mewarisi dari Person");
        System.out.println("✓ Override: Method displayInfo(), toString(), dll di-override");
        System.out.println("✓ Super: Constructor dan method menggunakan super()");
        System.out.println("✓ Polymorphism: ArrayList<Dokter> bisa berisi DokterSpesialis");
        System.out.println("✓ Multi-level Inheritance: Person -> Dokter -> DokterSpesialis");
    }
}