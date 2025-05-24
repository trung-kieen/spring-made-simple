package com.polling.polling.entity.user.repository;

import java.util.Optional;

import com.polling.polling.entity.user.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // User detail service need some how to get user from database
  Optional<UserEntity> findUserByUsername(String username);

  Boolean existsByUsername(String username);

  Page<UserEntity> findAll(Pageable pageable);

  @Query(value = "SELECT count(*) FROM user u WHERE 1", nativeQuery = true)
  Long countAllUser();
  // Check if user is exist

}
