
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer
    private SortUtil sortUtil = new SortUtil();
    private List<Book> books;
    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
         books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO - missing code
            logger.log("Program started and menu displayed.");
            System.out.println("\n==== Book Library Menu ====");
            System.out.println("1. View all books");
            System.out.println("2. Sort books by title");
            System.out.println("3. Sort books by author");
            System.out.println("4. Sort books by publication year");
            System.out.println("5. Search for a book by keyword");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");


            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    library.viewAllBooks();
                    logger.log("Viewed all books.");
                    break;

                case "2":
                    sortUtil.bubbleSort(library.getBooks(),Comparator.comparing(Book::getTitle));
                    logger.log("Sorted books by title.");
                    library.viewAllBooks();
                    logger.log("Viewed all books.");
                    break;

                case "3":
                    sortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    logger.log("Sorted books by author.");
                    library.viewAllBooks();
                    logger.log("Viewed all books.");
                    break;

                case "4":
                    sortUtil.quickSort(library.getBooks(),  Comparator.comparingInt(Book::getPublicationYear),0, library.getBooks().size() - 1);
                    logger.log("Sorted books by publication year.");
                    library.viewAllBooks();
                    logger.log("Viewed all books.");
                    break;

                case "5":
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    Book found = library.searchBookByKeyword(keyword);
                    if (found != null) {
                        System.out.println("Book found:\n" + found);
                    } else {
                        System.out.println("No book matched the keyword.");
                    }
                    logger.log("Searched a book by keyword.");
                    break;

                case "6":
                    System.out.println("Exiting program. Goodbye!");
                    logger.log("Program exitted");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    logger.log("Invalid choice given.");
            }
        }
    }

}
