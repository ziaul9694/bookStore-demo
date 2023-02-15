package com.bookstore.service;

import com.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    //here we will write all the business logic as per requirement
    private List<Book> books = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
//        Book addedBook = books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(int id) {

        Book searchedBook = books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
        return searchedBook;
    }

    @Override
    public Book updateBookById(int id, Book book) {
        Book updatedBook = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        if (updatedBook != null) {
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setGenre(book.getGenre());
        }
        return updatedBook;
    }

    @Override
    public void deleteBookById(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
