package com.polling.polling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.polling.polling.entity.user.repository.UserRepository;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  void contextLoads() {
  }
  @Test
  void pageableCountApplyTrueForSpecificRangeOfUser(){
    assertEquals((Long) userRepository.count(), userRepository.countAllUser());

    if (userRepository.countAllUser() > 10) {
      var page = PageRequest.of(0, 10);
      assertEquals(userRepository.findAll(page), 10);
    }

  }

}
