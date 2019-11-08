package com.epam.dmrval.service;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.hibernateDao.BidderHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class BidderServiceImpl implements BidderService {
  @Autowired private BidderHibernateDao bidderHibernateDao;

  @Override
  public Bidder findByBidderId(int id_bidder) {
    return bidderHibernateDao.findByBidderId(id_bidder);
  }
}
