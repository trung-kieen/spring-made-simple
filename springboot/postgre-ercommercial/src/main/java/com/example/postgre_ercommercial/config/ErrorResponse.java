package com.example.postgre_ercommercial.config;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * ErrorResponse
 */
@Data
@Builder
public class ErrorResponse {

  private String message;
  private String error;
  private int status;

}
