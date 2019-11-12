package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.AuctionProductInfo;
import com.epam.dmrval.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/** Author - Damir_Valeev */
@Component
public class AuctionProductInfoHibernateDaoImpl implements AuctionProductInfoHibernateDao {
  @Autowired SessionFactory sessionFactory;
  @Autowired ProductHibernateDao productHibernateDao;

  @Override
  public AuctionProductInfo getAuctionProductInfo(int id_info) {
    sessionFactory.getCurrentSession().beginTransaction();
    AuctionProductInfo temp =
        sessionFactory.getCurrentSession().get(AuctionProductInfo.class, id_info);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return temp;
  }

  @Override
  public AuctionProductInfo getAuctionByIdProduct(int idProduct) {
    List<Product> productList = productHibernateDao.getAllProducts();
    for (Product tmp : productList) {
      if (idProduct == tmp.getUid()) {
        return tmp.getInfo();
      }
    }
    return null;
  }

  @Override
  public long saveAuctionProductInfo(AuctionProductInfo info) {
    sessionFactory.getCurrentSession().beginTransaction();
    Serializable result = sessionFactory.getCurrentSession().save(info);
    long l = info.getId();
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return l;
  }

    @Override
    public void updateAuctionProductInfo(AuctionProductInfo auctionProductInfo) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(auctionProductInfo);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }
}
