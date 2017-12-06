package com.company.model;

public class ModelBeer {
  private String model;
  private String type;
  private Double degree;
  private Double conditionning;
  private Double price;
  private int evalutation;

  public String GetModel(){return model;}
  public String GetType(){return type;}
  public Double GetDegree(){return degree;}
  public Double GetConditionning(){return conditionning;}
  public Double GetPrice(){return price;}
  public int GetEvaluation(){return evalutation;}

  public void SetModel(String model){this.model = model;}
  public void SetType(String type){this.type = type;}
  public void SetDegree(Double degree){this.degree = degree;}
  public void SetConditionning(Double conditionning){this.conditionning = conditionning;}
  public void SetPrice(Double price){this.price = price;}
  public void SetEvaluation(int evalutation){this.evalutation = evalutation;}

  public ModelBeer(String model, String type, Double degree, Double conditionning, Double price, int evalutation)
  {
    SetModel(model);
    SetType(type);
    SetDegree(degree);
    SetConditionning(conditionning);
    SetPrice(price);
    SetEvaluation(evalutation);
  }


}
