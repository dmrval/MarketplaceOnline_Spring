package com.epam.dmrval.controller;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.service.ProductService;
import com.epam.dmrval.service.UserService;
import com.epam.dmrval.service.helper.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user/showMyItems")
@SessionAttributes(value = "currentUser")
public class UserItemsController {

  @Autowired UserService userService;
  @Autowired ProductService productService;

  @RequestMapping(method = RequestMethod.GET)
  public String showMyItems(Model model, @ModelAttribute("currentUser") User currentUser) {
    model.addAttribute("userItems", productService.getProductsByUserLogin(currentUser.getLogin()));
    return "showMyItems";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchMyItems(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText,
      Principal principal) {
    User currentUser = userService.findByLogin(principal.getName());
    RequestHelper.getSearchMyItemsParam(model, selecter, searchText, currentUser.getProductList());
    return "showMyItems";
  }
}
