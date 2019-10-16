package com.epam.dmrval.service;

import com.epam.dmrval.dao.SexDao;
import com.epam.dmrval.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;

public class SexServiceImpl implements SexService {
  @Autowired SexDao sexDao;

  @Override
  public Sex findById(int id_sex) {
    return sexDao.findById(id_sex);
  }
}
