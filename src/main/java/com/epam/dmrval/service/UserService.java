package com.epam.dmrval.service;

import com.epam.dmrval.entity.User;

import java.util.List;

public interface UserService {
  User findByLogin(String login);

  List<User> getAllUsers();

  User getUser(int id);

  void saveUser(User user);

  void updateUser(User user);
}
