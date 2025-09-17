/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.polban.service;

import id.ac.polban.model.Dokter;
import id.ac.polban.model.Person;

/**
 * Class Pasien yang mewarisi dari Person
 * Mendemonstrasikan konsep inheritance, super, dan override
 * @author Ryzen
 */
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
    
    // Getter methods
    public String getPenyakit() {
        return penyakit;
    }
    
    public Dokter getDokter() {
        return dokter;
    }
    
    public String getNomorRekamMedis() {
        return nomorRekamMedis;
    }
    
    // Setter methods
    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
    
    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
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
    
    // Method tambahan untuk pasien
    public void daftar() {
        System.out.println("Pasien " + nama + " telah terdaftar dengan dokter " + dokter.getNama());
    }
    
    // Override toString method
    @Override
    public String toString() {
        return super.toString() + " - Keluhan: " + penyakit;
    }
}