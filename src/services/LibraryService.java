package services;
import model.Book;
import utils.InputValidator;
import java.util.*;

public class LibraryService {
    private final Map<String, Book> bookCatalog = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();
        if (bookCatalog.containsKey(bookID)) {
            System.out.println("Error: Book ID already exists!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String status = scanner.nextLine();

        if (!InputValidator.isValidBook(title, author, status)) {
            System.out.println("Invalid inputs. Please try again.");
            return;
        }

        Book book = new Book(bookID, title, author, genre, status);
        bookCatalog.put(bookID, book);
        System.out.println("Book added successfully!");
    }

    public void viewAllBooks() {
        if (bookCatalog.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        bookCatalog.values().forEach(System.out::println);
    }
      // delete book details based on th id
    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookID = scanner.nextLine();

        if (bookCatalog.remove(bookID) != null) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    //  Search book by ID or Title
    public void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String query = scanner.nextLine();

        for (Book book : bookCatalog.values()) {
            if (book.getBookID().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + book);
                return;
            }
        }
        System.out.println("No matching book found.");
    }

    //  Update book details
    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookID = scanner.nextLine();

        if (!bookCatalog.containsKey(bookID)) {
            System.out.println("Book not found.");
            return;
        }

        Book book = bookCatalog.get(bookID);

        System.out.print("Enter new Title (press Enter to keep current: " + book.getTitle() + "): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new Author (press Enter to keep current: " + book.getAuthor() + "): ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new Genre (press Enter to keep current: " + book.getGenre() + "): ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter new Availability Status (Available/Checked Out, press Enter to keep current: " + book.getAvailabilityStatus() + "): ");
        String newStatus = scanner.nextLine();

        // Update only if the input is not empty
        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (!newGenre.isEmpty()) book.setGenre(newGenre);
        if (!newStatus.isEmpty()) {
            if (newStatus.equalsIgnoreCase("Available") || newStatus.equalsIgnoreCase("Checked Out")) {
                book.setAvailabilityStatus(newStatus);
            } else {
                System.out.println("Invalid status! Must be 'Available' or 'Checked Out'.");
                return;
            }
        }

        System.out.println("Book details updated successfully!");
    }
}