
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // TODO 21: Serialize and write the list of books
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {

            return null;
        }

        try
                (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // TODO - missing code
            @SuppressWarnings("unchecked")
            List<Book> books = (List<Book>) ois.readObject();
            return books;
        }
        catch (EOFException e) {

            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

