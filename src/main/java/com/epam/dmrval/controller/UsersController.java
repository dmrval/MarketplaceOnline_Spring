package com.epam.dmrval.controller;

import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Optional;

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

  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  public String getShowItems(Model model, Principal principal) {
    Optional<Principal> pr = Optional.ofNullable(principal);
    System.out.println(pr);
    if (pr.isPresent()) {
      model.addAttribute("currentUser", usersHelper.getUserByLogin(pr.get().getName()));
      model.addAttribute("allProducts", usersHelper.getAllProducts());
      return "showItems";
    } else {
      model.addAttribute("allProducts", usersHelper.getAllProducts());
      return "guestPage";
    }
  }

  //  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  //  public String getShowItems(Model model) {}
}
