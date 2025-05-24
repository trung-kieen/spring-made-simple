package com.trung_kieen.hibernate_audit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNoteFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNoteFoundException extends RuntimeException {

  private String resourceName;
  private String resourceField;
  private Object fieldValue;

  public ResourceNoteFoundException(String resourceName, String resourceField, Object fieldValue) {
    super(String.format("%s not found with field %s = %s", resourceName, resourceField, fieldValue));
    this.resourceName = resourceName;
    this.resourceField = resourceField;
    this.fieldValue = fieldValue;
  }

}
