package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;

/** Author - Damir_Valeev */
public interface BidderHibernateDao {
  Bidder findByBidderId(int id_bidder);

  Long saveBidder(Bidder bidder);
}
