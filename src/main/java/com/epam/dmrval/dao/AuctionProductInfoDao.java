package com.epam.dmrval.dao;

import com.epam.dmrval.entity.AuctionProductInfo;
import com.epam.dmrval.entity.Bidder;

/** Author - Damir_Valeev */
public interface AuctionProductInfoDao {
  AuctionProductInfo getAuctionProductInfo(int id_info);

  AuctionProductInfo getAuctionByIdProduct(int idProduct);

  long saveAuctionProductInfo(AuctionProductInfo info);

}
