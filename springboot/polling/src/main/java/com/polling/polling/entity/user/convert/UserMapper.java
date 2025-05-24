package com.polling.polling.entity.user.convert;

import java.util.Arrays;

import com.polling.polling.entity.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.polling.polling.core.converter.BaseMapper;
import com.polling.polling.core.enums.RoleType;
import com.polling.polling.entity.user.role.repository.RoleRepository;
import com.polling.polling.web.payload.controller.request.RegisterDto;

/**
 * UserMapper
 */
@Component
public class UserMapper extends BaseMapper<UserEntity> {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  public UserEntity getEntity(RegisterDto registerDto) {
    encodePassword(registerDto);

    var rolesUserOnly = Arrays.asList(roleRepository.findByName(RoleType.USER).get());
    return com.polling.polling.entity.user.model.UserEntity.builder()
      .username(registerDto.getUsername())
      .password(encodePassword(registerDto.getUsername()))
      .email(registerDto.getEmail())
      .roles(rolesUserOnly).build();

    //return modelMapper.map(RegisterDto.class, User.class);

  }

  private void encodePassword (RegisterDto registerDto){
    registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
  }

  private String  encodePassword (String rawPassword){
    return passwordEncoder.encode(rawPassword);
  }



}
