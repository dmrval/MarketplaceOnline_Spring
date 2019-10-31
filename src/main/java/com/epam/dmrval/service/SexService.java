package com.epam.dmrval.service;

import com.epam.dmrval.entity.Sex;

/** Author - Damir_Valeev */
public interface SexService {
  Sex findById(int id_sex);

  int findBySexName(String s_name);
}
