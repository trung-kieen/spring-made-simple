package com.example.the_open_book.service;

import com.example.the_open_book.book.Book;
import com.example.the_open_book.payload.request.BookRequest;
import com.example.the_open_book.user.User;

/**
 * BookService
 */
public interface BookService {
  public Book save(BookRequest book, User user);

}
