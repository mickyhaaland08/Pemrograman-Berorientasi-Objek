/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package id.ac.polban;

/**
 *
 * @author Ryzen
 */

import id.ac.polban.model.Dokter;
import id.ac.polban.service.Pasien;
import java.util.ArrayList;
import java.util.Scanner;

public class rumahSakit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        
        ArrayList<Dokter> daftarDokter = new ArrayList<>();
        daftarDokter.add(new Dokter("Dr. Bambang", "Bedah"));
        daftarDokter.add(new Dokter("Dr. Agus", "Kelamin"));
        daftarDokter.add(new Dokter("Dr. Yusuf", "Penyakit Dalam"));
        daftarDokter.add(new Dokter("Dr. Heri", "Saraf"));
        daftarDokter.add(new Dokter("Dr. Dedi", "Mata"));
        daftarDokter.add(new Dokter("Dr. Ikhlas", "THT"));
        
        System.out.println("=== | Daftar Dokter | ===");
        for (int i = 0; i < daftarDokter.size(); i++){
            System.out.println((i + 1) + ". " + daftarDokter.get(i));
        }
        
        System.out.println("\nMasukkan nama pasien : ");
        String pasien = Input.nextLine();
        
        System.out.println("Masukkan umur pasien : ");
        int umur = Input.nextInt();
        Input.nextLine();
        
        System.out.println("Masukkan keluhan anda : ");
        String penyakit = Input.nextLine();
        
        System.out.println("Pilih nomor Dokter : ");
        int pilih = Input.nextInt();
        Dokter dokterDipilih = daftarDokter.get(pilih - 1);
        
        Pasien pasien1 = new Pasien(pasien, umur, penyakit, dokterDipilih);
        
        System.out.println("\n==== | Info Pasien | ====");
        
        pasien1.infoPasien();
        
        Input.close();
    }
    
}