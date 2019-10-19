package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;

/** Author - Damir_Valeev */
public interface BidderDao {
  Bidder findByBidderId(int id_bidder);

  Long saveBidder(Bidder bidder);
}
