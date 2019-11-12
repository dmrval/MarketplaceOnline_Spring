package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import com.epam.dmrval.hibernateDao.ProductHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** Author - Damir_Valeev */
@Component
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductHibernateDao productHibernateDao;

  @Override
  public List<Product> getAllProducts() {
    return productHibernateDao.getAllProducts();
  }

  @Override
  public List<Product> getProductsByUserLogin(String login) {
    return productHibernateDao.getProductsByUserLogin(login);
  }

  @Override
  public void saveProduct(Product product) {
    productHibernateDao.saveProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
    productHibernateDao.updateProduct(product);
  }

  @Override
  public void setBidder(Bidder bidder, int id_Product) {
    productHibernateDao.setBidder(bidder, id_Product);
  }

  @Override
  public double chechCurrentBiddePrice(int idProduct) {
    return productHibernateDao.chechCurrentBiddePrice(idProduct);
  }

  @Override
  public void transferProduct(int idProduct, int idNewUser) {
    productHibernateDao.transferProduct(idProduct, idNewUser);
  }

  @Override
  public Product getProduct(int id) {
    return productHibernateDao.getProduct(id);
  }
}
