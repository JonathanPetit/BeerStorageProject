package com.company.model;

import java.util.ArrayList;


public class BrandBeer {
  private String name;
  private String address;
  private String number;
  private ArrayList<Beer> beersList;

  public BrandBeer(String name, String address, String number){
    this.name = name;
    this.address = address;
    this.number = number;
    this.beersList = new ArrayList<Beer>();
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getNumber() {
    return number;
  }

  public ArrayList<Beer> getBeersList() {
    return beersList;
  }

  public void AddBeer(Beer beer){
    this.beersList.add(beer);
  }

  public void RemoveBeer(Beer beer) {this.beersList.remove(beer);}
}
