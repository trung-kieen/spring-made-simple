package com.trung_kieen.jpa_advance.entity;

import org.hibernate.internal.build.AllowSysOut;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Account
 */
@Data
@NoArgsConstructor
@Entity
@Inheritance
// Use to modfied DTYPE column which is specify which type of account entity
// (account, checking, saving)
// We can use type of integer instead of string
@DiscriminatorColumn(name = "ACOUNT_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Account(double balance) {
    this.balance = balance;
  }

  private double balance;

}
