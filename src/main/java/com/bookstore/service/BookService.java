package com.bookstore.service;

import com.bookstore.model.Book;

import java.util.List;

public interface BookService {
   public Book addBook(Book book);

   public List <Book> getAllBooks();

   public Book getBookById(int id);

   public Book updateBookById(int id, Book book);

   public void deleteBookById(int id);
}
