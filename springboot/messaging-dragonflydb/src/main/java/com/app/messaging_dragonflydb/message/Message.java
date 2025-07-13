package com.app.messaging_dragonflydb.message;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
  private String message;
  private String username;
  private MessageType messageType;
  private String timestamp;
}
