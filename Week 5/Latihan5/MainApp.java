public class MainApp {
    public static void main(String[] args) {
        // Membuat objek dari setiap kelas
        Food durian = new Food("Durian Belanda", 15000, 95);
        Toy mainan = new Toy("Mobil Remot", 550000, 4);
        Book novel = new Book("Bumi Manusia", 120000, "Pramoedya Ananta Toer");

        // Menampilkan detail Food (tanpa pajak)
        durian.display();
        System.out.println("\n");

        // Menampilkan detail Toy (dengan pajak)
        mainan.display();
        System.out.println("\n");

        // Menampilkan detail Book (dengan pajak)
        novel.display();
        System.out.println("\n");

        // Contoh modifikasi harga menggunakan setter (Encapsulation)
        System.out.println("--- Update Harga Buku ---");
        System.out.println("Harga lama: Rp" + String.format("%,.2f", novel.getPrice()));
        novel.setPrice(150000);
        System.out.println("Harga baru: Rp" + String.format("%,.2f", novel.getPrice()));
        novel.display();
    }
}
