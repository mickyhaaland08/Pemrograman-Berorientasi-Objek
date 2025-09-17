package id.ac.polban.service;

import id.ac.polban.model.Dokter;

/**
 * Class PasienDarurat yang mewarisi dari Pasien
 * Mendemonstrasikan inheritance dan override dengan prioritas khusus
 * @author Ryzen
 */
public class PasienDarurat extends Pasien {
    private String tingkatKegawatan; // Ringan, Sedang, Berat, Kritis
    private boolean perluOperasi;
    
    // Constructor menggunakan super() 
    public PasienDarurat(String nama, int umur, String penyakit, Dokter dokter, String tingkatKegawatan) {
        super(nama, umur, penyakit, dokter); // Memanggil constructor Pasien
        this.tingkatKegawatan = tingkatKegawatan;
        this.perluOperasi = tingkatKegawatan.equals("Kritis") || tingkatKegawatan.equals("Berat");
    }
    
    // Getter methods
    public String getTingkatKegawatan() {
        return tingkatKegawatan;
    }
    
    public boolean isPerluOperasi() {
        return perluOperasi;
    }
    
    // Setter methods
    public void setTingkatKegawatan(String tingkatKegawatan) {
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
    
    // Override method daftar dengan proses prioritas
    @Override
    public void daftar() {
        System.out.println("HOSPITAL: Pasien darurat " + nama + " didaftarkan dengan PRIORITAS " + tingkatKegawatan);
        System.out.println("   Ditangani oleh: " + getDokter().getNama());
        
        // Menentukan prioritas antrian
        switch (tingkatKegawatan) {
            case "Kritis":
                System.out.println("   Status: SEGERA - Masuk ruang operasi");
                break;
            case "Berat":
                System.out.println("   Status: URGENT - Persiapan ruang tindakan");
                break;
            case "Sedang":
                System.out.println("   Status: PRIORITAS - Antrian dipercepat");
                break;
            default:
                System.out.println("   Status: NORMAL - Antrian biasa");
        }
    }
    
    // Method khusus untuk pasien darurat
    public void prosedurDarurat() {
        System.out.println("Melakukan prosedur darurat untuk " + nama + " dengan tingkat " + tingkatKegawatan);
    }
    
    // Override toString dengan informasi darurat
    @Override
    public String toString() {
        return "[DARURAT] " + super.toString() + " [" + tingkatKegawatan + "]";
    }
}