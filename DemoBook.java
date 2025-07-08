public class DemoBook extends Book {
    public DemoBook(String isbn, String title, String author, int publicationYear) {
        super(isbn, title, author, publicationYear, 0, new NoDeliveryService());
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public void printDetails() {
        System.out.println("Quantum book store - ---------- Book ---------");
        super.printDetails();
        System.out.println("Quantum book store - -------------------------");
    }
}
