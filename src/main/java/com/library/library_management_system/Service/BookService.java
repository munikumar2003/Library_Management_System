package com.library.library_management_system.Service;


import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    //private final BookRepository bookRepository;


    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // View all available books
    public List<Book> viewAvailableBooks() {
        return bookRepository.findByBorrowed(false);
    }

    // Borrow a book
    public String borrowBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                book.setAvailable(false);
                bookRepository.save(book);
                return "You have successfully borrowed the book: " + book.getTitle();
            } else {
                return "Sorry, this book is already borrowed.";
            }
        } else {
            return "Book not found!";
        }
    }

    // Return a book
    public String returnBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.isBorrowed()) {
                book.setBorrowed(false);
                book.setAvailable(true);
                bookRepository.save(book);
                return "You have successfully returned the book: " + book.getTitle();
            } else {
                return "This book was not borrowed.";
            }
        } else {
            return "Book not found!";
        }
    }
    public Book addBook(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            throw new IllegalArgumentException("Book with this ISBN already exists!");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book bookDetails) {
        // Find the existing book by id
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();

            // Update the book's details
            bookToUpdate.setTitle(bookDetails.getTitle());
            bookToUpdate.setAuthor(bookDetails.getAuthor());
            bookToUpdate.setPublicationYear(bookDetails.getPublicationYear());
            bookToUpdate.setAvailable(bookDetails.isAvailable());
            bookToUpdate.setBorrowed(bookDetails.isBorrowed());

            // Save the updated book
            return bookRepository.save(bookToUpdate);
        }
        return null; // or throw an exception if the book isn't found
    }

    public boolean deleteBook(String id) {
        // Find the book by its ID
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            // Delete the book if found
            bookRepository.deleteById(id);
            return true; // Return true if book was successfully deleted
        }
        return false; // Return false if book wasn't found
    }
}

