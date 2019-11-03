package com.epam.dmrval.service;

import com.epam.dmrval.dao.AuctionProductInfoDao;
import com.epam.dmrval.entity.AuctionProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class AuctionProductInfoServiceImpl implements AuctionProductInfoService {
  @Autowired private AuctionProductInfoDao auctionProductInfoDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    return auctionProductInfoDao.getAuctionProductInfo(id_info);
  }

  @Override
  public AuctionProductInfo getAuctionByIdProduct(int idProduct) {
    return auctionProductInfoDao.getAuctionByIdProduct(idProduct);
  }
}