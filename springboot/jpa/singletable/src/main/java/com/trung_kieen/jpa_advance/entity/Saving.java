package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

/**
 * Saving
 */
@Entity
@DiscriminatorValue(value = "2")
public class Saving extends Account {
  public Saving(double balance, double interest) {
    super(balance);
    this.interest = interest;
  }

  private double interest;
}
