package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Sex;

/** Author - Damir_Valeev */
public interface SexDao {
  Sex findById(int id_sex);

  int findBySexName(String s_name);
}
