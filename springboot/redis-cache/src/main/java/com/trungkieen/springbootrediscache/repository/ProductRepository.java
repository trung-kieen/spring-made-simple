package com.trungkieen.springbootrediscache.repository;

import com.trungkieen.springbootrediscache.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
