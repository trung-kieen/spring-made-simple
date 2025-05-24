package com.trung_kieen.finance.app.web.payload.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * LoginDto
 */
/**
 * LoginDto
 */
public record LoginDto(
    @NotBlank
    String username,
    @NotBlank
    String password
) {
}
