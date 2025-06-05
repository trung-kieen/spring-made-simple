package com.trung_kieen.finance.app.web.payload.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * TokenResponse
 */
public record JwtTokenResponse(
    @NotBlank String token
) {
}
