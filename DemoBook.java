public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int publicationYear, float price) {
        super(isbn, title, publicationYear, price, new NoDeliveryService());
    }

    @Override
    public boolean isForSale() {
        return false;
    }
}
