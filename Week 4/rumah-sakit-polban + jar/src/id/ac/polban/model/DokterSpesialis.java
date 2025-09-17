package id.ac.polban.model;

/**
 * Class DokterSpesialis yang mewarisi dari Dokter
 * Mendemonstrasikan multi-level inheritance dan override
 * @author Ryzen
 */
public class DokterSpesialis extends Dokter {
    private String subSpesialis;
    private int pengalaman; // dalam tahun
    
    // Constructor menggunakan super() untuk memanggil constructor Dokter
    public DokterSpesialis(String nama, int umur, String spesialis, String subSpesialis, int pengalaman) {
        super(nama, umur, spesialis); // Memanggil constructor Dokter
        this.subSpesialis = subSpesialis;
        this.pengalaman = pengalaman;
    }
    
    // Getter methods
    public String getSubSpesialis() {
        return subSpesialis;
    }
    
    public int getPengalaman() {
        return pengalaman;
    }
    
    // Setter methods
    public void setSubSpesialis(String subSpesialis) {
        this.subSpesialis = subSpesialis;
    }
    
    public void setPengalaman(int pengalaman) {
        this.pengalaman = pengalaman;
    }
    
    // Override method displayInfo dengan chain dari Person -> Dokter -> DokterSpesialis
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil displayInfo dari Dokter (yang juga memanggil dari Person)
        System.out.println("Sub-Spesialis: " + subSpesialis + ", Pengalaman: " + pengalaman + " tahun");
    }
    
    // Override method diagnosa dari Dokter
    @Override
    public void diagnosa() {
        System.out.println("Prof. Dr. " + nama + " (Spesialis " + spesialis + " - " + subSpesialis + 
                          ") sedang melakukan diagnosa lanjutan dengan pengalaman " + pengalaman + " tahun...");
    }
    
    // Method khusus untuk dokter spesialis
    public void konsultasiLanjutan() {
        System.out.println("Dr. " + nama + " memberikan konsultasi " + subSpesialis + " tingkat lanjut");
    }
    
    // Override toString method dengan informasi lengkap
    @Override
    public String toString() {
        return "Prof. Dr. " + nama + " (" + spesialis + " - " + subSpesialis + ", " + pengalaman + " tahun pengalaman)";
    }
}