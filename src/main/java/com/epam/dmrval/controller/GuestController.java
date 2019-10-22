package com.epam.dmrval.controller;

import com.epam.dmrval.helper.RequestHelper;
import com.epam.dmrval.processbase.GlobalAttribute;
import com.epam.dmrval.processbase.TimerTaskOfAuction;
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

  @Autowired private TimerTaskOfAuction timerTaskOfAuction;
  @Autowired GlobalAttribute globalAttribute;

  @RequestMapping(value = "/showAllItems", method = RequestMethod.GET)
  public String showItems(Model model) {
    timerTaskOfAuction.transferGoods();
    model.addAttribute(
        "allProducts", RequestHelper.getProductsThatYouCanBuy(globalAttribute.getAllProducts()));
    return "guestPage";
  }

  @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
  public String searchParams(
      Model model,
      @RequestParam("selecter") String selecter,
      @RequestParam("searchText") String searchText) {
    timerTaskOfAuction.transferGoods();
    RequestHelper.getSearchAllItemsParam(
        model,
        selecter,
        searchText,
        RequestHelper.getProductsThatYouCanBuy(globalAttribute.getAllProducts()));
    return "guestPage";
  }
}
