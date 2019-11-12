package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/** Author - Damir_Valeev */
@Component
public class UserHibernateDaoImp implements UserHibernateDao {

  @Autowired SessionFactory sessionFactory;

  @Override
  public User findByLogin(String login) {
    sessionFactory.getCurrentSession().beginTransaction();
    CriteriaQuery<User> criteriaQuery =
        sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(User.class);
    criteriaQuery.from(User.class);
    List<User> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
    for (User u : list) {
      if (u.getLogin().equals(login)) {
        User temp = u;
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
      }
    }
    return null;
  }

  @Override
  public User getUserById(int id) {
    sessionFactory.getCurrentSession().beginTransaction();
    User temp = sessionFactory.getCurrentSession().get(User.class, id);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
    return temp;
  }

  @Override
  public int getIdUserByLogin(String user_login) {
    User result = findByLogin(user_login);
    return result.getId();
  }

  @Override
  public void saveUser(User user) {
    sessionFactory.getCurrentSession().beginTransaction();
    Serializable result = sessionFactory.getCurrentSession().save(user);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();
  }
}
