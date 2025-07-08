public class ShippingService implements DeliveryService {
    @Override
    public void deliver(Book book, String address) {
        System.out.println("Shipping Service: " + book.getTitle() + " will be shipped to " + address);
    }
}
