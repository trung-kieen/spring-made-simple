package com.polling.polling.core.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NoSuchElementFoundException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoSuchElementFoundException extends RuntimeException {
  public NoSuchElementFoundException(String message) {
    super(message);
  }

}
