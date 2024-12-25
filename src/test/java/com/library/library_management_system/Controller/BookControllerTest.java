package com.library.library_management_system.Controller;
import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.Year;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookControllerTest {

    private BookService bookService;
    private BookController bookController;

    @BeforeEach
    void setUp() {
        bookService = mock(BookService.class);
        bookController = new BookController(bookService);
    }

    @Test
    void shouldReturnCreatedResponseWhenBookIsAdded() {
        // Arrange
        Book book = new Book("123-456-789", "The Great Gatsby", "F. Scott Fitzgerald", Year.of(1925), true, false);
        when(bookService.addBook(book)).thenReturn(book);

        // Act
        ResponseEntity<Book> response = bookController.addBook(book);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
}
