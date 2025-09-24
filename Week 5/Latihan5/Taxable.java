public interface Taxable {
    // Tarif pajak sebesar 0.06 (6%)
    double TAX_RATE = 0.06; 

    /**
     * Menghitung nilai pajak dari suatu barang.
     * @param price Harga barang
     * @return Nilai pajak
     */
    double calculateTax(double price);
}
