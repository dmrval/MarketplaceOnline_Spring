package com.epam.dmrval.controller;

import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

  @Autowired UsersHelper usersHelper;

  @RequestMapping(value = "/", method = RequestMethod.GET)
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

//  @RequestMapping(value = "/login", method = RequestMethod.POST)
//  public String postLogin(Model model) {
//    model.addAttribute("currentUser", usersHelper.getAllUsers().get(0));
//    model.addAttribute("allProducts", usersHelper.getAllProducts());
//    return "showItems";
//  }
//
  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  public String getShowItems(Model model) {
    model.addAttribute("currentUser", usersHelper.getAllUsers().get(0));
    model.addAttribute("allProducts", usersHelper.getAllProducts());
    return "showItems";
  }

  //  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  //  public String getShowItems(Model model) {}
}
