public class ShippingService implements DeliveryService {
    @Override
    public String deliver(Book book, String address) {
        return "Shipping Service: " + book.getTitle() + " book will be shipped to " + address;
    }
}
