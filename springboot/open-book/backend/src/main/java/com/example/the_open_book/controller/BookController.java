package com.example.the_open_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.example.the_open_book.payload.request.BookRequest;
import com.example.the_open_book.service.BookService;
import com.example.the_open_book.user.User;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


/**
 * BookController
 */
@RestController
@AllArgsConstructor

public class BookController {
  @Autowired
  private BookService bookService;

  public ResponseEntity<?> saveBook(BookRequest bookRequest){
    var currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return ResponseEntity.ok(bookService.save(bookRequest, currentUser));
  }

}
