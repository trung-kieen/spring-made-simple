package com.trung_kieen.test_with_junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * UserServiceTest
 */

public class UserServiceTest {


  @InjectMocks
  private UserService userService;


  @Mock
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    /*
     * What mockito magic does in nothing but create mock repository
     * Then inject in the service constructor
     */
  }

  @Test
  void shouldSavedUserSuccessfull() {
    User user = new User(null, "myemail@gmail.com", "123456", "kai");
    // Given how mock repo will perform
    given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());

    /*
     * Stubborn instead of hiting actually database call
     * It will return the first argument when it be call as return instead of
     * perfrom action
     */
    given(userRepository.save(user)).willAnswer(invocation -> invocation.getArgument(0));

    User savedUser = userService.createUser(user);
    Assertions.assertThat(savedUser).isNotNull();

    // Make sure user will be save via mock repo
    verify(userRepository).save(any(User.class));
  }

  @Test
  void shouldThrowWhenExistedEmail_createdUser() {

    User user = new User(null, "myemail@gmail.com", "123456", "kai");
    given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.of(user));

    assertThrows(RuntimeException.class, () -> userService.createUser(user));


    // Make sure repo will not save invalid user
    verify(userRepository, never()).save(any(User.class));
  }

}
