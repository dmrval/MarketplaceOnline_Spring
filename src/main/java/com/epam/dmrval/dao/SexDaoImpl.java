package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Sex;
import com.epam.dmrval.jdbcconnection.JdbcConnections;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SexDaoImpl implements SexDao {
  @Override
  public Sex findById(int id_sex) {
    Sex sex = Sex.MR;
    try (Connection connection = JdbcConnections.connectToDataBase();
        PreparedStatement ps =
            connection.prepareStatement("SELECT GENDERNAME FROM GENDER WHERE GENDERID=?")) {
      ps.setInt(1, id_sex);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        sex = Sex.valueOf(rs.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return sex;
  }
}
