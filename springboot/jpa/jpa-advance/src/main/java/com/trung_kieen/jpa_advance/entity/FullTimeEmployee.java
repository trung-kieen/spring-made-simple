package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * FullTimeEmployee
 */

@Entity
@DiscriminatorValue(value = "FULL_TIME")
public class FullTimeEmployee extends Employee {

  public FullTimeEmployee(Long id, String name, Integer salary) {
    super(id, name);
    this.salary = salary;
  }

  private Integer salary;

}
