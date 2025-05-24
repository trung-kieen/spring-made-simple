package com.polling.polling.entity.user.model;

import java.util.List;

import com.polling.polling.entity.user.role.model.Role;

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
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Use as claim
  @NotBlank(message = "Username must not blank")
  @Column(unique = true)
  private String username;

  // @Email
  //@Column(unique = true)
  private String email;

  @NotBlank(message = "Password must not blank")
  // Encode password
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user", referencedColumnName = "id"))
  private List<Role> roles;
  // TODO: soft delete, audit object

  @Column(columnDefinition = "boolean default false")
  private Boolean vertified;

  public String getUsername() {
    return username;
  }


}
