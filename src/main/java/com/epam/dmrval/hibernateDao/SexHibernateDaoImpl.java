package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Sex;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class SexHibernateDaoImpl implements SexHibernateDao {
  @Override
  public Sex findById(int id_sex) {
    return null;
  }

  @Override
  public int findBySexName(String s_name) {
    return 0;
  }
}
