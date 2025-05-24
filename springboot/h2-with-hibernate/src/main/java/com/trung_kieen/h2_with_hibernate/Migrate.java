package com.trung_kieen.h2_with_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Migrate
 */
@Component
public class Migrate {

  @Autowired
  private BookRepository bookRepository;

  @Bean
  public CommandLineRunner migreateDate() {
    return (args) -> {
      System.out.println("HI");
      var book = new Book("HI", "HELLO");
      bookRepository.save(book);

      var searchBook = bookRepository.findByTitle("HI");
      System.out.println(searchBook.get());

    };

  }

}
