import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Inventory {
    private List<Book> books = new ArrayList<>();

    public void listBooks() {
        for (Book book : books) {
            book.printDetails();
            System.out.println();
        }
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
            if(currentYear - book.getPublicationYear() >  years) {
                outdatedBooks.add(book);
                iterator.remove();
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
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                if(!book.isForSale()) {
                    throw new IllegalArgumentException("Book with ISBN " + isbn + " is not for sale.");
                }

                float paidAmount = book.getPrice() * quantity;
                String deliveryMessage = "";

                if(book instanceof PaperBook pb) {
                    if(quantity > pb.getStock()) {
                        throw new IllegalArgumentException("Not enough stock for book with ISBN: " + isbn);
                    }

                    pb.reduceStock(quantity);
                    deliveryMessage = pb.deliver(address);
                } else if(book instanceof EBook eb) {
                    deliveryMessage = eb.deliver(email);
                }

                PurchaseResult purchaseResult = new PurchaseResult(paidAmount,  deliveryMessage);
                return purchaseResult;
            }
        }

        throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
    }
}
