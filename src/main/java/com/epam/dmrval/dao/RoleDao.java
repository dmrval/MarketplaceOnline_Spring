package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Role;

/** Author - Damir_Valeev */
public interface RoleDao {
  Role findById(int id_role);
}
