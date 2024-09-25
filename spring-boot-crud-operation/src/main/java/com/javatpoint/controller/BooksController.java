package com.javatpoint.controller;
import java.io.IOException;
import java.util.List;

import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

//mark class as Controller
@RestController
public class BooksController {
    //autowire the BooksService class
    @Autowired
    BooksService booksService;
    //1.creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }
    //2Creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") Long id)
    {
        return booksService.getBooksById(id);
    }
    //3.creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") Long id)
    {
        booksService.delete(id);
        System.out.println("Delete Book Successfully"+id);
    }
    //4.creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return 1;
    }
    //5.creating put mapping that updates the book detail
    @PutMapping("/book/{bookid}")
    private Books update(@PathVariable("bookid") Long id, @RequestBody Books updatedBook) {
        // Ensure the book ID in the path matches the ID in the updatedBook object
        updatedBook.setId(id);

        // Save or update the book
        Books updated = booksService.saveOrUpdate(updatedBook);

        // Return the updated book object
        return updated;
    }

}
