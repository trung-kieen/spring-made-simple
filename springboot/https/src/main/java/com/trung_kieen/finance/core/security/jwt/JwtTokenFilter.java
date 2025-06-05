package com.trung_kieen.finance.core.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.javafaker.File;
import com.sun.net.httpserver.Filter;
import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.core.security.auth.AuthenticationService;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JwtTokenFilter
 * Implement parsing & validating JWT, loading User details (using UserDetailsService), checking Authorizaion
 */

@Component
@Slf4j // For logging
@RequiredArgsConstructor
// Filter as inceptor for token
public class JwtTokenFilter extends OncePerRequestFilter {
  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private JwtService jwtService;

  final String TOKEN_PREFIX = "Bearer ";


  public void doFilterInternal(@NotNull HttpServletRequest request,
      @NotNull HttpServletResponse response,
      @NotNull FilterChain filterChain)
      throws IOException, ServletException {
    try {
      final String requestHeader = request.getHeader("Authorization");
      Boolean validHeader = !StringUtil.isNullOrEmpty(requestHeader) && requestHeader.startsWith(TOKEN_PREFIX);

      if (validHeader) {
        // Extract token from header
        final String jwt = requestHeader.substring(TOKEN_PREFIX.length());
        final String username = jwtService.extractUsername(jwt);

        if (StringUtil.notNullNorEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
          var user = userDetailsService.loadUserByUsername(username);
          if (jwtService.isValidToken(jwt, user)) {
            setContext(user, request);
          }
        }
      }

    } catch (Exception ex) {
      logger.error("Unable to set user authentication into SecurityContextHolder: {}", ex);
    }

    filterChain.doFilter(request, response);
    return;

  }

  private void setContext(UserDetails user, HttpServletRequest request) {
    var context = SecurityContextHolder.createEmptyContext();
    var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    // Convert request raw http to java class
    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    context.setAuthentication(auth);
  }

}
