package com.trung_kieen.finance.app.role.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trung_kieen.finance.app.role.model.Role;
import com.trung_kieen.finance.core.enums.role.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  public Optional<Role> findByName(RoleName role );
}
