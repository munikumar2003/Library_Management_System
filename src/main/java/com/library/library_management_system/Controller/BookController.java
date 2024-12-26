package com.library.library_management_system.Controller;

import com.library.library_management_system.Exception.ApiResponse;
import com.library.library_management_system.Exception.InvalidRequestException;
import com.library.library_management_system.Exception.ResourceNotFoundException;
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
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new InvalidRequestException("Book title cannot be empty.");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new InvalidRequestException("Author name cannot be empty.");
        }
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/update-book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook); // Return updated book with status 200
        }
        return ResponseEntity.notFound().build(); // Return 404 if book is not found
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable String id) {
        try {
            boolean isDeleted = bookService.deleteBook(id);
            if (isDeleted) {
                // Return a success message if the book is deleted
                return ResponseEntity.ok(new ApiResponse("Book deleted successfully.", HttpStatus.OK.value()));
            } else {
                // This branch may not be needed if you use exceptions for not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("Book not found.", HttpStatus.NOT_FOUND.value()));
            }
        } catch (ResourceNotFoundException ex) {
            // Handle the exception and return a meaningful response
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
        }
    }

}

