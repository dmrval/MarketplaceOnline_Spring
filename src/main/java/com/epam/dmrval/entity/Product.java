package com.epam.dmrval.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/** Author - Damir_Valeev Created on 9/12/2019 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

  @Id
  @Column(name = "PRODUCTID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int uid;

  @Column(name = "NAMEPRODUCT")
  private String nameProduct;

  @Column(name = "DESCRIPTION")
  private String description;

  @OneToOne
  @JoinColumn(name = "AUCTIONINFO_FK", referencedColumnName = "INFOID")
  private AuctionProductInfo info;

  public Product(int uid, String nameProduct, String description, AuctionProductInfo info) {
    this.uid = uid;
    this.nameProduct = nameProduct;
    this.description = description;
    this.info = info;
  }

  public Product() {}

  public Product(String nameProduct, String description, AuctionProductInfo info) {
    this.nameProduct = nameProduct;
    this.description = description;
    this.info = info;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getNameProduct() {
    return nameProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AuctionProductInfo getInfo() {
    return info;
  }

  public void setInfo(AuctionProductInfo info) {
    this.info = info;
  }

  public LocalDateTime getLocalDateTimeOfProduct() {
    return info.getTime();
  }
}
