package com.polling.polling.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polling.polling.core.auth.jwt.JwtService;
import com.polling.polling.core.auth.userdetails.AuthenticationService;
import com.polling.polling.entity.user.service.UserService;
import com.polling.polling.web.payload.controller.request.RegisterDto;

import jakarta.validation.Valid;

/**
 * AuthController
 */
@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {
  @Autowired
  private UserService userService;

  @Autowired
  private JwtService jwtService;

  @Autowired
  AuthenticationService authenticationService;


  @GetMapping("test")
  public ResponseEntity<?> test() {
    return ResponseEntity.ok("Does this is test controller for autentication");
  }
  @PostMapping("test")
  public ResponseEntity<?> testPostRequest() {
    return ResponseEntity.ok("Does this is test controller for autentication from post request");
  }

  @PostMapping("register")
  public ResponseEntity<?> register ( @RequestBody @Valid RegisterDto registerDto) {
    var user = userService.register(registerDto);
    var authentication = authenticationService.getAuthenticationToken(user);
    authenticationService.setAuthenticationToken(authentication);
    var jwtToken = jwtService.generateToken(authentication);

     return  ResponseEntity.ok(jwtToken);

  }
}
