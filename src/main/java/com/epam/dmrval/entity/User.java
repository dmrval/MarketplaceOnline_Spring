package com.epam.dmrval.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev */
@Component
public class User implements Serializable {
  private String fullname;
  private String address;
  private String login;
  private String password;
  private Sex sex;
  private List<Product> productList;
  private Role userRole;

  public User(String fullname, String address, String login, Sex sex) {
    productList = new ArrayList<>();
    this.fullname = fullname;
    this.address = address;
    this.login = login;
    this.sex = sex;
  }

  public User(
      String fullname, String address, String login, String password, Sex sex, Role userRole) {
    productList = new ArrayList<>();
    this.fullname = fullname;
    this.address = address;
    this.login = login;
    this.password = password;
    this.sex = sex;
    this.userRole = userRole;
  }

  public User() {
    this.userRole = Role.USER;
    productList = new ArrayList<>();
  }

  public User(String fullname) {
    this.fullname = fullname;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public Role getUserRole() {
    return userRole;
  }

  public void setUserRole(Role userRole) {
    this.userRole = userRole;
  }
}
