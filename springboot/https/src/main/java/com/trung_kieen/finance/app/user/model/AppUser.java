package com.trung_kieen.finance.app.user.model;

import java.util.List;

import com.trung_kieen.finance.app.role.model.Role;
import com.trung_kieen.finance.core.generic.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * User
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class AppUser extends BaseEntity<AppUser> {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;


  // Use as claim
  @NotBlank(message = "Username must not blank")
  @Column(unique = true)
  private String username;

  @Column(unique = true)
  private String email;

  @NotBlank(message = "Password must not blank")
  @Column
  // Encode password
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Column
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user", referencedColumnName = "id"))
  private List<Role> roles;

  @Column(columnDefinition = "boolean default false")
  private Boolean verified;


//  public AppUser(String username,String password, String email, List<Role> roles, Boolean verified){
//    this.username = username;
//    this.password = password;
//    this.email = email;
//    this.roles = roles;
//    this.verified = verified;
//  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public String getUsername() {
    return username;
  }

  public Boolean isVerified() {
    return verified;
  }
}
