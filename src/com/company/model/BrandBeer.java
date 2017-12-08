package com.company.model;

import java.util.ArrayList;


public class BrandBeer {
  private String name;
  private ArrayList<Beer> beersList;

  public String GetName(){return name;}
  public List<ModelBeer> GetModelList(){return modelList;}

  public void SetName(String name){this.name = name;}
  public void SetModelList(List<ModelBeer> modelList){this.modelList = modelList;}

  public BrandBeer(String name){
    SetName(name);
    List<ModelBeer> modelList = new LinkedList<ModelBeer>();
    SetModelList(modelList);
  }

  public void AddBeer(ModelBeer beer){
    // Add a beer of the brand represented by the object BrandBeer
    List<ModelBeer> updatedModelList = this.GetModelList();
    updatedModelList.add(beer);

    SetModelList(updatedModelList);
  }

  public String ModelBeerList2String(String sep){
    List<ModelBeer> modelBeerList = this.GetModelList();
    String listStringed = modelBeerList.stream().map(ModelBeer::GetModel).collect(Collectors.joining(sep));
    return listStringed;
  }}
