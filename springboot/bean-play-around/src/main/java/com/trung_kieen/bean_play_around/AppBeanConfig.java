package com.trung_kieen.bean_play_around;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppBeanConfig
 */
@Configuration
public class AppBeanConfig {
  @Bean(name = "studentBean", initMethod = "init", destroyMethod = "destroy")
  public Student student() { // Bean will name default as method name if we don't explicit it
    return new Student();

  }

}
