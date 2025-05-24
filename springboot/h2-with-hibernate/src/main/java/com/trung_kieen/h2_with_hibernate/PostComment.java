package com.trung_kieen.h2_with_hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * PostComment
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Post post;
}
