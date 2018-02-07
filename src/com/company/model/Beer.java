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

    /**
    * Override the "toString" method of an Object
    * @return a String with the Object with Json structure
    */
    @Override
        public String toString() {
            return String.format("%20s%20s%20s%20s%20s%20s", this.name, this.type, this.degree, this
                .conditioning,this.price, this.evaluation);
    }
}
