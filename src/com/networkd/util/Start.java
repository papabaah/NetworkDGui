package com.networkd.util;

import com.networkd.gui.OperationWindow;
import com.networkd.model.Operation;
import com.networkd.model.Operator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Start {

  public static void main(String[] args) {
    OperationWindow opWindow = new OperationWindow();
    opWindow.setVisible(true);
  }

  public static void createOperation() {
    try {
      System.out.println("Taking values.....");
      double v1 = 228.0;
      double v2 = 13.0;
      double res = 0.0;
      Operator op = Operator.divide;
      Timestamp dateCtd = new Timestamp(new Date().getTime());
      switch (op) {
        case add:
          res = v1 + v2;
          break;
        case subtract:
          res = v1 - v2;
          break;
        case multiply:
          res = v1 * v2;
          break;
        case divide:
          res = v1 / v2;
          break;
      }
      System.out.println("Creating Operation object.....");
      Operation operation = new Operation();
      operation.setValueOne(v1);
      operation.setValueTwo(v2);
      operation.setResult(res);
      operation.setOperator(op);
      operation.setDateCreated(dateCtd);

      System.out.println("Saving operation to the Database...");
      DBAccess dao = new DBAccess();
      int count = dao.save(operation);

      System.out.println("Count: " + count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void selectAll() {
    try {

      DBAccess dao = new DBAccess();
      List<Operation> operations = dao.findAll();

      for(Operation op : operations)
        System.out.println(op.toString());

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void deleteOperation(int operationId) {
    try{
      DBAccess dao = new DBAccess();
      int res = dao.delete(operationId);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
