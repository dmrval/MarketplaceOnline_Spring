package com.epam.dmrval.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev Created on 9/16/2019 */
public class UsersHelper {
  private List<User> allUsers = new ArrayList<>();

  public UsersHelper() {
    User currentUser = new User("Ivanov Ivan Ivanovich", "Stepnaya 9", "v", "v", Sex.MR, Role.USER);
    currentUser
        .getProductList()
        .add(
            new Product(
                1,
                "Monitor",
                "Lcd display",
                new AuctionProductInfo(15000, 1000, LocalDateTime.now(), currentUser, true)));
    currentUser
        .getProductList()
        .add(
            new Product(
                2,
                "Glass boll",
                "Glass bol",
                new AuctionProductInfo(1000, 100, LocalDateTime.now(), currentUser)));

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
                    100, 10, new Bidder(20, currentUser), LocalDateTime.now(), secondUser, true)));

    allUsers.add(currentUser);
    allUsers.add(secondUser);
  }

  List<User> getAllUsers() {
    return allUsers;
  }

  public void setAllUsers(List<User> allUsers) {
    this.allUsers = allUsers;
  }

  public void addUser(User u) {
    this.allUsers.add(u);
  }

  public User getUserByLogin(String login) {
    for (User tmp : allUsers) {
      if (tmp.getLogin().equals(login)) {
        return tmp;
      }
    }
    return null;
  }

  public AuctionProductInfo getAuctionByIdProduct(int id) {
    for (int i = 0; i < allUsers.size(); i++) {
      for (int j = 0; j < allUsers.get(i).getProductList().size(); j++) {
        if (allUsers.get(i).getProductList().get(j).getUid() == id) {
          return allUsers.get(i).getProductList().get(j).getInfo();
        }
      }
    }
    return null;
  }

  public List<Product> getAllProducts() {
    List<Product> productList = new ArrayList<>();
    for (User user : allUsers) {
      productList.addAll(user.getProductList());
    }
    return productList;
  }
}
