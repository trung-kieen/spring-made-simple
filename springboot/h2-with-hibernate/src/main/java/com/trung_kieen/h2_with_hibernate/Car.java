package com.trung_kieen.h2_with_hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Car
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Car {
  @Id
  @GeneratedValue
  private Long id;
  private String model;

  private String color;

  @ManyToMany(mappedBy = "cars")
  private List<Person> people;
}
