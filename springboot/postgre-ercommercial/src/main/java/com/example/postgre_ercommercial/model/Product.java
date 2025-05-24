package com.example.postgre_ercommercial.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product
 */
@AllArgsConstructor
@Data
@Entity
@Builder
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
  private List<CartItem> cartItem;

  @NotBlank(message = "product name must not be empty")
  private String name;

  private String description;

  @NotNull(message = "price must not be null")
  @PositiveOrZero
  private BigDecimal price;

  @NotNull(message = "quantity must not be empty")
  @Column(columnDefinition = "int default 0")
  @PositiveOrZero
  private Integer quantity;

  @Column(name = "image_url")
  private String imageUrl ;

  @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private List<Comment> comments;


  @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST})
  private List<OrderItem>  orderItems;
}
