package com.trung_kieen.finance.core.app.user.model;

import java.util.Set;

import com.trung_kieen.finance.core.app.role.model.Role;
import com.trung_kieen.finance.core.generic.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * UserEntity
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "USER")
public class UserEntity extends BaseEntity<UserEntity> {

  @Column(unique = true)
  // TODO: Make constraint unique
  private String username;
  @NotBlank
  private String password;

  @NotBlank
  private String email;

  @ManyToMany
  @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles;

  @Column(columnDefinition = "boolean default false" , name = "is_enabled")
  private boolean isEnable;

}
