public abstract class Goods {
    // Atribut dasar (dengan Enkapsulasi)
    private String description;
    private double price;

    // Konstruktor
    public Goods(String description, double price) {
        this.description = description;
        this.price = price;
    }

    // Getter dan Setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method abstrak untuk menampilkan detail barang.
     * Setiap subclass harus mengimplementasikannya.
     */
    public abstract void display();

    /**
     * Method umum untuk menampilkan informasi dasar barang.
     */
    protected void displayGoodsInfo() {
        System.out.println("  Deskripsi: " + description);
        System.out.println("  Harga: Rp" + String.format("%,.2f", price));
    }
}