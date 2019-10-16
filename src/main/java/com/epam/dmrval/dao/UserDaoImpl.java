package com.epam.dmrval.dao;

import com.epam.dmrval.entity.User;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
  @Autowired RoleDao roleDao;
  @Autowired SexDao sexDao;

  @Override
  public User findByLogin(String login) {
    return null;
  }

  @Override
  public List<User> getAllUsers() {
    return null;
  }

  @Override
  public User getUser(int id) {
    User user = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps = connection.prepareStatement("SELECT FULLNAME,ADDRESS,LOGIN,PASSWORD,GENDER,ROLE FROM USERS WHERE USERID=?")) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        user =
            new User(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                sexDao.findById(rs.getInt(5)),
                roleDao.findById(rs.getInt(6)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void saveUser(User user) {}

  @Override
  public void updateUser(User user) {}
}