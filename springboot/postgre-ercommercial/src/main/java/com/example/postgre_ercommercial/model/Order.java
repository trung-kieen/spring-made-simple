package com.example.postgre_ercommercial.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 */
@AllArgsConstructor
@Data
@Entity
@Builder
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id ;

  @ManyToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private AppUser  user;

  @NotBlank
  private String address;

  @Column(name = "phone_number")
  @NotBlank
  private String phoneNumber;

  public enum OrderStatus{
    PREPARING, DELIVERING, DELIVERED, CANCELED

  }
  // TODO Enum
  @NotBlank
  private String status ;


  @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
  private List<OrderItem> orderItem;

}
