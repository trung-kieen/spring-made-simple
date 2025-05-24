package com.trung_kieen.bean_play_around;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanPlayAroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanPlayAroundApplication.class, args);
    try {
      var context  = new AnnotationConfigApplicationContext(AppBeanConfig.class);
      var student = (Student) context.getBean(Student.class);

      var student2 = (Student) context.getBean(Student.class);
      System.out.println(student);
      System.out.println(student2);


    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    }
	}

}
