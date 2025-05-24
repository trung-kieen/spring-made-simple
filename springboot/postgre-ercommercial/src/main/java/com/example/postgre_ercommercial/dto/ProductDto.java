package com.example.postgre_ercommercial.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * ProductDto
 */
@Data
public class ProductDto {
  private String name;
  private String description;

  private BigDecimal price;

  private Integer quantity;
  private String imageUrl;

  private List <CommentDto> comments ;
}
