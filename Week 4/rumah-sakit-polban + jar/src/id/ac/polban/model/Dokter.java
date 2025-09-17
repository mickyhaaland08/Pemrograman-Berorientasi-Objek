package id.ac.polban.model;

/**
 * Class Dokter yang mewarisi dari Person
 * Mendemonstrasikan konsep inheritance, super, dan override
 * @author Ryzen
 */
public class Dokter extends Person {
    protected String spesialis;
    protected String noLisensi;
    
    // Constructor menggunakan super() untuk memanggil constructor parent
    public Dokter(String nama, int umur, String spesialis) {
        super(nama, umur); // Memanggil constructor Person
        this.spesialis = spesialis;
        this.noLisensi = "LIC-" + nama.substring(0, 3).toUpperCase() + "001";
    }
    
    // Constructor dengan parameter tambahan
    public Dokter(String nama, int umur, String spesialis, String noLisensi) {
        super(nama, umur);
        this.spesialis = spesialis;
        this.noLisensi = noLisensi;
    }
    
    // Getter methods
    public String getSpesialis() {
        return spesialis;
    }
    
    public String getNoLisensi() {
        return noLisensi;
    }
    
    // Setter methods
    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
    
    public void setNoLisensi(String noLisensi) {
        this.noLisensi = noLisensi;
    }
    
    // Override method displayInfo dari Person
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent menggunakan super
        System.out.println("Spesialis: " + spesialis + ", No. Lisensi: " + noLisensi);
    }
    
    // Method khusus untuk dokter
    public void diagnosa() {
        System.out.println("Dr. " + nama + " sedang melakukan diagnosa...");
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "Dr. " + nama + " (" + spesialis + ")";
    }
}
