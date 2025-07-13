package com.app.messaging_dragonflydb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    // Contact to register websocket endpoint
    registry.addEndpoint("/ws").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // message broker destination prefix like we send to /topic/public/chat a message
    // All client subscribe to /topic/public/* will receive message (broadcast prefix)
    registry.enableSimpleBroker("/topic/public");
    // All message from client to server must come with this prefix
    // For example server have the MessageMapping @MessageMapping("/chat.send")
    // Client require to send message with the prefix app
    // stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
    registry.setApplicationDestinationPrefixes("/app");
  }

}
