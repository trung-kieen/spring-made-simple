package com.example.postgre_ercommercial.exception;

/**
 * BadRequest
 */

public class BadRequest extends RuntimeException {

  public BadRequest(String message) {
    super(message);
  }

  public BadRequest(Throwable throwable) {
    super(throwable);
  }

  public BadRequest(String message, Throwable throwable) {
    super(message, throwable);
  }

}
