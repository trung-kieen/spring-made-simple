package com.trung_kieen.finance.core.security.userdetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.trung_kieen.finance.app.role.model.Role;
import com.trung_kieen.finance.app.user.model.AppUser;


/**
 * UserDetailsMapper
 */

@Component
public class UserDetailsMapper {


  public UserDetails toUserDetails(AppUser userEntity) {
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
