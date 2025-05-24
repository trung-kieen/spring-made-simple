package com.trung_kieen.test_with_junit;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * UserControllerTest
 */
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UserService userService;

  @Autowired
  private ObjectMapper objectMapper;

  private List<User> userList;
  private User user1;

  @BeforeEach
  void setUp() {

    userList = new ArrayList<>();
    userList.add(new User(1L, "abc@gmail.com", "secret", "kai"));
    userList.add(new User(2L, "bcd@gmail.com", "secret123", "kaito"));
    userList.add(new User(3L, "bcde@gmail.com", "secret1234", "kaito k"));
    objectMapper.registerModule(new ProblemModule());
    objectMapper.registerModule(new ConstraintViolationProblemModule());
  }

  @Test
  void shouldFetchAllUser() throws Exception {
    given(userService.findAllUsers()).willReturn(userList);
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(userList.size())));

  }

  @Test
  void shouldFindOneUser() throws Exception {
    int checkIdx = 1;
    User user1 = userList.get(checkIdx);

    given(userService.findUserById(user1.getId())).willReturn(Optional.of(user1));

    // Use param for filter search and {id} for path variable
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{id}", String.valueOf(user1.getId())))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(user1.getEmail()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(user1.getName()));

  }
}
