package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    // from here we handle the requests from clients.
    // we create url end points here by mapping the url with get,post,delete,put etc.
    //we need the bean for the bookService

    @Autowired
    private BookService bookService;

    //API for creating a Book
    @PostMapping("/create")
    public Book addBookHandler(@RequestBody Book book){
        Book createdBook = bookService.addBook(book);
        return createdBook;
    }

    //API for Get all the books
    @GetMapping("/all-books")
    public List<Book> getAllBookHandler(){
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    //API for get one book by ID;
    @GetMapping("/{id}")
    public Book getBookByIdHandler(@PathVariable int id){
        Book bookById = bookService.getBookById(id);
        return bookById;
    }

    //API for update a book by ID;
    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable int id,@RequestBody Book book){
        Book updateBookById = bookService.updateBookById(id, book);
        return updateBookById;
    }

    //API for delete a book by ID;
    @DeleteMapping("/{id}")
    private void deleteBookByIdHandler(@PathVariable int id){
        bookService.deleteBookById(id);
    }
}
