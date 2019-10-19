package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;

import java.util.List;

/** Author - Damir_Valeev */
public interface ProductService {
  Product findByName(String name);

  List<Product> getAllProducts();

  Product getProduct(int id);

  List<Product> getProductsByUserLogin(String login);

  void saveProduct(Product product);

  void updateProduct(Product product);

  void setBidder(Bidder bidder, int id_Product);

  double chechCurrentBiddePrice(int idProduct);

}
