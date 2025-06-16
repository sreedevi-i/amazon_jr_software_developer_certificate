
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    // Method to log search interactions
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    // Method to log viewing all books
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    // Generic method to log messages with a timestamp
    public void log(String message) {
    // TODO - missing code.
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            // TODO 18: Construct log entry with timestamp
            String timestamp = LocalDateTime.now().toString();
            String logEntry = timestamp + " - " + message + System.lineSeparator();

            writer.write(logEntry);
        } catch (IOException e) {
            // TODO 19: Handle exceptions
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

}
