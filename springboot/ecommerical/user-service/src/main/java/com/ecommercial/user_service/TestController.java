package com.ecommercial.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
@RequestMapping("user/")
public class TestController {
  @GetMapping("test")
  public String test(){
    return "Call from test  user_service";

  }


}
