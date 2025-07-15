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
    public boolean isBookExists(String isbn) {
        return bookMap.containsKey(isbn);
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return bookMap.get(isbn);
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
}
