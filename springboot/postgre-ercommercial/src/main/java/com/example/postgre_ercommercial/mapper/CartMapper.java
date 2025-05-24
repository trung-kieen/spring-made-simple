package com.example.postgre_ercommercial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.postgre_ercommercial.dto.CartDto;
import com.example.postgre_ercommercial.dto.CartItemDto;
import com.example.postgre_ercommercial.model.Cart;
import com.example.postgre_ercommercial.model.CartItem;

/**
 * CartMapper
 */

// Mark adhere to spring bean so we can autowrite mapper instead of create INSTANCE and get via Mappers.getMapper
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartMapper {
  // CartMapper INSTANCE  = Mappers.getMapper(CartMapper.class);

  @Mapping(source = "id", target = "userId")
  public CartDto toDto(Cart cart);

  @Mapping(source = "userId", target = "user.id") // Because both entity may have field id
  public Cart toEntity(CartDto cartDto);


  // In Cart we  have cart item is the subitem need for mapping



}
