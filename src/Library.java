import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Library {
    // all books
    // barrowed books userName
    // get most readed book
    // get available books
    private List<Book> books;
    private HashMap<String, Book> barrowBooks;

    public Library() {
        //this.books = new ArrayList<>();
        this.barrowBooks = new HashMap<>();
        this.books = getAllBooks();
    }

    public void setBarrowBooks(String userName, Book book) {
        barrowBooks.put(userName, book);
    }

    public HashMap<String, Book> getBarrowBooks() {
        return barrowBooks;
    }

    public Book getMostReadBook() {
        return this.books.stream().max((t1,t2) -> t1.getTotalBorrowingTime() - t2.getTotalBorrowingTime()).get();
    }

    public ArrayList<Book> getAllBooks() {
        //file = readBooksFromFile();
        ArrayList<Book> books = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get("books.txt"))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String name = parts[0];
                String author = parts[1];
                int publicationYear = Integer.parseInt(parts[2]);
                int numberOfPages = Integer.parseInt(parts[3]);
                Genre genre = Genre.fromString(parts[4]);
                int totalBorrowingTime = Integer.parseInt(parts[5]);

                Book book = new Book(name, author, publicationYear,
                        numberOfPages, genre, totalBorrowingTime);
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }

}
