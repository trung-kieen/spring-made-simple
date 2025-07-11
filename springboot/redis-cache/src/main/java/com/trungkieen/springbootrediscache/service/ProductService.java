package com.trungkieen.springbootrediscache.service;

import com.trungkieen.springbootrediscache.dto.ProductDto;
import com.trungkieen.springbootrediscache.entity.Product;
import com.trungkieen.springbootrediscache.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Where we cache
 *
 *
 */
@Service
public class ProductService {

  public static final String PRODUCT_CACHE = "products";
  // public static final String PRODUCT_CACHE = "products";
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  // When we create new entity => put entity to cache by mark with their id for
  // identify
  @CachePut(value = PRODUCT_CACHE, key = "#result.id()")
  // @CachePut(value = PRODUCT_CACHE, key = "#result.id()")
  public ProductDto createProduct(ProductDto productDto) {
    var product = new Product();
    product.setName(productDto.name());
    product.setPrice(productDto.price());

    Product savedProduct = productRepository.save(product);
    return new ProductDto(savedProduct.getId(), savedProduct.getName(),
        savedProduct.getPrice());
  }

  // Now if key of entity exist => direct get from cache instead of excute
  // database query
  // Where the #productId from? the method argument
  @Cacheable(value = PRODUCT_CACHE, key = "#productId")
  // @Cacheable(value = PRODUCT_CACHE, key = "#productId")
  public ProductDto getProduct(Long productId) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new IllegalArgumentException("Cannot find product with id " + productId));
    return new ProductDto(product.getId(), product.getName(),
        product.getPrice());
  }

  // Why key is #result.id ? becase we return a record => fieldname is the getter
  @CachePut(value = PRODUCT_CACHE, key = "#result.id()")
  // @CachePut(value = PRODUCT_CACHE, key = "#result.id()")
  public ProductDto updateProduct(ProductDto productDto) {
    Long productId = productDto.id();
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new IllegalArgumentException("Cannot find product with id " + productId));

    product.setName(productDto.name());
    product.setPrice(productDto.price());

    Product updatedProduct = productRepository.save(product);
    return new ProductDto(updatedProduct.getId(), updatedProduct.getName(),
        updatedProduct.getPrice());
  }

  // @CacheEvict(value = PRODUCT_CACHE, key = "#productId")
  public void deleteProduct(Long productId) {
    productRepository.deleteById(productId);
  }
}
