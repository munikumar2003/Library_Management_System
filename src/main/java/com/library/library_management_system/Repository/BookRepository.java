package com.library.library_management_system.Repository;


import com.library.library_management_system.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByBorrowed(boolean isBorrowed);
}

