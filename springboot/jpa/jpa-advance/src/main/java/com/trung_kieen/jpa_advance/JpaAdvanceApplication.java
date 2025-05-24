package com.trung_kieen.jpa_advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trung_kieen.jpa_advance.entity.FullTimeEmployee;
import com.trung_kieen.jpa_advance.repository.CourseRepository;
import com.trung_kieen.jpa_advance.repository.FullTimeEmployeeRepository;
import com.trung_kieen.jpa_advance.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaAdvanceApplication implements CommandLineRunner {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final CourseRepository courseRepository;
  private final StudentRepository studentRepository;
  @Autowired
  private EntityManager em;

  private final FullTimeEmployeeRepository fRepository;

  public static void main(String[] args) {
    SpringApplication.run(JpaAdvanceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    // var course = courseRepository.findById(2l);
    // var course1 = courseRepository.findById(3l);

    // // Save a student tie to a course
    // var student = new Student(100L, "BOB", null, course.get());
    // studentRepository.save(student);
    // var getStudent = studentRepository.findById(100L);

    // var courseHaveStudent = courseRepository.findById(2l).get();
    // // var studentsTiesToCourse = courseHaveStudent.getStudents();

    var students = studentRepository.findAll();
    var p =  students.get(0).getPassport();
    // var passport = students.get(2).getPassport();

    // var full_em_1 = new FullTimeEmployee(1l, "Jame", 1000);
    // var courses = courseRepository.getAllCourses();
    // var test = courses;

  }

}
