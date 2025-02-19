package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.model.Books;
import com.javatpoint.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service

public class BooksService {
    @Autowired
    BooksRepository booksRepository;
//getting all books record by using the method findaAll() of CrudRepository
public List<Books> getAllBooks()
{
    List<Books> books = new ArrayList<Books>();
    booksRepository.findAll().forEach(books1 -> books.add(books1));
    return books;
}
    //getting a specific record by using the method findById() of CrudRepository
    public Books getBooksById(Long id)
    {
        return booksRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public Books saveOrUpdate(Books books)
    {
        booksRepository.save(books);
        return books;
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        booksRepository.deleteById(id);
    }
    //updating a record
    public void update(Books books, Long id)
    {
        booksRepository.save(books);
    }

}
