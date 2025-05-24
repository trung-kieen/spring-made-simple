package com.polling.polling.core.auth;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * VerbotenFitler
 */
// Any filter must impl this interface
public class VerbotenFitler extends OncePerRequestFilter {

  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      // We define what do before and after filter
      throws ServletException, IOException {
    System.out.println("Ist das verboten?");
    var verbotenHeader = request.getHeader("x-verboten");
    if (verbotenHeader.equals("wahr")) {
      // Reject request example
      response.setStatus(HttpStatus.FORBIDDEN.value());
      response.getWriter().write("Das ist verbonten");
    }
    filterChain.doFilter(request, response);

  }

}
