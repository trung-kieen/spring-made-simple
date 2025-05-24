package com.trung_kieen.h2_with_hibernate;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Post
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  @Id
  @GeneratedValue
  private Long id;

  @OneToMany(mappedBy = "post")
  private List<PostComment> postComments;
}
