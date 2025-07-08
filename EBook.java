public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int publicationYear, float price, String fileType) {
        super(isbn, title, publicationYear, price, new MailService());
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
