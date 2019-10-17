package com.epam.dmrval.service;

import com.epam.dmrval.dao.BidderDao;
import com.epam.dmrval.entity.Bidder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class BidderServiceImpl implements BidderService {
  @Autowired BidderDao bidderDao;

  @Override
  public Bidder findByBidderId(int id_bidder) {
    return bidderDao.findByBidderId(id_bidder);
  }
}
