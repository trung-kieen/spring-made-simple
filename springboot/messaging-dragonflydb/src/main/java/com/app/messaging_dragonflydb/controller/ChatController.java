package com.app.messaging_dragonflydb.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.app.messaging_dragonflydb.message.Message;
import com.app.messaging_dragonflydb.message.MessageType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
  private final RedisTemplate template;
  @Value("${redis.topic:chat}")
  private String topic;

  // Send message to client
  @MessageMapping("chat.send")
  @SendTo("chat")
  public Message sendMessage(@Payload Message message) {
    message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    template.convertAndSend(topic, message);
    return message;
  }

  @MessageMapping("chat.addUser")
  public Message userJoin(@Payload Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) {
    // Save the username for connection
    // We need to notice when user is leave the room
    simpMessageHeaderAccessor.getSessionAttributes().put("username", message.getUsername());
    message.setMessageType(MessageType.JOIN);
    message.setMessage(message.getUsername() + " joined the chat");
    message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    // Send to chat channel
    template.convertAndSend(topic, message);
    // Send back to user that send message
    return message;
  }

}
