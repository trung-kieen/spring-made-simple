package com.trung_kieen.basic_test;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service // (1)
@RequiredArgsConstructor // (2)
public class GreetingService {
    private final ApplicationProperties properties;  // (3)

    public String sayHello(String name) {
        String s = name == null ? properties.getDefaultName(): name;
        return String.format("%s %s", properties.getGreeting(), s);
    }
}
