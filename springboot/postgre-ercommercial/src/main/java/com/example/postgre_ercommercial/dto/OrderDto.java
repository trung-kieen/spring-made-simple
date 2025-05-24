package com.example.postgre_ercommercial.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.postgre_ercommercial.model.Order.OrderStatus;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * OrderDto
 */
@Data
public class OrderDto {
  private Long userId;

  @NotBlank
  private String phoneNumber;

  // TODO Enum
  @NotBlank
  private String status ;

  private OrderStatus orderStatus;


  private LocalDateTime createAt;

  private List<OrderItemDto> orderItems;
}
