package com.app.hexagonal_coffe_shop.domain;

import java.util.UUID;

import com.app.hexagonal_coffe_shop.infas.Payment;

public interface Payments {
  Payment findPaymentByOrderId(UUID orderId);

  Payment save(Payment payment);

}
