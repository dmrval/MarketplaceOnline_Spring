package com.epam.dmrval.service;

import com.epam.dmrval.entity.Product;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Author - Damir_Valeev Created on 9/30/2019
 */
public class RequestHelper {
    public static void getSearchAllItemsParam(
            Model model, String selecter, String searchText, List<Product> allProducts) {
        List<Product> result = switchSelecter(selecter, searchText, allProducts);
        model.addAttribute("allProducts", result);

    }

    public static void getSearchMyItemsParam(Model model, String selecter, String searchText, List<Product> userProductsList) {
        List<Product> result = switchSelecter(selecter, searchText, userProductsList);
        model.addAttribute("userItems", result);
    }


    private static List<Product> switchSelecter(String selecter, String searchText, List<Product> allProducts) {
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
                    for (Product tmp : allProducts) {
                        if (tmp.getInfo().getStartPrice() >= price) {
                            result.add(tmp);
                        }
                    }
                }
                break;
            case "Title":
                for (Product tmp : allProducts) {
                    if (tmp.getNameProduct().contains(searchText)) {
                        result.add(tmp);
                    }
                }
                break;
            default:
                for (Product tmp : allProducts) {
                    if (tmp.getNameProduct().contains(searchText)) {
                        result.add(tmp);
                    }
                }
        }
        return result;
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
