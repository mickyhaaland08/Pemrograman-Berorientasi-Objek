public class Book extends Goods implements Taxable {
    private String author;

    // Konstruktor
    public Book(String description, double price, String author) {
        super(description, price);
        this.author = author;
    }

    // Getter dan Setter
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Implementasi method display() dari Goods.
     */
    @Override
    public void display() {
        double tax = calculateTax(getPrice());
        double finalPrice = getPrice() + tax;

        System.out.println("--- Detail Buku ---");
        super.displayGoodsInfo();
        System.out.println("  Penulis: " + author);
        System.out.println("  Pajak (" + (TAX_RATE * 100) + "%): Rp" + String.format("%,.2f", tax));
        System.out.println("  Harga Akhir (Termasuk Pajak): Rp" + String.format("%,.2f", finalPrice));
        System.out.println("-------------------");
    }

    /**
     * Implementasi method calculateTax() dari Interface Taxable.
     */
    @Override
    public double calculateTax(double price) {
        return price * TAX_RATE;
    }
}
