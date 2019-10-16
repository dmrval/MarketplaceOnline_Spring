package com.epam.dmrval.service;

import com.epam.dmrval.dao.ProductDao;
import com.epam.dmrval.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
  @Autowired ProductDao productDao;

  @Override
  public Product findByName(String name) {
    return productDao.findByName(name);
  }

  @Override
  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }

  @Override
  public Product getProduct(int id) {
    return productDao.getProduct(id);
  }

  @Override
  public void saveProduct(Product product) {
    productDao.saveProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
    productDao.saveProduct(product);
  }
}
