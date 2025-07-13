package com.app.hexagonal_coffe_shop.infas;

import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Order {

  private UUID id = UUID.randomUUID();
  private final Location location;
  private final List<LineItem> items;
  private Status status = Status.PAYMENT_EXPECTED;

  public Order markPaid() {
    if (status != Status.PAYMENT_EXPECTED) {
      throw new IllegalStateException("Order is already paid");
    }
    status = Status.PAID;
    return this;
  }

  public Order markBeingPrepare() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'markBeingPrepare'");
  }

}
