package com.epam.dmrval.service;

import com.epam.dmrval.dao.SexDao;
import com.epam.dmrval.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class SexServiceImpl implements SexService {

  @Autowired private SexDao sexDao;

  @Override
  public Sex findById(int id_sex) {
    return sexDao.findById(id_sex);
  }

  @Override
  public int findBySexName(String s_name) {
    return sexDao.findBySexName(s_name);
  }
}
