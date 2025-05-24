package com.example.the_open_book.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.the_open_book.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * CustomUserDetailService
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  public UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
    // User email a claims for extract user
    var user = userRepository.findByEmail(userEmail).orElseThrow(() -> {
      throw new UsernameNotFoundException("email is not valid");
    });
    return user;
  }

}
