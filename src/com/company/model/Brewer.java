package com.company.model;

import java.util.ArrayList;

public class Brewer {
  private String name;
  private String address;
  private ArrayList<BrandBeer> brandList;
  private String number;

  public Brewer(String name, String address, String number) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.brandList = new ArrayList<BrandBeer>();
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
    return brandList;
  }

  public void AddBrand(BrandBeer brand){
    this.brandList.add(brand);
  }
}