package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * PartTimeEmployee
 */

@Entity
@DiscriminatorValue(value = "PART_TIME")
public class PartTimeEmployee extends Employee {

  private Integer hourlyRate;

  public PartTimeEmployee(Long id, String name, Integer hourlyRate) {
    super(id, name);
    this.hourlyRate = hourlyRate;
  }

}
