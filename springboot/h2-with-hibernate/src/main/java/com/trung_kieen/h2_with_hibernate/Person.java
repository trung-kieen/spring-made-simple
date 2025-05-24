package com.trung_kieen.h2_with_hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToMany
  @JoinTable( name = "people_cars",
    joinColumns = @JoinColumn(name = "people_id",
      referencedColumnName = "id"),
    inverseJoinColumns =
    @JoinColumn(name = "car_id",
      referencedColumnName = "id"))
  private List<Car> cars;

}
