package utils;

public class InputValidator {
    public static boolean isValidBook(String title, String author, String status) {
        return !title.isEmpty() && !author.isEmpty() &&
               (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Checked Out"));
    }
}