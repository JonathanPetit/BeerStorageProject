package com.company.model;

import java.util.ArrayList;

public class Brewer {
  private String name;
  private String address;
  private ArrayList<BrandBeer> brandsList;
  private String number;

  public Brewer(String name, String address, String number) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.brandsList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number){
    this.number = number;
  }

  public ArrayList<BrandBeer> getBrandList() {
    return brandsList;
  }

  public void addBrand(BrandBeer brand){
    this.brandsList.add(brand);
  }

  public void RemoveBrand(BrandBeer brand) {this.brandsList.remove(brand);}


  @Override
  public String toString(){
    String toString = "{";
    toString += "\"name\": \""+this.name;
    toString += "\", \"address\": \""+this.address;
    toString += "\", \"number\": \""+this.number;
    toString += "\", \"brandsList\": [";
    ArrayList<BrandBeer> brandBeers = this.brandsList;
    for (BrandBeer brandBeer:brandBeers){
      // First possibility: add brandBeer to string (so with all data)
      // toString += brandBeer.toString();
      // Other possibility: just add brandBeer name
      toString = toString.concat("\""+brandBeer.getName()+"\"");
      if (brandBeer != brandBeers.get(brandBeers.size()-1)){
        toString += ",";
      }
    }
    toString += "]}";
    return toString;
  }


}