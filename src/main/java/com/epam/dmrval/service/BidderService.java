package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;

/** Author - Damir_Valeev */
public interface BidderService {
  Bidder findByBidderId(int id_bidder);
}
