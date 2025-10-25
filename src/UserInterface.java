import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private ArrayList books;

    public UserInterface(Scanner scanner) {
        this.scan = scanner;
        this.books = new ArrayList<>();
    }

    public void start() {
        // books from file
        //ArrayList<Book> books = new ArrayList<>();
        Library library = new Library();
        //books = readBooksFromFile("books.txt");
        books = library.getAllBooks();

        // commands
        System.out.println("---------------------------------------");
        System.out.println("\t\tWelcome to the Library.");
        System.out.println("---------------------------------------");

        // while loop option selection
        while(true) {
            System.out.println("Following functions are available.\n");

            System.out.println("1 - Enter as user");
            System.out.println("2 - Enter as librarian");
            System.out.println("3 - View All Books in Library");
            System.out.println("4 - Exit");
            String command = scan.nextLine();

            if(command.equals("4")) {
                break;
            }

            if(command.equals("3")) {
                books.stream().forEach(book -> System.out.println(book + "\n"));
                System.out.println("Total Books: " + books.size() + "\n");
            }

            if(command.equals("1")) {
                System.out.print("Enter your name: ");
                String name = scan.nextLine();
                User user = new User(name, scan, library);
                user.userMenu();
            }
        }
    }

    public static ArrayList<Book> readBooksFromFile(String file) {
        ArrayList<Book> books = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(file))) {
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
