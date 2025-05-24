package com.polling.polling.web.endpoint;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReleaseEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReleaseEntity {
  private String version;
  private Date releaseDate;
  private String tag;
}
