package com.polling.polling.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ApplicationException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException {
  public ApplicationException(String message) {
    super(message);
  }
}
