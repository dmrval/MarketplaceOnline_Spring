package com.epam.dmrval.processbase;

import com.epam.dmrval.entity.Product;
import com.epam.dmrval.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Author - Damir_Valeev */
@Service
public class GlobalAttribute {

  @Autowired ProductService productService;
  private boolean firstInitFlag = true;

  private List<Product> allProducts;

  public List<Product> getAllProducts() {
    if (!firstInitFlag) {
      return allProducts;
    } else {
      refreshAllProducts();
      firstInitFlag = false;
      return allProducts;
    }
  }

  public void setAllProducts(List<Product> allProducts) {
    this.allProducts = allProducts;
  }

  public void refreshAllProducts() {
    allProducts = productService.getAllProducts();
  }
}
