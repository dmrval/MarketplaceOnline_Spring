package com.epam.dmrval.service;

import com.epam.dmrval.dao.RoleDao;
import com.epam.dmrval.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
  @Autowired RoleDao roleDao;

  @Override
  public Role findById(int id_role) {
    return roleDao.findById(id_role);
  }
}
