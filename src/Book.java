public class Book {
    private String name;
    private String author;
    private int publicationYear;
    private int numberOfPages;
    private Genre genre;
    private int totalBorrowingTime;

    public Book(String name, String author, int publicationYear, int numberOfPages, Genre genre,int totalBorrowingTime) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.totalBorrowingTime = totalBorrowingTime;
    }

    public int getTotalBorrowingTime() {
        return this.totalBorrowingTime;
    }

    @Override
    public String toString() {
        return
                this.name + " Author: " + this.author
                + ", Publication year: " + this.publicationYear
                + ", page number: " + this.numberOfPages
                + ", genre: " + this.genre;

    }
}
