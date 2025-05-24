package com.example.postgre_ercommercial.dto;

import java.util.List;

import com.example.postgre_ercommercial.model.CartItem;

import lombok.Data;

/**
 * CartDto
 */
@Data
public class CartDto {
  private Long id ;
  private Long userId;
  private List<CartItem> items;

}
