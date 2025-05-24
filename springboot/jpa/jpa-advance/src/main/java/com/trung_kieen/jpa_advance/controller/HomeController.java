package com.trung_kieen.jpa_advance.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 */
@RestController
@RequestMapping("/")
public class HomeController {
  public String greeting (){
    return "Hi there";
  }



}
