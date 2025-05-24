package com.example.postgre_ercommercial.model;

import java.nio.channels.Pipe;
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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CartItem
 */

@AllArgsConstructor
@Data
@Entity
@Builder
@NoArgsConstructor
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cart_id", referencedColumnName = "id")
  private Cart cart;


  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;


  @NotNull(message = "quantity must not be empty")
  @Column(columnDefinition = "int default 0")
  private Integer quantity;

}
