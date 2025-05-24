package com.trung_kieen.h2_with_hibernate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Customer
 */
@Entity
@Table
@Setter
@AllArgsConstructor
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  private String firstname;
  private String lastname;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST)
  private Address address;

  public Customer(String firstname, String lastname, Address address) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
  }

  public Customer(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }


}
