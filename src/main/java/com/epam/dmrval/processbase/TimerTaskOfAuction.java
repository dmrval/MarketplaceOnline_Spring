package com.epam.dmrval.processbase;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import com.epam.dmrval.service.ProductService;
import com.epam.dmrval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/** Author - Damir_Valeev */
@Component
public class TimerTaskOfAuction {

  @Autowired ProductService productService;
  @Autowired UserService userService;
  @Autowired GlobalAttribute globalAttribute;

  public void transferGoods() {
    List<Product> productList = new ArrayList<>(globalAttribute.getAllProducts());
    List<Product> products =
        productList.stream()
            .filter(
                integerLocalDateTime ->
                    integerLocalDateTime.getInfo().getTime().isBefore(LocalDateTime.now()))
            .collect(Collectors.toList());
    if (products.size() != 0) {
      for (int i = 0; i < products.size(); i++) {
        Bidder buyer = products.get(i).getInfo().getBidder();
        int idProduct = products.get(i).getUid();
        if (!Objects.isNull(buyer)) {
          int idNewUser = userService.getIdUserByLogin(buyer.getBidderUser().getLogin());
          productService.transferProduct(idProduct, idNewUser);
          productList.remove(i);
          globalAttribute.refreshAllProducts();
        }
      }
    }
  }
}
