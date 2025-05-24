package com.trung_kieen.basic_test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "app") // (1)
@Service
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationProperties {
    private String greeting = "Hello";
    private String defaultName = "World";
}
