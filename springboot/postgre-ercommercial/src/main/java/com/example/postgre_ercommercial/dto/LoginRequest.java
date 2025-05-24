package com.example.postgre_ercommercial.dto;

import lombok.Data;

/**
 * LoginRequest
 */
@Data
public class LoginRequest {
  private String email;
  private String password;
}
