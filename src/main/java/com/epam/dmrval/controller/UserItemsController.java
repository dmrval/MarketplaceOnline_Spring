package com.epam.dmrval.controller;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.helper.RequestHelper;
import com.epam.dmrval.processbase.GlobalAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/** Author - Damir_Valeev */
@Controller
@RequestMapping("/user/showMyItems")
@SessionAttributes(value = {"currentUser"})
public class UserItemsController {

  @Autowired private GlobalAttribute globalAttribute;

  @RequestMapping(method = RequestMethod.GET)
  public String showMyItems(Model model, @ModelAttribute("currentUser") User currentUser) {
    model.addAttribute(
        "userItems",
        RequestHelper.getCurrentUserProduct(globalAttribute.getAllProducts(), currentUser));
    return "showMyItems";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchMyItems(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText,
      @ModelAttribute("currentUser") User currentUser) {
    RequestHelper.getSearchMyItemsParam(
        model,
        selecter,
        searchText,
        RequestHelper.getCurrentUserProduct(globalAttribute.getAllProducts(), currentUser));
    return "showMyItems";
  }
}
