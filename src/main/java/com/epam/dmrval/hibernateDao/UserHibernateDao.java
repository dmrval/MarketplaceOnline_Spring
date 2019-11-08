package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.User;

/** Author - Damir_Valeev */
public interface UserHibernateDao {
  User findByLogin(String login);

  User getUserById(int id);

  int getIdUserByLogin(String user_login);

  void saveUser(User user);
}
