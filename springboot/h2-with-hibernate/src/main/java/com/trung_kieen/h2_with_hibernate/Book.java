package com.trung_kieen.h2_with_hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Book
 */
@Entity(name = "books")
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "getAllBooks", query = "Select b from BOOK b")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column private Long id;

  private String title;

  private String author;


  @OneToOne(mappedBy = "book")
  @PrimaryKeyJoinColumn
  private BookDetail bookDetail;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }




}
