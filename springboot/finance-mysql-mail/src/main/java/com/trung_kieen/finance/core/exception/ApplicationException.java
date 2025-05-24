package com.trung_kieen.finance.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ApplicationException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException {
  public static final Logger logger = LoggerFactory.getLogger(ApplicationException.class);

  public ApplicationException(String message) {
    super(message);
    logger.error(message);
  }

  // @SuppressWarnings("unchecked")
  /**
   * Message to catch via {@link} GlobalExceptionHandler
   */
  public ApplicationException(String message, Object... objectRelateErrors) {
    super(message);
    logger.error(message);

    logger.error("Error relate to object:");
    for (Object obj: objectRelateErrors)
      logger.error(obj.toString());
  }
}
