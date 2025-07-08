import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Inventory {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> removeOutdatedBooks(int years) {
        int currentYear = Year.now().getValue();
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if(currentYear - book.getPublicationYear() >  currentYear) {
                outdatedBooks.add(book);
                iterator.remove();
            }
        }

        return outdatedBooks;
    }
}
