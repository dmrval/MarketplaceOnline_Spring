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

  @Autowired AuctionProductInfoDao auctionProductInfoDao;

  @Override
  public Product findByName(String name) {
    return null;
  }

  @Override
  public List<Product> getAllProducts() {
    List<Product> result = new ArrayList<>();
    try {
      try (Connection connection = JdbcConnections.connectToDataBase();
          PreparedStatement ps = connection.prepareStatement("SELECT PRODUCTID,NAMEPRODUCT,DESCRIPTION,AUCTIONINFO_FK FROM  Products")) {
        ResultSet rs = ps.executeQuery();
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new ProductDaoImpl().getAllProducts().get(3).getNameProduct());
  }

  @Override
  public Product getProduct(int id) {
    return null;
  }

  @Override
  public void saveProduct(Product product) {}

  @Override
  public void updateProduct(Product product) {}
}
