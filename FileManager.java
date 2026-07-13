import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "books.txt";

    // Save books to file
    public static void saveBooks(ArrayList<Book> books) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    // Load books from file
    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    String author = data[2];

                    books.add(new Book(id, title, author));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        return books;
    }
}