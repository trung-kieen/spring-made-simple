package com.example.postgre_ercommercial.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * OrderItemDto
 */
@Data
public class OrderItemDto {
  private Integer quantity;
  private Long productId;
  private BigDecimal price;


}
