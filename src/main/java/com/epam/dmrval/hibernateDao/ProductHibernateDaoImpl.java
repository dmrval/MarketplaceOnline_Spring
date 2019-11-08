package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/** Author - Damir_Valeev */
@Component
public class ProductHibernateDaoImpl implements ProductHibernateDao {

  @Autowired SessionFactory sessionFactory;

  @Override
  public List<Product> getAllProducts() {
    sessionFactory.openSession();
    sessionFactory.getCurrentSession().beginTransaction();
    CriteriaQuery<Product> criteriaQuery =
        sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Product.class);
    criteriaQuery.from(Product.class);
    List<Product> list =
        sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
    return list;
  }

  @Override
  public List<Product> getProductsByUserId(int usedId) {
    return null;
  }

  @Override
  public List<Product> getProductsByUserLogin(String login) {
    return null;
  }

  @Override
  public void saveProduct(Product product) {}

  @Override
  public void setBidder(Bidder bidder, int id_Product) {}

  @Override
  public double chechCurrentBiddePrice(int idProduct) {
    return 0;
  }

  @Override
  public void transferProduct(int idProduct, int idNewUser) {}
}
