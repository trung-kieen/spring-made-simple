package com.trung_kieen.jpa_advance.entity;

import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;

/**
 * Employee
 */
@Entity
@AllArgsConstructor
@Inheritance
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee {

  @Id
  @GeneratedValue
  private Long id;

  private String name;


}
