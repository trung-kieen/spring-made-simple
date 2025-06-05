package com.trung_kieen.finance.app.role.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.trung_kieen.finance.core.enums.role.RoleName;
import com.trung_kieen.finance.core.generic.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Role
 */
@Entity(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role")
public class Role extends BaseEntity<Role> {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;


  @Enumerated(EnumType.STRING)
  @Column(unique = true)
  private RoleName name;


  private String string;

  public GrantedAuthority getAuthority() {
    return new SimpleGrantedAuthority(name.toString());
  }
}
