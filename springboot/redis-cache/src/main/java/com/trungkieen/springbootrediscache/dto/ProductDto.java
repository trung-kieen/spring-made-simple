package com.trungkieen.springbootrediscache.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

// The main record
public record ProductDto(Long id, @NotBlank String name, @Positive BigDecimal price) {
}
