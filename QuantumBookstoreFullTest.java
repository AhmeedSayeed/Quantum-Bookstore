import java.util.List;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add books
        inventory.addBook(new PaperBook("111", "Clean Code", "Robert C. Martin", 2008, 300, 5));
        inventory.addBook(new EBook("222", "Design Patterns", "Erich Gamma", 2012, 150, "PDF"));
        inventory.addBook(new DemoBook("333", "Quantum Book Demo", "Venkat Subramaniam", 2024));

        // List books
        System.out.println("===== Inventory List =====");
        inventory.listBooks();
        System.out.println("==========================\n");

        System.out.println("===== Buy Tests =====");

        try {
            PurchaseResult result = inventory.buyBook("111", 3, "user@example.com", "Cairo, Egypt");
            System.out.println("Bought 3 x Clean Code. Paid: " + result.getPaidAmount());
            System.out.println(result.getDeliveryMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        try {
            PurchaseResult result = inventory.buyBook("222", 1, "user@example.com", "Not needed");
            System.out.println("Bought Design Patterns (EBook). Paid: " + result.getPaidAmount());
            System.out.println(result.getDeliveryMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        try {
            PurchaseResult result = inventory.buyBook("333", 1, "user@example.com", "No delivery");
        } catch (Exception e) {
            System.out.println("Expected error (not for sale): " + e.getMessage());
        }

        System.out.println();

        try {
            PurchaseResult result = inventory.buyBook("111", 4, "user@example.com", "Cairo");
            System.out.println("Bought 4 x Clean Code. Paid: " + result.getPaidAmount());
            System.out.println(result.getDeliveryMessage());
        } catch (Exception e) {
            System.out.println("Expected error (not enough stock): " + e.getMessage());
        }

        System.out.println();

        try {
            PurchaseResult result = inventory.buyBook("999", 1, "user@example.com", "Nowhere");
        } catch (Exception e) {
            System.out.println("Expected error (not found): " + e.getMessage());
        }

        System.out.println();

        try {
            PurchaseResult result = inventory.buyBook("111", 0, "user@example.com", "Cairo");
            System.out.println("Bought 0 x Clean Code. Paid: " + result.getPaidAmount());
            System.out.println(result.getDeliveryMessage());
        } catch (Exception e) {
            System.out.println("Expected error (invalid quantity): " + e.getMessage());
        }

        System.out.println();

        System.out.println("===== Remove Outdated Books =====");
        List<Book> removed = inventory.removeOutdatedBooks(10); // remove books older than 10 years

        if (removed.isEmpty()) {
            System.out.println("No outdated books found.");
        } else {
            System.out.println("Removed outdated books:");
            for (Book book : removed) {
                System.out.println("- " + book.getTitle() + " (" + book.getPublicationYear() + ")");
            }
        }
    }
}
