import java.util.Scanner;

public class Librarian {
    private Scanner scan;
    private Library library;

    public Librarian(Scanner scan, Library library) {
        this.scan = scan;
        this.library = library;
    }
    // functions show active users, show borrowed books, add new book.

    public void librarianMenu() {
        System.out.println("---------------------------------------");
        System.out.println("\tWelcome to the Library Admin Portal");
        System.out.println("---------------------------------------");

        while(true) {
            System.out.println("Following functions are available.\n");

            System.out.println("1 - Show active users");
            System.out.println("2 - Show borrowed books");
            System.out.println("3 - Add new book");
            System.out.println("4 - Go back to main menu");
            String command = scan.nextLine();

            if(command.equals("4")) {
                break;
            }

            if(command.equals("3")) {
                System.out.print("Name: ");
                String name = scan.nextLine();

                System.out.print("Author: ");
                String author = scan.nextLine();

                System.out.print("Publication Year: ");
                int publicationYear = Integer.valueOf(scan.nextLine());

                System.out.print("Number Of Pages: ");
                int numberOfPages = Integer.valueOf(scan.nextLine());

                System.out.print("Genre: ");
                Genre genre = Genre.fromString(scan.nextLine());

                int totalBorrowingTime = 0;
                Book book = new Book(name, author, publicationYear, numberOfPages, genre, totalBorrowingTime);

                library.addNewBook(book);
                System.out.println("entering...");
            }

            if(command.equals("2")) {
                if(library.getBorrowedBooks().isEmpty()) {
                    System.out.println("There are no borrowed books at the moment!");
                }
                library.getBorrowedBooks().entrySet().stream().forEach(borrowedBook -> System.out.println(borrowedBook));
            }

            if(command.equals("1")) {
                if(library.getUsers().isEmpty()) {
                    System.out.println("There are no active users.");
                }
                library.getUsers().stream().forEach(user -> System.out.println(user));
            }
        }
    }
}
