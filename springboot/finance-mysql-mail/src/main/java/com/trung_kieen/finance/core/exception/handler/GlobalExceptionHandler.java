package com.trung_kieen.finance.core.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  // TODO: return appropriate status for each type of exception

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
  @ExceptionHandler({ Exception.class })

  public ResponseEntity<?> handleIllegalState(Exception  ex) {

    logger.debug(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Server error");
  }

}
