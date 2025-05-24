package com.trung_kieen.h2_with_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class H2WithHiberateApplication implements CommandLineRunner {
  @Autowired
  private EntityManager entityManager;

  public static void main(String[] args) {
    SpringApplication.run(H2WithHiberateApplication.class, args);
  }

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    var address = new Address("SLSDJF", "JLKASjd");
    var c = new Customer("HI", "HIO");
    c.setAddress(address);
    entityManager.persist(c);
    // entityManager.persist(address);
  }

}
