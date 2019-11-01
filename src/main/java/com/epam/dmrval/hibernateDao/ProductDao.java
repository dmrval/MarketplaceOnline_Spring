package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;

import java.util.List;

/** Author - Damir_Valeev */
public interface ProductDao {

  List<Product> getAllProducts();

  List<Product> getProductsByUserId(int usedId);

  List<Product> getProductsByUserLogin(String login);

  void saveProduct(Product product);

  void setBidder(Bidder bidder, int id_Product);

  double chechCurrentBiddePrice(int idProduct);

  void transferProduct(int idProduct, int idNewUser);

}
