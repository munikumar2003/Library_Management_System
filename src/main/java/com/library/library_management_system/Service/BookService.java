package com.library.library_management_system.Service;


import com.library.library_management_system.Model.Book;
import com.library.library_management_system.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            throw new IllegalArgumentException("Book with this ISBN already exists!");
        }
        return bookRepository.save(book);
    }
}

