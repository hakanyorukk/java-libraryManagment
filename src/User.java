import java.util.List;
import java.util.Scanner;

public class User {
    private String userName;
    private Scanner scan;
    private Library library;

    public User(String userName, Scanner scan, Library library) {
        this.scan = scan;
        this.userName = userName;
        this.library = library;
    }

    public void userMenu(){
        System.out.println("---------------------------------------");
        System.out.println("Welcome to the Library User Portal " + this.userName);
        System.out.println("---------------------------------------");

        while(true) {
            System.out.println("Following functions are available.\n");

            System.out.println("1 - Show available books");
            System.out.println("2 - Show most read book.");
            System.out.println("3 - Search book.");
            System.out.println("4 - Borrow book.");
            System.out.println("5 - Go back to main menu.");
            String command = scan.nextLine();

            if(command.equals("5")) {
                break;
            }

            if(command.equals("2")) {
                System.out.println("Most read books is: " + library.getMostReadBook());
            }

            if(command.equals("3")) {
                // search book
                System.out.print("Enter the name of the book: ");
                String name = scan.nextLine();

                if(library.searchBook(name) != null) {
                    System.out.println("Book is found -> " + library.searchBook(name));
                } else {
                    System.out.println("Book is not found!");
                }
            }

            if(command.equals("4")) {
                System.out.print("Enter the name of the book you want to borrow: ");
                String name = scan.nextLine();

                if(library.searchBook(name) != null) {
                    Book book = library.searchBook(name);
                    library.borrowBooks(this.userName, book);
                    System.out.println("Book " + book.getName() + " is borrowed by " + userName + ".");
                } else {
                    System.out.println("Book is not found!");
                }
            }

            if(command.equals("1")) {
                List<Book> availableBooks = library.getAvailableBooks();
                availableBooks.stream().forEach(book -> System.out.println(book + "\n"));
            }
        }
    }
}
