package com.epam.dmrval.service;

import com.epam.dmrval.entity.User;

import java.util.List;

/** Author - Damir_Valeev */
public interface UserService {
  User findByLogin(String login);

  User getUserById(int id);

  void saveUser(User user);

  int getIdUserByLogin(String user_login);
}
