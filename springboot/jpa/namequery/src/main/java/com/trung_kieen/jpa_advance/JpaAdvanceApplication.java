package com.trung_kieen.jpa_advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trung_kieen.jpa_advance.repository.CourseRepository;
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


  public static void main(String[] args) {
    SpringApplication.run(JpaAdvanceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    var courses = courseRepository.getAllCourses();

  }

}
