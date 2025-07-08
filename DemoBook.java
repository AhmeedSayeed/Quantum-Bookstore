public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int publicationYear) {
        super(isbn, title, publicationYear, 0, new NoDeliveryService());
    }

    @Override
    public boolean isForSale() {
        return false;
    }
}
