package com.epam.dmrval.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Author - Damir_Valeev Created on 9/19/2019 */
public class AuctionProductInfo {
  private double startPrice;
  private double stepLevel;
  private Bidder bidder;
  private LocalDateTime time;
  private User master;
  private boolean isBidding;

  {
    bidder = new Bidder(0, new User());
  }

  AuctionProductInfo(double startPrice, double stepLevel, LocalDateTime time, User master) {
    this.startPrice = startPrice;
    this.stepLevel = stepLevel;
    this.time = time;
    this.master = master;
  }

  public AuctionProductInfo() {}

  AuctionProductInfo(
      double startPrice, double stepLevel, LocalDateTime time, User master, boolean isBidding) {
    this.startPrice = startPrice;
    this.stepLevel = stepLevel;
    this.time = time;
    this.master = master;
    this.isBidding = isBidding;
  }

  public AuctionProductInfo(
          double startPrice,
          double stepLevel,
          Bidder bidder,
          LocalDateTime time,
          User master,
          boolean isBidding) {
    this.startPrice = startPrice;
    this.stepLevel = stepLevel;
    this.bidder = bidder;
    this.time = time;
    this.master = master;
    this.isBidding = isBidding;
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

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
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

  public String getLocalDateTime() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return this.time.format(dateTimeFormatter);
  }
}
