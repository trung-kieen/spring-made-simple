package com.trung_kieen.demo_sql;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Book
 */
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table
public class Book {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();

  public Book(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
