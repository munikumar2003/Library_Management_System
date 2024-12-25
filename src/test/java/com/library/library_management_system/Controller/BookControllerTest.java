package com.library.library_management_system.Controller;

import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookControllerTest {

    @Test
    void shouldReturnCreatedResponseWhenBookIsAdded() {
        // Arrange
        BookService bookService = mock(BookService.class);
        BookController bookController = new BookController(bookService);
        Book book = new Book("123-456-789", "The Great Gatsby", "F. Scott Fitzgerald", 1925, true);

        when(bookService.addBook(book)).thenReturn(book);

        // Act
        ResponseEntity<Book> response = bookController.addBook(book);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
}

