/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumah.sakit.polban;

/**
 *
 * @author Ryzen
 */


public class Pasien {
    private String nama;
    private int umur;
    private String penyakit;
    private Dokter dokter;
    
    public Pasien(String nama, int umur, String penyakit, Dokter dokter){
        this.nama = nama;
        this.umur = umur;
        this.penyakit = penyakit;
        this.dokter = dokter;
    }
    
    public void infoPasien(){
        System.out.println("Pasien : " + nama + "| Umur : "  + umur + "| Penyakit : " + penyakit + "| Dokter : " + dokter );
    }

    
}
