package com.app.messaging_dragonflydb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Config for redis (dragronflydb)
 */
@Configuration
public class RedisConfig {
  @Value("${redis.topic:chat}")
  private String topic;

  // Define to redis template for redis operation
  @Primary
  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
    return template;
  }

  @Bean
  public ChannelTopic channelTopic() {
    // Define topic chat for message broker
    return new ChannelTopic(topic);
  }

  // Adapter redis as message broker
  @Bean
  public MessageListenerAdapter messageListenerAdapter(RedisMessageSubcriber  redisMessageSubcriber){
    return new MessageListenerAdapter(redisMessageSubcriber);
  }

  // Add channel for redis message subscription
  public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
      MessageListenerAdapter messageListenerAdapter) {

    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.addMessageListener(messageListenerAdapter, channelTopic());
    return container;
  }

}
