package com.app.hexagonal_coffe_shop.business;

import java.util.UUID;

import com.app.hexagonal_coffe_shop.domain.CreditCard;
import com.app.hexagonal_coffe_shop.infas.Order;
import com.app.hexagonal_coffe_shop.infas.Payment;
import com.app.hexagonal_coffe_shop.infas.Receipt;

/**
 * User will create coffee order
 */
public interface  OrderingCoffee {
  // User create order
  Order placeOrder(Order order);
  // User can add new item to order, if order is paid this is not allow
  Order updateOrder(UUID orderId,  Order order);
  // User can cancel order
  void cancelOrder(UUID orderId);
  // User can pay order with credit card
  Payment payOrder(UUID orderId, CreditCard creditCard);
  // User can read the receipt after payment
  Receipt readReceipt (UUID orderId);
  // Order ready user can take it away
  Order takeOrder(UUID orderId);
}
