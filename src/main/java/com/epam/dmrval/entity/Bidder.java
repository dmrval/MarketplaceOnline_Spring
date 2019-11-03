package com.epam.dmrval.entity;

import javax.persistence.*;

/** Author - Damir_Valeev Created on 9/19/2019 */
@Entity
@Table(name = "BIDDER")
public class Bidder {
  @Id
  @Column(name = "BIDDERID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "BIDDEROFFER")
  private double bidderOffer;

  @ManyToOne
  @JoinColumn(name = "BIDDERUSER_FK", referencedColumnName = "USERID")
  private User bidderUser;

  public Bidder(double bidderOffer, User bidderUser) {
    this.bidderOffer = bidderOffer;
    this.bidderUser = bidderUser;
  }

  public Bidder() {}

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
