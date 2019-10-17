package com.epam.dmrval.service;

import com.epam.dmrval.entity.User;

import java.util.List;

/** Author - Damir_Valeev */
public interface UserService {
  User findByLogin(String login);

  List<User> getAllUsers();

  User getUserById(int id);

  void saveUser(User user);

  void updateUser(User user);
}
