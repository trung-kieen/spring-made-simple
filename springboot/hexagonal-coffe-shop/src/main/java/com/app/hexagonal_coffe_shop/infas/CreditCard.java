package com.app.hexagonal_coffe_shop.infas;

import java.time.Month;
import java.time.Year;

public record CreditCard(
    String cardHolderName,
    String cardNumber,
    Month expiryMonth,
    Year expiryYear) {

}
