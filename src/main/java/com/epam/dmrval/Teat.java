package com.epam.dmrval;

import com.epam.dmrval.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

/** Author - Damir_Valeev */
public class Teat {
  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    sessionFactory.getCurrentSession().beginTransaction();
    User master = new User("AAasddasdasAA", "AAdadasdasdassAA", "AAdasdasdasA", "AAdasdasdAA", Sex.MR, Role.USER);

    AuctionProductInfo temp =
        new AuctionProductInfo(32132123, 1231231223, null, LocalDateTime.now(), master, true);
    sessionFactory.getCurrentSession().save(temp);
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();

    /*AuctionProductInfo info =
        new AuctionProductInfo(11321, 1321, null, LocalDateTime.now(), new User(), true);
    String time = AuctionProductInfoDaoImpl.getLocaldatetime_toTimestampString(info.getTime());
    Query query =
        sessionFactory
            .getCurrentSession()
            .createQuery(
                "INSERT INTO AuctionProductInfo (startPrice,stepLevel,time,master,isBidding) values ("
                    + info.getStartPrice()
                    + ","
                    + info.getStepLevel()
                    + ", TO_TIMESTAMP('"
                    + time
                    + "', 'YYYY-MM-DD HH24:MI')"
                    + ","
                    + 4
                    + ","
                    + 1
                    + ")");
    sessionFactory.getCurrentSession().getTransaction().commit();
    sessionFactory.getCurrentSession().close();*/
  }
}
