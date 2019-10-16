package com.epam.dmrval.dao;

import com.epam.dmrval.entity.AuctionProductInfo;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class AuctionProductInfoDaoImpl implements AuctionProductInfoDao {

  @Autowired BidderDao bidderDao;
  @Autowired UserDao userDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    AuctionProductInfo info = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT STARTPRICE,STEPLEVEL,BIDDER_FK,TIME,USER_MASTER_FK,ISBIDDING FROM AUCTIONPRODUCTINFO WHERE INFOID=?")) {
      ResultSet rs = JdbcConnections.insertPreparedStatement(ps, id_info);
      while (rs.next()) {
        String timeString = rs.getString(4).replace(" ", "T");
        info =
            new AuctionProductInfo(
                rs.getDouble(1),
                rs.getDouble(2),
                bidderDao.findByBidderId(rs.getInt(3)),
                LocalDateTime.parse(timeString),
                userDao.getUser(rs.getInt(5)),
                false);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return info;
  }
}
