package com.epam.dmrval.controller;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.User;
import com.epam.dmrval.entity.UsersHelper;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev Created on 9/30/2019 */
class RequestHelper {
  static void getSearchAllItemsParam(
      Model model, String selecter, String searchText, UsersHelper usersHelper) {
    List<Product> allProducts = usersHelper.getAllProducts();
    List<Product> result = new ArrayList<>();
    switch (selecter) {
      case "Seller":
        for (Product tmp : allProducts) {
          if (tmp.getInfo().getMaster().getFullname().contains(searchText)) {
            result.add(tmp);
          }
        }
        break;
      case "Start price":
        if (inputCorrect(searchText)) {
          double price = Double.parseDouble(searchText);
          System.out.println(price);
          System.out.println(selecter);
          for (Product tmp : allProducts) {
            if (tmp.getInfo().getStartPrice() >= price) {
              result.add(tmp);
            }
          }
        }
        break;
      case "Name":
        for (Product tmp : allProducts) {
          if (tmp.getNameProduct().contains(searchText)) {
            result.add(tmp);
          }
        }
        model.addAttribute("allProducts", result);
        break;
      default:
        model.addAttribute("allProducts", usersHelper.getAllProducts());
    }
  }

  static void getSearchMyItemsParam(Model model, String searchText, User user) {
    List<Product> userProductList = user.getProductList();
    List<Product> result = new ArrayList<>();

    for (Product tmp : userProductList) {
      if (tmp.getNameProduct().contains(searchText)) {
        result.add(tmp);
      }
    }

    model.addAttribute("userItems", result);
  }

  private static boolean inputCorrect(String s) {
    if (s.isEmpty()) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
