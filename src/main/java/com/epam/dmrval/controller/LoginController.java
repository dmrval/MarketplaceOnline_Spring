package com.epam.dmrval.controller;

import com.epam.dmrval.processbase.TimerTaskOfAuction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Author - Damir_Valeev Created on 9/30/2019 */
@Controller("allProducts")
public class LoginController {

  @Autowired private TimerTaskOfAuction timerTaskOfAuction;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String rootPath() {
    return "redirect:/login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    timerTaskOfAuction.transferGoods();
    return "login";
  }

  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
  public String accessDenied() {
    return "403";
  }
}
