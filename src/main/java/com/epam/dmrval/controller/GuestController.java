package com.epam.dmrval.controller;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev Created on 9/30/2019 */
@Controller
@RequestMapping("/guest")
public class GuestController {


  @Autowired UsersHelper usersHelper;

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String postSearchParams(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText) {
    RequestHelper.getSearchParam(model, selecter, searchText, usersHelper);
    return "guestPage";
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getShowItems(Model model) {
    model.addAttribute("allProducts", usersHelper.getAllProducts());
    return "guestPage";
  }

//  private static void guestSearch(
//      Model model,
//      @RequestParam("selecter") String selecter,
//      @RequestParam("searchText") String searchText,
//      UsersHelper usersHelper) {
//    List<Product> allProducts = usersHelper.getAllProducts();
//    List<Product> result = new ArrayList<>();
//    if (selecter.equals("Seller")) {
//      for (Product tmp : allProducts) {
//        if (tmp.getInfo().getMaster().getFullname().equals(searchText)) {
//          result.add(tmp);
//        }
//      }
//    } else {
//      for (Product tmp : allProducts) {
//        if (tmp.getNameProduct().equals(searchText)) {
//          result.add(tmp);
//        }
//      }
//    }
//    model.addAttribute("allProducts", result);
//  }
}
