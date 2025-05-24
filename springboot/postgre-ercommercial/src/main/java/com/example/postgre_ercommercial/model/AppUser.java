package com.example.postgre_ercommercial.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@AllArgsConstructor
@Data
@Entity
@Builder
@NoArgsConstructor
public class AppUser implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email(message = "email is not valid")
  private String email;
  @Size(min = 6, message = "password must at least 6 character length")
  private String password;

  @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private List<Cart> carts;

  @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
  private List<Order> orders;



  @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST })
  private List<Comment> comments;

  @Min(value = 2, message = "username must at least 2 characters length")
  private String username;


  public enum Role {
    ROLE_USER, ROLE_ADMIN
  }
  private Role  role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    var userRole = new SimpleGrantedAuthority(Role.ROLE_USER.toString());
    return java.util.Set.of(userRole);
  }

  @Override
  public String getUsername() {
    return username;
  }
}
