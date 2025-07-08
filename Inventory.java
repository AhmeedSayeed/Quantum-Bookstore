import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private List<Book> books = new ArrayList<>();
    private Map<String, Book> bookMap = new HashMap<>();

    public void listBooks() {
        for (Book book : books) {
            book.printDetails();
            System.out.println();
        }
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getIsbn(), book);
    }

    public List<Book> removeOutdatedBooks(int years) {
        int currentYear = Year.now().getValue();
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (currentYear - book.getPublicationYear() > years) {
                outdatedBooks.add(book);
                iterator.remove();
                bookMap.remove(book.getIsbn());
            }
        }

        return outdatedBooks;
    }

    /*
        First, i make the delivery methods prints a message to know it will be delivered but,
        i used a result object (PurchaseResult) instead of returning a primitive value.
        This helps separate business logic from output handling (e.g., printing),
        making the method reusable in different contexts such as CLI, GUI, or API layers
        without being tied to specific presentation behavior.
     */
    public PurchaseResult buyBook(String isbn, int quantity, String email, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantum book store - Quantity must be greater than 0.");
        }

        if (!bookMap.containsKey(isbn)) {
            throw new IllegalArgumentException("Quantum book store - Book with ISBN " + isbn + " not found.");
        }

        Book book = bookMap.get(isbn);

        if (!book.isForSale()) {
            throw new IllegalArgumentException("Quantum book store - Book with ISBN " + isbn + " is not for sale.");
        }

        float paidAmount = book.getPrice() * ((book instanceof PaperBook) ? quantity : 1);
        String deliveryMessage = "";

        if (book instanceof PaperBook pb) {
            if (quantity > pb.getStock()) {
                throw new IllegalArgumentException("Quantum book store - Not enough stock for book with ISBN: " + isbn);
            }

            pb.reduceStock(quantity);
            deliveryMessage = pb.deliver(address);
        } else if (book instanceof EBook eb) {
            deliveryMessage = eb.deliver(email);
        }

        return new PurchaseResult(paidAmount, deliveryMessage);
    }
}
