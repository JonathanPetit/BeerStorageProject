package com.company.model;

import java.util.ArrayList;

public class Brewer {
  private String name;
  private String address;
  private ArrayList<Brand> brandsList;
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

  public ArrayList<Brand> getBrandList() {
    return brandsList;
  }

  public void addBrand(Brand brand){
    this.brandsList.add(brand);
  }

  public void RemoveBrand(Brand brand) {this.brandsList.remove(brand);}

  public String beautifulString() {
    ArrayList<Brand> brands = this.brandsList;
    String brandsString = "";
    for (Brand brand:brands) {
      // First possibility: add beer to string (with all data)
      //toString += beer.toString();
      //Other possibility: just add beer name
      brandsString = brandsString.concat(brand.getName());
      if (brand != brands.get(brands.size() - 1)) {
        brandsString += ", ";
      }
    }
    return String.format("%20s%20s%20s%20s",
            this.name, this.address, this.number,brandsString);
  }
  @Override
  public String toString(){
    String toString = "{";
    toString += "\"name\": \""+this.name;
    toString += "\", \"address\": \""+this.address;
    toString += "\", \"number\": \""+this.number;
    toString += "\", \"brandsList\": [";
    ArrayList<Brand> brandBeers = this.brandsList;
    for (Brand brandBeer:brandBeers){
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