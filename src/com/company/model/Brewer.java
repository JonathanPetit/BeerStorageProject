package com.company.model;

import com.company.Json.JsonRead;

import java.util.ArrayList;
import java.util.List;

public class Brewer {
  private String name;
  private String address;
  private ArrayList<BrandBeer> brandsList;
  private String number;

  public Brewer(String name, String address, String number) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.brandsList = new ArrayList<BrandBeer>();
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
      //toString += brandBeer.toString();
      //Other possibility: just add brandBeer name
      toString += "\""+brandBeer.getName()+"\"";
      if (brandBeer != brandBeers.get(brandBeers.size()-1)){
        toString += ",";
      }
    }
    toString += "]}";
    return toString;
  }


}