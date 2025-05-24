package com.trung_kieen.jpa_advance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trung_kieen.jpa_advance.repository.CourseRepository;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
class JpaAdvanceApplicationTests {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private EntityManager entityManager;

  @Test
  void contextLoads() {

  }

  @Test
  public void initCourseById() {
    var course = courseRepository.findById(1l).get();
    assertEquals(course.getName(), "Jpa for beginner");

    var course2 = courseRepository.findById(2l).get();
    assertEquals(course2.getName(), "Jpa for beginner");

    var course3 = courseRepository.findById(3l).get();
    assertEquals(course3.getName(), "LKAjda");

    // Spring in 50 Steps
  }

  @Test
  public void deleteCourse_basic() {
    courseRepository.deleteById(2L);
    assertNull(courseRepository.findById(2l));
  }

  @DirtiesContext
  @Test
  public void saveCourseAndUpdateCourse_basic() {

    var inputCourseName = "API design";
    // courseRepository.save(new Course(id, name, reviews, students, isDeleted, lastModified, createAt));
    var courseName1 = courseRepository.findById(10L);
    assertEquals(courseName1, inputCourseName);

  }


}
