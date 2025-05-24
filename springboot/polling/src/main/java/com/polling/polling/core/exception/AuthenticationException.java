package com.polling.polling.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AuthenticationException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AuthenticationException extends ApplicationException {
  public static final long serialVersionUID = 1;
  public AuthenticationException(String message ){
    super(message);
  }

}
