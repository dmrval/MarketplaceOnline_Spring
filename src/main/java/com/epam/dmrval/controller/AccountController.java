package com.epam.dmrval.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AccountController {

  @GetMapping("/show")
  public String sendJmsMessage() {
    return "Hello!!!";
  }
}
