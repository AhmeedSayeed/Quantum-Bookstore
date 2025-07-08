import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Inventory {
    private List<Book> books = new ArrayList<>();

    public void listBooks() {
        System.out.println("Books in Inventory:");
        System.out.println();
        for (Book book : books) {
            book.printDetails();
            System.out.println();
        }
        System.out.println("--------------------------");
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

    public float buyBook(String isbn, int quantity, String email, String address) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                if(!book.isForSale()) {
                    throw new IllegalArgumentException("Book with ISBN " + isbn + " is not for sale.");
                }

                float paidAmount = book.getPrice() * quantity;

                if(book instanceof PaperBook pb) {
                    if(quantity > pb.getStock()) {
                        throw new IllegalArgumentException("Not enough stock for book with ISBN: " + isbn);
                    }

                    pb.reduceStock(quantity);
                    pb.deliver(address);
                } else if(book instanceof EBook eb) {
                    eb.deliver(email);
                }

                return paidAmount;
            }
        }

        throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
    }
}
