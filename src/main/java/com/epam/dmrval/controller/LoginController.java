package com.epam.dmrval.controller;

import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Author - Damir_Valeev Created on 9/30/2019 */
@Controller
public class LoginController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String rootPath() {
    return login();
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return "login";
  }

  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
  public String accessDenied() {
    return "403";
  }
}
