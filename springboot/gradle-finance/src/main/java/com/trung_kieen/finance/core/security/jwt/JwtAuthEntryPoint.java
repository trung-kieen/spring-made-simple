package com.trung_kieen.finance.core.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JwtAuthEntryPoint
 * Catch authentication error and return http status unauthorize
 */
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
  private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

  public void commence(HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authenticationException) throws IOException, ServletException {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
  }

}
