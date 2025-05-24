package com.example.postgre_ercommercial.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorDetail
 */
@Data
@AllArgsConstructor
public class ErrorDetail {
  private String message ;
  private String details;

  private Date timestampt;

}
