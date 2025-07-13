package com.app.hexagonal_coffe_shop.adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.app.hexagonal_coffe_shop.domain.Orders;
import com.app.hexagonal_coffe_shop.infas.Order;

/*
 * Adapter for secondary port
 */
public class InMemoryOrders implements Orders {
  private final Map<UUID, Order> entities = new HashMap<>();

  @Override
  public Order findOrderById(UUID orderId) {
    var order = entities.get(orderId);
    return order;
  }

  @Override
  public Order save(Order order) {
    entities.put(order.getId(), order);
    return order;
  }

  @Override
  public void deleteById(UUID orderId) {
    entities.remove(orderId);
  }

}
