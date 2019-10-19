package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;

import java.util.List;

/** Author - Damir_Valeev */
public interface ProductDao {
  Product findByName(String name);

  List<Product> getAllProducts();

  List<Product> getProductsByUserId(int usedId);

  List<Product> getProductsByUserLogin(String login);

  Product getProduct(int id);

  void saveProduct(Product product);

  void updateProduct(Product product);

  void setBidder(Bidder bidder, int id_Product);

  double chechCurrentBiddePrice(int idProduct);

}
