public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int publicationYear, float price, String fileType) {
        super(isbn, title, author, publicationYear, price, new MailService());
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public void printDetails() {
        System.out.println("Quantum book store - ---------- Book ---------");
        super.printDetails();
        System.out.println("Quantum book store - File Type: " + fileType);
        System.out.println("Quantum book store - -------------------------");
    }
}
