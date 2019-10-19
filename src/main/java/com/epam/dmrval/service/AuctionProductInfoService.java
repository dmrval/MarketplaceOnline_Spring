package com.epam.dmrval.service;

import com.epam.dmrval.entity.AuctionProductInfo;

/** Author - Damir_Valeev */
public interface AuctionProductInfoService {
  AuctionProductInfo getAuctionProductInfo(int id_info);

  AuctionProductInfo getAuctionByIdProduct(int idProduct);

}
