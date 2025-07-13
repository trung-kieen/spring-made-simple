package com.app.hexagonal_coffe_shop.business;

import java.util.UUID;

import com.app.hexagonal_coffe_shop.domain.Order;

public interface PrepareCoffee {

  // Order is ready barista start prepare the order
  void prepareOrder(UUID orderId);

  // When the order is ready baresta mark order is finish
  Order markOrderComplete(UUID orderId);
}
