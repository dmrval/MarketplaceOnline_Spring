package com.epam.dmrval.helper;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.entity.ProductSearcher;
import com.epam.dmrval.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Author - Damir_Valeev Created on 9/30/2019 */
public class RequestHelper {
  public static void getSearchAllItemsParam(
      Model model, String selecter, String searchText, List<Product> allProducts) {
    List<Product> result = switchSelecter(selecter, searchText, allProducts);
    model.addAttribute("allProducts", result);
  }

  public static void getSearchMyItemsParam(
      Model model, String selecter, String searchText, List<Product> userProductsList) {
    List<Product> result = switchSelecter(selecter, searchText, userProductsList);
    model.addAttribute("userItems", result);

  }

  private static List<Product> switchSelecter(
      String selecter, String searchText, List<Product> allProducts) {
    List<Product> result = new ArrayList<>();
    switch (selecter) {
      case "Seller":
        for (Product tmp : allProducts) {
          if (tmp.getInfo()
              .getMaster()
              .getFullname()
              .toLowerCase()
              .contains(searchText.toLowerCase())) {
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
          if (tmp.getNameProduct().toLowerCase().contains(searchText.toLowerCase())) {
            result.add(tmp);
          }
        }
        break;
      default:
        for (Product tmp : allProducts) {
          if (tmp.getNameProduct().toLowerCase().contains(searchText.toLowerCase())) {
            result.add(tmp);
          }
        }
    }
    return result;
  }

  public static List<Product> getProductsThatYouCanBuy(List<Product> currentProducts) {
    return currentProducts.stream()
        .filter(product -> product.getInfo().getTime().isAfter(LocalDateTime.now()))
        .collect(Collectors.toList());
  }

  public static List<Product> getCurrentUserProduct(
      List<Product> currentProducts, User currentUser) {
    return currentProducts.stream()
        .filter(product -> product.getInfo().getMaster().getLogin().equals(currentUser.getLogin()))
        .collect(Collectors.toList());
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

  public static List<Product> getAdvancedSearch(
      List<Product> allProducts, ProductSearcher productSearcher) {
    Stream<Product> productStream = allProducts.stream();
    List<Predicate<Product>> predicates = new ArrayList<>();

    if (productSearcher.getUid() > 0) {
      predicates.add(product -> product.getUid() == productSearcher.getUid());
    }
    if (!productSearcher.getNameProduct().isEmpty()) {
      predicates.add(
          product ->
              product
                  .getNameProduct()
                  .toLowerCase()
                  .contains(productSearcher.getNameProduct().toLowerCase()));
    }
    if (!productSearcher.getDescription().isEmpty()) {
      predicates.add(
          product ->
              product
                  .getDescription()
                  .toLowerCase()
                  .contains(productSearcher.getDescription().toLowerCase()));
    }
    if (productSearcher.getMinPrice() > 0) {
      predicates.add(product -> product.getInfo().getStartPrice() >= productSearcher.getMinPrice());
    }
    if (productSearcher.getMaxPrice() > 0) {
      predicates.add(product -> product.getInfo().getStartPrice() <= productSearcher.getMaxPrice());
    }
    if (productSearcher.isBidding()) {
      predicates.add(product -> product.getInfo().isBidding());
    }
    if (!productSearcher.getExpireDate().isEmpty()) {
      predicates.add(
          product ->
              product.getInfo().getTime().isAfter(productSearcher.getLocalDateTimeProduct()));
    }
    if (productSearcher.getBestOffer() > 0) {
      predicates.add(
          product ->
              product.getInfo().getBidder().getBidderOffer() < productSearcher.getBestOffer());
    }
    for (Predicate<Product> predicate : predicates) {
      productStream = productStream.filter(predicate);
    }
    return productStream.collect(Collectors.toList());
  }
}
