package com.example.the_open_book.payload.request;

import com.example.the_open_book.user.User;

/**
 * BookRequest
 */
public record BookRequest (

  String title,

  String authorName,

  String isbn,

  String synopsis,

  String bookCover,


  // Get from security context
  User owner


) {


}
