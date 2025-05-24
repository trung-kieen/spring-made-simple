package com.trung_kieen.h2_with_hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * BookDetail
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BookDetail {

  @Id
  // @GeneratedValue
  private Long id;

  private String isbn;

  @OneToOne
  private Book book;

}
