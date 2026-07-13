public class Book {

    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Convert book to text for saving in file
    public String toFileString() {
        return id + "," + title + "," + author;
    }

    @Override
    public String toString() {
        return String.format("%-8d %-30s %-25s", id, title, author);
    }
}