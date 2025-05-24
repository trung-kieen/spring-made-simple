package com.trung_kieen.finance.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.trung_kieen.finance.core.security.jwt.JwtAuthEntryPoint;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
// TODO:
public class SecurityConfig {
  @Autowired
  private JwtAuthEntryPoint jwtAuthEntryPoint;

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailService();

  }

  private final String[] WHILTELIST_MATCHER = {
      "/", "/api/auth/**", "/error"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> {
          csrf.disable();
        })
        .authorizeHttpRequests(request -> {
          request.requestMatchers(WHILTELIST_MATCHER).permitAll();
          request.anyRequest().authenticated();
        })

        // https secure
        .requiresChannel(chanel -> {
          // Choose specific endpoint to secure with https here
          final String[] SECURE_ENDPOINT_LIST = { "/ssl-test" };
          chanel.requestMatchers("/user/**").requiresSecure();
          chanel.requestMatchers(SECURE_ENDPOINT_LIST).requiresSecure();
        })

        // Custom entry point here for jwt
        .exceptionHandling(except -> {
          except.authenticationEntryPoint(jwtAuthEntryPoint);
        })
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider())

        .formLogin(login -> {
          login.defaultSuccessUrl("/");
        })

        /*
         * Authentication token before servlet
         * Custom filter add before any filter we know, the order
         * sometimes doesn't matter and we know that we authorize
         * http request in the filter chain method => add custom
         * filter like jwt before that filter
         * After filter chain go throw we build this request to pass
         * into controller
         */
        .addFilterBefore(new JwtTokenFilter(), AuthorizationFilter.class)
        // .addFilterBefore(new VerbotenFitler(), AuthorizationFilter.class)
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    var provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }


}
