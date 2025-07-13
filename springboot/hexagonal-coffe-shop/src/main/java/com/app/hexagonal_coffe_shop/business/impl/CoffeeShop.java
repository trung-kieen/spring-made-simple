package com.app.hexagonal_coffe_shop.business.impl;

import java.time.LocalDate;
import java.util.UUID;

import com.app.hexagonal_coffe_shop.business.OrderingCoffee;
import com.app.hexagonal_coffe_shop.domain.Orders;
import com.app.hexagonal_coffe_shop.domain.Payments;
import com.app.hexagonal_coffe_shop.infas.CreditCard;
import com.app.hexagonal_coffe_shop.infas.Order;
import com.app.hexagonal_coffe_shop.infas.Payment;
import com.app.hexagonal_coffe_shop.infas.Receipt;

/*
 * Main logic use adapter to implement
 */
public class CoffeeShop implements OrderingCoffee {
  // Inject the secondary port
  private final Orders orders;
  private final Payments payments;

  @Override
  public Payment payOrder(UUID orderId, CreditCard creditCard) {
    var order = orders.findOrderById(orderId);
    orders.save(order.markPaid());
    return payments.save(new Payment(orderId, creditCard, LocalDate.now()));
  }

  // ===========================================================================

  @Override
  public Order placeOrder(Order order) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
  }

  @Override
  public Order updateOrder(UUID orderId, Order order) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
  }

  @Override
  public void cancelOrder(UUID orderId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'cancelOrder'");
  }

  @Override
  public Receipt readReceipt(UUID orderId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readReceipt'");
  }

  @Override
  public Order takeOrder(UUID orderId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'takeOrder'");
  }

}
