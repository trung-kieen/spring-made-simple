package com.trung_kieen.jpa_advance.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Course
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")
@SQLDelete(sql = "update course set is_deleted  = true where id=?")

/*
 * None navtive query will base on JPQL when course is Entity name and isDeleted
 * is field name of model
 * Course.getAllCourses with have the prefix is Course to specify which class
 * type return
 * SELECT c FROM course c define return object return from query in syntax of
 * JPQL
 * Ref: https://www.youtube.com/watch?v=D4mmF2Kz14s&list=PLGTrAf5-F1YLNgq_0TXd9Xu245dJxqJMr&index=48
 */
@NamedQuery(name = "Course.getAllCourses", query = "SELECT c FROM course c WHERE c.isDeleted = false")

public class Course {

  /*
   * id ,
   * name nullable
   * toMany relationship with reviews => mapping them
   * toMany relationship with studens
   * create field to track create and modified date field
   * soft deleet field
   */

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "course")
  private List<Review> reviews = new ArrayList<>();

  @OneToMany(mappedBy = "course")
  private List<Student> students = new ArrayList<>();

  @Column(columnDefinition = "boolean default false", name = "is_deleted")
  private boolean isDeleted;

  @LastModifiedDate
  @Column(name = "last_modified")

  private LocalDateTime lastModified;

  @CreationTimestamp
  @Column(name = "create_at")
  private LocalDateTime createAt;

  /* Action to do before entity state change to Removed
   * Take a look at entity state
   * Ref: https://youtu.be/j6MHydQrXoE?si=q5RrfyZ9eCK2UKcc
   */
  @PreRemove
  private void PreRemoved() {
    isDeleted = true;
  }

}
