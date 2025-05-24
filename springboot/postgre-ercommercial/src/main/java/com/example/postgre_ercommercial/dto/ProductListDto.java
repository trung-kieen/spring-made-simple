package com.example.postgre_ercommercial.dto;

import java.math.BigDecimal;

import org.antlr.v4.runtime.misc.Interval;

import lombok.Data;

/**
 * ProductListDto
 */
@Data
public class ProductListDto {
  private Long id ;

  private String name ;

  private  String description ;
  private BigDecimal price ;
  private Integer  quantity ;

  private String image;



}
