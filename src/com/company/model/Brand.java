package com.company.model;

import java.util.ArrayList;

public class Brand {
  private String name;
  private String address;
  private String number;
  private ArrayList<Beer> beersList;

  public Brand(String name, String address, String number){
    this.name = name;
    this.address = address;
    this.number = number;
    this.beersList = new ArrayList<Beer>();
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public String getNumber() {
    return this.number;
  }

  public ArrayList<Beer> getBeersList() {
    return this.beersList;
  }

  public void addBeer(Beer beer){
    this.beersList.add(beer);
  }
}
