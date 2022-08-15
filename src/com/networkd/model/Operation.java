package com.networkd.model;

import java.sql.Timestamp;
import java.util.Date;

public class Operation {
  private int id;
  private Double valueOne;
  private Double valueTwo;
  private Double result;
  private Operator operator;
  private Timestamp dateCreated;

  public Operation()
  {}

  public Operation(Double valueOne, Double valueTwo, Operator operator) {
    this.valueOne = valueOne;
    this.valueTwo = valueTwo;
    this.operator = operator;
    this.dateCreated = new Timestamp(new Date().getTime());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getValueOne() {
    return valueOne;
  }

  public void setValueOne(Double valueOne) {
    this.valueOne = valueOne;
  }

  public Double getValueTwo() {
    return valueTwo;
  }

  public void setValueTwo(Double valueTwo) {
    this.valueTwo = valueTwo;
  }

  public Double getResult() {
    return result;
  }

  public void setResult(Double result) {
    this.result = result;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "id=" + id +
        ", valueOne=" + valueOne +
        ", valueTwo=" + valueTwo +
        ", result=" + result +
        ", operator=" + operator +
        ", dateCreated=" + dateCreated +
        '}';
  }
}
