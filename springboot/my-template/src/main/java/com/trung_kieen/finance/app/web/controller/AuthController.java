package com.trung_kieen.finance.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trung_kieen.finance.app.web.payload.auth.JwtTokenResponse;
import com.trung_kieen.finance.app.web.payload.auth.LoginDto;
import com.trung_kieen.finance.app.web.payload.auth.RegisterDto;
import com.trung_kieen.finance.core.constant.EndpointConstant;
import com.trung_kieen.finance.core.security.auth.AuthenticationService;

import jakarta.validation.Valid;

/**
 * AuthController use for authentication and authorization: verify email,
 * login, register
 *
 */
@RestController
@RequestMapping(EndpointConstant.AUTH)
public class AuthController {

  private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("register")
  public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
    logger.info("Auth");
    authenticationService.register(registerDto);
    return ResponseEntity.ok("Please, check your email for to complete your registration");
  }

  @GetMapping(EndpointConstant.AUTH_EMAIL_VERIFIED_SUFFIX)
  public ResponseEntity<?> verifyEmail(
      @RequestParam(EndpointConstant.AUTH_EMAIL_REQUEST_CODE_PARAM) String encodedToken) {
    authenticationService.verify(encodedToken);
    return ResponseEntity.ok("Registration sucessful. Now you can login to your account");
  }

  @PostMapping("signin")
  public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
    var bearToken = authenticationService.verifyLogin(loginDto);
    return ResponseEntity.ok(new JwtTokenResponse(bearToken));
  }

}
