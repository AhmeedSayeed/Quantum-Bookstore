/*
    Abstraction Layer for implementing Strategy Design Pattern (which helps in following the Open/Closed Principle),
    any new deliver service can be added without modifying existing services or in book class.
 */

public interface DeliveryService {
    public void deliver(Book book, String destination);
}
