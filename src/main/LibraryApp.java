package main;

import java.util.Scanner;

import services.LibraryService;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. Update Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> libraryService.addBook();
                case 2 -> libraryService.viewAllBooks();
                case 3 -> libraryService.deleteBook();
                case 4 -> libraryService.searchBook();
                case 5 -> libraryService.updateBook();
                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}