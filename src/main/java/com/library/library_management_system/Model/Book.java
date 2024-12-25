package com.library.library_management_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Book {

    @Id
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available = true;
    private boolean borrowed;

    public Book(String isbn, String title, String author, int publicationYear,
                boolean available, boolean isBorrowed) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = available;
        this.borrowed = isBorrowed;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for publicationYear
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Getter and Setter for available
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Getter and Setter for isBorrowed
    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Book(){

    }

    @Override
    public String toString() {
        return String.format("Book[ISBN=%s, Title=%s, Author=%s, Year=%d, Available=%s, Borrowed=%s]",
                isbn, title, author, publicationYear, available, borrowed);
    }
}
