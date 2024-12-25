package com.library.library_management_system.Controller;

import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Endpoint to view all available books
    @GetMapping("/view-available-books")
    public ResponseEntity<List<Book>> viewAvailableBooks() {
        List<Book> allBooks = bookService.viewAvailableBooks();
        return ResponseEntity.ok(allBooks);
    }

    // Endpoint to borrow a book
    @PostMapping("/borrow/{bookId}")
    public ResponseEntity<String> borrowBook(@PathVariable String bookId) {
        String message = bookService.borrowBook(bookId);
        return ResponseEntity.ok(message);
    }

    // Endpoint to return a book
    @PostMapping("/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable String bookId) {
        String message = bookService.returnBook(bookId);
        return ResponseEntity.ok(message);
    }

    //private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}

