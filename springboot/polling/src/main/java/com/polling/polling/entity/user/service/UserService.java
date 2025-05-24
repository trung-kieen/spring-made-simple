package com.polling.polling.entity.user.service;

import com.polling.polling.entity.user.convert.UserMapper;
import com.polling.polling.entity.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polling.polling.core.exception.AuthenticationException;
import com.polling.polling.entity.user.repository.UserRepository;
import com.polling.polling.web.payload.controller.request.RegisterDto;

/**
 * UserService
 */

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRepository userRepository;

  public UserEntity register(RegisterDto registerDto) {
    if (userRepository.existsByUsername(registerDto.getUsername())) {
      throw new AuthenticationException("Username is taken");
    }
    var user = userMapper.getEntity(registerDto);
    userRepository.save(user);

    return user;

  }

}
