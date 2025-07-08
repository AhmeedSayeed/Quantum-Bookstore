public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publicationYear, float price, int stock) {
        super(isbn, title, author, publicationYear, price, new ShippingService());
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    public void printDetails() {
        System.out.println("Quantum book store - ---------- Book ---------");
        super.printDetails();
        System.out.println("Quantum book store - Available Stock: " + stock + " Book" + (stock > 1 ? "s" : ""));
        System.out.println("Quantum book store - -------------------------");
    }
}
