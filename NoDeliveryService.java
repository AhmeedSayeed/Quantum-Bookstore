/*
    NoDeliveryService is a concrete implementation of the DeliveryService interface
    that represents the absence of delivery logic (e.g., for demo or showcase books).

    This class follows the Null Object Pattern, providing a safe default behavior
    instead of using null or conditional checks.

    To not break the strategy and more easily extensible code.
 */

public class NoDeliveryService implements DeliveryService {
    @Override
    public String deliver(Book book, String destination) {
        return "Quantum book store - '" + book.title + "' is not for Sale.";
    }
}