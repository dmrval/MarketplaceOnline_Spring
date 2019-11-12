package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Bidder;
import com.epam.dmrval.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
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
    List<Product> allProducts = getAllProducts();
    List<Product> userProducts = new ArrayList<>();
    for (Product tmp : allProducts) {
      if (tmp.getInfo().getMaster().getId() == usedId) {
        userProducts.add(tmp);
      }
    }
    return userProducts;
  }

  @Override
  public List<Product> getProductsByUserLogin(String login) {
    List<Product> allProducts = getAllProducts();
    List<Product> userProducts = new ArrayList<>();
    for (Product tmp : allProducts) {
      if (tmp.getInfo().getMaster().getLogin().equals(login)) {
        userProducts.add(tmp);
      }
    }
    return userProducts;
  }

  @Override
  public void saveProduct(Product product) {
    sessionFactory.getCurrentSession().beginTransaction();
    sessionFactory.getCurrentSession().save(product.getInfo());
    sessionFactory.getCurrentSession().save(product);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
  }

  @Override
  public void setBidder(Bidder bidder, int id_Product) {
  }

  @Override
  public double chechCurrentBiddePrice(int idProduct) {
    return 0;
  }

  @Override
  public void transferProduct(int idProduct, int idNewUser) {}

  @Override
  public Product getProduct(int id) {
    sessionFactory.getCurrentSession().beginTransaction();
    Product temp = sessionFactory.getCurrentSession().get(Product.class, id);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return temp;
  }

  @Override
  public void updateProduct(Product product) {
    sessionFactory.getCurrentSession().beginTransaction();
    sessionFactory.getCurrentSession().save(product.getInfo().getBidder());
    sessionFactory.getCurrentSession().update(product.getInfo());
    sessionFactory.getCurrentSession().update(product);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
  }
}
