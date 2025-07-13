package com.app.hexagonal_coffe_shop.infas;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Receipt(
    BigDecimal amount, LocalDate paid) {
}
