package com.company.model;

public class Beer {
  private String name;
  private String type;
  private double degree;
  private double conditioning;
  private double price;
  private double evaluation;

  public Beer(String name, String type, double degree, double conditioning, double price,
                   double evaluation) {
    this.name = name;
    this.type = type;
    this.degree = degree;
    this.conditioning = conditioning;
    this.price = price;
    this.evaluation = evaluation;
  }

  /**
   * Get the name of the Beer Object
   * @return a String with the name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the type of the Beer Object
   * @return a String with the type
   */
  public String getType() {
    return type;
  }

  /**
   * Get the degree of the Beer Object
   * @return a Double with the degree
   */
  public double getDegree() {
    return degree;
  }

  /**
   * Get the conditioning of the Beer Object
   * @return a Double with the conditioning
   */
  public double getConditioning() {
    return conditioning;
  }

  /**
   * Get the price of the Beer Object
   * @return a Double with the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Set the price of the Beer Object
   * @param price: a Double with the new price
   */
  public void setPrice(Double price) {
    this.price = price;
  }

  /**
   * Get the evaluation of the Beer Object
   * @return a Double with the evaluation
   */
  public double getEvaluation() {
    return evaluation;
  }

  /**
   * Set the evaluation of the Beer Object
   * @param evaluation: a Double with the new evaluation
   */
  public void setEvaluation(Double evaluation) {
    this.evaluation = evaluation;
  }

  public String beautifulString(){
    return String.format("%20s%20s%20s%20s%20s%20s",
            this.name, this.type, this.degree,this.conditioning,this.price, this.evaluation);
  }
  /**
   * Override the "toString" method of an Object
   * @return a String with the Object with Json structure
   */
  @Override
  public String toString() {
    String toString = "{";
    toString += "\"name\": \""+this.name;
    toString += "\", \"type\": \""+this.type;
    toString += "\", \"degree\": \""+this.degree;
    toString += "\", \"conditioning\": \""+this.conditioning;
    toString += "\", \"price\": \""+this.price;
    toString += "\", \"evaluation\": \""+this.evaluation;
    toString += "\"}";
    return toString;
  }
}
