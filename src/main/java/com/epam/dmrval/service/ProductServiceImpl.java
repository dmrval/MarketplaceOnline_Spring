package com.epam.dmrval.service;

import com.epam.dmrval.dao.ProductDao;
import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** Author - Damir_Valeev */
@Component
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductDao productDao;

  @Override
  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }

  @Override
  public List<Product> getProductsByUserLogin(String login) {
    return productDao.getProductsByUserLogin(login);
  }

  @Override
  public void saveProduct(Product product) {
    productDao.saveProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
    productDao.saveProduct(product);
  }

  @Override
  public void setBidder(Bidder bidder, int id_Product) {
    productDao.setBidder(bidder, id_Product);
  }

  @Override
  public double chechCurrentBiddePrice(int idProduct) {
    return productDao.chechCurrentBiddePrice(idProduct);
  }

  @Override
  public void transferProduct(int idProduct, int idNewUser) {
    productDao.transferProduct(idProduct,idNewUser);
  }
}
