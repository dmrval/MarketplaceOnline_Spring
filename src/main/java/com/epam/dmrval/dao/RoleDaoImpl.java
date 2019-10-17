package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Role;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Author - Damir_Valeev */
@Component
public class RoleDaoImpl implements RoleDao {
  @Override
  public Role findById(int id_role) {
    Role role = Role.GUEST;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement("SELECT ROLENAME FROM ROLES WHERE ROLEID=?")) {
      ps.setInt(1, id_role);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        role = Role.valueOf(rs.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return role;
  }
}
