package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Review
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
  @Id
  @GeneratedValue
  private Long id;

  @Enumerated(EnumType.STRING)
  private ReviewRating rating;

  private String description;

  @ManyToOne
  private Course course;

}
