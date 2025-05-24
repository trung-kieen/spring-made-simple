package com.trung_kieen.test_with_junit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class UserRegistrationException extends RuntimeException {
  private String message;


}
