package com.epam.dmrval.hibernateDao;

import com.epam.dmrval.entity.Role;

/** Author - Damir_Valeev */
public interface RoleHibernateDao {
  Role findById(int id_role);
}
