/*
    An abstract Book class allows adding new book types without modifying existing ones
    (which helps in following the Open/Closed Principle).
    The Book follows the Dependency Inversion Principle by depending on abstractions rather than
    concrete implementations in Delivery Service.
 */

import java.time.Year;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int publicationYear;
    protected float price;
    protected DeliveryService deliveryService;

    public Book(String isbn, String title, int publicationYear, float price,  DeliveryService deliveryService) {
        this.isbn = isbn;
        this.title = title;
        if(publicationYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Publication year is greater than Year now.");
        }
        this.publicationYear = publicationYear;
        if(price < 0) {
            throw new IllegalArgumentException("Price is negative.");
        }
        this.price = price;
        this.deliveryService = deliveryService;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public float getPrice() {
        return price;
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public boolean isForSale() {
        return true; // will be overwritten in Demo Book
    }

    public String deliver(String destination) {
        return deliveryService.deliver(this, destination);
    }

    public void printDetails() {
        System.out.println("---------- Book ---------");
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Publication year: " + publicationYear);
        if(price > 0.0){
            System.out.println("Price: " + price);
        } else {
            System.out.println("Not for sale.");
        }
        System.out.println("-------------------------");
    }
}
