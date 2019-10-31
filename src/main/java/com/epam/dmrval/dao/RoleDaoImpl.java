package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Author - Damir_Valeev */
@Component
public class RoleDaoImpl implements RoleDao {

  @Autowired private DataSource dataSource;

  @Override
  public Role findById(int id_role) {
    Role role = Role.GUEST;
    try (Connection connection = dataSource.getConnection();
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
