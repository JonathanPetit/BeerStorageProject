package com.company.model;

public class Beer {
  private String name;
  private String type;
  private double degree;
  private double conditionning;
  private double price;
  private double evalutation;

  public Beer(String name, String type, double degree, double conditionning, double price,
                   int evalutation) {
    this.name = name;
    this.type = type;
    this.degree = degree;
    this.conditionning = conditionning;
    this.price = price;
    this.evalutation = evalutation;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public double getDegree() {
    return degree;
  }

  public double getConditionning() {
    return conditionning;
  }

  public double getPrice() {
    return price;
  }

  public double getEvalutation() {
    return evalutation;
  }
}
