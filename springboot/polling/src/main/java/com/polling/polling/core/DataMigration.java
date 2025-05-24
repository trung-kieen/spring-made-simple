package com.polling.polling.core;

import java.util.Collections;
import java.util.List;

import com.polling.polling.entity.user.model.UserEntity;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.polling.polling.core.enums.RoleType;
import com.polling.polling.entity.user.role.model.Role;
import com.polling.polling.entity.user.role.repository.RoleRepository;
import com.polling.polling.entity.user.repository.UserRepository;

/**
 * DataMigration
 */
@Component

public class DataMigration {
  private static final Logger logger = LoggerFactory.getLogger(DataMigration.class);

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Bean
  public CommandLineRunner runner() {
    return (args) -> {
      //feedData();
      //findByPaginate();
    };
  }

  public void findByPaginate() {
    System.out.println("========================================" );
    System.out.println("Search for page of users sample value" );
    var pageable = PageRequest.of(2, 10);
    userRepository.findAll(pageable).forEach(System.out::println);
    System.out.println("========================================" );
  }

  public void feedData() {

    System.out.println("========================================");
    System.out.println("FEEDDING DATA...");
    for (int i = 0; i < 50; i++) {
      try {
        Faker f = new Faker();
        var roleUser = roleRepository.findByName(RoleType.USER).get();
        if (roleUser != null) {
          System.out.println(roleUser.toString());
        }
        List<Role> roles = Collections.singletonList(roleUser);

        userRepository.save(UserEntity.builder()
            .id((long) i)
            .username(f.funnyName().name())
            .password(f.country().capital() + f.number().randomNumber())
            .email(f.name().username() + "@gmail.com")
            .roles(roles)
            .build());
      } catch (Exception ex) {
          logger.error("Could not add sample data", ex.getCause());
      }
    }

    System.out.println("========================================");
  }

}
