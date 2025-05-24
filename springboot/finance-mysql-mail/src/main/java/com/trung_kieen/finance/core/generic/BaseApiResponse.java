package com.trung_kieen.finance.core.generic;

import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

/**
 * BaseApiResponse
 */
@RequiredArgsConstructor
public class BaseApiResponse <T>  {
  private Boolean success;
  private String message;
  private T data;

  // TODO



}
