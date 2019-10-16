package com.epam.dmrval.service;

import com.epam.dmrval.dao.AuctionProductInfoDao;
import com.epam.dmrval.entity.AuctionProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuctionProductInfoServiceImpl implements AuctionProductInfoService {
  @Autowired AuctionProductInfoDao auctionProductInfoDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    return auctionProductInfoDao.getAuctionProductInfo(id_info);
  }
}
