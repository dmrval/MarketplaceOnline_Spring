package com.epam.dmrval.jdbcconnection;

import java.sql.*;

public class JdbcConnections {

  public static Connection connectToDataBase() throws SQLException {
    final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    final String login = "C##DMRVAL";
    final String password = "Password1";
    return DriverManager.getConnection(url, login, password);
  }

  public static ResultSet insertPreparedStatement(PreparedStatement ps, int id)
      throws SQLException {
    ps.setInt(1, id);
    return ps.executeQuery();
  }
}
