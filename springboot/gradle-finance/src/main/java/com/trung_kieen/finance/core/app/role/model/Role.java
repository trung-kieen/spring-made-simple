package com.trung_kieen.finance.core.app.role.model;

import com.trung_kieen.finance.core.enums.role.RoleName;
import com.trung_kieen.finance.core.generic.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Role
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ROLE")
@Entity
public class Role extends BaseEntity<Role> {
  @Enumerated(EnumType.STRING)
  private RoleName name;

}
