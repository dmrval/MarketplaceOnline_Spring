package com.epam.dmrval.entity;

import com.epam.dmrval.validators.IdDigitValid;
import com.epam.dmrval.validators.SearchDigitValid;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/** Author - Damir_Valeev */
public class ProductSearcher {
  @IdDigitValid private int uid = 0;
  private String nameProduct;
  private String description;
  @SearchDigitValid private double minPrice;
  @SearchDigitValid private double maxPrice;
  private boolean isBidding;
  private double stepLevel;
  private String expireDate;
  @SearchDigitValid private double bestOffer;

  public LocalDateTime getLocalDateTimeProduct() {
    try {
      return LocalDateTime.parse(expireDate);
    } catch (DateTimeParseException d) {
      System.out.println("FAIL");
      return LocalDateTime.now();
    }
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

  public double getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(double minPrice) {
    this.minPrice = minPrice;
  }

  public double getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(double maxPrice) {
    this.maxPrice = maxPrice;
  }

  public boolean isBidding() {
    return isBidding;
  }

  public void setBidding(boolean bidding) {
    isBidding = bidding;
  }

  public double getStepLevel() {
    return stepLevel;
  }

  public void setStepLevel(double stepLevel) {
    this.stepLevel = stepLevel;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public double getBestOffer() {
    return bestOffer;
  }

  public void setBestOffer(double bestOffer) {
    this.bestOffer = bestOffer;
  }
}
