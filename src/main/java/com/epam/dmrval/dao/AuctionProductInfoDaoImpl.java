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
import java.time.format.DateTimeFormatter;

/** Author - Damir_Valeev */
@Component
public class AuctionProductInfoDaoImpl implements AuctionProductInfoDao {

  @Autowired private BidderDao bidderDao;
  @Autowired private UserDao userDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    AuctionProductInfo info = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT STARTPRICE,STEPLEVEL,BIDDER_FK,TIME,USER_MASTER_FK,ISBIDDING FROM AUCTIONPRODUCTINFO WHERE INFOID=?")) {
      ResultSet rs = JdbcConnections.insertPreparedStatement(ps, id_info);
      info = buildAuctionProductInfoOfResultSet(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return info;
  }

  @Override
  public AuctionProductInfo getAuctionByIdProduct(int idProduct) {
    AuctionProductInfo info = null;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT STARTPRICE,STEPLEVEL,BIDDER_FK,TIME,USER_MASTER_FK,ISBIDDING FROM PRODUCTS "
                    + "WHERE  = (SELECT products.auctioninfo_fk FROM Products WHERE productid = ?)")) {
      ResultSet rs = JdbcConnections.insertPreparedStatement(ps, idProduct);
      info = buildAuctionProductInfoOfResultSet(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return info;
  }

  @Override
  public long saveAuctionProductInfo(AuctionProductInfo info) {
    Long id_info = 0L;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "INSERT INTO auctionproductinfo (startprice,steplevel,time,user_master_fk,isbidding) VALUES (?,?,?,?,?) ",
                new String[] {"infoid"})) {
      prepareStatement.setDouble(1, info.getStartPrice());
      prepareStatement.setDouble(2, info.getStepLevel());
      prepareStatement.setString(3, getLocaldatetime_toTimestampString(info.getTime()));
      prepareStatement.setInt(4, userDao.getIdUserByLogin(info.getMaster().getLogin()));
      prepareStatement.setInt(5, checkIsBiddingStatusNumber(info.isBidding()));
      prepareStatement.execute();
      ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
      if (null != generatedKeys && generatedKeys.next()) {
        id_info = generatedKeys.getLong(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return id_info;
  }

  private int checkIsBiddingStatusNumber(boolean isBidding) {
    return isBidding ? 1 : 0;
  }

  private String getLocaldatetime_toTimestampString(LocalDateTime localDateTime) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
    return localDateTime.format(dateTimeFormatter);
  }

  private boolean getBiddingByStatusNumber(int statusNumber) {
    return statusNumber == 1;
  }

  private AuctionProductInfo buildAuctionProductInfoOfResultSet(ResultSet rs) throws SQLException {
    AuctionProductInfo info = null;
    while (rs.next()) {
      String timeString = rs.getString(4).replace(" ", "T");
      info =
          new AuctionProductInfo(
              rs.getDouble(1),
              rs.getDouble(2),
              bidderDao.findByBidderId(rs.getInt(3)),
              LocalDateTime.parse(timeString),
              userDao.getUserById(rs.getInt(5)),
              getBiddingByStatusNumber(rs.getInt(6)));
    }
    return info;
  }
}
