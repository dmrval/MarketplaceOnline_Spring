package com.epam.dmrval.service;

import com.epam.dmrval.entity.Role;
import com.epam.dmrval.hibernateDao.RoleHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev */
@Component
public class RoleServiceImpl implements RoleService {
  @Autowired private RoleHibernateDao roleHibernateDao;

  @Override
  public Role findById(int id_role) {
    return roleHibernateDao.findById(id_role);
  }
}
