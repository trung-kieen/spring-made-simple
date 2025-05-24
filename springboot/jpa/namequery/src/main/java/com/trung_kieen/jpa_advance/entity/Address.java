package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address
 */


/*
 * Practice
 * Create addresss field and emmbed in other entity
 *
 */
@AllArgsConstructor
@Embeddable
public class Address {

  // Access with protected modified
  protected Address() {
  }

  private String addressLine1;
  private String addressLine2;
  private String city;

}
