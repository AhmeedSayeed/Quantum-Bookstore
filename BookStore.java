public class BookStore {
    private Inventory inventory = new Inventory();

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

        if (!inventory.isBookExists(isbn)) {
            throw new IllegalArgumentException("Quantum book store - Book with ISBN " + isbn + " not found.");
        }

        Book book = inventory.getBook(isbn);

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
