package com.trung_kieen.thymeleaf;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.trung_kieen.thymeleaf.controller.HomeController;




/*
 * We can static import those package to reduce boilterplate code
 */
    //MockMvcBuilders.*
    //MockMvcRequestBuilders.*
    //MockMvcResultMatchers.*
    //MockMvcResultHandlers.*




/**
 * HomeControllerTest
 */
@RunWith(SpringRunner.class)  // Require to add dependency junit
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHomeEndpoint()  throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/home"))

      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.view().name("home"))
      .andExpect(MockMvcResultMatchers.model().attributeExists("home"))
      .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("HI")))
      .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("a nice day")));


  }
}
