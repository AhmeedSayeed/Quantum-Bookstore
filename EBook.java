public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int publicationYear, float price, String fileType) {
        super(isbn, title, publicationYear, price, new MailService());
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public void printDetails() {
        System.out.println("---------- Book ---------");
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Publication year: " + publicationYear);
        System.out.println("File Type: " + fileType);
        if(price > 0.0){
            System.out.println("Price: " + price);
        } else {
            System.out.println("Not for sale.");
        }
        System.out.println("-------------------------");
    }
}
