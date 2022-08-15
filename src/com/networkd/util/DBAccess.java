package com.networkd.util;

import com.networkd.model.Operation;
import com.networkd.model.Operator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
  private final String CONNECTION_DRIVER="com.mysql.cj.jdbc.Driver";
  private final String DBNAME = "db_nwkd";
  private final String PASSWORD = "12345";
  private final String USERNAME = "networkd";
  private final String HOST = "localhost";

  private Connection connection = null;
  private PreparedStatement ps = null;
  private ResultSet resultSet = null;

  public DBAccess() throws Exception {
    Class.forName(CONNECTION_DRIVER);
    connection = DriverManager.getConnection(getUrl());
  }

  public int save(Operation op) throws SQLException {
    String query = "INSERT INTO operation (valueOne, valueTwo, result, operator, dateCreated) values(?, ?, ?, ?, ?)";
    ps = connection.prepareStatement(query);
    ps.setDouble(1, op.getValueOne());
    ps.setDouble(2, op.getValueTwo());
    ps.setDouble(3, op.getResult());
    ps.setString(4, op.getOperator().toString());
    ps.setTimestamp(5, op.getDateCreated());
    return ps.executeUpdate();
  }

  public List<Operation> findAll() throws SQLException {
    String query = "SELECT * FROM operation";
    ps = connection.prepareStatement(query);
    resultSet = ps.executeQuery();

    List<Operation> listOps = new ArrayList<>();
    while (resultSet.next()) {
      Operation op = new Operation();
      op.setId(resultSet.getInt("id"));
      op.setValueOne(resultSet.getDouble("valueOne"));
      op.setValueTwo(resultSet.getDouble("valueTwo"));
      op.setResult(resultSet.getDouble("result"));
      op.setOperator(Operator.valueOf(resultSet.getString("operator")));
      op.setDateCreated(resultSet.getTimestamp("dateCreated"));
      listOps.add(op);
    }
    return listOps;
  }

  public int delete(int id) throws SQLException {
    String query = "DELETE FROM operation WHERE id = ?";
    ps = connection.prepareStatement(query);
    ps.setInt(1, id);
    return ps.executeUpdate();
  }

  private String getUrl() {
    return "jdbc:mysql://"+USERNAME+":"+PASSWORD+"@"+HOST+"/"+DBNAME;
  }
}
