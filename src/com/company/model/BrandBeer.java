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

  public void addBeer(Beer beer){
    this.beersList.add(beer);
  }

  public void RemoveBeer(Beer beer) {this.beersList.remove(beer);}

  @Override
  public String toString(){
    String toString = "{";
    toString += "name: "+this.name;
    toString += ", address: "+this.address;
    toString += ", number: "+this.number;
    toString += ", beersList: [";
    ArrayList<Beer> beers = this.beersList;
    for (Beer beer:beers){
      toString += beer.toString();
      //Other possibility: just add beer name
      //toString += beer.getName();
      if (beer != beers.get(beers.size()-1)){
        toString += ", ";
      }
    }
    toString += "]}";
    return toString;
  }
}
