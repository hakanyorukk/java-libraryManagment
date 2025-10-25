import java.util.Scanner;

public class User {
    private String userName;
    private Scanner scan;
    private Library library;

    public User(String userName, Scanner scan, Library library) {
        this.scan = scan;
        this.userName = userName;
        this.library = new Library();
    }

    public void userMenu(){
        System.out.println("Welcome: " + this.userName + "\n");
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
        }
    }
}
