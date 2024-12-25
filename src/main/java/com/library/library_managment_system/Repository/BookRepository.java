package com.library.library_managment_system.Repository;


import com.library.library_managment_system.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}

