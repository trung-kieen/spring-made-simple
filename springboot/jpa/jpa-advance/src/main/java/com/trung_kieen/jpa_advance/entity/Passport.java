package com.trung_kieen.jpa_advance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Passport
 */
@Entity(name = "passport")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passport {
  @Id
  @GeneratedValue
  private Long id;

  private String number;

  /*
   * mappedBy passport make in student have passport_id  column integrate with this class
   * OneToOne need to declare in Student class the field of passport
   */
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
  private Student student;

}
