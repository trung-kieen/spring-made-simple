package com.trung_kieen.jpa_advance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
class JpaAdvanceApplicationTests {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  void contextLoads() {

  }



}
