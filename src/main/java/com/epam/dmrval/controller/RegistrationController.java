package com.epam.dmrval.controller;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

  @Autowired private UsersHelper usersHelper;

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registration(
      @ModelAttribute("user") User user,
      @RequestParam("repassword") String repassword,
      Model model) {
    if (!user.getPassword().equals(repassword)) {
      model.addAttribute("passNotMatch", 1);
      return registration();
    }
    usersHelper.addUser(user);
    return "login";
  }

  @RequestMapping(value = "/signUp", method = RequestMethod.GET)
  public String registration() {
    return "registration";
  }

  @ModelAttribute("user")
  public User createNewUser() {
    return new User();
  }
}
