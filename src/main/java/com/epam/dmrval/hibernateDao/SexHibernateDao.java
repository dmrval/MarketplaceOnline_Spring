package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Sex;

/** Author - Damir_Valeev */
public interface SexHibernateDao {
  Sex findById(int id_sex);

  int findBySexName(String s_name);
}
