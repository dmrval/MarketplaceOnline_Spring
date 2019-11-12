package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class BidderHibernateDaoImpl implements BidderHibernateDao {
  @Autowired SessionFactory sessionFactory;

  @Override
  public Bidder findByBidderId(int id_bidder) {
    sessionFactory.getCurrentSession().beginTransaction();
    Bidder temp = sessionFactory.getCurrentSession().get(Bidder.class, id_bidder);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return temp;
  }

  @Override
  public Long saveBidder(Bidder bidder) {
    sessionFactory.getCurrentSession().beginTransaction();
    sessionFactory.getCurrentSession().save(bidder);
    long l = bidder.getId();
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return l;
  }
}
