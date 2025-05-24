package com.polling.polling.core.auth.userdetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.polling.polling.entity.user.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * CustomUserDetailService
 */
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDetailsMapper userDetailsMapper;

   public  UserDetails  loadUserByUsername(String username ) {
     if(!userRepository.existsByUsername(username)){
        throw new UsernameNotFoundException("username is not exist");
     }
     return userDetailsMapper.toUserDetails(userRepository.findUserByUsername(username).get());
  }
}
