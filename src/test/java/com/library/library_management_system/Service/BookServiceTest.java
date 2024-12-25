package com.library.library_management_system.Service;

import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Repository.BookRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void shouldAddBookSuccessfully() {
        // Arrange
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book = new Book("123-456-789", "The Great Gatsby", "F. Scott Fitzgerald", 1925, true);

        when(bookRepository.existsById(book.getIsbn())).thenReturn(false);
        when(bookRepository.save(book)).thenReturn(book);

        // Act
        Book savedBook = bookService.addBook(book);

        // Assert
        assertEquals(book, savedBook);
        verify(bookRepository, times(1)).save(book);
    }
}

