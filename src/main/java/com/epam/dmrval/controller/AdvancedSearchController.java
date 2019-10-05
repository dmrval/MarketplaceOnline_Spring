package com.epam.dmrval.controller;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.ProductSearcher;
import com.epam.dmrval.entity.UsersHelper;
import com.epam.dmrval.service.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class AdvancedSearchController {

  @Autowired UsersHelper usersHelper;

  @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
  public String advancedSearch() {
    return "advancedSearch";
  }

  @RequestMapping(value = "/advancedSearch", method = RequestMethod.POST)
  public String showAdvancedSearchPage(
      Model model,
      Principal principal,
      @Valid @ModelAttribute("productSearcher") ProductSearcher productSearcher,
      BindingResult bindingResult) {
    List<Product> allProducts = usersHelper.getAllProducts();
    List<Product> resultList = RequestHelper.getAdvancedSearch(allProducts, productSearcher);
    if (bindingResult.hasErrors()) {
      return "advancedSearch";
    }
    if (principal != null) {
      model.addAttribute("allProducts", resultList);
      return "showAllItems";
    } else {
      model.addAttribute("allProducts", resultList);
      return "guestPage";
    }
  }

  @RequestMapping(value = "/clearField", method = RequestMethod.GET)
  public String clearField() {
    return "redirect:/advancedSearch";
  }

  private String checkUser(Principal principal, List<Product> resultList, Model model) {
    if (principal != null) {
      model.addAttribute("allProducts", resultList);
      return "showAllItems";
    } else {
      model.addAttribute("allProducts", resultList);
      return "guestPage";
    }
  }

  @ModelAttribute("productSearcher")
  ProductSearcher productSearcher() {
    return new ProductSearcher();
  }
}
