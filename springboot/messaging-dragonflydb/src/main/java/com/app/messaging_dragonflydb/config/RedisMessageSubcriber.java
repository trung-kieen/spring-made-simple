package com.app.messaging_dragonflydb.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RedisMessageSubcriber implements MessageListener {
  private final RedisTemplate<String, Object> template;
  private final ObjectMapper objectMapper;
  private final SimpMessageSendingOperations simpMessageSendingOperations;

  // Broadcast message with
  @Override
  public void onMessage(Message message, byte[] pattern) {
    String publishedMessage = template.getStringSerializer().deserialize(message.getBody());
    try {
      Message chatMessage = objectMapper.readValue(publishedMessage, Message.class);
      simpMessageSendingOperations.convertAndSend("/topic/public", chatMessage);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);

    }
  }

}
