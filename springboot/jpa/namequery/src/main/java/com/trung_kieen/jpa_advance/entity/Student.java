package com.trung_kieen.jpa_advance.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student
 */
@Entity
@Data
@NoArgsConstructor
public class Student {

  public Student(Long id, String name, Address address, Course course) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.course = course;
  }

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  private String name;

  @Embedded
  private Address address;

  @ManyToOne
  private Course course; // Now let assume that student just enrole one class

}
