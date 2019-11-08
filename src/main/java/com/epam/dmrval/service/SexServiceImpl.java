package com.epam.dmrval.service;

import com.epam.dmrval.entity.Sex;
import com.epam.dmrval.hibernateDao.SexHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class SexServiceImpl implements SexService {

  @Autowired private SexHibernateDao sexHibernateDao;

  @Override
  public Sex findById(int id_sex) {
    return sexHibernateDao.findById(id_sex);
  }

  @Override
  public int findBySexName(String s_name) {
    return sexHibernateDao.findBySexName(s_name);
  }
}
