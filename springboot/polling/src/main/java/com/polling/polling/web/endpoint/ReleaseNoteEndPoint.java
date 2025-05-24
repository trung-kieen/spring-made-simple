package com.polling.polling.web.endpoint;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * ReleaseNoteEndPoint
 */
@Component
@Endpoint(enableByDefault = true, id = "releaseNotes")
public class ReleaseNoteEndPoint {
  @ReadOperation
  public ReleaseEntity getDemoReleaseNote(){
    return ReleaseEntity.builder().version("1.1").releaseDate(new Date()).tag("v").build();
  }

}
