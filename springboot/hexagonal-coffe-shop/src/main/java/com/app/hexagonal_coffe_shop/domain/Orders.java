package com.app.hexagonal_coffe_shop.domain;

import java.util.UUID;

import com.app.hexagonal_coffe_shop.infas.Order;

public interface Orders {

  Order findOrderById(UUID orderId);

  Order save(Order order);

  void deleteById(UUID orderId);

}
