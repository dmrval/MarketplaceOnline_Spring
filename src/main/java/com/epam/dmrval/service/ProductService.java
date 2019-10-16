package com.epam.dmrval.service;

import com.epam.dmrval.entity.Product;

import java.util.List;

public interface ProductService {
  Product findByName(String name);

  List<Product> getAllProducts();

  Product getProduct(int id);

  void saveProduct(Product product);

  void updateProduct(Product product);
}
