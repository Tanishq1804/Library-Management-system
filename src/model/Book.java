package model;

public class Book {
    private final String bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String status) {
        if (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Checked Out")) {
            this.availabilityStatus = status;
        }
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID + " | Title: " + title + " | Author: " + author +
               " | Genre: " + genre + " | Status: " + availabilityStatus;
    }
}