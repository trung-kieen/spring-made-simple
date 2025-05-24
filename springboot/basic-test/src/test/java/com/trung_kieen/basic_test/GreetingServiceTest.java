package com.trung_kieen.basic_test;

import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * GreetingServiceTest
 */

/*
 * Help to create mock object and inject for service test
 */
@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {

  @Mock
  /*
   * Mock => Create implement to use as mock
   * To given value for main inject mock => to test many input can be and how
   * the main inject mock will return
   */
  private ApplicationProperties applicationProperties;

  /*
   * Create class instance and inject the mock dependency for it
   * => We use this class for TEST behavior
   */
  @InjectMocks
  private GreetingService greetingService;

  @BeforeEach
  void setUp() {
    // Prepare test setup given
    given(applicationProperties.getGreeting()).willReturn("Hello");
  }

  @Test
  void shouldGreetWithDefaultNameWhenNameIsNotProvided() {
    given(applicationProperties.getDefaultName()).willReturn("World");

    String greeting = greetingService.sayHello(null);
    Assertions.assertEquals(greeting, "Hello World");
  }

  @Test
  void shouldGreetingInputName_whenNameisProvided() {

    String greeting = greetingService.sayHello("My");
    Assertions.assertEquals(greeting, "Hello My");
  }


}
