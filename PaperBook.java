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

    @Override
    public void printDetails() {
        System.out.println("---------- Book ---------");
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Publication year: " + publicationYear);
        System.out.println("Available Stock: " + stock + " Book" + (stock > 1 ? "s" : ""));
        if(price > 0.0){
            System.out.println("Price: " + price);
        } else {
            System.out.println("Not for sale.");
        }
        System.out.println("-------------------------");
    }
}
