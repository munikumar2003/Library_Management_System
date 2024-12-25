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
    private boolean isBorrowed = false;

    //no arguments constructor
    public Book(){

    }

    //all-arguments constructor
    public Book(String title, String author, String isbn,int publicationYear, boolean available, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear=publicationYear;
        this.available = available;
        this.isBorrowed=isBorrowed;
    }


    //getter for isbn
    public String getIsbn() {
        return isbn;
    }

    //getter for title
    public String getTitle() {
        return title;
    }

    //getter for author
    public String getAuthor() {
        return author;
    }

    //getter for publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    //getter and setter for availability
    public boolean available() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //getter and setter for isBorrowed
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    @Override
    public String toString() {
        return String.format("Book[ISBN=%s, Title=%s, Author=%s, Year=%d, Available=%s, Borrowed=%s]",
                isbn, title, author, publicationYear, available, isBorrowed);
    }
}

