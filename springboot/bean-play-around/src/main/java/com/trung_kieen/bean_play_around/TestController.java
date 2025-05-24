package com.trung_kieen.bean_play_around;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * TestController
 */
@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {

  @GetMapping
  public String testEndpoint(){
    return "DDOS me!!!";

  }

}
