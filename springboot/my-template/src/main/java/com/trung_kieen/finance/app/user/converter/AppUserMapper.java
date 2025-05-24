package com.trung_kieen.finance.app.user.converter;

import com.trung_kieen.finance.app.role.model.Role;
import com.trung_kieen.finance.app.role.repository.RoleRepository;
import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.app.web.payload.auth.RegisterDto;
import com.trung_kieen.finance.core.enums.role.RoleName;
import org.apache.catalina.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

/**
 * AppUserMapper
 */

@Service
public class AppUserMapper {

  private static final Logger logger = LoggerFactory.getLogger(AppUserMapper.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    /**
     * Convert register information to actual jpa entity
     * User is not verified and need to active via email
     */
    public AppUser toAppUser(RegisterDto registerDto){
        var roleUser  = roleRepository.findByName(RoleName.USER).get();
        var requireVerified = true;
        var roles = Collections.singletonList(roleUser);
        var password = passwordEncoder.encode(registerDto.password());

        //var user = new AppUser(registerDto.username(), password,registerDto.email(), roles,!requireVerified );
//        var user = new AppUser();
//        user.setUsername(registerDto.username());
//        user.setPassword(password);
//        user.setEmail(registerDto.email());
//        user.setRoles(roles);
//        user.setVerified(!requireVerified);

        //var user = new AppUser(registerDto.username(), password,registerDto.email(), roles,!requireVerified );
        var user =(AppUser) AppUser.builder()
                .username(registerDto.username())
                .password(password)
                .email(registerDto.email())
                .roles(roles)
                .verified(!requireVerified)
                .build();
        System.out.println(user.toString());
        return user;
    }


}
