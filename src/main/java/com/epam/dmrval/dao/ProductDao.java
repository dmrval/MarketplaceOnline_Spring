package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Product;

import java.util.List;

public interface ProductDao {
  Product findByName(String name);

  List<Product> getAllProducts();

  Product getProduct(int id);

  void saveProduct(Product product);

  void updateProduct(Product product);
}
