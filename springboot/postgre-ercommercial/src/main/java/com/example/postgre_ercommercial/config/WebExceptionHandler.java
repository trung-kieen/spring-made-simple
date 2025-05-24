package com.example.postgre_ercommercial.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.postgre_ercommercial.exception.BadRequest;

/**
 * AdviceController
 */
@RestControllerAdvice
public class WebExceptionHandler{

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadRequest.class)
  public ErrorResponse badRequest(){
    return ErrorResponse.builder()
    .message("Bad request parameter")
    .error("Bad request")
    .build();
  }


}
