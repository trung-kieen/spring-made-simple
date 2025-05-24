package com.polling.polling.core.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.polling.polling.web.payload.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * HandleWebException
 */
@Slf4j
@RestControllerAdvice
public class HandleWebException extends ResponseEntityExceptionHandler {

  @Value("${web.trace:false}")
  private Boolean printStackTrace;

  @ExceptionHandler( value = { NoSuchElementFoundException.class })
  public ErrorResponse handleNoSuchElementFound(NoSuchElementFoundException ex,
                                                 HttpHeaders header,
                                                 HttpStatus status,
                                                 WebRequest request) {

    return ErrorResponse.builder().message(ex.getMessage()).cause(ex.getCause().toString()).build();

  }

  @ExceptionHandler(value = { ApplicationException.class })
  public Object handleNoSuchElementFound(ApplicationException ex,
      HttpHeaders header,
      HttpStatus status,
      WebRequest request) {
    return ErrorResponse.builder().message(ex.getMessage()).cause(ex.getCause().toString()).build();
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = { Exception.class})
  public Object  handleAllUncaughtException (Exception ex, WebRequest webRequest) {
//     return Response.builder().message(ex.getMessage()).cause(ex.getCause().toString()).build();
    return ErrorResponse.builder().message(ex.getMessage()).cause(ex.getCause().toString()).build();
  }

}
