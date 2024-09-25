package com.javatpoint.repo;

import com.javatpoint.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {


}
