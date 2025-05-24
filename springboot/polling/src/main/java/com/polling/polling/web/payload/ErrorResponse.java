package com.polling.polling.web.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response
 */
// TODO: use in global exception handle may be: data, error, ... => Need
// to extend
// Better to handle property time with @JsonIgnore
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
  private String message;
  // private Date time;
  private String cause;
}
