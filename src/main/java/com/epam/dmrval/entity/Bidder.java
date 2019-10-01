package com.epam.dmrval.entity;

/** Author - Damir_Valeev Created on 9/19/2019 */
public class Bidder {
  double bidderOffer;
  User bidderUser;

  public Bidder(double bidderOffer, User bidderUser) {
    this.bidderOffer = bidderOffer;
    this.bidderUser = bidderUser;
  }

  public double getBidderOffer() {
    return bidderOffer;
  }

  public void setBidderOffer(double bidderOffer) {
    this.bidderOffer = bidderOffer;
  }

  public User getBidderUser() {
    return bidderUser;
  }

  public void setBidderUser(User bidderUser) {
    this.bidderUser = bidderUser;
  }
}
