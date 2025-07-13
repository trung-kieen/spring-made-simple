package com.app.messaging_dragonflydb.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.app.messaging_dragonflydb.message.Message;
import com.app.messaging_dragonflydb.message.MessageType;

import org.springframework.cglib.core.Local;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebsocketEventListener {
  private final RedisTemplate<String, Object> template;

  @EventListener
  public void handleWebsocketDisconnected(SessionDisconnectEvent event) {
    var headerAccessor = SimpMessageHeaderAccessor.wrap(event.getMessage());
    String username = (String) headerAccessor.getSessionAttributes().get("username");
    if (username == null) {
      return;
    }
    Message message = Message.builder()
        .content(username + " has leaved!")
        .type(MessageType.LEAVE)
        .username(username)
        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
        .build();
    template.convertAndSend("chat", message);
  }

}
