package com.trung_kieen.demo_sql;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Comment
 */

@AllArgsConstructor
@RequiredArgsConstructor
@Table
@Entity
public class Comment {

  @Id
  @GeneratedValue
  private Long id;

  private String content;



}
