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

  public void AddBrand(BrandBeer brand){
    this.brandsList.add(brand);
  }

  public void RemoveBrand(BrandBeer brand) {this.brandsList.remove(brand);}
}