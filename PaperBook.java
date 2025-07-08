public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int publicationYear, float price, int stock) {
        super(isbn, title, publicationYear, price, new ShippingService());
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}
