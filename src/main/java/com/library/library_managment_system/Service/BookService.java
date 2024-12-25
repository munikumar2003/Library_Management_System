package com.library.library_managment_system.Service;


import com.library.library_managment_system.Model.Book;
import com.library.library_managment_system.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}

