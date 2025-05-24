package com.trung_kieen.basic_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // (1)
@RequiredArgsConstructor
@Slf4j // (2)
public class HelloWorldController {
    private final GreetingService greetingService;

    @GetMapping("/api/hello") // (3)
    public GreetingResponse sayHello(
            @RequestParam(name = "name", required = false) String name) {
        log.info("Say Hello to Name: {}", name);
        String greeting = greetingService.sayHello(name);
        return new GreetingResponse(greeting);
    }
}
