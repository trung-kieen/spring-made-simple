package com.trung_kieen.h2_with_hibernate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Address
 */
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  @Id
  @GeneratedValue
  private Long id;


  private String street;
  private String zipcode;
  @OneToOne
  private Customer customer;

  public Address(String street, String zipcode) {
    this.street = street;
    this.zipcode = zipcode;
  }

  public Address(Long id, String street, String zipcode) {
    this.id = id;
    this.street = street;
    this.zipcode = zipcode;
  }




}
