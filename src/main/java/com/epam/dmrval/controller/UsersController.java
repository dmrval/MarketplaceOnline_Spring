package com.epam.dmrval.controller;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.ProductBuilder;
import com.epam.dmrval.entity.User;
import com.epam.dmrval.service.ProductService;
import com.epam.dmrval.service.UserService;
import com.epam.dmrval.service.helper.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

/** Author - Damir_Valeev */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = "currentUser")
public class UsersController {

  @Autowired private UserService userService;
  @Autowired private ProductService productService;

  @ModelAttribute("currentUser")
  public User createUser(Principal principal) {
    return userService.findByLogin(principal.getName());
  }

  @ModelAttribute("buildProduct")
  ProductBuilder buildProduct() {
    return new ProductBuilder();
  }

  @RequestMapping(value = "/showAllItems", method = RequestMethod.GET)
  public String showItems(Model model) {
    model.addAttribute("allProducts", productService.getAllProducts());
    return "showAllItems";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchParams(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText) {
    RequestHelper.getSearchAllItemsParam(
        model, selecter, searchText, productService.getAllProducts());
    return "showAllItems";
  }

  @RequestMapping(value = "/sellProduct", method = RequestMethod.GET)
  public String sellProduct() {
    return "sellProduct";
  }

  @RequestMapping(value = "/sellProduct/cancel", method = RequestMethod.GET)
  public String sellProductCancel() {
    return "redirect:/user/showAllItems";
  }

  @RequestMapping(value = "/sellProduct", method = RequestMethod.POST)
  public String sellProduct(
      @ModelAttribute("currentUser") User currentUser,
      @ModelAttribute("buildProduct") @Valid ProductBuilder buildProduct,
      BindingResult bindingResult) {
    Product newProduct = buildProduct.build(currentUser);
    if (bindingResult.hasErrors()) {
      return "sellProduct";
    }
    if (!Objects.isNull(newProduct)) {
      productService.saveProduct(newProduct);
    }
    return "redirect:/user/showMyItems";
  }

  @RequestMapping(value = "/biddUp", method = RequestMethod.POST)
  public String biddUp(
      @ModelAttribute("currentUser") User currentUser,
      @RequestParam("biddInfo") String biddInfo,
      @RequestParam("biddLot") String biddLot,
      Model model) {
    int idProduct = Integer.parseInt(biddInfo);
    double bidLot = Double.parseDouble(biddLot);
    double currentBiddPrice = productService.chechCurrentBiddePrice(idProduct);
    if (bidLot <= currentBiddPrice) {
      model.addAttribute("minimalBiddError", true);
      model.addAttribute("allProducts", productService.getAllProducts());
      return "showAllItems";
    } else {
      Bidder bidder = new Bidder(bidLot, currentUser);
      productService.setBidder(bidder, idProduct);
      return "redirect:/user/showAllItems";
    }
  }
}
