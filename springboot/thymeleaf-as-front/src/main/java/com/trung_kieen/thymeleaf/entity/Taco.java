package com.trung_kieen.thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * Taco
 */
@Entity
@Data
@Table
@Builder
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 5, message = "Order name must at least 5 characters long")
  private String name;

  @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be format date of MM/YY")
  private String ccExpiration;

  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  private String ccCVV;
}
