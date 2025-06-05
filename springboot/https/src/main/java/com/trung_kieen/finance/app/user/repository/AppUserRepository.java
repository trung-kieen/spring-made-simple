package com.trung_kieen.finance.app.user.repository;

import java.lang.reflect.Field;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trung_kieen.finance.app.user.model.AppUser;

/**
 * AppUserRepository
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

  Optional<AppUser> findByUsername(String username);

  Boolean existsByUsername(String username);

  Page<AppUser> findAll(Pageable pageable);

  @Query("UPDATE user u SET u.verified = true WHERE u.username = ?1")
  int verifiedUser(String username);

}
