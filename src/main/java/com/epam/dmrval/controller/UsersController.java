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
@RequestMapping("/user")
public class UsersController {
    public static final String MY_ITEMS = "showMyItems";
    public static final String ALL_ITEMS = "showAllItems";

    @Autowired
    UsersHelper usersHelper;

    @RequestMapping(value = "/showAllItems", method = RequestMethod.GET)
    public String getShowItems(Model model, Principal principal) {
        model.addAttribute("currentUser", usersHelper.getUserByLogin(principal.getName()));
        model.addAttribute("allProducts", usersHelper.getAllProducts());
        return "showAllItems";
    }

    @RequestMapping(value = "/searchParams", method = RequestMethod.POST)
    public String postSearchParams(
            Model model,
            @RequestParam("selecter") String selecter,
            @RequestParam("searchText") String searchText) {
        RequestHelper.getSearchAllItemsParam(model, selecter, searchText, usersHelper.getAllProducts());
        return "showAllItems";
    }

    @RequestMapping(value = "/showMyItems", method = RequestMethod.GET)
    public String getshowMyItems(Model model, Principal principal) {
        model.addAttribute("currentUser", usersHelper.getUserByLogin(principal.getName()));
        model.addAttribute(
                "userItems", usersHelper.getUserByLogin(principal.getName()).getProductList());
        return "showMyItems";
    }

    @RequestMapping(value = "/showMyItems/searchParams", method = RequestMethod.POST)
    public String postSearchMyItems(
            Model model,
            @RequestParam("selecter") String selecter,
            @RequestParam("searchText") String searchText,
            Principal principal) {
        User currentUser = usersHelper.getUserByLogin(principal.getName());
        RequestHelper.getSearchMyItemsParam(model, selecter, searchText, currentUser.getProductList());
        model.addAttribute("currentUser", usersHelper.getUserByLogin(principal.getName()));
        return "showMyItems";
    }
}
