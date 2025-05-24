package com.polling.polling.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * BaseMapper
 */

public abstract class BaseMapper<E> {
  @Autowired
  protected ModelMapper modelMapper;

  /**
   * Mapper
   */
  @Configuration
  public static class Mapper {
    @Bean
    public ModelMapper modelMapper() {
      return new ModelMapper();
    }
  }
}


