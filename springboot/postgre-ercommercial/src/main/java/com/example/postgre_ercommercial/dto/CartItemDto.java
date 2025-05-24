package com.example.postgre_ercommercial.dto;

import java.util.List;

import com.example.postgre_ercommercial.model.Cart;
import com.example.postgre_ercommercial.model.Product;

import lombok.Data;

/**
 * CartItem
 */
@Data
public class CartItemDto {

  private Cart cart;

  private Long  productId;

  private Integer quantity;

}
