package com.epam.dmrval.controller;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.entity.UsersHelper;
import com.epam.dmrval.service.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user/showMyItems")
public class UserItemsController {

  @Autowired private UsersHelper usersHelper;

  @RequestMapping(method = RequestMethod.GET)
  public String showMyItems(Model model, Principal principal) {
    model.addAttribute(
        "userItems", usersHelper.getUserByLogin(principal.getName()).getProductList());
    return "showMyItems";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchMyItems(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText,
      Principal principal) {
    User currentUser = usersHelper.getUserByLogin(principal.getName());
    RequestHelper.getSearchMyItemsParam(model, selecter, searchText, currentUser.getProductList());
    return "showMyItems";
  }
}
