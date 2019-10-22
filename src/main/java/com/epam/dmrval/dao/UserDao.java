package com.epam.dmrval.dao;

import com.epam.dmrval.entity.User;

import java.util.List;

/** Author - Damir_Valeev */
public interface UserDao {
  User findByLogin(String login);

  User getUserById(int id);

  int getIdUserByLogin(String user_login);

  void saveUser(User user);

}
