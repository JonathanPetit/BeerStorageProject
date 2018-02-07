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

  // Getters and setters
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
<<<<<<< HEAD

  /**
   * Set the evaluation of the Beer Object
   * @param evaluation: a Double with the new evaluation
   */
  public void setEvaluation(Double evaluation) {
    this.evaluation = evaluation;
  }

<<<<<<< HEAD
=======
  public String beautifulString(){
    return String.format("%20s%20s%20s%20s%20s%20s",
            this.name, this.type, this.degree,this.conditioning,this.price, this.evaluation);
  }
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
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
=======
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
}
