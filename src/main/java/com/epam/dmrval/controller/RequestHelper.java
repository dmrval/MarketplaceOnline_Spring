package com.epam.dmrval.controller;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.UsersHelper;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev Created on 9/30/2019 */
class RequestHelper {
  static void getSearchParam(
      Model model, String selecter, String searchText, UsersHelper usersHelper) {
    List<Product> allProducts = usersHelper.getAllProducts();
    List<Product> result = new ArrayList<>();
    if (selecter.equals("Seller")) {
      for (Product tmp : allProducts) {
        if (tmp.getInfo().getMaster().getFullname().equals(searchText)) {
          result.add(tmp);
        }
      }
    } else {
      for (Product tmp : allProducts) {
        if (tmp.getNameProduct().equals(searchText)) {
          result.add(tmp);
        }
      }
    }
    model.addAttribute("allProducts", result);
  }
}
