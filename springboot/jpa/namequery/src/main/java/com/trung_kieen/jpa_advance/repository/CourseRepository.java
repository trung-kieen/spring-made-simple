package com.trung_kieen.jpa_advance.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trung_kieen.jpa_advance.entity.Course;

/**
 * CourseRepository
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  // Create from name query
  List<Course> getAllCourses();
}
