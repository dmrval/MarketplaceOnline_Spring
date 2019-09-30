package com.epam.dmrval.entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev Created on 9/16/2019 */
@Service
public class UsersHelper {
  public List<User> allUsers = new ArrayList<>();

  public UsersHelper() {
    User currentUser =
        new User("Ivanov Ivan Ivanovich", "Stepnaya 9", "ivan", "ivan", Sex.MR, Role.USER);
    currentUser
        .getProductList()
        .add(
            new Product(
                1,
                "Monitor",
                "Lcd display",
                new AuctionProductInfo(15000, 1000, 23423, currentUser, true)));
    currentUser
        .getProductList()
        .add(
            new Product(
                2,
                "Glass boll",
                "Glass bol",
                new AuctionProductInfo(1000, 100, 23423, currentUser)));

    User secondUser =
        new User("Mockachino Ludmila Petrovna", "Горького 16", "luda", "luda", Sex.MRS, Role.USER);
    secondUser
        .getProductList()
        .add(
            new Product(
                3,
                "Water",
                "Water",
                new AuctionProductInfo(
                    100, 10, new Bidder(20, currentUser), 234, secondUser, true)));

    allUsers.add(currentUser);
    allUsers.add(secondUser);
  }

  public List<User> getAllUsers() {
    return allUsers;
  }

  public void setAllUsers(List<User> allUsers) {
    this.allUsers = allUsers;
  }

  public User getUserByLogin(String login) {
    for (User tmp : allUsers) {
      if (tmp.getLogin().equals(login)) {
        return tmp;
      }
    }
    return null;
  }

  public AuctionProductInfo getAuctionByInfo(String nameProduct) {
    for (int i = 0; i < allUsers.size(); i++) {
      for (int j = 0; j < allUsers.get(i).getProductList().size(); j++) {
        if (allUsers.get(i).getProductList().get(j).nameProduct.equals(nameProduct)) {
          return allUsers.get(i).getProductList().get(j).info;
        }
      }
    }
    return null;
  }

  public List<Product> getAllProducts() {
    List<Product> productList = new ArrayList<>();
    for (User user : allUsers) {
      for (Product p : user.getProductList()) {
        productList.add(p);
      }
    }
    return productList;
  }
}
