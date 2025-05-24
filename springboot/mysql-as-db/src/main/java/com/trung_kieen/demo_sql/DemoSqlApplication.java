package com.trung_kieen.demo_sql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSqlApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DemoSqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var books= new Book(1L, "Spring" );
    books.getComments().add(new Comment(2L, "Content"));
  }

}
