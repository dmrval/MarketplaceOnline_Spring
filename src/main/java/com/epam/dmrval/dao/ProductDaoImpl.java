package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Author - Damir_Valeev */
//@Component
public class ProductDaoImpl implements ProductDao {

  @Autowired private AuctionProductInfoDao auctionProductInfoDao;
  @Autowired private BidderDao bidderDao;
  @Autowired private DataSource dataSource;

  @Override
  public List<Product> getAllProducts() {
    List<Product> result = new ArrayList<>();
    try {
      try (Connection connection = dataSource.getConnection();
          PreparedStatement ps =
              connection.prepareStatement(
                  "SELECT PRODUCTID,NAMEPRODUCT,DESCRIPTION,AUCTIONINFO_FK FROM  PRODUCTS")) {
        ResultSet rs = ps.executeQuery();
        buildProductsListOfResultSet(rs, result);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Product> getProductsByUserId(int usedId) {
    List<Product> result = new ArrayList<>();
    try {
      try (Connection connection = dataSource.getConnection();
          PreparedStatement ps =
              connection.prepareStatement(
                  "SELECT PRODUCTID,NAMEPRODUCT,DESCRIPTION,AUCTIONINFO_FK FROM PRODUCTS "
                      + "where AUCTIONINFO_FK IN"
                      + "(SELECT INFOID FROM AUCTIONPRODUCTINFO WHERE USER_MASTER_FK=?)")) {
        ps.setInt(1, usedId);
        ResultSet rs = ps.executeQuery();
        buildProductsListOfResultSet(rs, result);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Product> getProductsByUserLogin(String login) {
    List<Product> result = new ArrayList<>();
    try {
      try (Connection connection = dataSource.getConnection();
          PreparedStatement ps =
              connection.prepareStatement(
                  "SELECT PRODUCTID, NAMEPRODUCT,DESCRIPTION,AUCTIONINFO_FK FROM PRODUCTS "
                      + "WHERE AUCTIONINFO_FK IN "
                      + "(SELECT AUCTIONPRODUCTINFO.INFOID FROM AUCTIONPRODUCTINFO LEFT JOIN USERS ON "
                      + "(USERS.USERID=AUCTIONPRODUCTINFO.USER_MASTER_FK) WHERE USERS.LOGIN=?)")) {
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        buildProductsListOfResultSet(rs, result);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void saveProduct(Product product) {
    long id_auction_info = auctionProductInfoDao.saveAuctionProductInfo(product.getInfo());
    try (Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "INSERT INTO PRODUCTS (NAMEPRODUCT,DESCRIPTION,AUCTIONINFO_FK) VALUES (?,?,?)")) {
      prepareStatement.setString(1, product.getNameProduct());
      prepareStatement.setString(2, product.getDescription());
      prepareStatement.setLong(3, id_auction_info);
      prepareStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setBidder(Bidder bidder, int id_Product) {
    long id_bidder = bidderDao.saveBidder(bidder);
    try (Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "UPDATE AUCTIONPRODUCTINFO SET BIDDER_FK=? WHERE INFOID=" +
                        "(SELECT products.auctioninfo_fk FROM Products "
                    + "WHERE PRODUCTID=?) ")) {
      prepareStatement.setLong(1, id_bidder);
      prepareStatement.setInt(2, id_Product);
      prepareStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public double chechCurrentBiddePrice(int idProduct) {
    double currBiddPrice = 0;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "SELECT BIDDEROFFER FROM BIDDER WHERE BIDDERID="
                    + "(SELECT BIDDER_FK FROM AUCTIONPRODUCTINFO WHERE INFOID="
                    + "(SELECT AUCTIONINFO_FK FROM PRODUCTS WHERE PRODUCTID=?))")) {
      prepareStatement.setInt(1, idProduct);
      ResultSet rs = prepareStatement.executeQuery();
      while (rs.next()) {
        currBiddPrice = rs.getDouble(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return currBiddPrice;
  }

  @Override
  public void transferProduct(int idProduct, int idNewUser) {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement =
            connection.prepareStatement(
                "UPDATE AUCTIONPRODUCTINFO SET USER_MASTER_FK=?, BIDDER_FK=NULL WHERE INFOID = " +
                        "(SELECT AUCTIONINFO_FK FROM PRODUCTS WHERE PRODUCTID = ?)")) {
      prepareStatement.setInt(1, idNewUser);
      prepareStatement.setInt(2, idProduct);
      prepareStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void buildProductsListOfResultSet(ResultSet rs, List<Product> result)
      throws SQLException {
    Product temp;
    while (rs.next()) {
      temp =
          new Product(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              auctionProductInfoDao.getAuctionProductInfo(rs.getInt(4)));
      result.add(temp);
    }
  }
}
