package com.example.the_open_book.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.the_open_book.book.Book;
import com.example.the_open_book.book.BookRepository;
import com.example.the_open_book.mapper.BookMapper;
import com.example.the_open_book.payload.request.BookRequest;
import com.example.the_open_book.service.BookService;
import com.example.the_open_book.user.User;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * BookServiceImpl
 */


@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookMapper bookMapper;
  @Autowired
  private BookRepository bookRepository;
  public Book save(BookRequest bookRequest, User user){
    Book  book = bookMapper.toEntity(bookRequest);
    book.setOwner(user);
    bookRepository.save(book);
    return book;
  }



}
