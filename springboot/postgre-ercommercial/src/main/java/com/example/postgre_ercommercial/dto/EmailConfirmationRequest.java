package com.example.postgre_ercommercial.dto;

import lombok.Data;

/**
 * EmailConfirmationRequest
 */
@Data
public class EmailConfirmationRequest {
  private String email;
  private String cofirmationCode;
}
