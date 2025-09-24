public class Food extends Goods {
    private int calories;

    // Konstruktor
    public Food(String description, double price, int calories) {
        super(description, price);
        this.calories = calories;
    }

    // Getter dan Setter
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Implementasi method display() dari Goods.
     */
    @Override
    public void display() {
        System.out.println("--- Detail Makanan ---");
        super.displayGoodsInfo();
        System.out.println("  Kalori: " + calories + " kkal");
        System.out.println("----------------------");
    }
}
