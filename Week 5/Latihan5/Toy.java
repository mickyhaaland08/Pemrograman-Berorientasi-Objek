public class Toy extends Goods implements Taxable {
    private int minimumAge;

    // Konstruktor
    public Toy(String description, double price, int minimumAge) {
        super(description, price);
        this.minimumAge = minimumAge;
    }

    // Getter dan Setter
    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    /**
     * Implementasi method display() dari Goods.
     */
    @Override
    public void display() {
        double tax = calculateTax(getPrice());
        double finalPrice = getPrice() + tax;

        System.out.println("--- Detail Mainan ---");
        super.displayGoodsInfo();
        System.out.println("  Usia Minimum: " + minimumAge + " tahun");
        System.out.println("  Pajak (" + (TAX_RATE * 100) + "%): Rp" + String.format("%,.2f", tax));
        System.out.println("  Harga Akhir (Termasuk Pajak): Rp" + String.format("%,.2f", finalPrice));
        System.out.println("---------------------");
    }

    /**
     * Implementasi method calculateTax() dari Interface Taxable.
     */
    @Override
    public double calculateTax(double price) {
        return price * TAX_RATE;
    }
}
