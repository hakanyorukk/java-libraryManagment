import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Library {
    private List<Book> books;
    private HashMap<String, List<Book>> borrowedBooks;
    private List<String> users;

    public Library() {
        //this.books = new ArrayList<>();
        this.borrowedBooks = new HashMap<>();
        this.books = readBooksFromFile();
        this.users = new ArrayList<>();
    }

    public void setUser(String user) {
        users.add(user);
    }

    public List<String> getUsers() {
        return users;
    }
    // get available books allbooks- not borrow books
    public List<Book> getAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public HashMap<String, List<Book>> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void borrowBooks(String userName, Book book) {
        if(!book.isAvailable()) {
            System.out.println("This book is not available.");
            return;
        }
        book.setAvailable(false);
        book.setTotalBorrowingTime();

        borrowedBooks.putIfAbsent(userName, new ArrayList<>());
        borrowedBooks.get(userName).add(book);
    }

    public Book searchBook(String name) {
        for(Book book: this.getAvailableBooks()) {
            if(book.getName().toLowerCase().contains(name.toLowerCase())) {
                return book;
                //return "Book is found -> " + book;
            }
        }
        return null;
        //return "Book is not found";
    }

    public Book getMostReadBook() {
        return this.books.stream().max((t1,t2) -> t1.getTotalBorrowingTime() - t2.getTotalBorrowingTime()).get();
    }

    public void addNewBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public ArrayList<Book> readBooksFromFile() {
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
