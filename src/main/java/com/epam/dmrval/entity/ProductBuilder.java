package com.epam.dmrval.entity;

import com.epam.dmrval.validators.MinPrice;
import com.epam.dmrval.validators.NotNullStringValue;
import com.epam.dmrval.validators.TimeValid;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/** Author - Damir_Valeev */
public class ProductBuilder {

  private int uid;

  @NotNullStringValue private String nameProduct;

  @NotNullStringValue private String description;

  @MinPrice private double startPrice;

  @MinPrice private double stepLevel;

  private Bidder bidder;

  @TimeValid private String time;

  private User master;
  private boolean isBidding;

  public Product build(User user) {
    if (!time.isEmpty()) {
      try {
        LocalDateTime timeLocal = LocalDateTime.parse(time);
        AuctionProductInfo auctionProductInfo =
            new AuctionProductInfo(startPrice, stepLevel, timeLocal, user, isBidding);
        Product result = new Product(nameProduct, description, auctionProductInfo);
        return result;
      } catch (DateTimeParseException d) {
        return null;
      }
    } else return null;
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

  public double getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(double startPrice) {
    this.startPrice = startPrice;
  }

  public double getStepLevel() {
    return stepLevel;
  }

  public void setStepLevel(double stepLevel) {
    this.stepLevel = stepLevel;
  }

  public Bidder getBidder() {
    return bidder;
  }

  public void setBidder(Bidder bidder) {
    this.bidder = bidder;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public User getMaster() {
    return master;
  }

  public void setMaster(User master) {
    this.master = master;
  }

  public boolean isBidding() {
    return isBidding;
  }

  public void setBidding(boolean bidding) {
    isBidding = bidding;
  }
}
