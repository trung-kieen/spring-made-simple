package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Saving
 */
@Entity
public class Saving extends Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  public Saving(double balance, double interest) {
    super(balance);
    this.interest = interest;
  }

  private double interest;
}
