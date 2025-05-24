package com.trung_kieen.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trung_kieen.thymeleaf.entity.Order;

/**
 * HomeController
 */
@Controller
@RequestMapping
public class HomeController {
  @GetMapping("/home")
  public String home(Model model) {

    // Pass message a variable to file html
    model.addAttribute("message", "Have a nice day");
    // Return view extract from file template/home.html
    return "home";

  }

  @GetMapping("/order")
  public String getOrder(Model model) {

    // Pass message a variable to file html
    //model.addAttribute("order", new Order());
    // Return view extract from file template/home.html
    return "order";

  }
}
