
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private final Library library;

    public UserInterface(Scanner scanner) {
        this.scan = scanner;
        this.library = new Library();
    }

    public void start() {

        //ArrayList<Book> books = new ArrayList<>();
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

            if(command.equals("2")) {
                Librarian librarian = new Librarian(scan, library);
                librarian.librarianMenu();
            }

            if(command.equals("3")) {
                List<Book> allBooks = library.getAllBooks();
                allBooks.stream().forEach(book -> System.out.println(book + "\n"));
                System.out.println("Total Books: " + allBooks.size() + "\n");
            }

            if(command.equals("1")) {
                System.out.print("Enter your name: ");
                String name = scan.nextLine();
                library.setUser(name);
                User user = new User(name, scan, library);
                user.userMenu();
            }
        }
    }
}
