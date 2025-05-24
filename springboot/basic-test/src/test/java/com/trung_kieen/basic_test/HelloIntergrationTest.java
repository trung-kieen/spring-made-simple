package com.trung_kieen.basic_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

/**
 * HelloIntergrationTest
 *
 * Load entire application context
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
/*
 * Because application context is load
 * Must explicit config for mock mvc even application context already init
 */
@AutoConfigureMockMvc
public class HelloIntergrationTest {


  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldGreetName_sayHello() throws Exception {
    mockMvc.perform(get("/api/hello")
        .param("name", "My"))
        .andExpect(status().isOk())
      .andExpect(jsonPath("greeting").value("Hello My"));
  }

  @Test
  void shouldGreetDefaultName_sayHello() throws Exception {
    mockMvc.perform(get("/api/hello"))
        .andExpect(status().isOk())
      .andExpect(jsonPath("greeting").value("Hello World"));
  }
}
