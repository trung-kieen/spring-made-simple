package com.example.postgre_ercommercial.model;

/**
 * Role
 */
public enum Role {

  ROLE_ADMIN("ROLE_ADMIN"),
  ROLE_USER("ROLE_ADMIN");
  String roleValue;

  private Role(String rolevalue) {
    this.roleValue = roleValue;
  }
}
