package com.epam.dmrval.controller;

import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UsersController {

  @Autowired UsersHelper usersHelper;

  @RequestMapping(value = "/showAllItems", method = RequestMethod.GET)
  public String getShowItems(Model model, Principal principal) {
    Optional<Principal> pr = Optional.ofNullable(principal);
    if (pr.isPresent()) {
      model.addAttribute("currentUser", usersHelper.getUserByLogin(pr.get().getName()));
      model.addAttribute("allProducts", usersHelper.getAllProducts());
      return "showAllItems";
    } else {
      model.addAttribute("allProducts", usersHelper.getAllProducts());
      return "guestPage";
    }
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String postSearchParams(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText) {
    RequestHelper.getSearchParam(model, selecter, searchText, usersHelper);
    return "showAllItems";
  }
}
