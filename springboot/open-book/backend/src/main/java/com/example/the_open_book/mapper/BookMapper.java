package com.example.the_open_book.mapper;

import com.example.the_open_book.book.Book;
import com.example.the_open_book.payload.request.BookRequest;

/**
 * BookMapper
 */
@Component
public class BookMapper {

  public Book toEntity(BookRequest bookRequest){
    return Book.builder()
      .title(bookRequest.title())
      .authorName(bookRequest.authorName())
      .isbn(bookRequest.isbn())
      .synopsis(bookRequest.synopsis())
      .bookCover(bookRequest.bookCover())
      .build();
  }


}
