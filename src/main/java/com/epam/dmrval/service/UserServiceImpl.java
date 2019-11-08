package com.epam.dmrval.service;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.hibernateDao.UserHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class UserServiceImpl implements UserService {

  @Autowired UserHibernateDao userHibernateDao;

  @Override
  public User findByLogin(String login) {
    return userHibernateDao.findByLogin(login);
  }

  @Override
  public User getUserById(int id) {
    return userHibernateDao.getUserById(id);
  }

  @Override
  public void saveUser(User user) {
    userHibernateDao.saveUser(user);
  }

  @Override
  public int getIdUserByLogin(String user_login) {
    return userHibernateDao.getIdUserByLogin(user_login);
  }
}
