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

  public void setAddress(String address){
    this.address = address;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number){
    this.number = number;
  }


  public ArrayList<Beer> getBeersList() {
    return this.beersList;
  }

  public void addBeer(Beer beer){
    this.beersList.add(beer);
  }
  public void removeBeer(Beer beer) {this.beersList.remove(beer);}

  public String beautifulString() {
    ArrayList<Beer> beers = this.beersList;
    String beersString = "";
    for (Beer beer:beers) {
      // First possibility: add beer to string (with all data)
      //toString += beer.toString();
      //Other possibility: just add beer name
      beersString = beersString.concat(beer.getName());
      if (beer != beers.get(beers.size() - 1)) {
        beersString += ", ";
      }
    }
    return String.format("%20s%20s%20s%20s",
            this.name, this.address, this.number,beersString);
  }
  @Override
  public String toString(){
    String toString = "{";
    toString += "\"name\": \""+this.name;
    toString += "\", \"address\": \""+this.address;
    toString += "\", \"number\": \""+this.number;
    toString += "\", \"beersList\": [";
    ArrayList<Beer> beers = this.beersList;
    for (Beer beer:beers){
      // First possibility: add beer to string (with all data)
      //toString += beer.toString();
      //Other possibility: just add beer name
      toString = toString.concat("\""+beer.getName()+"\"");
      if (beer != beers.get(beers.size()-1)){
        toString += ", ";
      }
    }
    toString += "]}";
    return toString;
  }
}
