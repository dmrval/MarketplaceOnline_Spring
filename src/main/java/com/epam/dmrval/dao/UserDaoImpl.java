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

/** Author - Damir_Valeev */
@Component
public class UserDaoImpl implements UserDao {
  @Autowired private RoleDao roleDao;
  @Autowired private SexDao sexDao;

  @Override
  public User findByLogin(String login) {
    User user = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT FULLNAME,ADDRESS,LOGIN,PASSWORD,GENDER,ROLE FROM USERS WHERE LOGIN=?")) {
      ps.setString(1, login);
      ResultSet rs = ps.executeQuery();
      user = buildUserOfResultSet(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    return null;
  }

  @Override
  public User getUserById(int id) {
    User user = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT FULLNAME,ADDRESS,LOGIN,PASSWORD,GENDER,ROLE FROM USERS WHERE USERID=?")) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      user = buildUserOfResultSet(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void saveUser(User user) {
    int genderId = sexDao.findBySexName(user.getSex().name());
    System.out.println(user.getSex().name());
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "INSERT INTO USERS (FULLNAME,ADDRESS,LOGIN,PASSWORD,GENDER,ROLE) VALUES (?,?,?,?,?,1)")) {
      ps.setString(1, user.getFullname());
      ps.setString(2, user.getAddress());
      ps.setString(3, user.getLogin());
      ps.setString(4, user.getPassword());
      ps.setInt(5, genderId);
      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateUser(User user) {}

  private User buildUserOfResultSet(ResultSet rs) throws SQLException {
    User user = null;
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
    return user;
  }
}
