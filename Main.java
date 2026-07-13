import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }


            switch (choice) {


                case 1:

                    int id;

                    while (true) {

                        try {

                            System.out.print("Enter Book ID: ");
                            id = Integer.parseInt(sc.nextLine());

                            boolean exists = false;

                            for (Book book : library.getBooks()) {

                                if (book.getId() == id) {
                                    exists = true;
                                    break;
                                }
                            }

                            if (exists) {
                                System.out.println("Book ID already exists! Please enter a different ID.");
                                continue;
                            }

                            break;

                        } catch (NumberFormatException e) {

                            System.out.println("Invalid ID! Please enter numbers only.");
                        }
                    }


                    String title;

                    while (true) {

                        System.out.print("Enter Book Title: ");
                        title = sc.nextLine().trim();

                        if (!title.isEmpty()) {
                            break;
                        }

                        System.out.println("Title cannot be empty.");
                    }


                    String author;

                    while (true) {

                        System.out.print("Enter Author Name: ");
                        author = sc.nextLine().trim();

                        if (!author.isEmpty()) {
                            break;
                        }

                        System.out.println("Author name cannot be empty.");
                    }


                    library.addBook(new Book(id, title, author));
                    break;



                case 2:

                    library.displayBooks();
                    break;



                case 3:

                    System.out.println("\nSearch By");
                    System.out.println("1. Book ID");
                    System.out.println("2. Book Title");
                    System.out.println("3. Author Name");
                    System.out.print("Choose: ");


                    int searchChoice;

                    try {

                        searchChoice = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid choice.");
                        break;
                    }


                    switch (searchChoice) {


                        case 1:

                            try {

                                System.out.print("Enter Book ID: ");
                                int searchId = Integer.parseInt(sc.nextLine());
                                library.searchById(searchId);

                            } catch (NumberFormatException e) {

                                System.out.println("Invalid ID.");
                            }

                            break;



                        case 2:

                            System.out.print("Enter Book Title: ");
                            library.searchByTitle(sc.nextLine());
                            break;



                        case 3:

                            System.out.print("Enter Author Name: ");
                            library.searchByAuthor(sc.nextLine());
                            break;



                        default:

                            System.out.println("Invalid option.");
                    }

                    break;



                case 4:

                    try {

                        System.out.print("Enter Book ID to Remove: ");
                        int removeId = Integer.parseInt(sc.nextLine());
                        library.removeBook(removeId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid ID.");
                    }

                    break;



                case 5:

                    System.out.println("\nThank you for using Library Management System!");
                    System.out.println("Have a great day!");
                    sc.close();
                    System.exit(0);



                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}