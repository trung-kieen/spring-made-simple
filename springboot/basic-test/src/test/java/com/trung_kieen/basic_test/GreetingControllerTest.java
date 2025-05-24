package com.trung_kieen.basic_test;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * GreetingControllerTest
 */

// Mock class for web layer
@WebMvcTest(controllers = HelloWorldController.class)
public class GreetingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private GreetingService greetingService;

  @Test
  void souldGreetSuccessfull_sayHello() throws Exception {
    given(greetingService.sayHello("My")).willReturn("Hello My");

    mockMvc.perform(get("/api/hello").param("name", "My"))
        .andExpect(status().isOk())
      .andExpect(jsonPath("greeting").value("Hello My"));

  }

}
