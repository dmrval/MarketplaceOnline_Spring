package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BidderDaoImpl implements BidderDao {

  @Autowired private UserDao userDao;

  @Override
  public Bidder findByBidderId(int id_bidder) {
    Bidder bidder = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT BIDDEROFFER,BIDDERUSER_FK FROM BIDDER WHERE BIDDERID=?")) {
      ResultSet rs = JdbcConnections.insertPreparedStatement(ps, id_bidder);
      while (rs.next()) {
        bidder = new Bidder(rs.getDouble(1), userDao.getUser(rs.getInt(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bidder;
  }
}
