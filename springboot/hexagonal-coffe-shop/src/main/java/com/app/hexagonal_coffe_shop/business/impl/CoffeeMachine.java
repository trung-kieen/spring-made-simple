package com.app.hexagonal_coffe_shop.business.impl;

import java.util.UUID;

import com.app.hexagonal_coffe_shop.business.PrepareCoffee;
import com.app.hexagonal_coffe_shop.domain.Orders;
import com.app.hexagonal_coffe_shop.infas.Order;

public class CoffeeMachine implements PrepareCoffee {
  private final Orders orders;

  @Override
  public Order startPrepareOrder(UUID orderId) {
    var order = orders.findOrderById(orderId);
    return orders.save(order.markBeingPrepare());
  }

  @Override
  public Order finishPrepareOrder(UUID orderId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'finishPrepareOrder'");
  }

}
