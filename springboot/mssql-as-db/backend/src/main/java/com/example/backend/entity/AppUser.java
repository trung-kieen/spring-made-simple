package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * AppUser
 */
@Entity
public class AppUser {
  @Id
  @GeneratedValue
  private Long id;


}
