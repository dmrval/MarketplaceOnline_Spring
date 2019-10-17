package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

  @Autowired private AuctionProductInfoDao auctionProductInfoDao;

  @Override
  public Product findByName(String name) {
    return null;
  }

  @Override
  public List<Product> getAllProducts() {
    List<Product> result = new ArrayList<>();
    try {
      try (Connection connection = JdbcConnections.connectToDataBase();
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
      try (Connection connection = JdbcConnections.connectToDataBase();
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
      try (Connection connection = JdbcConnections.connectToDataBase();
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
  public Product getProduct(int id) {
    return null;
  }

  @Override
  public void saveProduct(Product product) {}

  @Override
  public void updateProduct(Product product) {}

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
