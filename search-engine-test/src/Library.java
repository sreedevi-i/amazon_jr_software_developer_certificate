
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
               //  TODO - missing code
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());

                    // TODO 2: Create a Book object
                    Book book = new Book(title, author, year);

                    // Add to your collection (e.g., bookList or bookMap)
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO missing code
        keyword = keyword.toLowerCase();
        for (Book book : books) {
            String title = book.getTitle().toLowerCase();
            String author = book.getAuthor().toLowerCase();
            String year = String.valueOf(book.getPublicationYear());

            // TODO 11: Check the search conditions
            if (title.contains(keyword) || author.contains(keyword) || year.equals(keyword)) {
                return book;
            }
        }
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
