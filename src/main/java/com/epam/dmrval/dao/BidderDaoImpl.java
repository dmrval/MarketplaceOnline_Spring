package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Author - Damir_Valeev */
@Component
public class BidderDaoImpl implements BidderDao {

  @Autowired private UserDao userDao;
  @Autowired private DataSource dataSource;

  @Override
  public Bidder findByBidderId(int id_bidder) {
    Bidder bidder = null;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement ps =
            connection.prepareStatement(
                "SELECT BIDDEROFFER,BIDDERUSER_FK FROM BIDDER WHERE BIDDERID=?")) {
      ResultSet rs = insertPreparedStatement(ps, id_bidder);
      while (rs.next()) {
        bidder = new Bidder(rs.getDouble(1), userDao.getUserById(rs.getInt(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bidder;
  }

  @Override
  public Long saveBidder(Bidder bidder) {
    Long id_bidder = 0L;
    int currBidder = userDao.getIdUserByLogin(bidder.getBidderUser().getLogin());
    try (Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "INSERT INTO BIDDER (BIDDEROFFER,BIDDERUSER_FK) VALUES (?,?) ",
                new String[] {"bidderid"})) {
      prepareStatement.setDouble(1, bidder.getBidderOffer());
      prepareStatement.setInt(2, currBidder);
      prepareStatement.execute();
      ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
      if (null != generatedKeys && generatedKeys.next()) {
        id_bidder = generatedKeys.getLong(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return id_bidder;
  }

  private ResultSet insertPreparedStatement(PreparedStatement ps, int id) throws SQLException {
    ps.setInt(1, id);
    return ps.executeQuery();
  }
}
