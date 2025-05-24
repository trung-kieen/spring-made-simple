package com.trung_kieen.finance.app.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
@RequestMapping("/api/test/")
public class TestController {

  @GetMapping()
  public ResponseEntity<?> main() {
    return ResponseEntity.ok("test");
  }

}
