package com.epam.dmrval.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/** Author - Damir_Valeev */
@Service
@Entity
@Table(name = "USERS")
public class User implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "USERID", nullable = false)
  private int id;

  @Column(name = "FULLNAME")
  private String fullname;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "LOGIN")
  private String login;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "GENDER", columnDefinition = "GENDER")
  @Convert(converter = SexAttributeConverter.class)
  private Sex sex;

  @Column(name = "ROLE")
  @Convert(converter = RoleAttributeConverter.class)
  private Role userRole;

  public User(String fullname, String address, String login, Sex sex) {
    this.fullname = fullname;
    this.address = address;
    this.login = login;
    this.sex = sex;
  }

  public User(
      String fullname, String address, String login, String password, Sex sex, Role userRole) {
    this.fullname = fullname;
    this.address = address;
    this.login = login;
    this.password = password;
    this.sex = sex;
    this.userRole = userRole;
  }

  public User() {
    this.userRole = Role.USER;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
