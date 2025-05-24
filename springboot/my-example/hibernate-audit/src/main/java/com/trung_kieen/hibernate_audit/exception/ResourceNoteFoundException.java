package com.trung_kieen.hibernate_audit.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNoteFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNoteFoundException extends RuntimeException {

  private final String resourceName;
  private final String resourceField;
  private final Object fieldValue;

  @Autowired
  public ResourceNoteFoundException(final String resourceName, final String resourceField, final Object fieldValue) {
    super(String.format("%s not found with field %s = %s", resourceName, resourceField, fieldValue));
    this.resourceName = resourceName;
    this.resourceField = resourceField;
    this.fieldValue = fieldValue;
  }

}
