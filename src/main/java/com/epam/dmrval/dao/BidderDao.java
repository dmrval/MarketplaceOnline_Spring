package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Bidder;

public interface BidderDao {
  Bidder findByBidderId(int id_bidder);
}
