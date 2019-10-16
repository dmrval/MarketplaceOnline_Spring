package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;

public interface BidderService {
  Bidder findByBidderId(int id_bidder);
}
