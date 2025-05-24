package com.polling.polling.core.auth.userdetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.polling.polling.entity.user.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.polling.polling.entity.user.role.model.Role;


/**
 * UserDetailsMapper
 */

@Component
public class UserDetailsMapper {


  public UserDetails toUserDetails(UserEntity userEntity) {
    return  User.builder()
      .username(userEntity.getUsername())
      .password(userEntity.getPassword())
      .authorities(toAuthorities(userEntity.getRoles()))
      .build();
  }
  protected ArrayList<? extends GrantedAuthority> toAuthorities(List<Role> roles ){
    return roles.stream().map(Role::getAuthority).collect(Collectors.toCollection(ArrayList::new));
  }
}
