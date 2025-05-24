package com.polling.polling.entity.user.role.repository;

import java.util.Optional;

import com.polling.polling.entity.user.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polling.polling.core.enums.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  public Optional<Role> findByName(RoleType role );

}
