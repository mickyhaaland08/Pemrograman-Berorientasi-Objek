package id.ac.polban.model;

/**
 * Base class untuk semua person di rumah sakit
 * Mendemonstrasikan konsep inheritance sebagai parent class
 * @author Ryzen
 */
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
    
    // Getter methods
    public String getNama() {
        return nama;
    }
    
    public int getUmur() {
        return umur;
    }
    
    // Setter methods
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setUmur(int umur) {
        this.umur = umur;
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