package com.polling.polling.web.payload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
@RequestMapping
public class TestController {

@GetMapping(value = "/ssl-test")
    public String greeting(){
        return "Self Signed SSL is Working!!";
    }
}
