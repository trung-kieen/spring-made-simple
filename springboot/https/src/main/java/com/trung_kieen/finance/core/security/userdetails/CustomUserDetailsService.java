package com.trung_kieen.finance.core.security.userdetails;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trung_kieen.finance.app.user.repository.AppUserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * CustomUserDetailService
 */
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private AppUserRepository userRepository;

  @Autowired
  private UserDetailsMapper userDetailsMapper;

  public UserDetails loadUserByUsername(String username) {
    var user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("username is not exist"));
    return userDetailsMapper.toUserDetails(user);
  }
}
