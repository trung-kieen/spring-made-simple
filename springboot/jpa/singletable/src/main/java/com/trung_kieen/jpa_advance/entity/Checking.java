package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Checking
 */
@Entity
@NoArgsConstructor
@DiscriminatorValue(value = "1")
public class Checking extends Account {

  public Checking(double balance, double limit) {
    super(balance);
    this.limit = limit;
  }

  @Column(name = "[limit]")
  private double limit;

}
