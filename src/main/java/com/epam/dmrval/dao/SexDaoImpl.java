package com.epam.dmrval.dao;

import com.epam.dmrval.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Author - Damir_Valeev */
//@Component
public class SexDaoImpl implements SexDao {

  @Autowired private DataSource dataSource;

  @Override
  public Sex findById(int id_sex) {
    Sex sex = Sex.MR;
    try (Connection connection = dataSource.getConnection();
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

  @Override
  public int findBySexName(String s_name) {
    int result = 0;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement ps =
            connection.prepareStatement("SELECT GENDERID FROM GENDER WHERE GENDERNAME=?")) {
      ps.setString(1, s_name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
