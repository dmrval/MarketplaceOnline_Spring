package com.epam.dmrval.service;

import com.epam.dmrval.entity.AuctionProductInfo;
import com.epam.dmrval.hibernateDao.AuctionProductInfoHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class AuctionProductInfoServiceImpl implements AuctionProductInfoService {
  @Autowired private AuctionProductInfoHibernateDao auctionProductInfoHibernateDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    return auctionProductInfoHibernateDao.getAuctionProductInfo(id_info);
  }

  @Override
  public AuctionProductInfo getAuctionByIdProduct(int idProduct) {
    return auctionProductInfoHibernateDao.getAuctionByIdProduct(idProduct);
  }
}
