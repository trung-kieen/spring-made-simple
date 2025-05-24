package com.trung_kieen.finance.core.security.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.app.user.service.AppUserService;
import com.trung_kieen.finance.app.web.controller.AuthController;
import com.trung_kieen.finance.app.web.payload.auth.JwtTokenResponse;
import com.trung_kieen.finance.app.web.payload.auth.LoginDto;
import com.trung_kieen.finance.app.web.payload.auth.RegisterDto;
import com.trung_kieen.finance.core.event.SendEmailVerificationEvent;
import com.trung_kieen.finance.core.security.jwt.JwtService;
import com.trung_kieen.finance.core.verification.VerificationToken;
import com.trung_kieen.finance.core.verification.service.VerificationService;

/**
 * AuthenticationService
 */
@Service
public class AuthenticationService {

  @Autowired
  private UserDetailsService customUserDetailService;

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AppUserService appUserService;

  @Autowired
  private VerificationService verificationService;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  /**
   * Create new user and throw exception if user information is not valid
   * save verification into database and send verification code via email
   * Email verification will provide user link direct to {@link
   * AuthController#verifyEmail(String)} endpoint with passing code token
   * Verification code is field token (type UUID) of class
   * {@link VerificationToken}
   */
  public void register(RegisterDto registerDto) {
    var user = appUserService.save(registerDto);

    // Send email
    eventPublisher.publishEvent(new SendEmailVerificationEvent(user));
  }

  public void verify(String encodedToken) {
    verificationService.verify(encodedToken);
  }

  /**
   * Get matching user
   * If user is not verified or block (many login attempt) => Throw
   * exception
   * Verify user with authentication provider (call authentication manager)
   * Get authentication token
   * Set authentication token
   */
  public String verifyLogin(LoginDto loginDto) {
    var unauthencation = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());

    /*
     * Authentication provider match with this type of token will
     * validate to decide response isAuthentication or not
     */
    var responseAuth = authManager.authenticate(unauthencation);
    setAuthenticationToken(responseAuth);

    String token = jwtService.generateToken(responseAuth);

    return token;
  }

  /**
   * Create authentication object when JWT token IS VALID just use when
   * user is trusted
   *
   * @return already authenticate `Authentication` object
   */
  public Authentication getAuthenticationToken(AppUser userEntity) {
    var userDetail = customUserDetailService.loadUserByUsername(userEntity.getUsername());

    return new UsernamePasswordAuthenticationToken(userDetail.getUsername(), null, userDetail.getAuthorities());
  }

  /**
   * Set authencation object to security context
   */
  public void setAuthenticationToken(Authentication authentication) {
    var context = SecurityContextHolder.createEmptyContext();
    context.setAuthentication(authentication);
    SecurityContextHolder.setContext(context);
  }

}
