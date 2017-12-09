package com.company.model;

public class Beer {
  private String name;
  private String type;
  private double degree;
  private double conditioning;
  private double price;
  private double evaluation;

  public Beer(String name, String type, double degree, double conditioning, double price,
                   int evaluation) {
    this.name = name;
    this.type = type;
    this.degree = degree;
    this.conditioning = conditioning;
    this.price = price;
    this.evaluation = evaluation;
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

  public double getConditioning() {
    return conditioning;
  }

  public double getPrice() {
    return price;
  }

  public double getEvaluation() {
    return evaluation;
  }

  @Override
  public String toString() {
    String toString = "{";
    toString += "name: "+this.name;
    toString += ", type: "+this.type;
    toString += ", conditioning: "+this.conditioning;
    toString += ", price: "+this.price;
    toString += ", evaluation: "+this.evaluation;
    toString += "}";
    return toString;
  }
}
