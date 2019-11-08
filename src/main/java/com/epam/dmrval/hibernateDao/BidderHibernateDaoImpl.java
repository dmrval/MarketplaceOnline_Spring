package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class BidderHibernateDaoImpl implements BidderHibernateDao {
  @Override
  public Bidder findByBidderId(int id_bidder) {
    return null;
  }

  @Override
  public Long saveBidder(Bidder bidder) {
    return null;
  }
}
