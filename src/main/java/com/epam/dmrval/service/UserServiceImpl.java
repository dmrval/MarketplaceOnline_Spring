package com.epam.dmrval.service;

import com.epam.dmrval.dao.UserDao;
import com.epam.dmrval.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** Author - Damir_Valeev */
@Component
public class UserServiceImpl implements UserService {

  @Autowired UserDao userDao;

  @Override
  public User findByLogin(String login) {
    return userDao.findByLogin(login);
  }

  @Override
  public User getUserById(int id) {
    return userDao.getUserById(id);
  }

  @Override
  public void saveUser(User user) {
    userDao.saveUser(user);
  }

  @Override
  public int getIdUserByLogin(String user_login) {
    return userDao.getIdUserByLogin(user_login);
  }
}
