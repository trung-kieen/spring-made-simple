package com.polling.polling.web.payload.controller.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegisterDTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {


  @NotBlank(message = "Enter your username")
  private String username;

  @NotBlank(message = "Enter your email")
  @Email(message = "Email is not valid")
  private String email;

  @NotBlank(message = "Enter your password")
  private String password;


  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
