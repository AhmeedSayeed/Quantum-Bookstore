public class MailService implements DeliveryService {
    @Override
    public void deliver(Book book, String mail) {
        System.out.println("Mail Service: " + book.getTitle() + " will be sent to " + mail);
    }
}
