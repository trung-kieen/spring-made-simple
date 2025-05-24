package com.polling.polling.core.auth.userdetails;

import com.polling.polling.entity.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * AuthenticationService
 */
@Service
public class AuthenticationService {

  @Autowired
  private UserDetailsService customUserDetailService;

  public Authentication getAuthenticationToken(UserEntity userEntity) {
    var userDetail = customUserDetailService.loadUserByUsername(userEntity.getUsername());
    return new UsernamePasswordAuthenticationToken(userDetail.getUsername(), null, userDetail.getAuthorities());
  }

  public void setAuthenticationToken(Authentication authentication) {
    var context = SecurityContextHolder.createEmptyContext();
    context.setAuthentication(authentication);
    SecurityContextHolder.setContext(context);
  }

}
