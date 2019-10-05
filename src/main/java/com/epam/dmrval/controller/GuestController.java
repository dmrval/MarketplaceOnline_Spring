package com.epam.dmrval.controller;

import com.epam.dmrval.entity.UsersHelper;
import com.epam.dmrval.service.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** Author - Damir_Valeev Created on 9/30/2019 */
@Controller
@RequestMapping("/guest")
public class GuestController {

  @Autowired private UsersHelper usersHelper;

  @RequestMapping(value = "/showAllItems", method = RequestMethod.GET)
  public String showItems(Model model) {
    model.addAttribute("allProducts", usersHelper.getAllProducts());
    return "guestPage";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchParams(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText) {
    RequestHelper.getSearchAllItemsParam(model, selecter, searchText, usersHelper.getAllProducts());
    return "guestPage";
  }
}
