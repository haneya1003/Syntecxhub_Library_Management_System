import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = FileManager.loadBooks();
    }

    // Get Books (Used for duplicate ID checking)
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Add Book
    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        books.add(book);
        FileManager.saveBooks(books);
        System.out.println("Book added successfully.");
    }

    // Display Books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-30s %-25s%n", "ID", "TITLE", "AUTHOR");
        System.out.println("---------------------------------------------------------------");

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("---------------------------------------------------------------");
    }

    // Search by ID
    public void searchById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                System.out.println("Book Found:");
                System.out.println("---------------------------------------------------------------");
                System.out.printf("%-8s %-30s %-25s%n", "ID", "TITLE", "AUTHOR");
                System.out.println("---------------------------------------------------------------");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Search by Title
    public void searchByTitle(String title) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!found) {
                    System.out.println("---------------------------------------------------------------");
                    System.out.printf("%-8s %-30s %-25s%n", "ID", "TITLE", "AUTHOR");
                    System.out.println("---------------------------------------------------------------");
                }

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Search by Author
    public void searchByAuthor(String author) {

        boolean found = false;

        for (Book book : books) {

            if (book.getAuthor().equalsIgnoreCase(author)) {

                if (!found) {
                    System.out.println("---------------------------------------------------------------");
                    System.out.printf("%-8s %-30s %-25s%n", "ID", "TITLE", "AUTHOR");
                    System.out.println("---------------------------------------------------------------");
                }

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Author not found.");
        }
    }

    // Remove Book
    public void removeBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                books.remove(book);
                FileManager.saveBooks(books);
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Book ID not found.");
    }
}