package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.AuctionProductInfo;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class AuctionProductInfoHibernateDaoImpl implements AuctionProductInfoHibernateDao {
  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    return null;
  }

  @Override
  public AuctionProductInfo getAuctionByIdProduct(int idProduct) {
    return null;
  }

  @Override
  public long saveAuctionProductInfo(AuctionProductInfo info) {
    return 0;
  }
}
