package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.AuctionProductInfo;

/** Author - Damir_Valeev */
public interface AuctionProductInfoHibernateDao {
  AuctionProductInfo getAuctionProductInfo(int id_info);

  AuctionProductInfo getAuctionByIdProduct(int idProduct);

  long saveAuctionProductInfo(AuctionProductInfo info);
}
