public class MailService implements DeliveryService {
    @Override
    public String deliver(Book book, String mail) {
        return "Mail Service: " + book.getTitle() + " book will be sent to " + mail;
    }
}
