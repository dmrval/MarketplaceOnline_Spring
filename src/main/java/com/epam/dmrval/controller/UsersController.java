package com.epam.dmrval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLogin() {
    return "login";
  }

  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  public String getShowItems() {
    return "showItems";
  }
}
