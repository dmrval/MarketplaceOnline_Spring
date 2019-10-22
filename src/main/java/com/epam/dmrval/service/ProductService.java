package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;

import java.util.List;

/** Author - Damir_Valeev */
public interface ProductService {

  List<Product> getAllProducts();

  List<Product> getProductsByUserLogin(String login);

  void saveProduct(Product product);

  void updateProduct(Product product);

  void setBidder(Bidder bidder, int id_Product);

  double chechCurrentBiddePrice(int idProduct);

  void transferProduct(int idProduct, int idNewUser);


}
