package id.ac.polban.model;

/**
 *
 * @author Ryzen
 */
public class Dokter {
    private String nama;
    private String spesialis;
    
    public Dokter(String nama, String spesialis){
        this.nama = nama;
        this.spesialis = spesialis;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getSpesialis(){
        return spesialis;
    }
    
    @Override
    public String toString() {
        return nama + " (" + spesialis + ")";
    }
}
