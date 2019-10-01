package com.epam.dmrval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Author - Damir_Valeev Created on 9/30/2019 */
@Controller
public class LoginController {

  @RequestMapping(method = RequestMethod.GET)
  public String getRootPath() {
    return getLogin();
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLogin() {
    return "login";
  }

  @RequestMapping(value = "/signUp", method = RequestMethod.GET)
  public String getRegistration() {
    return "registration";
  }

  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
  public String getAccessDenied() {
    return "403";
  }
}
