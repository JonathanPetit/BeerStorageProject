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
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public double getDegree() {
    return this.degree;
  }

  public double getConditioning() {
    return this.conditioning;
  }

  public double getPrice() {
    return this.price;
  }

  public double getEvaluation() {
    return this.evaluation;
  }

}
